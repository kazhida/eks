/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

import ekspress.externals.EventEmitter
import ekspress.externals.eventEmitter
import ekspress.externals.http
import ekspress.externals.https
import kotlin.js.Promise

@Suppress("unused")
class Application(
        private val path: Path = Path(path = "/"),      // アプリケーションが対応するパス
        private val parent: Application? = null         // 上位のアプリケーション
) : Middleware, EventEmitter by eventEmitter() {
    /*-------------*/
    /*     API     */
    /*-------------*/

    /**
     * サブアプリケーションの生成
     *
     * 生成と同時に、自分のstackに登録する
     *
     * @args path: String バインドするパス
     * @return アプリケーション・オブジェクト
     */
    @Suppress("unused")
    fun subApplication(path: String): Application {
        val layer = stack.firstOrNull { it.path.equals(path) }
        return if (layer?.handler is Application) {
            // 既にあったらそれを返す
            layer.handler as Application
        } else {
            // 自分の下に作って返す
            val subPath = this.path.concat(Path(path))
            Application(subPath, this).also { app ->
                stack.add(Layer(subPath, null, app))
            }
        }
    }

//    private fun use(method: Method?, path: String, middleware: Middleware) {
//
//    }
//
//    fun use(path: String, middleware: Middleware) = use(null, path, middleware)
//    fun get(path: String, middleware: Middleware)  = use(Method.GET, path, middleware)
//    fun put(path: String, middleware: Middleware)  = use(Method.PUT, path, middleware)
//    fun post(path: String, middleware: Middleware)  = use(Method.POST, path, middleware)
//    fun delete(path: String, middleware: Middleware) = use(Method.DELETE, path, middleware)
//

    fun listen(port: Int, secure: Boolean = false, vararg args: Any?) {
        if (secure) {
            https
        } else {
            http
        }.createServer {
            callback()
        }.listen(port, null, args)
    }

    /*-------------*/
    /*  プロパティ */
    /*-------------*/

    private val stack: MutableList<Layer> = ArrayList()

    /**
     * Middlewareとしてのハンドラの再定義
     * stackを使い果たしたか中断するかされたときに呼ばれる
     */
    override suspend fun handle(context: Context, next: NextProc) {
        if (parent == null) {
            context.stoped = false

            // allow bypassing koa
            //if (false === context.respond) return;

            if (context.response.writable) {
                when {
                    context.isEmptyStatus -> {
                        context.response.body = null
                        context.response.end()
                    }
                    context.request.method == Method.HEAD -> // todo ちゃんと実装
                        //                    if (!res.headersSent && isJSON(body)) {
                        //                        ctx.length = Buffer.byteLength(JSON.stringify(body));
                        //                    }
                        context.response.end()
                    context.response.body == null -> {
                        // todo ちゃんと実装
                        val body = null
                        //                    body = ctx.message || String(code);
                        //                    if (!res.headersSent) {
                        //                        ctx.type = 'text';
                        //                        ctx.length = Buffer.byteLength(body);
                        //                    }
                        context.response.end(body)
                    }
                    else -> {
                        // todo ちゃんと実装
                        val body = null
                        //                    if (Buffer.isBuffer(body)) return res.end(body);
                        //                    if ('string' == typeof body) return res.end(body);
                        //                    if (body instanceof Stream) return body.pipe(res);
                        //
                        //                    // body: json
                        //                    body = JSON.stringify(body);
                        //                    if (!res.headersSent) {
                        //                        ctx.length = Buffer.byteLength(body);
                        //                    }
                        context.response.end(body)
                    }
                }
            }
        }
    }

    /**
     * Middlewareとしてのハンドラの再定義
     * 呼ばれないはず
     */
    override suspend fun requestHandle(context: Context, next: NextProc) {
        next.call(context).await()
    }

    /**
     * Middlewareとしてのハンドラの再定義
     * 呼ばれないはず
     */
    override suspend fun errorHandle(context: Context, next: NextProc) {
        next.call(context).await()
    }

    private fun callback(): (res: dynamic, req: dynamic)->Promise<Unit> {

        if (listenerCount("error") == 0) {
            on("error") { err: Error? -> onError(err) }
        }

        return { res: dynamic, req: dynamic -> dispatch(res, req) }
    }

    private fun dispatch(res: dynamic, req: dynamic): Promise<Unit> {
        val context = Context(this, req, res)
        val stack2 = ArrayList<Layer>().apply { addAll(stack) }
        return Dispatcher(this, stack2).call(context)
    }

    private fun onError(err: Error?) {
        if (err == null) {
            console.error("err is null at Application#onError.")
        } else {
            console.error("err = {$err} at Application#onError")
        }
    }

    /**
     * ミドルウェアとパスやメソッドをまとめて管理するためのクラス
     */
    private class Layer(
            val path: Path,
            val method: Method?,
            val handler: Middleware
    ) {
        suspend fun handle(context: Context, next: NextProc) {
            try {
                handler.handle(context, next)
            } catch (e: Error) {
                context.setError(e)
                handler.handle(context, next)
            }
        }

        fun match(context: Context, path: Path, method: Method?): Boolean {
            val params = this.path.matchParams(path)

            return if (params == null) {
                false
            } else if (this.method == null || this.method == method) {
                context.request.addParams(params)
                true
            } else {
                false
            }
        }
    }
    /**
     * PATHを扱うためのユーティリティクラス
     *
     * @args src PATHを"/"で区切った文字列リスト
     */
    class Path private constructor(src: List<String>) {

        companion object {
            /**
             * 文字列のPATHを"/"区切りで分離したリストを作る関数
             * 空欄は除去される
             */
            private fun split(path: String): List<String> = path.split("/").filter { it.isNotBlank() }
        }

        /**
         * こちらが普通に使用されるコンストラクタ
         *
         * @args path PATH文字列
         */
        constructor(path: String) : this(split(path))

        /**
         * ディレクトリ階層
         */
        private val directories: List<String> = src

        /**
         * リストの先頭を返すプロパティ
         * 空の場合はnullを返す
         */
        val head: String? get() = if (directories.isEmpty()) null else directories[0]

        /**
         * リストの先頭を除いた残りを生成して返すプロパティ
         */
        val rest: Path get() = Path(directories.slice(1..directories.size))

        /**
         * 渡されたPATH文字列との先頭一致を判別するメソッド
         *
         * @args path PATH文字列
         * @return 先頭一致していればtrue
         */
        fun contains(path: String): Boolean = contains(Path(path))

        /**
         * 渡されたPATHとの先頭一致を判別するメソッド
         *
         * @args path PATHを"/"で分離したリスト
         * @return 先頭一致していればtrue
         */
        fun contains(path: Path): Boolean {
            if (path.directories.size > this.directories.size) {
                return false
            } else {
                path.directories.forEachIndexed { index, dir ->
                    if (dir != directories[index]) {
                        return false
                    }
                }
            }
            return true
        }

        /**
         * 自分自身に渡されたパスを連結した新しいPathを返すメソッド
         *
         * @args path 末尾に連結するリスト
         * @return 連結された新しいリスト
         */
        fun concat(path: Path): Path {
            val cat = ArrayList<String>().apply {
                addAll(directories)
                addAll(path.directories)
            }
            return Path(cat)
        }

        /**
         * 渡されたpathとの一致と、パラメータの収集を行うメソッド
         *
         * @args path 判定の大詔となるPATH
         * @return 一致していなければnull、一致していたときはパラメータのmapを返す
         */
        fun matchParams(path: Path): Map<String, String>? {
            return if (path.directories.size != directories.size) {
                null
            } else {
                HashMap<String, String>().apply {
                    directories.forEachIndexed { index, d ->
                        val s = path.directories[index]
                        if (d.startsWith(":") && d.length > 1) {
                            val p = d.substring(1)
                            put(p, s)
                        } else if (s != d) {
                            return null
                        }
                    }
                }
            }
        }

        private val pathString: String by lazy { directories.joinToString("/") }

        fun equals(other: String): Boolean = pathString == other
    }

    /**
     * stackに積まれたミドルウェアを連鎖させるためのクラス
     */
    private class Dispatcher(
            private val app: Application,
            private val stack: ArrayList<Layer>
    ) : NextProc {

        override fun call(context: Context): Promise<Unit> {
            val layer = if (stack.isEmpty()) null else stack.removeAt(0)
            return async {
                if (layer == null) {
                    app.handle(context, this)
                } else {
                    layer.handler.handle(context, this)
                }
            }
        }
    }
}

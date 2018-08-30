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
import kotlin.coroutines.experimental.*
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
     *
     * @args context コンテクスト
     */
    override fun handle(context: Context): Context {
        return when {
            parent != null ->
                // 親アプリがあるときはそれに返す
                context.copy(isStopped = false)
            context.response.writable ->
                // ここで、それなりのレスポンスを返す
                when {
                    context.response.isEmptyStatus -> context.endAsEmpty()
                    context.request.method == Method.HEAD -> context.endAsHead()
                    context.response.body == null -> context.endAsCode()
                    else -> context.endAsNormally()
                }
            else -> context
        }
    }

    /**
     * listenで使うコールバック
     *
     * @args req Node.jsのリクエスト
     * @args res Node.jsのレスポンス
     * @return コンテクストを返すプロミス
     */
    private fun callback(): (res: dynamic, req: dynamic)->Promise<Context> {
        if (listenerCount("error") == 0) {
            on("error") { err: Throwable -> onError(err) }
        }
        return { res: dynamic, req: dynamic ->
            dispatch(Context.create(this, res, req))
        }
    }

    /**
     * ミドルウェアの処理
     *
     * @args originalContext 最初のコンテクスト
     * @return コンテクストを返すプロミス
     */
    private fun dispatch(originalContext: Context): Promise<Context> {
        return Promise { resolve, reject ->
            try {
                var handled = false
                var context = originalContext
                for (layer in stack) {
                    handled = true
                    val params = layer.path.matchParams(path)
                    if (params != null) {
                        context = layer.handler.handle(context.addedParams(params))
                    }
                    if (context.isStopped) break
                }
                if (handled) {
                    resolve(context)
                } else {
                    resolve(context.endAsNotFound())
                }
            } catch (e: Throwable) {
                reject(e)
            }
        }

    }

    /**
     * Node.jsレベルのエラーハンドラ
     *
     * @args err エラー
     */
    private fun onError(err: Throwable) {
        console.error("err = {$err} at Application#onError")
    }

    /**
     * ミドルウェアとパスやメソッドをまとめて管理するためのクラス
     *
     * @args path ミドルウェアに対応するエンドポイント
     * @args method 処理するメソッド、nullの場合はすべてを処理する
     * @args handler ミドルウェア
     */
    private class Layer(
            val path: Path,
            val method: Method?,
            val handler: Middleware
    )

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
     * 非同期な処理をを行う関数
     */
    @Suppress("unused")
    fun <T> async(target: T, block: suspend ()->T): Promise<T> {
        val continuation = object : Continuation<T> {
            override val context: CoroutineContext get() = EmptyCoroutineContext
            override fun resume(value: T) {}
            override fun resumeWithException(exception: Throwable) = throw exception
        }
        block.startCoroutine(continuation)
        return Promise.resolve(target)
    }

    /**
     * 非同期処理の完了を待つ拡張メソッド
     */
    @Suppress("unused")
    suspend fun <T> Promise<T>.await(): T = suspendCoroutine { continuation ->
        then {
            continuation.resume(it)
        }.catch {
            continuation.resumeWithException(it)
        }
    }
}

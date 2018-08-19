/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

import ekspress.externals.*
import kotlin.js.Promise

@Suppress("unused")
class Application(
        private val path: Path = Path("/"),         // アプリケーションが対応するパス
        private val parent: Application? = null     // 上位のアプリケーション
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
//    var proxy = false;
//    var middleware = []
//    var subdomainOffset = 2
//    var env = process.env.NODE_ENV || 'development'

    /**
     * Middlewareとしてのハンドラの再定義
     * stackを使い果たしたか中断するかされたときに呼ばれる
     */
    override suspend fun handle(context: Context, next: NextProc) {
        if (parent == null) {
            context.stoped = false

            // allow bypassing koa
            //if (false === context.respond) return;

            if (context.res.writable as Boolean) {
                if (context.isEmptyStatus) {
                    context.body = null
                    context.res.end()
                } else if (context.request.method == Method.HEAD) {
                    // todo ちゃんと実装
//                    if (!res.headersSent && isJSON(body)) {
//                        ctx.length = Buffer.byteLength(JSON.stringify(body));
//                    }
                    context.res.end()
                } else if (context.body == null) {
                    // todo ちゃんと実装
                    val body = null
//                    body = ctx.message || String(code);
//                    if (!res.headersSent) {
//                        ctx.type = 'text';
//                        ctx.length = Buffer.byteLength(body);
//                    }
                    context.res.end(body)
                } else {
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
                    context.res.end(body)
                }
            }
        }
    }

    /**
     * Middlewareとしてのハンドラの再定義
     * 呼ばれないはず
     */
    override suspend fun requestHandle(context: Context, next: NextProc) {
        next(context).await()
    }

    /**
     * Middlewareとしてのハンドラの再定義
     * 呼ばれないはず
     */
    override suspend fun errorHandle(context: Context, next: NextProc) {
        next(context).await()
    }

    private fun callback(): (res: dynamic, req: dynamic)->Promise<Unit> {

        if (listenerCount("error") == 0) on("error") { err: Error? -> onError(err) }

        val handleRequest = { res: dynamic, req: dynamic ->
            val context = Context(this, req, res).apply {
                res.statusCode = 404 // todo 必要？
            }
            // todo ちゃんと実装
//            onFinished(res) {
//                err -> context.onError(err)
//            }
            async {
                dispatch(context)
            }
        };

        return handleRequest;
    }

    private fun onError(err: Error?) {
        if (err == null) {
            console.error("err is null at Application#onError."))
        } else {
            console.error("err = {$err} at Application#onError"))
        }
    }

    private suspend fun dispatch(context: Context): Promise<Unit> {
        if (stack.isEmpty() || context.stoped) {
            val dummyNext = {
                _: Context? -> Promise.resolve(Unit)
            }
            // 自分のハンドラを呼ぶ
            handle(context, dummyNext)
        } else {
            next(context)
        }
    }

    private suspend fun next(context: Context): Promise<Unit> {
        val layer = stack.removeAt(0)
        if (context.request.method != layer.method || layer.method == null) {
            // 再帰呼び出し
            layer.handler.handle(context, next)
            dispatch(context, stack)
        } else {
            // 間接的に再帰呼び出し
            async {
                layer.handle(context, this)
            }
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
            } catch (e: Exception) {
                context.setError(e)
                handler.handle(context, next)
            }
        }

        @Suppress("unused")
        fun match(context: Context, path: Path, method: Method?): Boolean {
            val params = this.path.matchParams(path)

            return if (params == null) {
                false
            } else if (this.method == null || this.method == method) {
                context.req.params.add(params)
                true
            } else {
                false
            }
        }
    }

    /**
     * stackに積まれたミドルウェアを連鎖させるためのクラス
     */
    private class Dispatcher(val app: Application, val stack: ArrayList<Layer>) {

        suspend fun dispatch(context: Context) {
            if (stack.isEmpty()) {
                val dummyNext = {
                    _: Context? -> Promise.resolve(Unit)
                }
                // 自分のハンドラを呼ぶ
                app.handle(context, dummyNext)
            } else {
                call(context)
            }
        }

        suspend fun call(context: Context): Promise<Unit> {
            val layer = if (stack.isEmpty()) {
                dispatch(context)
            } else {
                stack.removeAt(0)
            }
            if (layer == null) {
                done.call(context)
            } else if (context.request.method != layer.method || layer.method == null) {
                // 再帰呼び出し
                call(context)
            } else {
                // 間接的に再帰呼び出し
                async {
                    layer.handle(context, this)
                }
            }
        }
    }
}

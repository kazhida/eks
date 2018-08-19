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
        private val path: Path = Path("/"),
        private val handler: Middleware? = null
) : Middleware, NextProc, EventEmitter by eventEmitter() {
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
        val handler = layer?.handler
        return handler as? Application ?: this.path.concat(Path(path)).let { p ->
            Application(p).also { app ->
                stack.add(Layer(p, null, app))
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
//    fun listen(port: Int,
// connected: (app: Application)->Unit) {
//
//    }

    /*-------------*/
    /*  プロパティ */
    /*-------------*/

    private val stack: MutableList<Layer> = ArrayList()
    val request: Context.Request? = null
    val response: Context.Response? = null
    var proxy = false;
//    var middleware = []
//    var subdomainOffset = 2
//    var env = process.env.NODE_ENV || 'development'

    /**
     * Middlewareとしてのハンドラの再定義
     */
    override suspend fun handle(context: Context, next: NextProc) {
        if (handler != null) {
            handler.handle(context, null)
        } else {
            // todo: とりあえず404を返す
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

//    /**
//     * NextProcとしての定義
//     */
//    override fun call(context: Context?): Promise<Unit> {
//        // 自分のハンドラを呼ぶ
//        if (context != null) {
//            async {
//                handle(context, null)
//            }
//        }
//        return Promise.resolve(Unit)
//    }

    private suspend fun dispatch(context: Context) {
        if (stack.isEmpty()) {
            handle(context, this)
        } else {
            val dup = ArrayList<Layer>().apply { addAll(stack) }
            RouteNext(this, dup).call(context)
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
    private class RouteNext(val done: NextProc, val stack: ArrayList<Layer>) : NextProc {

        override fun call(context: Context?): Promise<Unit> {
            return if (context == null) {
                done.call(null)
            } else {
                val layer = if (stack.isEmpty()) {
                    null
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

//        listen(...args) {
//            debug('listen');
//            const server = http.createServer(this.callback());
//            return server.listen(...args);
//        }


    fun listen(secure: Boolean, port: Int, vararg args: Any?) {
        if (secure) {
            https
        } else {
            http
        }.createServer {
            {
                req: dynamic, res: dynamic ->
                val context = Context(this@Application, req, res)
            }
        }.listen(port, null, args)
    }

        /**
         * Return a request handler callback
         * for node's native http server.
         *
         * @return {Function}
         * @api public
         */

//        callback() {
//            const fn = compose(this.middleware);
//
//            if (!this.listenerCount('error')) this.on('error', this.onerror);
//
//            const handleRequest = (req, res) => {
//            const ctx = this.createContext(req, res);
//            return this.handleRequest(ctx, fn);
//        };
//
//            return handleRequest;
//        }

        /**
         * Handle request in callback.
         *
         * @api private
         */

//        handleRequest(ctx, fnMiddleware) {
//            const res = ctx.res;
//            res.statusCode = 404;
//            const onerror = err => ctx.onerror(err);
//            const handleResponse = () => respond(ctx);
//            onFinished(res, onerror);
//            return fnMiddleware(ctx).then(handleResponse).catch(onerror);
//        }

        /**
         * Default error handler.
         *
         * @param {Error} err
         * @api private
         */

//        onerror(err) {
//            if (!(err instanceof Error)) throw new TypeError(util.format('non-error thrown: %j', err));
//
//            if (404 == err.status || err.expose) return;
//            if (this.silent) return;
//
//            const msg = err.stack || err.toString();
//            console.error();
//            console.error(msg.replace(/^/gm, '  '));
//            console.error();
//        }
//    };

    /**
     * Response helper.
     */

//    function respond(ctx) {
//        // allow bypassing koa
//        if (false === ctx.respond) return;
//
//        const res = ctx.res;
//        if (!ctx.writable) return;
//
//        let body = ctx.body;
//        const code = ctx.status;
//
//        // ignore body
//        if (statuses.empty[code]) {
//            // strip headers
//            ctx.body = null;
//            return res.end();
//        }
//
//        if ('HEAD' == ctx.method) {
//            if (!res.headersSent && isJSON(body)) {
//                ctx.length = Buffer.byteLength(JSON.stringify(body));
//            }
//            return res.end();
//        }
//
//        // status body
//        if (null == body) {
//            body = ctx.message || String(code);
//            if (!res.headersSent) {
//                ctx.type = 'text';
//                ctx.length = Buffer.byteLength(body);
//            }
//            return res.end(body);
//        }
//
//        // responses
//        if (Buffer.isBuffer(body)) return res.end(body);
//        if ('string' == typeof body) return res.end(body);
//        if (body instanceof Stream) return body.pipe(res);
//
//        // body: json
//        body = JSON.stringify(body);
//        if (!res.headersSent) {
//            ctx.length = Buffer.byteLength(body);
//        }
//        res.end(body);
//    }
}

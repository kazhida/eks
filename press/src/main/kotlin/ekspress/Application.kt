/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

import ekspress.externals.*

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
     * 生成と同時に、自分のサブアプリケーションに登録する
     *
     * @args path: String バインドするパス
     * @return アプリケーション・オブジェクト
     */
    @Suppress("unused")
    fun subApplication(path: String): Application {
        var app = subApps[path]
        if (app == null) {
            val paths = this.path.concat(Path(path))
            app = Application(paths)
            subApps[path] = app
        }
        return app
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
//    fun listen(port: Int, connected: (app: Application)->Unit) {
//
//    }

    /**
     * Listen for connections.
     *
     * A node `http.Server` is returned, with this
     * application (which is a `Function`) as its
     * callback. If you wish to create both an HTTP
     * and HTTPS server you may do so with the "http"
     * and "https" modules as shown here:
     *
     *    var http = require('http')
     *      , https = require('https')
     *      , express = require('express')
     *      , app = express();
     *
     *    http.createServer(app).listen(80);
     *    https.createServer({ ... }, app).listen(443);
     *
     * @return {http.Server}
     * @public
     */

    /**
     * httpでのlisten開始
     *
     * @args port ポート番号
     * @args callback 開始後に呼ばれるコールバック
     * @args args listen時のオプション
     * @return 生成したサーバ
     */
    @Suppress("unused")
    fun listenHttp(port: Int, callback: EmptyCallback? = null, vararg args: Any?): Server {
        return http.createServer(this, null).listen(port, callback, args)
    }

    /**
     * httpsでのlisten開始
     *
     * いろいろオプションを渡せるはずなのだけど、
     * 樋田の理解がそこまで至っていない
     *
     * @args port ポート番号
     * @args callback 開始後に呼ばれるコールバック
     * @args args listen時のオプション
     * @return 生成したサーバ
     */
    @Suppress("unused")
    fun listenHttps(port: Int, callback: EmptyCallback? = null, vararg args: Any?): Server {
        return https.createServer(this, null).listen(port, callback, args)
    }

//    app.listen = function listen() {
//        var server = http.createServer(this);
//        return server.listen.apply(server, arguments);
//    };

    /*-------------*/
    /*  プロパティ */
    /*-------------*/

    private val subApps = HashMap<String, Application>()
    private val stack: List<Layer> = ArrayList()

//    private val cache: Any = Any()
//    private val engines: Any = Any()
//    private val settings: Any = Any()
//
//    private val x_powered_by = true
//    private val etag = "weak"
//    //private val env = Process.env.NODE_ENV || 'development';
//    private val query_parser = "extended"
//    private val subdomain_offset = 2
//    private val trust_proxy = false

    /**
     * Middlewareとしてのハンドラの再定義
     */
    override fun handle(context: Context, next: NextProc?) {
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
    override fun requestHandle(context: Context, next: NextProc) {
        next.call(context)
    }

    /**
     * Middlewareとしてのハンドラの再定義
     * 呼ばれないはず
     */
    override fun errorHandle(context: Context, next: NextProc) {
        next.call(context)
    }

    /**
     * NextProcとしての再定義
     */
    override fun call(context: Context) {
        // 自分のハンドラを呼ぶ
        handle(context, null)
    }



//    // trust proxy inherit back-compat
//    Object.defineProperty(this.settings, trustProxyDefaultSymbol, {
//        configurable: true,
//        value: true
//    });
//
//    debug('booting in %s mode', env);
//
//    this.on('mount', function onmount(parent) {
//        // inherit trust proxy
//        if (this.settings[trustProxyDefaultSymbol] === true
//                && typeof parent.settings['trust proxy fn'] === 'function') {
//            delete this.settings['trust proxy'];
//            delete this.settings['trust proxy fn'];
//        }
//
//        // inherit protos
//        setPrototypeOf(this.request, parent.request)
//        setPrototypeOf(this.response, parent.response)
//        setPrototypeOf(this.engines, parent.engines)
//        setPrototypeOf(this.settings, parent.settings)
//    });
//
//    // setup locals
//    this.locals = Object.create(null);
//
//    // top-most app is mounted at /
//    this.mountpath = '/';
//
//    // default locals
//    this.locals.settings = this.settings;
//
//    // default configuration
//    this.set('view', View);
//    this.set('views', resolve('views'));
//    this.set('jsonp callback name', 'callback');
//
//    if (env === 'production') {
//        this.enable('view cache');
//    }
//
//    Object.defineProperty(this, 'router', {
//        get: function() {
//            throw new Error('\'app.router\' is deprecated!\nPlease see the 3.x to 4.x migration guide for details on how to update your app.');
//        }
//    });

    /**
     * lazily adds the base router if it has not yet been added.
     *
     * We cannot add the base router in the defaultConfiguration because
     * it reads app settings which might be set after that has run.
     *
     * @private
     */
//    app.lazyrouter = function lazyrouter() {
//        if (!this._router) {
//            this._router = new Router({
//                caseSensitive: this.enabled('case sensitive routing'),
//                strict: this.enabled('strict routing')
//            });
//
//            this._router.use(query(this.get('query parser fn')));
//            this._router.use(middleware.init(this));
//        }
//    };

    /**
     * Dispatch a request, res pair into the application. Starts pipeline processing.
     *
     * If no callback is provided, then default error handlers will respond
     * in the event of an error bubbling through the stack.
     *
     * @private
     */

//    app.handle = function handle(request, res, callback) {
//        var router = this._router;
//
//        // final handle
//        var done = callback || finalhandler(request, res, {
//            env: this.get('env'),
//            onerror: logerror.bind(this)
//        });
//
//        // no routes
//        if (!router) {
//            debug('no routes defined on app');
//            done();
//            return;
//        }
//
//        router.handle(request, res, done);
//    };

    /**
     * Proxy `Router#use()` to add middleware to the app router.
     * See Router#use() documentation for details.
     *
     * If the _fn_ parameter is an express app, then it will be
     * mounted at the _route_ specified.
     *
     * @public
     */

//    app.use = function use(fn) {
//        var offset = 0;
//        var path = '/';
//
//        // default path to '/'
//        // disambiguate app.use([fn])
//        if (typeof fn !== 'function') {
//            var arg = fn;
//
//            while (Array.isArray(arg) && arg.length !== 0) {
//                arg = arg[0];
//            }
//
//            // first arg is the path
//            if (typeof arg !== 'function') {
//                offset = 1;
//                path = fn;
//            }
//        }
//
//        var fns = flatten(slice.call(arguments, offset));
//
//        if (fns.length === 0) {
//            throw new TypeError('app.use() requires a middleware function')
//        }
//
//        // setup router
//        this.lazyrouter();
//        var router = this._router;
//
//        fns.forEach(function (fn) {
//            // non-express app
//            if (!fn || !fn.handle || !fn.set) {
//                return router.use(path, fn);
//            }
//
//            debug('.use app under %s', path);
//            fn.mountpath = path;
//            fn.parent = this;
//
//            // restore .app property on request and res
//            router.use(path, function mounted_app(request, res, next) {
//                var orig = request.app;
//                fn.handle(request, res, function (err) {
//                    setPrototypeOf(request, orig.request)
//                    setPrototypeOf(res, orig.response)
//                    next(err);
//                });
//            });
//
//            // mounted an app
//            fn.emit('mount', this);
//        }, this);
//
//        return this;
//    };

    /**
     * Proxy to the app `Router#route()`
     * Returns a new `Route` instance for the _path_.
     *
     * Routes are isolated middleware stacks for specific paths.
     * See the Route api docs for details.
     *
     * @public
     */

//    app.route = function route(path) {
//        this.lazyrouter();
//        return this._router.route(path);
//    };

    /**
     * Register the given template engine callback `fn`
     * as `ext`.
     *
     * By default will `require()` the engine based on the
     * file extension. For example if you try to render
     * a "foo.ejs" file Express will invoke the following internally:
     *
     *     app.engine('ejs', require('ejs').__express);
     *
     * For engines that do not provide `.__express` out of the box,
     * or if you wish to "map" a different extension to the template engine
     * you may use this method. For example mapping the EJS template engine to
     * ".html" files:
     *
     *     app.engine('html', require('ejs').renderFile);
     *
     * In this case EJS provides a `.renderFile()` method with
     * the same signature that Express expects: `(path, options, callback)`,
     * though note that it aliases this method as `ejs.__express` internally
     * so if you're using ".ejs" extensions you dont need to do anything.
     *
     * Some template engines do not follow this convention, the
     * [Consolidate.js](https://github.com/tj/consolidate.js)
     * library was created to map all of node's popular template
     * engines to follow this convention, thus allowing them to
     * work seamlessly within Express.
     *
     * @param {String} ext
     * @param {Function} fn
     * @return {app} for chaining
     * @public
     */

//    app.engine = function engine(ext, fn) {
//        if (typeof fn !== 'function') {
//            throw new Error('callback function required');
//        }
//
//        // get file extension
//        var extension = ext[0] !== '.'
//        ? '.' + ext
//        : ext;
//
//        // store engine
//        this.engines[extension] = fn;
//
//        return this;
//    };

    /**
     * Proxy to `Router#param()` with one added api feature. The _name_ parameter
     * can be an array of names.
     *
     * See the Router#param() docs for more details.
     *
     * @param {String|Array} name
     * @param {Function} fn
     * @return {app} for chaining
     * @public
     */

//    app.param = function param(name, fn) {
//        this.lazyrouter();
//
//        if (Array.isArray(name)) {
//            for (var i = 0; i < name.length; i++) {
//                this.param(name[i], fn);
//            }
//
//            return this;
//        }
//
//        this._router.param(name, fn);
//
//        return this;
//    };

    /**
     * Assign `setting` to `val`, or return `setting`'s value.
     *
     *    app.set('foo', 'bar');
     *    app.set('foo');
     *    // => "bar"
     *
     * Mounted servers inherit their parent server's settings.
     *
     * @param {String} setting
     * @param {*} [val]
     * @return {Server} for chaining
     * @public
     */

//    app.set = function set(setting, val) {
//        if (arguments.length === 1) {
//            // app.get(setting)
//            return this.settings[setting];
//        }
//
//        debug('set "%s" to %o', setting, val);
//
//        // set value
//        this.settings[setting] = val;
//
//        // trigger matched settings
//        switch (setting) {
//            case 'etag':
//            this.set('etag fn', compileETag(val));
//            break;
//            case 'query parser':
//            this.set('query parser fn', compileQueryParser(val));
//            break;
//            case 'trust proxy':
//            this.set('trust proxy fn', compileTrust(val));
//
//            // trust proxy inherit back-compat
//            Object.defineProperty(this.settings, trustProxyDefaultSymbol, {
//                configurable: true,
//                value: false
//            });
//
//            break;
//        }
//
//        return this;
//    };

    /**
     * Return the app's absolute pathname
     * based on the parent(s) that have
     * mounted it.
     *
     * For example if the application was
     * mounted as "/admin", which itself
     * was mounted as "/blog" then the
     * return value would be "/blog/admin".
     *
     * @return {String}
     * @private
     */

//    app.path = function path() {
//        return this.parent
//        ? this.parent.path() + this.mountpath
//        : '';
//    };

    /**
     * Check if `setting` is enabled (truthy).
     *
     *    app.enabled('foo')
     *    // => false
     *
     *    app.enable('foo')
     *    app.enabled('foo')
     *    // => true
     *
     * @param {String} setting
     * @return {Boolean}
     * @public
     */

//    app.enabled = function enabled(setting) {
//        return Boolean(this.set(setting));
//    };

    /**
     * Check if `setting` is disabled.
     *
     *    app.disabled('foo')
     *    // => true
     *
     *    app.enable('foo')
     *    app.disabled('foo')
     *    // => false
     *
     * @param {String} setting
     * @return {Boolean}
     * @public
     */

//    app.disabled = function disabled(setting) {
//        return !this.set(setting);
//    };

    /**
     * Enable `setting`.
     *
     * @param {String} setting
     * @return {app} for chaining
     * @public
     */

//    app.enable = function enable(setting) {
//        return this.set(setting, true);
//    };

    /**
     * Disable `setting`.
     *
     * @param {String} setting
     * @return {app} for chaining
     * @public
     */

//    app.disable = function disable(setting) {
//        return this.set(setting, false);
//    };

    /**
     * Delegate `.VERB(...)` calls to `router.VERB(...)`.
     */

//    methods.forEach(function(method){
//        app[method] = function(path){
//            if (method === 'get' && arguments.length === 1) {
//                // app.get(setting)
//                return this.set(path);
//            }
//
//            this.lazyrouter();
//
//            var route = this._router.route(path);
//            route[method].apply(route, slice.call(arguments, 1));
//            return this;
//        };
//    });

    /**
     * Special-cased "all" method, applying the given route `path`,
     * middleware, and callback to _every_ HTTP method.
     *
     * @param {String} path
     * @param {Function} ...
     * @return {app} for chaining
     * @public
     */

//    app.all = function all(path) {
//        this.lazyrouter();
//
//        var route = this._router.route(path);
//        var args = slice.call(arguments, 1);
//
//        for (var i = 0; i < methods.length; i++) {
//            route[methods[i]].apply(route, args);
//        }
//
//        return this;
//    };

// del -> delete alias

//    app.del = deprecate.function(app.delete, 'app.del: Use app.delete instead');

    /**
     * Render the given view `name` name with `options`
     * and a callback accepting an error and the
     * rendered template string.
     *
     * Example:
     *
     *    app.render('email', { name: 'Tobi' }, function(err, html){
     *      // ...
     *    })
     *
     * @param {String} name
     * @param {Object|Function} options or fn
     * @param {Function} callback
     * @public
     */

//    app.render = function render(name, options, callback) {
//        var cache = this.cache;
//        var done = callback;
//        var engines = this.engines;
//        var opts = options;
//        var renderOptions = {};
//        var view;
//
//        // support callback function as second arg
//        if (typeof options === 'function') {
//            done = options;
//            opts = {};
//        }
//
//        // merge app.locals
//        merge(renderOptions, this.locals);
//
//        // merge options._locals
//        if (opts._locals) {
//            merge(renderOptions, opts._locals);
//        }
//
//        // merge options
//        merge(renderOptions, opts);
//
//        // set .cache unless explicitly provided
//        if (renderOptions.cache == null) {
//            renderOptions.cache = this.enabled('view cache');
//        }
//
//        // primed cache
//        if (renderOptions.cache) {
//            view = cache[name];
//        }
//
//        // view
//        if (!view) {
//            var View = this.get('view');
//
//            view = new View(name, {
//                defaultEngine: this.get('view engine'),
//                root: this.get('views'),
//                engines: engines
//            });
//
//            if (!view.path) {
//                var dirs = Array.isArray(view.root) && view.root.length > 1
//                ? 'directories "' + view.root.slice(0, -1).join('", "') + '" or "' + view.root[view.root.length - 1] + '"'
//                : 'directory "' + view.root + '"'
//                var err = new Error('Failed to lookup view "' + name + '" in views ' + dirs);
//                err.view = view;
//                return done(err);
//            }
//
//            // prime the cache
//            if (renderOptions.cache) {
//                cache[name] = view;
//            }
//        }
//
//        // render
//        tryRender(view, renderOptions, done);
//    };


    /**
     * Log error using console.error.
     *
     * @param {Error} err
     * @private
     */

//    function logerror(err) {
//        /* istanbul ignore next */
//        if (this.get('env') !== 'test') console.error(err.stack || err.toString());
//    }

    /**
     * Try rendering a view.
     * @private
     */

//    function tryRender(view, options, callback) {
//        try {
//            view.render(options, callback);
//        } catch (err) {
//            callback(err);
//        }
//    }

    private fun dispatch(context: Context) {
        if (stack.isEmpty()) {
            handle(context, this)
        } else {
            context.request.route = this
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
        fun handle(context: Context, next: NextProc) {
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
                context.request.params.add(params)
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

        override fun call(context: Context) {
            // signal to exit route
            if (context === Context.StopRoute) {
                done.call(context)
            }

            val layer = if (stack.isEmpty()) {
                null
            } else {
                stack.removeAt(0)
            }
            if (layer == null) {
                done.call(context)
            } else if (context.request.method != null && context.request.method != layer.method) {
                // 再帰呼び出し
                call(context)
            } else {
                // 間接的に再帰呼び出し
                layer.handle(context, this)
            }
        }
    }
}
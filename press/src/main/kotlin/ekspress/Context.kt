/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

import ekspress.externals.IncomingMessage
import ekspress.externals.ServerResponse
import ekspress.externals.req
import ekspress.externals.res

/**
 * middlewareを渡り歩いていくコンテキスト
 * errにErrorのインスタンスが割り当てられたら、
 * それ以降は、エラーリカバリか、
 * エラーを返すようにmiddlewareを実装する必要がある
 *
 * @args request リクエスト
 * @args response レスポンス
 */
class Context(
        val request: Request,
        val response: Response
) {
    companion object {
        /**
         * 処理の連鎖を中断させる特別なコンテキスト
         *
         * next.call(StopRoute)
         * と、呼び出せば、Applicationレベルまで処理が戻る
         */
        val StopRoute = Context(Request(), Response())
    }

    /**
     * エラーが起きていたらtrue
     */
    val hasError: Boolean get() = err != null

    /**
     * エラーを保持するプロパティ
     */
    private var err: Exception? = null

    /**
     * エラーの内容を取り出すためのプロパティ
     */
    @Suppress("unused")
    val error: Exception? get() = err

    /**
     * エラー発生時に呼び出すメソッド。
     * 一度セットしたらnullに戻せない
     */
    fun setError(err: Exception) {
        this.err = err
    }

    /**
     * パス・パラメータを管理するためのクラス
     */
    class Params {
        private val dict = HashMap<String, String>()

        @Suppress("unused")
        fun asString(key: String): String? = dict[key]

        @Suppress("unused")
        fun asInt(key: String): Int? = dict[key]?.toIntOrNull()

        @Suppress("unused")
        fun asLong(key: String): Long? = dict[key]?.toLongOrNull()

        @Suppress("unused")
        fun asFloat(key: String): Float? = dict[key]?.toFloatOrNull()

        @Suppress("unused")
        fun asDouble(key: String): Double? = dict[key]?.toDoubleOrNull()

        /**
         * 保持
         *
         * @args key キー
         * @args value 値
         */
        fun put(key: String, value: String) {
            dict[key] = value
        }

        /**
         * 保持
         *
         * @args entry キーと値の組み合わせ
         */
        fun put(entry: Map.Entry<String, String>) {
            put(entry.key, entry.value)
        }

        /**
         * 追加
         *
         * @args map追加する物が入ったマップ
         */
        fun add(map: Map<String, String>) {
            map.forEach {
                put(it)
            }
        }
    }

    /**
     * リクエスト
     */
    class Request(
            var route: Application? = null,
            var method: Method? = null,
            val params: Params = Params()
    ) : IncomingMessage by req() {

        /**
         * リクエスト・ヘッダの取得
         *
         * @args name パラメータ名
         * @return パラメータ、またはnull
         */
        @Suppress("unused")
        fun header(name: String): String? {
            // これがあの有名なTypoか。
            return when (name.toLowerCase()) {
                "referer",
                "referrer" -> arrayOf(this.headers.get("referer"), headers.get("referrer")).find { it != null }
                else -> this.headers.get(name)
            }
        }

        /**
         * header()のエイリアス
         */
        @Suppress("unused")
        fun get(name: String) = header(name)



        /**
         * To do: update docs.
         *
         * Check if the given `type(s)` is acceptable, returning
         * the best match when true, otherwise `undefined`, in which
         * case you should respond with 406 "Not Acceptable".
         *
         * The `type` value may be a single MIME type string
         * such as "application/json", an extension name
         * such as "json", a comma-delimited list such as "json, html, text/plain",
         * an argument list such as `"json", "html", "text/plain"`,
         * or an array `["json", "html", "text/plain"]`. When a list
         * or array is given, the _best_ match, if any is returned.
         *
         * Examples:
         *
         *     // Accept: text/html
         *     request.accepts('html');
         *     // => "html"
         *
         *     // Accept: text/ *, application/json
         *     request.accepts('html');
         *     // => "html"
         *     request.accepts('text/html');
         *     // => "text/html"
         *     request.accepts('json, text');
         *     // => "json"
         *     request.accepts('application/json');
         *     // => "application/json"
         *
         *     // Accept: text/ *, application/json
         *     request.accepts('image/png');
         *     request.accepts('png');
         *     // => undefined
         *
         *     // Accept: text/ *;q=.5, application/json
         *     request.accepts(['html', 'json']);
         *     request.accepts('html', 'json');
         *     request.accepts('html, json');
         *     // => "json"
         *
         * @param {String|Array} type(s)
         * @return {String|Array|Boolean}
         * @public
         */

        fun accepts() {

        }
//        request.accepts = function(){
//            var accept = accepts(this);
//            return accept.types.apply(accept, arguments);
//        };


        /**
         * Check if the given `encoding`s are accepted.
         *
         * @param {String} ...encoding
         * @return {String|Array}
         * @public
         */

//        request.acceptsEncodings = function(){
//            var accept = accepts(this);
//            return accept.encodings.apply(accept, arguments);
//        };

//        request.acceptsEncoding = deprecate.function(request.acceptsEncodings,
//        'request.acceptsEncoding: Use acceptsEncodings instead');

        /**
         * Check if the given `charset`s are acceptable,
         * otherwise you should respond with 406 "Not Acceptable".
         *
         * @param {String} ...charset
         * @return {String|Array}
         * @public
         */

//        request.acceptsCharsets = function(){
//            var accept = accepts(this);
//            return accept.charsets.apply(accept, arguments);
//        };

//        request.acceptsCharset = deprecate.function(request.acceptsCharsets,
//        'request.acceptsCharset: Use acceptsCharsets instead');

        /**
         * Check if the given `lang`s are acceptable,
         * otherwise you should respond with 406 "Not Acceptable".
         *
         * @param {String} ...lang
         * @return {String|Array}
         * @public
         */

//        request.acceptsLanguages = function(){
//            var accept = accepts(this);
//            return accept.languages.apply(accept, arguments);
//        };

//        request.acceptsLanguage = deprecate.function(request.acceptsLanguages,
//        'request.acceptsLanguage: Use acceptsLanguages instead');

        /**
         * Parse Range header field, capping to the given `size`.
         *
         * Unspecified ranges such as "0-" require knowledge of your resource length. In
         * the case of a byte range this is of course the total number of bytes. If the
         * Range header field is not given `undefined` is returned, `-1` when unsatisfiable,
         * and `-2` when syntactically invalid.
         *
         * When ranges are returned, the array has a "type" property which is the type of
         * range that is required (most commonly, "bytes"). Each array element is an object
         * with a "start" and "end" property for the portion of the range.
         *
         * The "combine" option can be set to `true` and overlapping & adjacent ranges
         * will be combined into a single range.
         *
         * NOTE: remember that ranges are inclusive, so for example "Range: users=0-3"
         * should respond with 4 users when available, not 3.
         *
         * @param {number} size
         * @param {object} [options]
         * @param {boolean} [options.combine=false]
         * @return {number|array}
         * @public
         */

//        request.range = function range(size, options) {
//            var range = this.get('Range');
//            if (!range) return;
//            return parseRange(size, range, options);
//        };

        /**
         * Return the value of param `name` when present or `defaultValue`.
         *
         *  - Checks route placeholders, ex: _/user/:id_
         *  - Checks body params, ex: id=12, {"id":12}
         *  - Checks query string params, ex: ?id=12
         *
         * To utilize request bodies, `request.body`
         * should be an object. This can be done by using
         * the `bodyParser()` middleware.
         *
         * @param {String} name
         * @param {Mixed} [defaultValue]
         * @return {String}
         * @public
         */

//        request.param = function param(name, defaultValue) {
//            var params = this.params || {};
//            var body = this.body || {};
//            var query = this.query || {};
//
//            var args = arguments.length === 1
//            ? 'name'
//            : 'name, default';
//            deprecate('request.param(' + args + '): Use request.params, request.body, or request.query instead');
//
//            if (null != params[name] && params.hasOwnProperty(name)) return params[name];
//            if (null != body[name]) return body[name];
//            if (null != query[name]) return query[name];
//
//            return defaultValue;
//        };

        /**
         * Check if the incoming request contains the "Content-Type"
         * header field, and it contains the give mime `type`.
         *
         * Examples:
         *
         *      // With Content-Type: text/html; charset=utf-8
         *      request.is('html');
         *      request.is('text/html');
         *      request.is('text/ *');
         *      // => true
         *
         *      // When Content-Type is application/json
         *      request.is('json');
         *      request.is('application/json');
         *      request.is('application/ *');
         *      // => true
         *
         *      request.is('html');
         *      // => false
         *
         * @param {String|Array} types...
         * @return {String|false|null}
         * @public
         */

//        request.is = function is(types) {
//            var arr = types;
//
//            // support flattened arguments
//            if (!Array.isArray(types)) {
//                arr = new Array(arguments.length);
//                for (var i = 0; i < arr.length; i++) {
//                    arr[i] = arguments[i];
//                }
//            }
//
//            return typeis(this, arr);
//        };

        /**
         * Return the protocol string "http" or "https"
         * when requested with TLS. When the "trust proxy"
         * setting trusts the socket address, the
         * "X-Forwarded-Proto" header field will be trusted
         * and used if present.
         *
         * If you're running behind a reverse proxy that
         * supplies https for you this may be enabled.
         *
         * @return {String}
         * @public
         */

//        defineGetter(request, 'protocol', function protocol(){
//            var proto = this.connection.encrypted
//            ? 'https'
//            : 'http';
//            var trust = this.app.get('trust proxy fn');
//
//            if (!trust(this.connection.remoteAddress, 0)) {
//                return proto;
//            }
//
//            // Note: X-Forwarded-Proto is normally only ever a
//            //       single value, but this is to be safe.
//            var header = this.get('X-Forwarded-Proto') || proto
//            var index = header.indexOf(',')
//
//            return index !== -1
//            ? header.substring(0, index).trim()
//            : header.trim()
//        });

        /**
         * Short-hand for:
         *
         *    request.protocol === 'https'
         *
         * @return {Boolean}
         * @public
         */

//        defineGetter(request, 'secure', function secure(){
//            return this.protocol === 'https';
//        });

        /**
         * Return the remote address from the trusted proxy.
         *
         * The is the remote address on the socket unless
         * "trust proxy" is set.
         *
         * @return {String}
         * @public
         */

//        defineGetter(request, 'ip', function ip(){
//            var trust = this.app.get('trust proxy fn');
//            return proxyaddr(this, trust);
//        });

        /**
         * When "trust proxy" is set, trusted proxy addresses + client.
         *
         * For example if the value were "client, proxy1, proxy2"
         * you would receive the array `["client", "proxy1", "proxy2"]`
         * where "proxy2" is the furthest down-stream and "proxy1" and
         * "proxy2" were trusted.
         *
         * @return {Array}
         * @public
         */

//        defineGetter(request, 'ips', function ips() {
//            var trust = this.app.get('trust proxy fn');
//            var addrs = proxyaddr.all(this, trust);
//
//            // reverse the order (to farthest -> closest)
//            // and remove socket address
//            addrs.reverse().pop()
//
//            return addrs
//        });

        /**
         * Return subdomains as an array.
         *
         * Subdomains are the dot-separated parts of the host before the main domain of
         * the app. By default, the domain of the app is assumed to be the last two
         * parts of the host. This can be changed by setting "subdomain offset".
         *
         * For example, if the domain is "tobi.ferrets.example.com":
         * If "subdomain offset" is not set, request.subdomains is `["ferrets", "tobi"]`.
         * If "subdomain offset" is 3, request.subdomains is `["tobi"]`.
         *
         * @return {Array}
         * @public
         */

//        defineGetter(request, 'subdomains', function subdomains() {
//            var hostname = this.hostname;
//
//            if (!hostname) return [];
//
//            var offset = this.app.get('subdomain offset');
//            var subdomains = !isIP(hostname)
//            ? hostname.split('.').reverse()
//            : [hostname];
//
//            return subdomains.slice(offset);
//        });

        /**
         * Short-hand for `url.parse(request.url).pathname`.
         *
         * @return {String}
         * @public
         */

//        defineGetter(request, 'path', function path() {
//            return parse(this).pathname;
//        });

        /**
         * Parse the "Host" header field to a hostname.
         *
         * When the "trust proxy" setting trusts the socket
         * address, the "X-Forwarded-Host" header field will
         * be trusted.
         *
         * @return {String}
         * @public
         */

//        defineGetter(request, 'hostname', function hostname(){
//            var trust = this.app.get('trust proxy fn');
//            var host = this.get('X-Forwarded-Host');
//
//            if (!host || !trust(this.connection.remoteAddress, 0)) {
//                host = this.get('Host');
//            }
//
//            if (!host) return;
//
//            // IPv6 literal support
//            var offset = host[0] === '['
//            ? host.indexOf(']') + 1
//            : 0;
//            var index = host.indexOf(':', offset);
//
//            return index !== -1
//            ? host.substring(0, index)
//            : host;
//        });

        // TODO: change request.host to return host in next major

//        defineGetter(request, 'host', deprecate.function(function host(){
//            return this.hostname;
//        }, 'request.host: Use request.hostname instead'));

        /**
         * Check if the request is fresh, aka
         * Last-Modified and/or the ETag
         * still match.
         *
         * @return {Boolean}
         * @public
         */

//        defineGetter(request, 'fresh', function(){
//            var method = this.method;
//            var response = this.response
//            var status = response.statusCode
//
//            // GET or HEAD for weak freshness validation only
//            if ('GET' !== method && 'HEAD' !== method) return false;
//
//            // 2xx or 304 as per rfc2616 14.26
//            if ((status >= 200 && status < 300) || 304 === status) {
//                return fresh(this.headers, {
//                    'etag': response.get('ETag'),
//                    'last-modified': response.get('Last-Modified')
//                })
//            }
//
//            return false;
//        });

        /**
         * Check if the request is stale, aka
         * "Last-Modified" and / or the "ETag" for the
         * resource has changed.
         *
         * @return {Boolean}
         * @public
         */

//        defineGetter(request, 'stale', function stale(){
//            return !this.fresh;
//        });

        /**
         * Check if the request was an _XMLHttpRequest_.
         *
         * @return {Boolean}
         * @public
         */

//        defineGetter(request, 'xhr', function xhr(){
//            var val = this.get('X-Requested-With') || '';
//            return val.toLowerCase() === 'xmlhttprequest';
//        });

        /**
         * Helper function for creating a getter on an object.
         *
         * @param {Object} obj
         * @param {String} name
         * @param {Function} getter
         * @private
         */
//        function defineGetter(obj, name, getter) {
//            Object.defineProperty(obj, name, {
//                configurable: true,
//                enumerable: true,
//                get: getter
//            });
//        }

    }

    /**
     * レスポンス
     */
    class Response : ServerResponse by res() {
        @Suppress("unused")
        var statusCode: Int = 200

        @Suppress("unused")
        fun send(body: String) {

        }

        /**
         * Module variables.
         * @private
         */

//        var charsetRegExp = /;\s*charset\s*=/;

        /**
         * Set status `code`.
         *
         * @param {Number} code
         * @return {ServerResponse}
         * @public
         */

//        response.status = function status(code) {
//            this.statusCode = code;
//            return this;
//        };

        /**
         * Set Link header field with the given `links`.
         *
         * Examples:
         *
         *    response.links({
         *      next: 'http://api.example.com/users?page=2',
         *      last: 'http://api.example.com/users?page=5'
         *    });
         *
         * @param {Object} links
         * @return {ServerResponse}
         * @public
         */

//        response.links = function(links){
//            var link = this.get('Link') || '';
//            if (link) link += ', ';
//            return this.set('Link', link + Object.keys(links).map(function(rel){
//                return '<' + links[rel] + '>; rel="' + rel + '"';
//            }).join(', '));
//        };

        /**
         * Send a response.
         *
         * Examples:
         *
         *     response.send(Buffer.from('wahoo'));
         *     response.send({ some: 'json' });
         *     response.send('<p>some html</p>');
         *
         * @param {string|number|boolean|object|Buffer} body
         * @public
         */

//        response.send = function send(body) {
//            var chunk = body;
//            var encoding;
//            var request = this.request;
//            var type;
//
//            // settings
//            var app = this.app;
//
//            // allow status / body
//            if (arguments.length === 2) {
//                // response.send(body, status) backwards compat
//                if (typeof arguments[0] !== 'number' && typeof arguments[1] === 'number') {
//                    deprecate('response.send(body, status): Use response.status(status).send(body) instead');
//                    this.statusCode = arguments[1];
//                } else {
//                    deprecate('response.send(status, body): Use response.status(status).send(body) instead');
//                    this.statusCode = arguments[0];
//                    chunk = arguments[1];
//                }
//            }
//
//            // disambiguate response.send(status) and response.send(status, num)
//            if (typeof chunk === 'number' && arguments.length === 1) {
//                // response.send(status) will set status message as text string
//                if (!this.get('Content-Type')) {
//                    this.type('txt');
//                }
//
//                deprecate('response.send(status): Use response.sendStatus(status) instead');
//                this.statusCode = chunk;
//                chunk = statuses[chunk]
//            }
//
//            switch (typeof chunk) {
//                // string defaulting to html
//                case 'string':
//                if (!this.get('Content-Type')) {
//                    this.type('html');
//                }
//                break;
//                case 'boolean':
//                case 'number':
//                case 'object':
//                if (chunk === null) {
//                    chunk = '';
//                } else if (Buffer.isBuffer(chunk)) {
//                    if (!this.get('Content-Type')) {
//                        this.type('bin');
//                    }
//                } else {
//                    return this.json(chunk);
//                }
//                break;
//            }
//
//            // write strings in utf-8
//            if (typeof chunk === 'string') {
//                encoding = 'utf8';
//                type = this.get('Content-Type');
//
//                // reflect this in content-type
//                if (typeof type === 'string') {
//                    this.set('Content-Type', setCharset(type, 'utf-8'));
//                }
//            }
//
//            // determine if ETag should be generated
//            var etagFn = app.get('etag fn')
//            var generateETag = !this.get('ETag') && typeof etagFn === 'function'
//
//            // populate Content-Length
//            var len
//            if (chunk !== undefined) {
//                if (Buffer.isBuffer(chunk)) {
//                    // get length of Buffer
//                    len = chunk.length
//                } else if (!generateETag && chunk.length < 1000) {
//                    // just calculate length when no ETag + small chunk
//                    len = Buffer.byteLength(chunk, encoding)
//                } else {
//                    // convert chunk to Buffer and calculate
//                    chunk = Buffer.from(chunk, encoding)
//                    encoding = undefined;
//                    len = chunk.length
//                }
//
//                this.set('Content-Length', len);
//            }
//
//            // populate ETag
//            var etag;
//            if (generateETag && len !== undefined) {
//                if ((etag = etagFn(chunk, encoding))) {
//                    this.set('ETag', etag);
//                }
//            }
//
//            // freshness
//            if (request.fresh) this.statusCode = 304;
//
//            // strip irrelevant headers
//            if (204 === this.statusCode || 304 === this.statusCode) {
//                this.removeHeader('Content-Type');
//                this.removeHeader('Content-Length');
//                this.removeHeader('Transfer-Encoding');
//                chunk = '';
//            }
//
//            if (request.method === 'HEAD') {
//                // skip body for HEAD
//                this.end();
//            } else {
//                // respond
//                this.end(chunk, encoding);
//            }
//
//            return this;
//        };

        /**
         * Send JSON response.
         *
         * Examples:
         *
         *     response.json(null);
         *     response.json({ user: 'tj' });
         *
         * @param {string|number|boolean|object} obj
         * @public
         */

//        response.json = function json(obj) {
//            var val = obj;
//
//            // allow status / body
//            if (arguments.length === 2) {
//                // response.json(body, status) backwards compat
//                if (typeof arguments[1] === 'number') {
//                    deprecate('response.json(obj, status): Use response.status(status).json(obj) instead');
//                    this.statusCode = arguments[1];
//                } else {
//                    deprecate('response.json(status, obj): Use response.status(status).json(obj) instead');
//                    this.statusCode = arguments[0];
//                    val = arguments[1];
//                }
//            }
//
//            // settings
//            var app = this.app;
//            var escape = app.get('json escape')
//            var replacer = app.get('json replacer');
//            var spaces = app.get('json spaces');
//            var body = stringify(val, replacer, spaces, escape)
//
//            // content-type
//            if (!this.get('Content-Type')) {
//                this.set('Content-Type', 'application/json');
//            }
//
//            return this.send(body);
//        };

        /**
         * Send JSON response with JSONP callback support.
         *
         * Examples:
         *
         *     response.jsonp(null);
         *     response.jsonp({ user: 'tj' });
         *
         * @param {string|number|boolean|object} obj
         * @public
         */

//        response.jsonp = function jsonp(obj) {
//            var val = obj;
//
//            // allow status / body
//            if (arguments.length === 2) {
//                // response.json(body, status) backwards compat
//                if (typeof arguments[1] === 'number') {
//                    deprecate('response.jsonp(obj, status): Use response.status(status).json(obj) instead');
//                    this.statusCode = arguments[1];
//                } else {
//                    deprecate('response.jsonp(status, obj): Use response.status(status).jsonp(obj) instead');
//                    this.statusCode = arguments[0];
//                    val = arguments[1];
//                }
//            }
//
//            // settings
//            var app = this.app;
//            var escape = app.get('json escape')
//            var replacer = app.get('json replacer');
//            var spaces = app.get('json spaces');
//            var body = stringify(val, replacer, spaces, escape)
//            var callback = this.request.query[app.get('jsonp callback name')];
//
//            // content-type
//            if (!this.get('Content-Type')) {
//                this.set('X-Content-Type-Options', 'nosniff');
//                this.set('Content-Type', 'application/json');
//            }
//
//            // fixup callback
//            if (Array.isArray(callback)) {
//                callback = callback[0];
//            }
//
//            // jsonp
//            if (typeof callback === 'string' && callback.length !== 0) {
//                this.set('X-Content-Type-Options', 'nosniff');
//                this.set('Content-Type', 'text/javascript');
//
//                // restrict callback charset
//                callback = callback.replace(/[^\[\]\w$.]/g, '');
//
//                // replace chars not allowed in JavaScript that are in JSON
//                body = body
//                        .replace(/\u2028/g, '\\u2028')
//                .replace(/\u2029/g, '\\u2029');
//
//                // the /**/ is a specific security mitigation for "Rosetta Flash JSONP abuse"
//                // the typeof check is just to reduce client error noise
//                body = '/**/ typeof ' + callback + ' === \'function\' && ' + callback + '(' + body + ');';
//            }
//
//            return this.send(body);
//        };

        /**
         * Send given HTTP status code.
         *
         * Sets the response status to `statusCode` and the body of the
         * response to the standard description from node's http.STATUS_CODES
         * or the statusCode number if no description.
         *
         * Examples:
         *
         *     response.sendStatus(200);
         *
         * @param {number} statusCode
         * @public
         */

//        response.sendStatus = function sendStatus(statusCode) {
//            var body = statuses[statusCode] || String(statusCode)
//
//            this.statusCode = statusCode;
//            this.type('txt');
//
//            return this.send(body);
//        };

        /**
         * Transfer the file at the given `path`.
         *
         * Automatically sets the _Content-Type_ response header field.
         * The callback `callback(err)` is invoked when the transfer is complete
         * or when an error occurs. Be sure to check `response.sentHeader`
         * if you wish to attempt responding, as the header and some data
         * may have already been transferred.
         *
         * Options:
         *
         *   - `maxAge`   defaulting to 0 (can be string converted by `ms`)
         *   - `root`     root directory for relative filenames
         *   - `headers`  object of headers to serve with file
         *   - `dotfiles` serve dotfiles, defaulting to false; can be `"allow"` to send them
         *
         * Other options are passed along to `send`.
         *
         * Examples:
         *
         *  The following example illustrates how `response.sendFile()` may
         *  be used as an alternative for the `static()` middleware for
         *  dynamic situations. The code backing `response.sendFile()` is actually
         *  the same code, so HTTP cache support etc is identical.
         *
         *     app.get('/user/:uid/photos/:file', function(request, response){
         *       var uid = request.params.uid
         *         , file = request.params.file;
         *
         *       request.user.mayViewFilesFrom(uid, function(yes){
         *         if (yes) {
         *           response.sendFile('/uploads/' + uid + '/' + file);
         *         } else {
         *           response.send(403, 'Sorry! you cant see that.');
         *         }
         *       });
         *     });
         *
         * @public
         */

//        response.sendFile = function sendFile(path, options, callback) {
//            var done = callback;
//            var request = this.request;
//            var response = this;
//            var next = request.next;
//            var opts = options || {};
//
//            if (!path) {
//                throw new TypeError('path argument is required to response.sendFile');
//            }
//
//            // support function as second arg
//            if (typeof options === 'function') {
//                done = options;
//                opts = {};
//            }
//
//            if (!opts.root && !isAbsolute(path)) {
//                throw new TypeError('path must be absolute or specify root to response.sendFile');
//            }
//
//            // create file stream
//            var pathname = encodeURI(path);
//            var file = send(request, pathname, opts);
//
//            // transfer
//            sendfile(response, file, opts, function (err) {
//                if (done) return done(err);
//                if (err && err.code === 'EISDIR') return next();
//
//                // next() all but write errors
//                if (err && err.code !== 'ECONNABORTED' && err.syscall !== 'write') {
//                    next(err);
//                }
//            });
//        };

        /**
         * Transfer the file at the given `path`.
         *
         * Automatically sets the _Content-Type_ response header field.
         * The callback `callback(err)` is invoked when the transfer is complete
         * or when an error occurs. Be sure to check `response.sentHeader`
         * if you wish to attempt responding, as the header and some data
         * may have already been transferred.
         *
         * Options:
         *
         *   - `maxAge`   defaulting to 0 (can be string converted by `ms`)
         *   - `root`     root directory for relative filenames
         *   - `headers`  object of headers to serve with file
         *   - `dotfiles` serve dotfiles, defaulting to false; can be `"allow"` to send them
         *
         * Other options are passed along to `send`.
         *
         * Examples:
         *
         *  The following example illustrates how `response.sendfile()` may
         *  be used as an alternative for the `static()` middleware for
         *  dynamic situations. The code backing `response.sendfile()` is actually
         *  the same code, so HTTP cache support etc is identical.
         *
         *     app.get('/user/:uid/photos/:file', function(request, response){
         *       var uid = request.params.uid
         *         , file = request.params.file;
         *
         *       request.user.mayViewFilesFrom(uid, function(yes){
         *         if (yes) {
         *           response.sendfile('/uploads/' + uid + '/' + file);
         *         } else {
         *           response.send(403, 'Sorry! you cant see that.');
         *         }
         *       });
         *     });
         *
         * @public
         */

//        response.sendfile = function (path, options, callback) {
//            var done = callback;
//            var request = this.request;
//            var response = this;
//            var next = request.next;
//            var opts = options || {};
//
//            // support function as second arg
//            if (typeof options === 'function') {
//                done = options;
//                opts = {};
//            }
//
//            // create file stream
//            var file = send(request, path, opts);
//
//            // transfer
//            sendfile(response, file, opts, function (err) {
//                if (done) return done(err);
//                if (err && err.code === 'EISDIR') return next();
//
//                // next() all but write errors
//                if (err && err.code !== 'ECONNABORT' && err.syscall !== 'write') {
//                    next(err);
//                }
//            });
//        };

//        response.sendfile = deprecate.function(response.sendfile,
//        'response.sendfile: Use response.sendFile instead');

        /**
         * Transfer the file at the given `path` as an attachment.
         *
         * Optionally providing an alternate attachment `filename`,
         * and optional callback `callback(err)`. The callback is invoked
         * when the data transfer is complete, or when an error has
         * ocurred. Be sure to check `response.headersSent` if you plan to respond.
         *
         * Optionally providing an `options` object to use with `response.sendFile()`.
         * This function will set the `Content-Disposition` header, overriding
         * any `Content-Disposition` header passed as header options in order
         * to set the attachment and filename.
         *
         * This method uses `response.sendFile()`.
         *
         * @public
         */

//        response.download = function download (path, filename, options, callback) {
//            var done = callback;
//            var name = filename;
//            var opts = options || null
//
//            // support function as second or third arg
//            if (typeof filename === 'function') {
//                done = filename;
//                name = null;
//                opts = null
//            } else if (typeof options === 'function') {
//                done = options
//                opts = null
//            }
//
//            // set Content-Disposition when file is sent
//            var headers = {
//                'Content-Disposition': contentDisposition(name || path)
//            };
//
//            // merge user-provided headers
//            if (opts && opts.headers) {
//                var keys = Object.keys(opts.headers)
//                for (var i = 0; i < keys.length; i++) {
//                    var key = keys[i]
//                    if (key.toLowerCase() !== 'content-disposition') {
//                        headers[key] = opts.headers[key]
//                    }
//                }
//            }
//
//            // merge user-provided options
//            opts = Object.create(opts)
//            opts.headers = headers
//
//            // Resolve the full path for sendFile
//            var fullPath = resolve(path);
//
//            // send file
//            return this.sendFile(fullPath, opts, done)
//        };

        /**
         * Set _Content-Type_ response header with `type` through `mime.lookup()`
         * when it does not contain "/", or set the Content-Type to `type` otherwise.
         *
         * Examples:
         *
         *     response.type('.html');
         *     response.type('html');
         *     response.type('json');
         *     response.type('application/json');
         *     response.type('png');
         *
         * @param {String} type
         * @return {ServerResponse} for chaining
         * @public
         */

//        response.contentType =
//        response.type = function contentType(type) {
//            var ct = type.indexOf('/') === -1
//            ? mime.lookup(type)
//            : type;
//
//            return this.set('Content-Type', ct);
//        };

        /**
         * Respond to the Acceptable formats using an `obj`
         * of mime-type callbacks.
         *
         * This method uses `request.accepted`, an array of
         * acceptable types ordered by their quality values.
         * When "Accept" is not present the _first_ callback
         * is invoked, otherwise the first match is used. When
         * no match is performed the server responds with
         * 406 "Not Acceptable".
         *
         * Content-Type is set for you, however if you choose
         * you may alter this within the callback using `response.type()`
         * or `response.set('Content-Type', ...)`.
         *
         *    response.format({
         *      'text/plain': function(){
         *        response.send('hey');
         *      },
         *
         *      'text/html': function(){
         *        response.send('<p>hey</p>');
         *      },
         *
         *      'appliation/json': function(){
         *        response.send({ message: 'hey' });
         *      }
         *    });
         *
         * In addition to canonicalized MIME types you may
         * also use extnames mapped to these types:
         *
         *    response.format({
         *      text: function(){
         *        response.send('hey');
         *      },
         *
         *      html: function(){
         *        response.send('<p>hey</p>');
         *      },
         *
         *      json: function(){
         *        response.send({ message: 'hey' });
         *      }
         *    });
         *
         * By default Express passes an `Error`
         * with a `.status` of 406 to `next(err)`
         * if a match is not made. If you provide
         * a `.default` callback it will be invoked
         * instead.
         *
         * @param {Object} obj
         * @return {ServerResponse} for chaining
         * @public
         */

//        response.format = function(obj){
//            var request = this.request;
//            var next = request.next;
//
//            var fn = obj.default;
//            if (fn) delete obj.default;
//            var keys = Object.keys(obj);
//
//            var key = keys.length > 0
//            ? request.accepts(keys)
//            : false;
//
//            this.vary("Accept");
//
//            if (key) {
//                this.set('Content-Type', normalizeType(key).value);
//                obj[key](request, this, next);
//            } else if (fn) {
//                fn();
//            } else {
//                var err = new Error('Not Acceptable');
//                err.status = err.statusCode = 406;
//                err.types = normalizeTypes(keys).map(function(o){ return o.value });
//                next(err);
//            }
//
//            return this;
//        };

        /**
         * Set _Content-Disposition_ header to _attachment_ with optional `filename`.
         *
         * @param {String} filename
         * @return {ServerResponse}
         * @public
         */

//        response.attachment = function attachment(filename) {
//            if (filename) {
//                this.type(extname(filename));
//            }
//
//            this.set('Content-Disposition', contentDisposition(filename));
//
//            return this;
//        };

        /**
         * Append additional header `field` with value `val`.
         *
         * Example:
         *
         *    response.append('Link', ['<http://localhost/>', '<http://localhost:3000/>']);
         *    response.append('Set-Cookie', 'foo=bar; Path=/; HttpOnly');
         *    response.append('Warning', '199 Miscellaneous warning');
         *
         * @param {String} field
         * @param {String|Array} val
         * @return {ServerResponse} for chaining
         * @public
         */

//        response.append = function append(field, val) {
//            var prev = this.get(field);
//            var value = val;
//
//            if (prev) {
//                // concat the new and prev vals
//                value = Array.isArray(prev) ? prev.concat(val)
//                : Array.isArray(val) ? [prev].concat(val)
//                : [prev, val];
//            }
//
//            return this.set(field, value);
//        };

        /**
         * Set header `field` to `val`, or pass
         * an object of header fields.
         *
         * Examples:
         *
         *    response.set('Foo', ['bar', 'baz']);
         *    response.set('Accept', 'application/json');
         *    response.set({ Accept: 'text/plain', 'X-API-Key': 'tobi' });
         *
         * Aliased as `response.header()`.
         *
         * @param {String|Object} field
         * @param {String|Array} val
         * @return {ServerResponse} for chaining
         * @public
         */

//        response.set =
//        response.header = function header(field, val) {
//            if (arguments.length === 2) {
//                var value = Array.isArray(val)
//                ? val.map(String)
//                        : String(val);
//
//                // add charset to content-type
//                if (field.toLowerCase() === 'content-type') {
//                    if (Array.isArray(value)) {
//                        throw new TypeError('Content-Type cannot be set to an Array');
//                    }
//                    if (!charsetRegExp.test(value)) {
//                        var charset = mime.charsets.lookup(value.split(';')[0]);
//                        if (charset) value += '; charset=' + charset.toLowerCase();
//                    }
//                }
//
//                this.setHeader(field, value);
//            } else {
//                for (var key in field) {
//                    this.set(key, field[key]);
//                }
//            }
//            return this;
//        };

        /**
         * Get value for header `field`.
         *
         * @param {String} field
         * @return {String}
         * @public
         */

//        response.get = function(field){
//            return this.getHeader(field);
//        };

        /**
         * Clear cookie `name`.
         *
         * @param {String} name
         * @param {Object} [options]
         * @return {ServerResponse} for chaining
         * @public
         */

//        response.clearCookie = function clearCookie(name, options) {
//            var opts = merge({ expires: new Date(1), path: '/' }, options);
//
//            return this.cookie(name, '', opts);
//        };

        /**
         * Set cookie `name` to `value`, with the given `options`.
         *
         * Options:
         *
         *    - `maxAge`   max-age in milliseconds, converted to `expires`
         *    - `signed`   sign the cookie
         *    - `path`     defaults to "/"
         *
         * Examples:
         *
         *    // "Remember Me" for 15 minutes
         *    response.cookie('rememberme', '1', { expires: new Date(Date.now() + 900000), httpOnly: true });
         *
         *    // save as above
         *    response.cookie('rememberme', '1', { maxAge: 900000, httpOnly: true })
         *
         * @param {String} name
         * @param {String|Object} value
         * @param {Object} [options]
         * @return {ServerResponse} for chaining
         * @public
         */

//        response.cookie = function (name, value, options) {
//            var opts = merge({}, options);
//            var secret = this.request.secret;
//            var signed = opts.signed;
//
//            if (signed && !secret) {
//                throw new Error('cookieParser("secret") required for signed cookies');
//            }
//
//            var val = typeof value === 'object'
//            ? 'j:' + JSON.stringify(value)
//            : String(value);
//
//            if (signed) {
//                val = 's:' + sign(val, secret);
//            }
//
//            if ('maxAge' in opts) {
//                opts.expires = new Date(Date.now() + opts.maxAge);
//                opts.maxAge /= 1000;
//            }
//
//            if (opts.path == null) {
//                opts.path = '/';
//            }
//
//            this.append('Set-Cookie', cookie.serialize(name, String(val), opts));
//
//            return this;
//        };

        /**
         * Set the location header to `url`.
         *
         * The given `url` can also be "back", which redirects
         * to the _Referrer_ or _Referer_ headers or "/".
         *
         * Examples:
         *
         *    response.location('/foo/bar').;
         *    response.location('http://example.com');
         *    response.location('../login');
         *
         * @param {String} url
         * @return {ServerResponse} for chaining
         * @public
         */

//        response.location = function location(url) {
//            var loc = url;
//
//            // "back" is an alias for the referrer
//            if (url === 'back') {
//                loc = this.request.get('Referrer') || '/';
//            }
//
//            // set location
//            return this.set('Location', encodeUrl(loc));
//        };

        /**
         * Redirect to the given `url` with optional response `status`
         * defaulting to 302.
         *
         * The resulting `url` is determined by `response.location()`, so
         * it will play nicely with mounted apps, relative paths,
         * `"back"` etc.
         *
         * Examples:
         *
         *    response.redirect('/foo/bar');
         *    response.redirect('http://example.com');
         *    response.redirect(301, 'http://example.com');
         *    response.redirect('../login'); // /blog/post/1 -> /blog/login
         *
         * @public
         */

//        response.redirect = function redirect(url) {
//            var address = url;
//            var body;
//            var status = 302;
//
//            // allow status / url
//            if (arguments.length === 2) {
//                if (typeof arguments[0] === 'number') {
//                    status = arguments[0];
//                    address = arguments[1];
//                } else {
//                    deprecate('response.redirect(url, status): Use response.redirect(status, url) instead');
//                    status = arguments[1];
//                }
//            }
//
//            // Set location header
//            address = this.location(address).get('Location');
//
//            // Support text/{plain,html} by default
//            this.format({
//                    text: function(){
//                    body = statuses[status] + '. Redirecting to ' + address
//                },
//
//                    html: function(){
//                    var u = escapeHtml(address);
//                    body = '<p>' + statuses[status] + '. Redirecting to <a href="' + u + '">' + u + '</a></p>'
//                },
//
//                    default: function(){
//                    body = '';
//                }
//            });
//
//            // Respond
//            this.statusCode = status;
//            this.set('Content-Length', Buffer.byteLength(body));
//
//            if (this.request.method === 'HEAD') {
//                this.end();
//            } else {
//                this.end(body);
//            }
//        };

        /**
         * Add `field` to Vary. If already present in the Vary set, then
         * this call is simply ignored.
         *
         * @param {Array|String} field
         * @return {ServerResponse} for chaining
         * @public
         */

//        response.vary = function(field){
//            // checks for back-compat
//            if (!field || (Array.isArray(field) && !field.length)) {
//                deprecate('response.vary(): Provide a field name');
//                return this;
//            }
//
//            vary(this, field);
//
//            return this;
//        };

        /**
         * Render `view` with the given `options` and optional callback `fn`.
         * When a callback function is given a response will _not_ be made
         * automatically, otherwise a response of _200_ and _text/html_ is given.
         *
         * Options:
         *
         *  - `cache`     boolean hinting to the engine it should cache
         *  - `filename`  filename of the view being rendered
         *
         * @public
         */

//        response.render = function render(view, options, callback) {
//            var app = this.request.app;
//            var done = callback;
//            var opts = options || {};
//            var request = this.request;
//            var self = this;
//
//            // support callback function as second arg
//            if (typeof options === 'function') {
//                done = options;
//                opts = {};
//            }
//
//            // merge response.locals
//            opts._locals = self.locals;
//
//            // default callback to respond
//            done = done || function (err, str) {
//                if (err) return request.next(err);
//                self.send(str);
//            };
//
//            // render
//            app.render(view, opts, done);
//        };

        // pipe the send file stream
//        function sendfile(response, file, options, callback) {
//            var done = false;
//            var streaming;
//
//            // request aborted
//            function onaborted() {
//                if (done) return;
//                done = true;
//
//                var err = new Error('Request aborted');
//                err.code = 'ECONNABORTED';
//                callback(err);
//            }
//
//            // directory
//            function ondirectory() {
//                if (done) return;
//                done = true;
//
//                var err = new Error('EISDIR, read');
//                err.code = 'EISDIR';
//                callback(err);
//            }
//
//            // errors
//            function onerror(err) {
//                if (done) return;
//                done = true;
//                callback(err);
//            }
//
//            // ended
//            function onend() {
//                if (done) return;
//                done = true;
//                callback();
//            }
//
//            // file
//            function onfile() {
//                streaming = false;
//            }
//
//            // finished
//            function onfinish(err) {
//                if (err && err.code === 'ECONNRESET') return onaborted();
//                if (err) return onerror(err);
//                if (done) return;
//
//                setImmediate(function () {
//                    if (streaming !== false && !done) {
//                        onaborted();
//                        return;
//                    }
//
//                    if (done) return;
//                    done = true;
//                    callback();
//                });
//            }
//
//            // streaming
//            function onstream() {
//                streaming = true;
//            }
//
//            file.on('directory', ondirectory);
//            file.on('end', onend);
//            file.on('error', onerror);
//            file.on('file', onfile);
//            file.on('stream', onstream);
//            onFinished(response, onfinish);
//
//            if (options.headers) {
//                // set headers on successful transfer
//                file.on('headers', function headers(response) {
//                    var obj = options.headers;
//                    var keys = Object.keys(obj);
//
//                    for (var i = 0; i < keys.length; i++) {
//                    var k = keys[i];
//                    response.setHeader(k, obj[k]);
//                }
//                });
//            }
//
//            // pipe
//            file.pipe(response);
//        }
//
        /**
         * Stringify JSON, like JSON.stringify, but v8 optimized, with the
         * ability to escape characters that can trigger HTML sniffing.
         *
         * @param {*} value
         * @param {function} replaces
         * @param {number} spaces
         * @param {boolean} escape
         * @returns {string}
         * @private
         */

//        function stringify (value, replacer, spaces, escape) {
//            // v8 checks arguments.length for optimizing simple call
//            // https://bugs.chromium.org/p/v8/issues/detail?id=4730
//            var json = replacer || spaces
//            ? JSON.stringify(value, replacer, spaces)
//            : JSON.stringify(value);
//
//            if (escape) {
//                json = json.replace(/[<>&]/g, function (c) {
//                    switch (c.charCodeAt(0)) {
//                        case 0x3c:
//                        return '\\u003c'
//                        case 0x3e:
//                        return '\\u003e'
//                        case 0x26:
//                        return '\\u0026'
//                        default:
//                        return c
//                    }
//                })
//            }
//
//            return json
//        }

    }
}

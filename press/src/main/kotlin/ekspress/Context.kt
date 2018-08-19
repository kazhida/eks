/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

import ekspress.externals.*
import org.w3c.fetch.Headers
import kotlin.js.Date
import kotlin.js.RegExp

/**
 * middlewareを渡り歩いていくコンテキスト
 * errにErrorのインスタンスが割り当てられたら、
 * それ以降は、エラーリカバリか、
 * エラーを返すようにmiddlewareを実装する必要がある
 *
 * @args req リクエスト
 * @args res レスポンス
 */
class Context(
        val app: Application,
        val req: dynamic,
        val res: dynamic
) {
    val request = Request(app, this, req, res)
    val response = Response(app, this, req, res)
    var status: Int = 404
    var body: Any? = null  // todo ちゃんと実装
    var stoped: Boolean = false

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

    fun stop(): Context = apply {
        stoped = true
    }

    val isEmptyStatus: Boolean get() = when (status) {
        204,
        205,
        304 -> true
        else -> false
    }

    @Suppress("unused")
    val params by lazy { Params() }
    @Suppress("unused")
    val cookies by lazy { Cookies() }

    /**
     * パス・パラメータを管理するためのクラス
     */
    @Suppress("unused")
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

        @Suppress("unused")
        fun put(key: String, value: String) {
            dict[key] = value
        }

        @Suppress("unused")
        fun put(entry: Map.Entry<String, String>) {
            put(entry.key, entry.value)
        }

        @Suppress("unused")
        fun add(map: Map<String, String>) {
            map.forEach {
                put(it)
            }
        }
    }

    /**
     * Default error handling.
     *
     * @param {Error} err
     * @api private
     */
    fun onError(err: Error?) {
        // don't do anything if there is no error.
        // this allows you to pass `this.onerror`
        // to node-style callbacks.
        if (null == err) return

//        if (!(err instanceof Error)) {
//            err = new Error(util.format('non-error thrown: %j', err))
//        };
//
//        var headerSent = false
//        if (this.headerSent || !this.writable) {
//            headerSent = err.headerSent = true;
//        }
//
//        // delegate
//        this.app.emit('error', err, this);
//
//        // nothing we can do here other
//        // than delegate to the app-level
//        // handler and log.
//        if (headerSent) {
//            return;
//        }
//
//        const { res } = this;
//
//        // first unset all headers
//        /* istanbul ignore else */
//        if (typeof res.getHeaderNames === 'function') {
//            res.getHeaderNames().forEach(name => res.removeHeader(name));
//        } else {
//            res._headers = {}; // Node < 7.7
//        }
//
//        // then set those specified
//        this.set(err.headers);
//
//        // force text/plain
//        this.type = 'text';
//
//        // ENOENT support
//        if ('ENOENT' == err.code) err.status = 404;
//
//        // default to 500
//        if ('number' != typeof err.status || !statuses[err.status]) err.status = 500;
//
//        // respond
//        const code = statuses[err.status];
//        const msg = err.expose ? err.message : code;
//        this.status = err.status;
//        this.length = Buffer.byteLength(msg);
//        this.res.end(msg);
    }

    /**
     * リクエスト
     */
    class Request(
            @Suppress("unused")
            val app: Application,
            @Suppress("unused")
            val context: Context,
            @Suppress("unused")
            private val req: dynamic,
            @Suppress("unused")
            private val res: dynamic
    ) {
        private val response: Response by lazy { context.response }

        @Suppress("unused")
        val originalUrl: String? = req.url?.unsafeCast<String?>()
        @Suppress("unused")
        private val accept by lazy { Accepts(req) }
        @Suppress("unused")
        private var _querycache: dynamic = null
        //private var memoizedURL: URL? = null
        private var remoteAddress: String? = null

        @Suppress("unused")
        private fun isInvalid(some: dynamic): Boolean = some == null || some == undefined
        @Suppress("unused")
        private fun isValid(some: dynamic): Boolean = some != null && some != undefined

        @Suppress("unused")
        fun acceptsLanguages(vararg languages: String): Boolean {
            return accept.languages(languages)
        }

        @Suppress("unused")
        fun acceptsEncodings(vararg encodings: String): Boolean {
            return accept.encodings(encodings)
        }

        @Suppress("unused")
        fun acceptsCharsets(vararg charsets: String): Boolean {
            return accept.charsets(charsets)
        }

        @Suppress("unused")
        fun accepts(vararg types: String): Boolean {
            return accept.types(types)
        }

        fun get(field: String): String? = req?.let { req ->
            field.toLowerCase().let { field ->
                when (field) {
                    "referer",
                    "referrer" -> listOf(
                            req.headers.get("referer"),
                            req.headers.get("referrer")
                    ).firstOrNull {
                        it != null && it != undefined
                    }
                    else -> req.headers.get(field)
                }
            }
        } as? String

        @Suppress("unused")
        var querystring: String
            get() = if (req == null) "" else parseurl(req)?.query ?: ""
            set(value) {
                val url = parseurl(req)
                if (url?.search != "?$value") {
                    url?.search = value
                    url?.path = null
                }
                this.url = NodeUrl.format(url, null)
            }

        @Suppress("unused")
        val idempotent: Boolean get() = true

        @Suppress("unused")
        val socket: Socket? get() = req.socket?.unsafeCast<Socket?>()

        @Suppress("unused")
        var search: String
            get() = "?$querystring"
            set(value) {
                querystring = value
            }

        @Suppress("unused")
        var method: Method?
            get() = when (req?.method?.unsafeCast<String?>()?.toUpperCase()) {
                "HEAD" -> Method.HEAD
                "GET" -> Method.GET
                "PUT" -> Method.PUT
                "POST" -> Method.POST
                "DELETE" -> Method.DELETE
                else -> null
            }
            set(value) {
                this.req?.method = when (value) {
                    Method.HEAD -> "HEAD"
                    Method.GET -> "GET"
                    Method.PUT -> "PUT"
                    Method.POST -> "POST"
                    Method.DELETE -> "DELETE"
                    else -> ""
                }
            }

        @Suppress("unused")
        var query: Any?
            get() {
                val s = querystring
                val c = _querycache
                if (c[s] == null) {
                    c[s] = NodeQueryString.parse(s, null, null, null)
                }
                return c[s]?.unsafeCast<Any?>()
            }
            set(value) {
                querystring = NodeQueryString.stringify(value, null, null, null) ?: ""
            }

        @Suppress("unused")
        var path: String?
            get() = NodeUrl.parse(req?.unsafeCast<Any?>())?.pathname
            set(value) {
                val url = NodeUrl.parse(req?.unsafeCast<Any?>())
                if (url != null && url.pathname != value) {
                    url.pathname = value
                    url.path = null
                    this.url = NodeQueryString.stringify(url, null, null, null)
                }
            }

        @Suppress("unused")
        var url: String?
            get() = req.url?.unsafeCast<String?>()
            set(value) { req.url = value }

        @Suppress("unused")
        val origin: String get() = "$protocol://$host"

        @Suppress("unused")
        val href: String get() = when {
            originalUrl == null -> ""
            isUrl(originalUrl)  -> originalUrl
            else                -> origin + originalUrl
        }

        private fun isUrl(url: String): Boolean = RegExp("^https?:\\/\\/", "i").test(url)

        @Suppress("unused")
        val subdomains: List<String> get() {
            val offset = this.app.subdomainOffset
            val hostname = this.hostname
            if (NodeNet.isIP(hostname) != 0) return ArrayList()
            val reversed = hostname.split('.').reversed()
            return reversed.slice(offset until reversed.size)
        }

        @Suppress("unused")
        val protocol: String get() {
            if (socket?.encrypted == true) return "https"
            if (!this.app.proxy) return "http"
            val proto: String? = this.get("X-Forwarded-Proto")
            return if (proto != null) {
                proto.split(Regex("\\s*,\\s*"))[0]
            } else {
                "http"
            }
        }

        @Suppress("unused")
        val host: String get() {
            val proxy = this.app.proxy
            val host = if (proxy) {
                get("X-Forwarded-Host")
            } else {
                get("Host")
            }

            return if (host == null) {
                ""
            } else {
                host.split(Regex("\\s*,\\s*"))[0]
            }
        }

        @Suppress("unused")
        val hostname: String get() {
            val host = this.host
            return when {
                host.isEmpty() -> ""
                host.startsWith("[") -> // IPv6
                    //URL.hostname ?: ""
                    // fixme URLの実装ができない
                    ""
                else -> host.split(":")[0]
            }
        }

        /**
         * Get WHATWG parsed URL.
         * Lazily memoized.
         *
         * @return {URL|Object}
         * @api public
         */
//        val URL: URL {
//            return if (memoizedURL == null || memoizedURL == undefined) {
//                val p = protocol
//                val h = host
//                val u = originalUrl ?: ""
//                try {
//                    memoizedURL = URL("${protocol}://${host}${originalUrl}")
//                } catch (e: Exception) {
//                    memoizedURL = null
//                }
//            } else {
//                memoizedURL
//            }
//        }


        @Suppress("unused")
        var headers: Headers
            get() = req.headers.unsafeCast<Headers>()
            set(value) { req.headers = value }
        @Suppress("unused")
        var header: Headers
            get() = headers
            set(value) { headers = value }

        @Suppress("unused")
        val secure: Boolean get() = protocol == "https"

        @Suppress("unused")
        val state: Boolean get() = !fresh

        @Suppress("unused")
        val fresh: Boolean get() = when (method) {
            Method.HEAD, Method.GET -> false
            else -> {
                val s = this.context.status
                // 2xx or 304 as per rfc2616 14.26
                if ((s in 200..299) || 304 == s) {
                    fresh(this.header, this.response.header)
                } else {
                    false
                }
            }
        }

        @Suppress("unused")
        val ips: List<String> get() {
            val proxy = this.app.proxy
            val value = this.get("X-Forwarded-For")
            return if (proxy && value != null) {
                value.split(Regex("\\s*,\\s*"))
            } else {
                ArrayList()
            }
        }

        @Suppress("unused")
        var ip: String
            get() {
                return remoteAddress ?: if (ips.isNotEmpty()) {
                    ips[0]
                } else {
                    socket?.remoteAddress ?: ""
                }.also {
                    remoteAddress = it
                }
            }
            set(value) {
                remoteAddress = value
            }

        /**
         * Get the charset when present or undefined.
         *
         * @return {String}
         * @api public
         */
//        val charset: String get() {
//            var type = this.get("Content-Type")
//            if (isInvalid(type)) {
//                return ""
//            } else {
//                try {
//                    type = contentType.parse(type);
//                    return type.parameters.charset || '';
//                } catch (e: Exception) {
//                    return "";
//                }
//            }
//        }

        @Suppress("unused")
        val length: Int? get() {
            return this.get("Content-Length")?.let { len ->
                if (len.isNotEmpty()) {
                    len.toIntOrNull()
                } else {
                    null
                }
            }
        }

        @Suppress("unused")
        val type: String? get() = this.get("Content-Type")?.let { t ->
            t.split(";").let { s ->
                if (s.isEmpty()) {
                    null
                } else {
                    s[0]
                }
            }
        }
    }

    class Response(
            @Suppress("unused")
            private val app: Application,
            @Suppress("unused")
            private val context: Context,
            @Suppress("unused")
            private val req: dynamic,
            @Suppress("unused")
            private val res: dynamic
    ) {
        @Suppress("unused")
        private val request: Request by lazy { context.request }

        private var _explicitStatus: Boolean = false

        @Suppress("unused")
        private fun isInvalid(some: dynamic): Boolean = some == null || some == undefined
        @Suppress("unused")
        private fun isValid(some: dynamic): Boolean = some != null && some != undefined

        @Suppress("unused")
        val socket: Socket? get() = this.res.socket?.unsafeCast<Socket?>()


        @Suppress("unused")
        val header: Headers get() = res._headers?.unsafeCast<Headers?>() ?: Headers()
        @Suppress("unused")
        val headers: Headers get() = header

        @Suppress("unused")
        var status: Int
            get() = res.statusCode.unsafeCast<Int>()
            set(value) {
                if (!this.headerSent) {
                    if (!STATUS_CODES.containsKey(value)) {
                        throw Exception("invalid status code: $value")
                    }
                    this.res.statusCode = value
                    this._explicitStatus = true
                    if (Status.empties.contains(value)) {
                        this.body = null
                    }
                }
            }

        @Suppress("unused")
//        fun attachment(filename: String) {
//            if (filename.isNotBlank()) {
//                this.type = NodePath.extname(filename)
//            }
//            this.set("Content-Disposition", contentDisposition(filename))
//        }

        private fun escapeHtml(string: String): String = string
                .replace("&", "&amp;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")

        @Suppress("unused")
        fun redirect(url: String, alt: String? = null) {
            if (url == "back") {
                context.request.header.get("Referrer") ?: alt ?: "/"
            } else {
                url
            }.let {
                this.set("Location", it)
                if (!Status.redirects.contains(this.status)) {
                    this.status = 302
                }
                if (context.request.accepts("html")) {
                    // html
                    escapeHtml(it).let { escaped ->
                        this.type = "text/html; charset=utf-8"
                        this.body = "Redirecting to <a href=\"$escaped\">$escaped</a>."
                    }
                } else {
                    // text
                    this.type = "text/plain; charset=utf-8"
                    this.body = "Redirecting to $it."
                }
            }
        }

        @Suppress("unused")
        fun remove(field: String) {
            if (!this.headerSent) {
                this.res.removeHeader(field)
            }
        }

        @Suppress("unused")
        fun vary(field: String) {
            if (!this.headerSent) {
                vary(this.res, field)
            }
        }

        @Suppress("unused")
        fun get(field: String): String? {
            return this.header.get(field.toLowerCase())
        }

        @Suppress("unused")
        fun set(field: String, value: String) {
            if (!this.headerSent) {
                this.res.setHeader(field, value)
            }
        }

        @Suppress("unused")
        fun append(field: String, value: String) {
            val prev = this.get(field)
            if (prev != null) {
                // fixme prevを配列にしてvalueを追加するんだけど、そういう作りにしていないので困った
            } else {
                set(field, value)
            }
        }

        @Suppress("unused")
        fun flushHeaders() {
            this.res.flushHeaders()
        }

        @Suppress("unused")
        val message: String get() {
            val msg = this.res.statusMessage
            return if (isValid(msg)) {
                msg
            } else {
                STATUS_CODES[this.status] ?: ""
            }
        }

        // fixme とりあえず文字列だけサポート
        @Suppress("unused")
        var body: String?
            get() = this._body
            set(value) {
                this._body = value
                // no content
                if (value == null) {
                    this.status = 204
                    this.remove("Content-Type")
                    this.remove("Content-Length")
                    this.remove("Transfer-Encoding")
                } else if (!this._explicitStatus) {
                    this.status = 200
                }
            }
        private var _body: String? = null

        @Suppress("unused")
        var length: Int
            get() {
                val len = this.header.get("content-length")
                val body = this.body
                return len?.toInt() ?: (body?.length ?: 0)
            }
            set(value) {
                this.set("Content-Length", value.toString())
            }

        @Suppress("unused")
        var type: String?
            get() = this.get("Content-Type")?.let { t ->
                t.split(";").let { s ->
                    if (s.isEmpty()) {
                        null
                    } else {
                        s[0]
                    }
                }
            }
            set(value) {
                // fixme 本当はmimeTypeに含まれる適切なContentTypeにする必要がある
                if (value == null) {
                    this.remove("Content-Type")
                } else {
                    this.set("Content-Type", value)
                }
            }

        @Suppress("unused")
        var lastModified: Date?
            get() = this.get("last-modified")?.let { Date(it) }
            set(value) {
                if (value == null) {
                    this.remove("Last-Modified")
                } else {
                    this.set("Last-Modified", value.toUTCString())
                }
            }

        @Suppress("unused")
        var etag: String?
            get() = this.get("ETag")
            set(value) {
                if (value == null) {
                    this.remove("ETag")
                } else {
                    if (!Regex("^(W/)?").matches(value)) {
                        this.set("ETag", "\"$value\"")
                    } else {
                        this.set("ETag", value)
                    }
                }
            }

        @Suppress("unused")
        val headerSent: Boolean get() = isValid(this.res.headersSent)

        @Suppress("unused")
        val writable: Boolean get() = if (this.res.finished.unsafeCast<Boolean>()) {
            false
        } else {
            this.res.socket?.writable?.unsafeCast<Boolean>() ?: false
        }
    }
}

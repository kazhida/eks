/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

import kotlin.js.Date

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
        req: dynamic,
        res: dynamic
) {
    val request = Request(this, req)
    val response = Response(this, res)
    var stoped: Boolean = false
    /**
     * エラーを保持するプロパティ
     */
    private var err: Error? = null

    /**
     * エラーが起きていたらtrue
     */
    val hasError: Boolean get() = err != null


    /**
     * エラーの内容を取り出すためのプロパティ
     */
    @Suppress("unused")
    val error: Error? get() = err

    /**
     * エラー発生時に呼び出すメソッド。
     * 一度セットしたらnullに戻せない
     */
    fun setError(err: Error) {
        this.err = err
    }

    @Suppress("unused")
    fun stop(): Context = apply {
        stoped = true
    }

    val isEmptyStatus: Boolean get() = when (response.status) {
        204,
        205,
        304 -> true
        else -> false
    }

    /**
     * Default error handling.
     *
     * @param {Error} err
     * @api private
     */
//    fun onError(err: Error?) {
//        if (err != null) {
//            val e: dynamic = err
//            val headerSent = response.headerSent || !response.writable
//            if (headerSent) {
//                e.heaaderSent = true
//            }
//            app.emit("error", e, this)
//            response.type = "text"
//            if (e.code == "ENOENT") {
//                e.status = 404
//            }
//            if (!isValidStatus(e.status)) {
//                e.status = 500
//            }
//
//            val msg = err.message ?: ""
//            response.status = e.status
//            response.length = msg.length
//            response.end(msg)
//        }
//    }

    private fun isValidStatus(status: Any?): Boolean {
        return if (status is Number) {
            when (status) {
                100, //"Continue"),
                101, //"Switching Protocols"),
                102, //"Processing"),
                103, //"Early Hints"),
                200, //"OK"),
                201, //"Created"),
                202, //"Accepted"),
                203, //"Non-Authoritative Information"),
                204, //"No Content"),
                205, //"Reset Content"),
                206, //"Partial Content"),
                207, //"Multi-Status"),
                208, //"Already Reported"),
                226, //"IM Used"),
                300, //"Multiple Choices"),
                301, //"Moved Permanently"),
                302, //"Found"),
                303, //"See Other"),
                304, //"Not Modified"),
                305, //"Use Proxy"),
                306, //"(Unused)"),
                307, //"Temporary Redirect"),
                308, //"Permanent Redirect"),
                400, //"Bad Request"),
                401, //"Unauthorized"),
                402, //"Payment Required"),
                403, //"Forbidden"),
                404, //"Not Found"),
                405, //"Method Not Allowed"),
                406, //"Not Acceptable"),
                407, //"Proxy Authentication Required"),
                408, //"Request Timeout"),
                409, //"Conflict"),
                410, //"Gone"),
                411, //"Length Required"),
                412, //"Precondition Failed"),
                413, //"Payload Too Large"),
                414, //"URI Too Long"),
                415, //"Unsupported Media Type"),
                416, //"Range Not Satisfiable"),
                417, //"Expectation Failed"),
                418, //"I'm a teapot"),
                421, //"Misdirected Request"),
                422, //"Unprocessable Entity"),
                423, //"Locked"),
                424, //"Failed Dependency"),
                425, //"Unordered Collection"),
                426, //"Upgrade Required"),
                428, //"Precondition Required"),
                429, //"Too Many Requests"),
                431, //"Request Header Fields Too Large"),
                451, //"Unavailable For Legal Reasons"),
                500, //"Internal Server Error"),
                501, //"Not Implemented"),
                502, //"Bad Gateway"),
                503, //"Service Unavailable"),
                504, //"Gateway Timeout"),
                505, //"HTTP Version Not Supported"),
                506, //"Variant Also Negotiates"),
                507, //"Insufficient Storage"),
                508, //"Loop Detected"),
                509, //"Bandwidth Limit Exceeded"),
                510, //"Not Extended"),
                511, //"Network Authentication Required")
                999 -> true
                else -> false
            }
        } else {
            false
        }
    }

    /**
     * リクエスト
     */
    class Request(
            private val context: Context,
            private val req: dynamic
    ) {

        fun headers(field: String): String? = req?.let { req ->
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

        fun headers(field: String, value: String) {
            //todo
        }

        val params: Map<String, String> = HashMap()
        fun addParam(key: String, value: String) {
            if (params is MutableMap) {
                params[key] = value
            }
        }
        fun addParams(from: Map<String, String>) {
            if (params is MutableMap) {
                params.putAll(from)
            }
        }

        var method: Method?
            get() = when ((req?.method as? String)?.toUpperCase()) {
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

        val length: Int? get() {
            return this.headers("Content-Length")?.let { len ->
                if (len.isNotEmpty()) {
                    len.toIntOrNull()
                } else {
                    null
                }
            }
        }

        val type: String? get() = headers("Content-Type")?.split(";")?.firstOrNull()
    }

    class Response(
            private val context: Context,
            private val res: dynamic
    ) {
        var status: Int
            get() = res.statusCode.unsafeCast<Int>()
            set(value) {
                if (!this.headerSent) {
                    this.res.statusCode = value
                }
            }

        fun end(message: String? = null) {
            res.end(message)
        }

        private fun escapeHtml(string: String): String = string
                .replace("&", "&amp;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")

        @Suppress("unused")
        fun redirect(url: String, alt: String? = null) {
            if (url == "back") {
                context.request.headers("Referrer") ?: alt ?: "/"
            } else {
                url
            }.let {
                res.headers("Location", it)
                if (!res.Status.redirects.contains(this.status)) {
                    this.status = 302
                }
//                if (context.request.accepts("html")) {
//                    // html
//                    escapeHtml(it).let { escaped ->
//                        this.type = "text/html; charset=utf-8"
//                        this.body = "Redirecting to <a href=\"$escaped\">$escaped</a>."
//                    }
//                } else {
//                    // text
//                    this.type = "text/plain; charset=utf-8"
//                    this.body = "Redirecting to $it."
//                }
            }
        }

//        fun remove(field: String) {
//            if (!this.headerSent) {
//                this.res.removeHeader(field)
//            }
//        }
//
//        fun vary(field: String) {
//            if (!this.headerSent) {
//                vary(this.res, field)
//            }
//        }

        fun append(field: String, value: String) {
            val prev = context.request.headers(field)
            if (prev != null) {
                // fixme prevを配列にしてvalueを追加するんだけど、そういう作りにしていないので困った
            } else {
                context.request.headers(field, value)
                //set(field, value)
            }
        }

//        fun flushHeaders() {
//            this.res.flushHeaders()
//        }
//
//        val message: String get() {
//            val msg = this.res.statusMessage
//            return if (isValid(msg)) {
//                msg
//            } else {
//                STATUS_CODES[this.status] ?: ""
//            }
//        }

        // fixme とりあえず文字列だけサポート
        @Suppress("unused")
        var body: String?
            get() = this._body
            set(value) {
                this._body = value
                // no content
//                if (value == null) {
//                    this.status = 204
//                    this.remove("Content-Type")
//                    this.remove("Content-Length")
//                    this.remove("Transfer-Encoding")
//                } else if (!this._explicitStatus) {
//                    this.status = 200
//                }
            }
        private var _body: String? = null

//        var length: Int
//            get() {
//                val len = this.headers("content-length")
//                val body = this.body
//                return len?.toInt() ?: (body?.length ?: 0)
//            }
//            set(value) {
//                this.set("Content-Length", value.toString())
//            }

//        var type: String?
//            get() = this.get("Content-Type")?.let { t ->
//                t.split(";").let { s ->
//                    if (s.isEmpty()) {
//                        null
//                    } else {
//                        s[0]
//                    }
//                }
//            }
//            set(value) {
//                // fixme 本当はmimeTypeに含まれる適切なContentTypeにする必要がある
//                if (value == null) {
//                    this.remove("Content-Type")
//                } else {
//                    this.set("Content-Type", value)
//                }
//            }

//        var lastModified: Date?
//            get() = this.get("last-modified")?.let { Date(it) }
//            set(value) {
//                if (value == null) {
//                    this.remove("Last-Modified")
//                } else {
//                    this.set("Last-Modified", value.toUTCString())
//                }
//            }
//
//        @Suppress("unused")
//        var etag: String?
//            get() = this.get("ETag")
//            set(value) {
//                if (value == null) {
//                    this.remove("ETag")
//                } else {
//                    if (!Regex("^(W/)?").matches(value)) {
//                        this.set("ETag", "\"$value\"")
//                    } else {
//                        this.set("ETag", value)
//                    }
//                }
//            }

        val headerSent: Boolean get() = this.res.headersSent.unsafeCast<Boolean>()

        val writable: Boolean get() = if (this.res.finished.unsafeCast<Boolean>()) {
            false
        } else {
            this.res.socket?.writable?.unsafeCast<Boolean>() ?: false
        }
    }
}

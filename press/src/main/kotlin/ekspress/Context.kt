/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

/**
 * ミドルウェアを渡り歩いていくコンテキスト
 *
 * @args app アプリケーション
 * @args req リクエスト
 * @args res レスポンス
 * @args isStopped 終端フラグ
 */
data class Context(
        private val app: Application,
        val request: Request,
        val response: Response,
        val isStopped: Boolean = false
) {
    companion object {
        // Applicationのcallbackで使うファクトリ
        fun create(
                app: Application,
                req: dynamic,
                res: dynamic
        ): Context = Context(app, Request(req), Response(res))
    }
//
    fun addedParams(params: Map<String, String>) = Context(
        app = this.app,
        request = this.request.apply { req.params.add(params) },
        response = this.response,
        isStopped = this.isStopped
    )

    internal fun endAsEmpty() = copy(
            response = response.apply {
                res.body = null
                res.end()
            },
            isStopped = true
    )

    internal fun endAsHead() = copy(
            response = response.apply {
//                        if (!res.headersSent && isJSON(body)) {
//                            ctx.length = Buffer.byteLength(JSON.stringify(body));
//                        }
                res.end()
            },
            isStopped = true
    )

    internal fun endAsCode() = copy(
            response = response.apply {
                val body = statusCode.toString()
                if (!headersSent) {
                    type = "text"
                    length = body.length
                }
                end(body)
            },
            isStopped = true
    )

    internal fun endAsNotFound() = copy(
            response = this.response.apply {
                res.status = 404
            },
            isStopped = true
    )

    internal fun endAsNormally() = copy(
            // todo ちゃんと実装
            isStopped = true
    )

    @Suppress("unused")
    private fun isValidStatus(status: Int): Boolean = when (status) {
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
        500, //"Internal NodeServer Error"),
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

    /**
     * リクエスト
     */
    data class Request(
            val req: dynamic
    ) {
        private val methodAsString: String? get() = req.method as String?

        val method: Method? get() = when (methodAsString?.toUpperCase()) {
            "HEAD" -> Method.HEAD
            "GET" -> Method.GET
            "PUT" -> Method.PUT
            "POST" -> Method.POST
            "DELETE" -> Method.DELETE
            else -> null
        }
    }

    data class Response(
            val res: dynamic
    ) {
        val writable: Boolean = res.writeble

        val isEmptyStatus: Boolean = when (res.status) {
            204,
            205,
            304 -> true
            else -> false
        }

        private val headerSentAsBoolean: Boolean? get() = res.headerSent as? Boolean
        private val headerSentAsString: String? get() = res.headerSent as? String
        private val headerSentAsInt: Int? get() = res.headerSent as? Int

        val headersSent: Boolean
            get() = headerSentAsBoolean ?:
                    headerSentAsString?.toLowerCase()?.equals("true") ?:
                    ((headerSentAsInt ?: 0) > 0)

        var type: String?
            get() = res.type
            set(value) { res.type = value }

        var statusCode: Int
            get() = res.status.toString().toInt()
            set(value) {
                res.status = value
            }

        var body: String?
            get() = res.body
            set(value) { res.body = value }

        var length: Int
            get() = res.length
            set(value) { res.length = value}

        fun end(body: String? = null) {
            if (body == null) {
                this.body = body
            }
            res.end()
        }

        fun endAsEmpty() {
            body = null
            res.end()
        }
    }

}

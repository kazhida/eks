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

//    val isEmptyStatus: Boolean get() = when (response.status) {
//        204,
//        205,
//        304 -> true
//        else -> false
//    }

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
    )

    data class Response(
            val res: dynamic
    )

    fun notFound() = Context(
            app = this.app,
            request = this.request,
            response = this.response.apply { res.status = 404 },
            isStopped = true
    )
}

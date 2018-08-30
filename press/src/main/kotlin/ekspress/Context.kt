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

    /**
     * リクエストにパラメータを追加
     *
     * @args params 追加するパラメータ
     */
    fun addedParams(params: Map<String, String>) = copy(
        request = this.request.copy().apply {
            req.params.add(params).unsafeCast<Unit>()
        }
    )

    /**
     * 空のレスポンス
     * （Application.ktでのみ使用する）
     */
    internal fun endAsEmpty() = copy(
            response = response.copy().apply {
                res.body = null
                res.end().unsafeCast<Unit>()
            },
            isStopped = true
    )

    /**
     * HEADメソッドに対応するレスポンス
     * （Application.ktでのみ使用する）
     */
    internal fun endAsHead() = copy(
            response = response.copy().apply {
//                if (!res.headersSent && isJSON(body)) {
//                    ctx.length = Buffer.byteLength(JSON.stringify(body));
//                }
                res.end().unsafeCast<Unit>()
            },
            isStopped = true
    )

    /**
     * ステータスコードをボディにするレスポンス
     * ボディが空のときに使用
     * （Application.ktでのみ使用する）
     */
    internal fun endAsCode() = copy(
            response = response.copy().apply {
                val body = res.statusCode.toString()
                if (!headersSent) {
                    res.type = "text"
                    res.length = body.length
                }
                res.end(body).unsafeCast<Unit>()
            },
            isStopped = true
    )

    /**
     * いわゆるNotFoundのレスポンス
     * （Application.ktでのみ使用する）
     */
    internal fun endAsNotFound() = copy(
            response = this.response.copy().apply {
                res.status = 404
            },
            isStopped = true
    )

    /**
     * 通常のレスポンス
     * （Application.ktでのみ使用する）
     */
    internal fun endAsNormally() = copy(
            response = this.response.copy().apply {
                // todo: bodyがStreamのときのことは考慮していない
                res.length = res.body.length
            },
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
     *
     * @args req Node.jsのリクエスト
     */
    data class Request(
            val req: dynamic
    ) {
        private val methodAsString: String? get() = req.method as String?

        /**
         * メソッド（enum class Methodに変換）
         */
        val method: Method? get() = when (methodAsString?.toUpperCase()) {
            "HEAD" -> Method.HEAD
            "GET" -> Method.GET
            "PUT" -> Method.PUT
            "POST" -> Method.POST
            "DELETE" -> Method.DELETE
            else -> null
        }
    }

    /**
     * レスポンス
     *
     * @args res Node.jsのレスポンス
     */
    data class Response(
            val res: dynamic
    ) {
        val writable: Boolean = res.writeble.unsafeCast<Boolean>()

        /**
         * コンテントが空のステータスコードならtrue
         */
        val isEmptyStatus: Boolean = when (res.status) {
            204,
            205,
            304 -> true
            else -> false
        }

        private val headerSentAsBoolean: Boolean? get() = res.headerSent as? Boolean
        private val headerSentAsString: String? get() = res.headerSent as? String
        private val headerSentAsInt: Int? get() = res.headerSent as? Int

        /**
         * headerSentのラッパー
         */
        val headersSent: Boolean
            get() = headerSentAsBoolean ?:
                    headerSentAsString?.toLowerCase()?.equals("true") ?:
                    ((headerSentAsInt ?: 0) > 0)

        /**
         * bodyのラッパー
         *
         * fixme bodyがStreamの場合もある
         */
        val body: String? get() = res.body.unsafeCast<String?>()
    }
}

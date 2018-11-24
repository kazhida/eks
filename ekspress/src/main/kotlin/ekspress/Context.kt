/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

import ekscore.IncomingMessage
import ekscore.ServerResponse

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
                req: IncomingMessage,
                res: ServerResponse
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
     * （ekspressパッケージ内でのみ使用する）
     */
    internal fun endAsEmpty(status: Int? = null) = copy(
            response = response.copy().apply {
                if (status != null) {
                    res.status = status
                }
                res.body = null
                res.end().unsafeCast<Unit>()
            },
            isStopped = true
    )

    /**
     * HEADメソッドに対応するレスポンス
     * （ekspressパッケージ内でのみ使用する）
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
     * （ekspressパッケージ内でのみ使用する）
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
     * （ekspressパッケージ内でのみ使用する）
     */
    internal fun endAsNotFound() = copy(
            response = this.response.copy().apply {
                res.status = 404
            },
            isStopped = true
    )

    /**
     * 通常のレスポンス
     * （ekspressパッケージ内でのみ使用する）
     */
    internal fun endAsNormally(status: Int? = null, type: String? = null, body: String? = null) = copy(
            response = this.response.copy().apply {
                // todo: bodyがStreamのときのことは考慮していない
                if (status != null) {
                    res.status = status
                }
                if (type != null) {
                    res.type = type
                }
                if (body != null) {
                    res.body = body
                }
                res.length = res.body.length
            },
            isStopped = true
    )

    /**
     * リクエスト
     *
     * @args req Node.jsのリクエスト
     */
    data class Request(
            val req: IncomingMessage
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
            val res: ServerResponse
    ) {
        val writable: Boolean = res.writable.unsafeCast<Boolean>()

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
    
    /**
     * どうしたらいいかわからないステータスのときは、
     * ステータスだけ設定しておく
     */

    @Suppress("unused")
    fun continue100(): Context = endAsNormally(100)
    
    @Suppress("unused")
    fun switchingProtocols101() = endAsNormally(101)
    
    @Suppress("unused")
    fun processing102() = endAsNormally(102)
    
    @Suppress("unused")
    fun earlyHints103() = endAsNormally(1003)
    
    @Suppress("unused")
    fun ok200(type: String, body: String) = endAsNormally(200, type, body) //"OK"),
    
    @Suppress("unused")
    fun created201() = endAsNormally(201)
    
    @Suppress("unused")
    fun accepted202() = endAsNormally(202)
    
    @Suppress("unused")
    fun nonAuthoritativeInformation203() = endAsNormally(203)
    
    @Suppress("unused")
    fun noContent204() = endAsEmpty(204)
    
    @Suppress("unused")
    fun resetContent205() = endAsEmpty(205)
    
    @Suppress("unused")
    fun partialContent206() = endAsNormally(203)
    
    @Suppress("unused")
    fun multiStatus207() = endAsNormally(203)
    
    @Suppress("unused")
    fun alreadyReported208() = endAsNormally(203)
    
    @Suppress("unused")
    fun imUsed226() = endAsNormally(226)
    
    @Suppress("unused")
    fun multipleChoices300() = endAsNormally(300)
    
    @Suppress("unused")
    fun movedPermanently301() = endAsNormally(301)
    
    @Suppress("unused")
    fun found302() = endAsNormally(302)

    @Suppress("unused")
    fun seeOther303() = endAsNormally(303)

    @Suppress("unused")
    fun notModified304() = endAsEmpty(304)

    @Suppress("unused")
    fun useProxy305() = endAsNormally(305)

    @Suppress("unused")
    fun unused306() = endAsNormally(306)

    @Suppress("unused")
    fun temporaryRedirect307() = endAsNormally(307)

    @Suppress("unused")
    fun permanentRedirect308() = endAsNormally(308)

    @Suppress("unused")
    fun badRequest400() = endAsNormally(400)

    @Suppress("unused")
    fun unauthorized401() = endAsNormally(401)

    @Suppress("unused")
    fun paymentRequired402() = endAsNormally(402)

    @Suppress("unused")
    fun forbidden403() = endAsNormally(403)

    @Suppress("unused")
    fun notFound404() = endAsNormally(404)

    @Suppress("unused")
    fun methodNotAllowed405() = endAsNormally(405)

    @Suppress("unused")
    fun notAcceptable406() = endAsNormally(406)

    @Suppress("unused")
    fun proxyAuthenticationRequired407() = endAsNormally(407)

    @Suppress("unused")
    fun requestTimeout408() = endAsNormally(408)

    @Suppress("unused")
    fun conflict409() = endAsNormally(409)

    @Suppress("unused")
    fun gone410() = endAsNormally(410)

    @Suppress("unused")
    fun lengthRequired411() = endAsNormally(411)

    @Suppress("unused")
    fun preconditionFailed412() = endAsNormally(412)

    @Suppress("unused")
    fun payloadTooLarge413() = endAsNormally(413)

    @Suppress("unused")
    fun uriTooLong414() = endAsNormally(414)

    @Suppress("unused")
    fun unsupportedMediaType415() = endAsNormally(415)

    @Suppress("unused")
    fun rangeNotSatisfiable416() = endAsNormally(416)

    @Suppress("unused")
    fun expectationFailed417() = endAsNormally(417)

    @Suppress("unused")
    fun imaTeapot418() = endAsNormally(418)

    @Suppress("unused")
    fun misdirectedRequest421() = endAsNormally(421)

    @Suppress("unused")
    fun unprocessableEntity422() = endAsNormally(422)

    @Suppress("unused")
    fun locked423() = endAsNormally(423)

    @Suppress("unused")
    fun failedDependency424() = endAsNormally(424)

    @Suppress("unused")
    fun unorderedCollection425() = endAsNormally(425)

    @Suppress("unused")
    fun upgradeRequired426() = endAsNormally(426)

    @Suppress("unused")
    fun preconditionRequired428() = endAsNormally(428)

    @Suppress("unused")
    fun tooManyRequests429() = endAsNormally(429)

    @Suppress("unused")
    fun requestHeaderFieldsTooLarge431() = endAsNormally(431)

    @Suppress("unused")
    fun unavailableForLegalReasons451() = endAsNormally(451)

    @Suppress("unused")
    fun internalServerError500() = endAsNormally(500)

    @Suppress("unused")
    fun notImplemented501() = endAsNormally(501)

    @Suppress("unused")
    fun badGateway502() = endAsNormally(502)

    @Suppress("unused")
    fun serviceUnavailable503() = endAsNormally(503)

    @Suppress("unused")
    fun gatewayTimeout504() = endAsNormally(504)

    @Suppress("unused")
    fun httpVersionNotSupported505() = endAsNormally(505)

    @Suppress("unused")
    fun variantAlsoNegotiates506() = endAsNormally(506)

    @Suppress("unused")
    fun insufficientStorage507() = endAsNormally(507)

    @Suppress("unused")
    fun loopDetected508() = endAsNormally(508)

    @Suppress("unused")
    fun bandwidthLimitExceeded509() = endAsNormally(509)

    @Suppress("unused")
    fun notExtended510() = endAsNormally(510)

    @Suppress("unused")
    fun networkAuthenticationRequired511() = endAsNormally(511)

    // fixme toJsonが欲しいところ
    @Suppress("unused")
    fun okJson(body: Any): Context = ok200("text/json", body.toString())
}

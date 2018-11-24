/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

@JsModule("https")
external object Https {

    interface SecureOption {
        val key: String
        val cert: String
    }

    fun createServer(secure: SecureOption, requestListener: ()->ServerCallback<Any>): Server
}

/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

@JsModule("http")
external object Http {
    fun createServer(requestListener: ()->ServerCallback<Any>): Server
}

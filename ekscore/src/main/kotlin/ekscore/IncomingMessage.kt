/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

external interface IncomingMessage : Stream.Readable {
    val socket: dynamic
    val connection: dynamic
    val httpVersionMajor: dynamic
    val httpVersionMinor: dynamic
    val httpVersion: dynamic
    val complete: Boolean

    val rawHeaders: dynamic
    val trailers: dynamic
    val rawTrailers:dynamic

    val readable: Boolean
    val aborted: Boolean

    val upgrade: dynamic

    // request (server) only
    var url: String
    var method: dynamic
    var path: String
    val params: dynamic
    var querystring: String
    var accept: Any
    var header: Map<String, dynamic>
    var headers: Map<String, dynamic>
    var statusCode: Int
    val headersSent: Boolean

    fun setHeader(field: String, value: dynamic)
    fun removeHeader(field: String)
    val finished: Boolean
}

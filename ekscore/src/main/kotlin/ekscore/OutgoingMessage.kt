/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

external interface OutgoingMessage {
    var outputSize: Int
    var writable: Boolean
    var chunkedEncoding: Boolean
    var shouldKeepAlive: Boolean
    var useChunkedEncodingByDefault: Boolean
    var sendDate: Boolean
    var finished: Boolean
    var socket: dynamic
    var connection: dynamic
    fun setHeader(name: String, value: dynamic)
    fun getHeader(name: String): dynamic
    fun getHeaderNames()
    fun getHeaders(): Array<String>
    fun hasHeader(name: String): Boolean
    fun removeHeader(name: String)
    val headersSent: Boolean
    fun write(chunk: dynamic, encoding: dynamic, callback: ()->Unit): Boolean
}
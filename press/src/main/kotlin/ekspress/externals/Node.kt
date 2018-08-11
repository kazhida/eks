/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress.externals

/*
 * Node.js本体の機能を利用するための宣言などをまとめたモジュール
 */

import ekspress.EmptyCallback
import org.w3c.fetch.Headers

external interface EventEmitter {
    fun on(name: String, fn: Any?): EventEmitter
    fun once(name: String, fn: Any?): EventEmitter
    fun addListener(name: String, fn: Any?): EventEmitter
    fun removeListener(name: String, fn: Any?): EventEmitter
    fun removeAllListeners(name: String): EventEmitter
    val listeners: Array<EventEmitter>?
    fun emit(name: String): Boolean
}

external interface Http {
    fun createServer(options: Any?, requestListener: EmptyCallback?): Server
}

external interface Server {
    fun listen(port: Int, callback: EmptyCallback?, vararg args: Any?): Server
}

external interface ServerResponse {

}

external interface IncomingMessage {
    val headers: Headers
}

external fun require(module:String): dynamic

val http = require("http").unsafeCast<Http>()
val https = require("https").unsafeCast<Http>()
fun eventEmitter() = require("events").EventEmitter.unsafeCast<EventEmitter>()
fun req() = require("http").IncomingMessage.unsafeCast<IncomingMessage>()
fun res() = require("http").ServerResponse.unsafeCast<ServerResponse>()
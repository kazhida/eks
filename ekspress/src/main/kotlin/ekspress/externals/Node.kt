/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */

package ekspress.externals

/*
 * node.js自体からrequireするようなモジュールを、externalとして宣言する
 */

import ekspress.Context
import ekspress.Procedure
import kotlin.js.Promise

external fun require(module:String): dynamic

@Suppress("unused")
external interface EventEmitter {
    fun on(name: String, fn: dynamic): EventEmitter
    fun once(name: String, fn: dynamic): EventEmitter
    fun addListener(name: String, fn: dynamic): EventEmitter
    fun removeListener(name: String, fn: dynamic): EventEmitter
    fun removeAllListeners(name: String): EventEmitter
    val listeners: Array<EventEmitter?>?
    fun listenerCount(event: String): Int
    fun emit(name: String, vararg args: dynamic): Boolean
}

typealias NodeServerCallback = (req: dynamic, res: dynamic)->Promise<Context>
typealias NodeCallback = (err: Throwable?, result: Any?)->Unit

interface NodeSecure {
    val key: String
    val cert: String
}

interface NodeHttp {
    fun createServer(requestListener: ()->NodeServerCallback): NodeServer
}

interface NodeHttps {
    fun createServer(secure: NodeSecure, requestListener: ()->NodeServerCallback): NodeServer
}

interface NodeServer {
    fun listen(port: Int, callback: Procedure?, vararg args: Any?): NodeServer
}

/**
 *
 */
@Suppress("unused")
object NodeCore {
    val http by lazy { require("http").unsafeCast<NodeHttp>() }
    val https by lazy { require("https").unsafeCast<NodeHttps>() }
    val eventEmitter = require("events").EventEmitter.unsafeCast<()->EventEmitter>()
    val path = require("path")
}

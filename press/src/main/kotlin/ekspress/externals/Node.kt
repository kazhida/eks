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

interface NodeHttp {
    fun createServer(requestListener: ()->NodeCallback): NodeServer
}

interface NodeServer {
    fun listen(port: Int, callback: Procedure?, vararg args: Any?): NodeServer
}

external fun require(module:String): dynamic

val http = require("http").unsafeCast<NodeHttp>()
val https = require("https").unsafeCast<NodeHttp>()
fun eventEmitter() = require("events").EventEmitter.unsafeCast<EventEmitter>()

typealias NodeCallback = (req: dynamic, res: dynamic)->Promise<Context>


@Suppress("unused")
object NodePath {
    private val path = require("path")
    val extname = path.extname.unsafeCast<(filename: String)->String>()
}

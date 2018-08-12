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

import ekspress.EmptyCallback
import kotlin.js.Promise

external interface EventEmitter {
    @Suppress("unused")
    fun on(name: String, fn: Any?): EventEmitter
    @Suppress("unused")
    fun once(name: String, fn: Any?): EventEmitter
    @Suppress("unused")
    fun addListener(name: String, fn: Any?): EventEmitter
    @Suppress("unused")
    fun removeListener(name: String, fn: Any?): EventEmitter
    @Suppress("unused")
    fun removeAllListeners(name: String): EventEmitter
    @Suppress("unused")
    val listeners: Array<EventEmitter>?
    @Suppress("unused")
    fun emit(name: String): Boolean
}

external interface Http {
    @Suppress("unused")
    fun createServer(requestListener: ()->NodeCallback): Server
}

external interface Server {
    @Suppress("unused")
    fun listen(port: Int, callback: EmptyCallback?, vararg args: Any?): Server
}

external fun require(module:String): dynamic

@Suppress("unused")
val http = require("http").unsafeCast<Http>()
@Suppress("unused")
val https = require("https").unsafeCast<Http>()
fun eventEmitter() = require("events").EventEmitter.unsafeCast<EventEmitter>()

external interface Socket {
    val encrypted: Boolean
    val remoteAddress: String?
}

external interface NodeCallback {
    @Suppress("unused")
    fun callback(req: dynamic, res: dynamic): Promise<Unit>
}

@Suppress("unused")
external interface URL {
    @Suppress("unused")
    val hostname: String?
}

external interface Url {
    var _raw: String?
    var path: String?
    var href: String?
    var pathname: String?
    var query: String?
    var search: String?
}

class UrlImpl(
        override var _raw: String?,
        override var path: String?,
        override var href: String?,
        override var pathname: String?,
        override var query: String?,
        override var search: String?
) : Url

object NodeUrl {
    val parse = require("url").parse.unsafeCast<(url: Any?)->Url?>()
    val format = require("url").format.unsafeCast<(urlObject: dynamic, options: Any?)->String?>()
}

object QueryString {
    private val qs = require("querystring")
    val parse = qs.parse.unsafeCast<(qs: dynamic, sep: dynamic, eq: dynamic, options: dynamic)->dynamic>()
    val stringify = qs.stringify.unsafeCast<(obj: dynamic, sep: dynamic, eq: dynamic, options: dynamic)->String?>()
}

object Net {
    val isIP = require("net").isIP.unsafeCast<(hostname: String)->Int>()
}
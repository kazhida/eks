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

import ekspress.Procedure
import kotlin.js.Promise

@Suppress("unused")
external interface EventEmitter {
    fun on(name: String, fn: Any?): EventEmitter
    fun once(name: String, fn: Any?): EventEmitter
    fun addListener(name: String, fn: Any?): EventEmitter
    fun removeListener(name: String, fn: Any?): EventEmitter
    fun removeAllListeners(name: String): EventEmitter
    val listeners: Array<EventEmitter>?
    fun listenerCount(event: String): Int
    fun emit(name: String): Boolean
}

external interface Http {
    fun createServer(requestListener: ()->NodeCallback): Server
}

external interface Server {
    fun listen(port: Int, callback: Procedure?, vararg args: Any?): Server
}

external fun require(module:String): dynamic

val http = require("http").unsafeCast<Http>()
val https = require("https").unsafeCast<Http>()
fun eventEmitter() = require("events").EventEmitter.unsafeCast<EventEmitter>()

external interface Socket {
    val encrypted: Boolean
    val remoteAddress: String?
}

typealias NodeCallback = (req: dynamic, res: dynamic)->Promise<Unit>


@Suppress("unused")
external interface URL {
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

object NodeQueryString {
    private val qs = require("querystring")
    val parse = qs.parse.unsafeCast<(qs: dynamic, sep: dynamic, eq: dynamic, options: dynamic)->dynamic>()
    val stringify = qs.stringify.unsafeCast<(obj: dynamic, sep: dynamic, eq: dynamic, options: dynamic)->String?>()
}

object NodeNet {
    val isIP = require("net").isIP.unsafeCast<(hostname: String)->Int>()
}

@Suppress("unused")
object NodePath {
    private val path = require("path")
    val extname = path.extname.unsafeCast<(filename: String)->String>()
}

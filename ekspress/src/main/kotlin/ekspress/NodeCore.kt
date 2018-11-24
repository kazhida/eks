/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

/*
 * node.js自体からrequireするようなモジュールを、externalとして宣言する
 */

import ekscore.*

external fun require(module:String): dynamic

/**
 *
 */
@Suppress("unused")
object NodeCore {
    val http: Http<Context> by lazy { require("http").unsafeCast<Http<Context>>() }
    val https: Https<Context> by lazy { require("https").unsafeCast<Https<Context>>() }
    val eventEmitter by lazy { require("events").EventEmitter.unsafeCast<()-> EventEmitter>() }
    val path: Path by lazy { require("path").unsafeCast<Path>() }
    val fs: FileSystem by lazy { require("fs").unsafeCast<FileSystem>() }
}

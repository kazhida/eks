/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

import kotlin.js.Promise

external fun require(module:String): dynamic

typealias ServerCallback<T> = (req: dynamic, res: dynamic)-> Promise<T>
typealias NodeCallback = (err: Throwable?, result: Any?)->Unit
typealias Procedure = ()->Unit

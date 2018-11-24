/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

import kotlin.js.Promise

typealias ServerCallback<T> = (req: IncomingMessage, res: ServerResponse)-> Promise<T>
typealias NodeCallback = (err: Throwable?, result: Any?)->Unit
typealias Procedure = ()->Unit

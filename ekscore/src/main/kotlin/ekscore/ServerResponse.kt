/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

external interface ServerResponse : OutgoingMessage {
    var status: dynamic
    var statusCode: dynamic
    var body: dynamic
    var type: dynamic
    var length: dynamic
    val headerSent: dynamic
    fun end()
    fun end(body: Any?)
}

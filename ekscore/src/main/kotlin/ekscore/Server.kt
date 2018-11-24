/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

external interface Server {
    fun listen(port: Int, callback: Procedure?, vararg args: Any?): Server
}

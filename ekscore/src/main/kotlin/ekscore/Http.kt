/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

external interface Http<T> {
    fun createServer(requestListener: ()->ServerCallback<T>): Server
}

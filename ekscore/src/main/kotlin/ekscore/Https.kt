/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

interface Https<T> {

    interface SecureOption {
        val key: String
        val cert: String
    }

    fun createServer(secure: SecureOption, requestListener: ()->ServerCallback<T>): Server
}

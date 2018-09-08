/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

external interface Stream {
    fun pipe(dest: dynamic, options: dynamic): dynamic

    interface Readable : Stream {
        fun read(n: Int): Int
    }
}

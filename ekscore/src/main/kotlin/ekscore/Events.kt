/*
 * ekscore
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekscore

external interface EventEmitter {
    fun on(name: String, fn: dynamic): EventEmitter
    fun once(name: String, fn: dynamic): EventEmitter
    fun addListener(name: String, fn: dynamic): EventEmitter
    fun removeListener(name: String, fn: dynamic): EventEmitter
    fun removeAllListeners(name: String): EventEmitter
    val listeners: Array<EventEmitter?>?
    fun listenerCount(event: String): Int
    fun emit(name: String, vararg args: dynamic): Boolean
}

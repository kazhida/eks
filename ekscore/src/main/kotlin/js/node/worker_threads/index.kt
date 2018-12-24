@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("worker_threads")
package js.node.worker_threads

import js.node.events.internal.EventEmitter
import js.node.stream.internal.Readable
import js.node.stream.internal.Writable
import kotlin.js.*

external var isMainThread: Boolean = definedExternally
external var parentPort: MessagePort? = definedExternally
external var threadId: Number = definedExternally
external var workerData: Any = definedExternally
open external class MessageChannel {
    open var port1: MessagePort = definedExternally
    open var port2: MessagePort = definedExternally
}
open external class MessagePort : EventEmitter {
    open fun close(): Unit = definedExternally
    open fun postMessage(value: Any, transferList: Array<dynamic /* ArrayBuffer | MessagePort */>? = definedExternally /* null */): Unit = definedExternally
    open fun ref(): Unit = definedExternally
    open fun unref(): Unit = definedExternally
    open fun start(): Unit = definedExternally
    open fun addListener(event: String /* "close" */, listener: () -> Unit): MessagePort /* this */ = definedExternally
    override fun addListener(event: String /* "message" */, listener: (value: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun addListener(event: Any?, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    open fun emit(event: String /* "close" */): Boolean = definedExternally
    open fun emit(event: String /* "message" */, value: Any): Boolean = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun on(event: String /* "close" */, listener: () -> Unit): MessagePort /* this */ = definedExternally
    override fun on(event: String /* "message" */, listener: (value: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun on(event: Any?, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    open fun once(event: String /* "close" */, listener: () -> Unit): MessagePort /* this */ = definedExternally
    override fun once(event: String /* "message" */, listener: (value: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun once(event: Any?, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    open fun prependListener(event: String /* "close" */, listener: () -> Unit): MessagePort /* this */ = definedExternally
    override fun prependListener(event: String /* "message" */, listener: (value: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun prependListener(event: Any?, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): MessagePort /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "message" */, listener: (value: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun prependOnceListener(event: Any?, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    open fun removeListener(event: String /* "close" */, listener: () -> Unit): MessagePort /* this */ = definedExternally
    override fun removeListener(event: String /* "message" */, listener: (value: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun removeListener(event: String, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun removeListener(event: Any?, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    open fun off(event: String /* "close" */, listener: () -> Unit): MessagePort /* this */ = definedExternally
    override fun off(event: String /* "message" */, listener: (value: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun off(event: String, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
    override fun off(event: Any?, listener: (args: Any) -> Unit): MessagePort /* this */ = definedExternally
}
external interface WorkerOptions {
    var eval: Boolean? get() = definedExternally; set(value) = definedExternally
    var workerData: Any? get() = definedExternally; set(value) = definedExternally
    var stdin: Boolean? get() = definedExternally; set(value) = definedExternally
    var stdout: Boolean? get() = definedExternally; set(value) = definedExternally
    var stderr: Boolean? get() = definedExternally; set(value) = definedExternally
}
open external class Worker(filename: String, options: WorkerOptions? = definedExternally /* null */) : EventEmitter {
    open var stdin: Writable? = definedExternally
    open var stdout: Readable = definedExternally
    open var stderr: Readable = definedExternally
    open var threadId: Number = definedExternally
    open fun postMessage(value: Any, transferList: Array<dynamic /* ArrayBuffer | MessagePort */>? = definedExternally /* null */): Unit = definedExternally
    open fun ref(): Unit = definedExternally
    open fun unref(): Unit = definedExternally
    open fun terminate(callback: ((err: Any, exitCode: Number) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    override fun addListener(event: String /* "error" */, listener: (err: Any) -> Unit): Worker /* this */ = definedExternally
    open fun addListener(event: String /* "exit" */, listener: (exitCode: Number) -> Unit): Worker /* this */ = definedExternally
    override fun addListener(event: String /* "message" */, listener: (value: Any) -> Unit): Worker /* this */ = definedExternally
    open fun addListener(event: String /* "online" */, listener: () -> Unit): Worker /* this */ = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun addListener(event: Any?, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    open fun emit(event: String /* "error" */, err: Any): Boolean = definedExternally
    open fun emit(event: String /* "exit" */, exitCode: Number): Boolean = definedExternally
    open fun emit(event: String /* "message" */, value: Any): Boolean = definedExternally
    open fun emit(event: String /* "online" */): Boolean = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    override fun on(event: String /* "error" */, listener: (err: Any) -> Unit): Worker /* this */ = definedExternally
    open fun on(event: String /* "exit" */, listener: (exitCode: Number) -> Unit): Worker /* this */ = definedExternally
    override fun on(event: String /* "message" */, listener: (value: Any) -> Unit): Worker /* this */ = definedExternally
    open fun on(event: String /* "online" */, listener: () -> Unit): Worker /* this */ = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun on(event: Any?, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun once(event: String /* "error" */, listener: (err: Any) -> Unit): Worker /* this */ = definedExternally
    open fun once(event: String /* "exit" */, listener: (exitCode: Number) -> Unit): Worker /* this */ = definedExternally
    override fun once(event: String /* "message" */, listener: (value: Any) -> Unit): Worker /* this */ = definedExternally
    open fun once(event: String /* "online" */, listener: () -> Unit): Worker /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun once(event: Any?, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun prependListener(event: String /* "error" */, listener: (err: Any) -> Unit): Worker /* this */ = definedExternally
    open fun prependListener(event: String /* "exit" */, listener: (exitCode: Number) -> Unit): Worker /* this */ = definedExternally
    override fun prependListener(event: String /* "message" */, listener: (value: Any) -> Unit): Worker /* this */ = definedExternally
    open fun prependListener(event: String /* "online" */, listener: () -> Unit): Worker /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun prependListener(event: Any?, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "error" */, listener: (err: Any) -> Unit): Worker /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "exit" */, listener: (exitCode: Number) -> Unit): Worker /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "message" */, listener: (value: Any) -> Unit): Worker /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "online" */, listener: () -> Unit): Worker /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun prependOnceListener(event: Any?, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun removeListener(event: String /* "error" */, listener: (err: Any) -> Unit): Worker /* this */ = definedExternally
    open fun removeListener(event: String /* "exit" */, listener: (exitCode: Number) -> Unit): Worker /* this */ = definedExternally
    override fun removeListener(event: String /* "message" */, listener: (value: Any) -> Unit): Worker /* this */ = definedExternally
    open fun removeListener(event: String /* "online" */, listener: () -> Unit): Worker /* this */ = definedExternally
    override fun removeListener(event: String, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun removeListener(event: Any?, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun off(event: String /* "error" */, listener: (err: Any) -> Unit): Worker /* this */ = definedExternally
    open fun off(event: String /* "exit" */, listener: (exitCode: Number) -> Unit): Worker /* this */ = definedExternally
    override fun off(event: String /* "message" */, listener: (value: Any) -> Unit): Worker /* this */ = definedExternally
    open fun off(event: String /* "online" */, listener: () -> Unit): Worker /* this */ = definedExternally
    override fun off(event: String, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
    override fun off(event: Any?, listener: (args: Any) -> Unit): Worker /* this */ = definedExternally
}

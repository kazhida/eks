@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("readline")
package js.node.readline

import js.node.Buffer
import js.node.ReadableStream
import js.node.WritableStream
import js.node.events.internal.EventEmitter
import kotlin.js.*

external interface Key {
    var sequence: String? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var ctrl: Boolean? get() = definedExternally; set(value) = definedExternally
    var meta: Boolean? get() = definedExternally; set(value) = definedExternally
    var shift: Boolean? get() = definedExternally; set(value) = definedExternally
}
open external class Interface : EventEmitter {
    constructor(input: ReadableStream, output: WritableStream? = definedExternally /* null */, completer: ((line: String) -> dynamic /* JsTuple<Array<String>, String> */)? = definedExternally /* null */, terminal: Boolean? = definedExternally /* null */)
    constructor(input: ReadableStream, output: WritableStream? = definedExternally /* null */, completer: ((line: String, callback: (err: Any, result: dynamic /* JsTuple<Array<String>, String> */) -> Unit) -> Any)? = definedExternally /* null */, terminal: Boolean? = definedExternally /* null */)
    constructor(options: ReadLineOptions)
    @Suppress("UNREACHABLE_CODE")
    open var terminal: Boolean = definedExternally
    open fun setPrompt(prompt: String): Unit = definedExternally
    open fun prompt(preserveCursor: Boolean? = definedExternally /* null */): Unit = definedExternally
    open fun question(query: String, callback: (answer: String) -> Unit): Unit = definedExternally
    open fun pause(): Interface /* this */ = definedExternally
    open fun resume(): Interface /* this */ = definedExternally
    open fun close(): Unit = definedExternally
    open fun write(data: String, key: Key? = definedExternally /* null */): Unit = definedExternally
    open fun write(data: Buffer, key: Key? = definedExternally /* null */): Unit = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): Interface /* this */ = definedExternally
    open fun addListener(event: String /* "close" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun addListener(event: String /* "line" */, listener: (input: String) -> Unit): Interface /* this */ = definedExternally
    open fun addListener(event: String /* "pause" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun addListener(event: String /* "resume" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun addListener(event: String /* "SIGCONT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun addListener(event: String /* "SIGINT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun addListener(event: String /* "SIGTSTP" */, listener: () -> Unit): Interface /* this */ = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun emit(event: String /* "close" */): Boolean = definedExternally
    open fun emit(event: String /* "line" */, input: String): Boolean = definedExternally
    open fun emit(event: String /* "pause" */): Boolean = definedExternally
    open fun emit(event: String /* "resume" */): Boolean = definedExternally
    open fun emit(event: String /* "SIGCONT" */): Boolean = definedExternally
    open fun emit(event: String /* "SIGINT" */): Boolean = definedExternally
    open fun emit(event: String /* "SIGTSTP" */): Boolean = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): Interface /* this */ = definedExternally
    open fun on(event: String /* "close" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun on(event: String /* "line" */, listener: (input: String) -> Unit): Interface /* this */ = definedExternally
    open fun on(event: String /* "pause" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun on(event: String /* "resume" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun on(event: String /* "SIGCONT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun on(event: String /* "SIGINT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun on(event: String /* "SIGTSTP" */, listener: () -> Unit): Interface /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): Interface /* this */ = definedExternally
    open fun once(event: String /* "close" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun once(event: String /* "line" */, listener: (input: String) -> Unit): Interface /* this */ = definedExternally
    open fun once(event: String /* "pause" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun once(event: String /* "resume" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun once(event: String /* "SIGCONT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun once(event: String /* "SIGINT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun once(event: String /* "SIGTSTP" */, listener: () -> Unit): Interface /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Interface /* this */ = definedExternally
    open fun prependListener(event: String /* "close" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependListener(event: String /* "line" */, listener: (input: String) -> Unit): Interface /* this */ = definedExternally
    open fun prependListener(event: String /* "pause" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependListener(event: String /* "resume" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependListener(event: String /* "SIGCONT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependListener(event: String /* "SIGINT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependListener(event: String /* "SIGTSTP" */, listener: () -> Unit): Interface /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Interface /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "line" */, listener: (input: String) -> Unit): Interface /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "pause" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "resume" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "SIGCONT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "SIGINT" */, listener: () -> Unit): Interface /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "SIGTSTP" */, listener: () -> Unit): Interface /* this */ = definedExternally
}
external interface ReadLineOptions {
    var input: ReadableStream
    var output: WritableStream? get() = definedExternally; set(value) = definedExternally
    var completer: dynamic /* (line: String) -> dynamic /* JsTuple<Array<String>, String> */ | (line: String, callback: (err: Any, result: dynamic /* JsTuple<Array<String>, String> */) -> Unit) -> Any */ get() = definedExternally; set(value) = definedExternally
    var terminal: Boolean? get() = definedExternally; set(value) = definedExternally
    var historySize: Number? get() = definedExternally; set(value) = definedExternally
    var prompt: String? get() = definedExternally; set(value) = definedExternally
    var crlfDelay: Number? get() = definedExternally; set(value) = definedExternally
    var removeHistoryDuplicates: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun createInterface(input: ReadableStream, output: WritableStream? = definedExternally /* null */, completer: ((line: String) -> dynamic /* JsTuple<Array<String>, String> */)? = definedExternally /* null */, terminal: Boolean? = definedExternally /* null */): Interface = definedExternally
external fun createInterface(input: ReadableStream, output: WritableStream? = definedExternally /* null */, completer: ((line: String, callback: (err: Any, result: dynamic /* JsTuple<Array<String>, String> */) -> Unit) -> Any)? = definedExternally /* null */, terminal: Boolean? = definedExternally /* null */): Interface = definedExternally
external fun createInterface(options: ReadLineOptions): Interface = definedExternally
external fun cursorTo(stream: WritableStream, x: Number, y: Number? = definedExternally /* null */): Unit = definedExternally
external fun emitKeypressEvents(stream: ReadableStream, `interface`: Interface? = definedExternally /* null */): Unit = definedExternally
external fun moveCursor(stream: WritableStream, dx: String, dy: String): Unit = definedExternally
external fun moveCursor(stream: WritableStream, dx: String, dy: Number): Unit = definedExternally
external fun moveCursor(stream: WritableStream, dx: Number, dy: String): Unit = definedExternally
external fun moveCursor(stream: WritableStream, dx: Number, dy: Number): Unit = definedExternally
external fun clearLine(stream: WritableStream, dir: Number): Unit = definedExternally
external fun clearScreenDown(stream: WritableStream): Unit = definedExternally
external fun createInterface(input: ReadableStream): Interface = definedExternally

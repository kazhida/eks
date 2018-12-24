@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("repl")
package js.node.repl

import js.node.ReadableStream
import js.node.WritableStream
import js.node.readline.Interface
import js.node.util.InspectOptions
import js.node.vm.Context
import kotlin.js.*

external interface ReplOptions {
    var prompt: String? get() = definedExternally; set(value) = definedExternally
    var input: ReadableStream? get() = definedExternally; set(value) = definedExternally
    var output: WritableStream? get() = definedExternally; set(value) = definedExternally
    var terminal: Boolean? get() = definedExternally; set(value) = definedExternally
    var eval: ((`this`: REPLServer, evalCmd: String, context: Context, file: String, cb: (err: Error?, result: Any) -> Unit) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var useColors: Boolean? get() = definedExternally; set(value) = definedExternally
    var useGlobal: Boolean? get() = definedExternally; set(value) = definedExternally
    var ignoreUndefined: Boolean? get() = definedExternally; set(value) = definedExternally
    var writer: ((`this`: REPLServer, obj: Any) -> String)? get() = definedExternally; set(value) = definedExternally
    var completer: dynamic /* (line: String) -> dynamic /* JsTuple<Array<String>, String> */ | (line: String, callback: (err: Any, result: dynamic /* JsTuple<Array<String>, String> */) -> Unit) -> Any */ get() = definedExternally; set(value) = definedExternally
    var replMode: Any? get() = definedExternally; set(value) = definedExternally
    var breakEvalOnSigint: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface `T$20` {
    var options: InspectOptions
}
external var writer: (`this`: REPLServer, obj: Any) -> String /* (`this`: REPLServer, obj: Any) -> String & `T$20` */ = definedExternally
external interface REPLCommand {
    var help: String? get() = definedExternally; set(value) = definedExternally
    var action: (`this`: REPLServer, text: String) -> Unit
}
@Suppress("deprecation")
external interface `T$21` {
    @nativeGetter
    operator fun get(name: String): REPLCommand?
    @nativeSetter
    operator fun set(name: String, value: REPLCommand?)
}
open external class REPLServer : Interface {
    open var context: Context = definedExternally
    open var inputStream: ReadableStream = definedExternally
    open var outputStream: WritableStream = definedExternally
    open var commands: `T$21` = definedExternally
    open var editorMode: Boolean = definedExternally
    open var underscoreAssigned: Boolean = definedExternally
    open var last: Any = definedExternally
    open var underscoreErrAssigned: Boolean = definedExternally
    open var lastError: Any = definedExternally
    open var eval: (`this`: REPLServer, evalCmd: String, context: Context, file: String, cb: (err: Error?, result: Any) -> Unit) -> Unit = definedExternally
    open var useColors: Boolean = definedExternally
    open var useGlobal: Boolean = definedExternally
    open var ignoreUndefined: Boolean = definedExternally
    open var writer: (`this`: REPLServer, obj: Any) -> String = definedExternally
    open var completer: dynamic /* (line: String) -> dynamic /* JsTuple<Array<String>, String> */ | (line: String, callback: (err: Any, result: dynamic /* JsTuple<Array<String>, String> */) -> Unit) -> Any */ = definedExternally
    open var replMode: Any? = definedExternally
    open fun defineCommand(keyword: String, cmd: (`this`: REPLServer, text: String) -> Unit): Unit = definedExternally
    open fun defineCommand(keyword: String, cmd: REPLCommand): Unit = definedExternally
    open fun displayPrompt(preserveCursor: Boolean? = definedExternally /* null */): Unit = definedExternally
    open fun clearBufferedCommand(): Unit = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): REPLServer /* this */ = definedExternally
    override fun addListener(event: String /* "close" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun addListener(event: String /* "line" */, listener: (input: String) -> Unit): REPLServer /* this */ = definedExternally
    override fun addListener(event: String /* "pause" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun addListener(event: String /* "resume" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun addListener(event: String /* "SIGCONT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun addListener(event: String /* "SIGINT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun addListener(event: String /* "SIGTSTP" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun addListener(event: String /* "exit" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    open fun addListener(event: String /* "reset" */, listener: (context: Context) -> Unit): REPLServer /* this */ = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    override fun emit(event: String /* "close" */): Boolean = definedExternally
    override fun emit(event: String /* "line" */, input: String): Boolean = definedExternally
    override fun emit(event: String /* "pause" */): Boolean = definedExternally
    override fun emit(event: String /* "resume" */): Boolean = definedExternally
    override fun emit(event: String /* "SIGCONT" */): Boolean = definedExternally
    override fun emit(event: String /* "SIGINT" */): Boolean = definedExternally
    override fun emit(event: String /* "SIGTSTP" */): Boolean = definedExternally
    override fun emit(event: String /* "exit" */): Boolean = definedExternally
    open fun emit(event: String /* "reset" */, context: Context): Boolean = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): REPLServer /* this */ = definedExternally
    override fun on(event: String /* "close" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun on(event: String /* "line" */, listener: (input: String) -> Unit): REPLServer /* this */ = definedExternally
    override fun on(event: String /* "pause" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun on(event: String /* "resume" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun on(event: String /* "SIGCONT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun on(event: String /* "SIGINT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun on(event: String /* "SIGTSTP" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun on(event: String /* "exit" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    open fun on(event: String /* "reset" */, listener: (context: Context) -> Unit): REPLServer /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): REPLServer /* this */ = definedExternally
    override fun once(event: String /* "close" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun once(event: String /* "line" */, listener: (input: String) -> Unit): REPLServer /* this */ = definedExternally
    override fun once(event: String /* "pause" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun once(event: String /* "resume" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun once(event: String /* "SIGCONT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun once(event: String /* "SIGINT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun once(event: String /* "SIGTSTP" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun once(event: String /* "exit" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    open fun once(event: String /* "reset" */, listener: (context: Context) -> Unit): REPLServer /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): REPLServer /* this */ = definedExternally
    override fun prependListener(event: String /* "close" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependListener(event: String /* "line" */, listener: (input: String) -> Unit): REPLServer /* this */ = definedExternally
    override fun prependListener(event: String /* "pause" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependListener(event: String /* "resume" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependListener(event: String /* "SIGCONT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependListener(event: String /* "SIGINT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependListener(event: String /* "SIGTSTP" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependListener(event: String /* "exit" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    open fun prependListener(event: String /* "reset" */, listener: (context: Context) -> Unit): REPLServer /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): REPLServer /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "line" */, listener: (input: String) -> Unit): REPLServer /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "pause" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "resume" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "SIGCONT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "SIGINT" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "SIGTSTP" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "exit" */, listener: () -> Unit): REPLServer /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "reset" */, listener: (context: Context) -> Unit): REPLServer /* this */ = definedExternally
}
external var REPL_MODE_SLOPPY: Any? = definedExternally
external var REPL_MODE_STRICT: Any? = definedExternally
external fun start(options: String? = definedExternally /* null */): REPLServer = definedExternally
external fun start(options: ReplOptions? = definedExternally /* null */): REPLServer = definedExternally
external interface SyntaxError
open external class Recoverable(err: Error) : SyntaxError {
    open var err: Error = definedExternally
}
external fun start(): REPLServer = definedExternally

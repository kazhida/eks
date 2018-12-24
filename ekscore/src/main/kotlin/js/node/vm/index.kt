@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("vm")
package js.node.vm

import js.node.Buffer
import kotlin.js.*

@Suppress("deprecation")
external interface Context {
    @nativeGetter
    operator fun get(key: String): Any?
    @nativeSetter
    operator fun set(key: String, value: Any)
}
external interface BaseOptions {
    var filename: String? get() = definedExternally; set(value) = definedExternally
    var lineOffset: Number? get() = definedExternally; set(value) = definedExternally
    var columnOffset: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ScriptOptions : BaseOptions {
    var displayErrors: Boolean? get() = definedExternally; set(value) = definedExternally
    var timeout: Number? get() = definedExternally; set(value) = definedExternally
    var cachedData: Buffer? get() = definedExternally; set(value) = definedExternally
    var produceCachedData: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface RunningScriptOptions : BaseOptions {
    var displayErrors: Boolean? get() = definedExternally; set(value) = definedExternally
    var timeout: Number? get() = definedExternally; set(value) = definedExternally
}
external interface CompileFunctionOptions : BaseOptions {
    var cachedData: Buffer? get() = definedExternally; set(value) = definedExternally
    var produceCachedData: Boolean? get() = definedExternally; set(value) = definedExternally
    var parsingContext: Context? get() = definedExternally; set(value) = definedExternally
    var contextExtensions: Array<Any>? get() = definedExternally; set(value) = definedExternally
}
open external class Script(code: String, options: ScriptOptions? = definedExternally /* null */) {
    open fun runInContext(contextifiedSandbox: Context, options: RunningScriptOptions? = definedExternally /* null */): Any = definedExternally
    open fun runInNewContext(sandbox: Context? = definedExternally /* null */, options: RunningScriptOptions? = definedExternally /* null */): Any = definedExternally
    open fun runInThisContext(options: RunningScriptOptions? = definedExternally /* null */): Any = definedExternally
}
external fun createContext(sandbox: Context? = definedExternally /* null */): Context = definedExternally
external fun isContext(sandbox: Context): Boolean = definedExternally
external fun runInContext(code: String, contextifiedSandbox: Context, options: String? = definedExternally /* null */): Any = definedExternally
external fun runInContext(code: String, contextifiedSandbox: Context, options: RunningScriptOptions? = definedExternally /* null */): Any = definedExternally
external fun runInNewContext(code: String, sandbox: Context? = definedExternally /* null */, options: String? = definedExternally /* null */): Any = definedExternally
external fun runInNewContext(code: String, sandbox: Context? = definedExternally /* null */, options: RunningScriptOptions? = definedExternally /* null */): Any = definedExternally
external fun runInThisContext(code: String, options: String? = definedExternally /* null */): Any = definedExternally
external fun runInThisContext(code: String, options: RunningScriptOptions? = definedExternally /* null */): Any = definedExternally
external fun compileFunction(code: String, params: Array<String>, options: CompileFunctionOptions): Function<*> = definedExternally
external fun runInContext(code: String, contextifiedSandbox: Context): Any = definedExternally
external fun runInNewContext(code: String): Any = definedExternally
external fun runInThisContext(code: String): Any = definedExternally

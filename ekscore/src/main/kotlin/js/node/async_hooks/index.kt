@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("async_hooks")
package js.node.async_hooks

external fun executionAsyncId(): Number = definedExternally
external fun triggerAsyncId(): Number = definedExternally
external interface HookCallbacks {
    val init: ((asyncId: Number, type: String, triggerAsyncId: Number, resource: Any) -> Unit)? get() = definedExternally
    val before: ((asyncId: Number) -> Unit)? get() = definedExternally
    val after: ((asyncId: Number) -> Unit)? get() = definedExternally
    val promiseResolve: ((asyncId: Number) -> Unit)? get() = definedExternally
    val destroy: ((asyncId: Number) -> Unit)? get() = definedExternally
}
external interface AsyncHook {
    fun enable(): AsyncHook /* this */
    fun disable(): AsyncHook /* this */
}
external fun createHook(options: HookCallbacks): AsyncHook = definedExternally
external interface AsyncResourceOptions {
    var triggerAsyncId: Number? get() = definedExternally; set(value) = definedExternally
    var requireManualDestroy: Boolean? get() = definedExternally; set(value) = definedExternally
}
open external class AsyncResource {
    constructor(type: String, triggerAsyncId: Number? = definedExternally /* null */)
    constructor(type: String, triggerAsyncId: AsyncResourceOptions? = definedExternally /* null */)
    open fun emitBefore(): Unit = definedExternally
    open fun emitAfter(): Unit = definedExternally
    open fun <This, Result> runInAsyncScope(fn: (`this`: This, args: Any) -> Result, thisArg: This? = definedExternally /* null */, vararg args: Any): Result = definedExternally
    open fun emitDestroy(): Unit = definedExternally
    open fun asyncId(): Number = definedExternally
    open fun triggerAsyncId(): Number = definedExternally
}

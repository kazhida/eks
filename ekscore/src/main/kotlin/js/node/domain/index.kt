@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("domain")
package js.node.domain

import js.node.events.internal
import kotlin.js.*

open external class Domain : internal.EventEmitter {
    fun run(fn: Function<*>): Unit = definedExternally
    open fun add(emitter: EventEmitter): Unit = definedExternally
    open fun remove(emitter: EventEmitter): Unit = definedExternally
    open fun bind(cb: (err: Error, data: Any) -> Any): Any = definedExternally
    open fun intercept(cb: (data: Any) -> Any): Any = definedExternally
    open var members: Array<Any> = definedExternally
    open fun enter(): Unit = definedExternally
    open fun exit(): Unit = definedExternally
}
external fun create(): Domain = definedExternally

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")

package js.node.stream

import js.node.WritableStream
import js.node.events.internal.EventEmitter
import kotlin.js.*

external interface `T$108` {
    var end: Boolean? get() = definedExternally; set(value) = definedExternally
}
@JsModule("stream")
open external class Internal : EventEmitter {
    open fun <T : WritableStream> pipe(destination: T, options: `T$108`? = definedExternally /* null */): T = definedExternally
}

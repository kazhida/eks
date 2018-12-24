@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("trace_events")
package js.node.trace_events

import kotlin.js.*

external interface Tracing {
    var categories: String
    fun disable()
    fun enable()
    var enabled: Boolean
}
external interface CreateTracingOptions {
    var categories: Array<String>
}
external fun createTracing(options: CreateTracingOptions): Tracing = definedExternally
external fun getEnabledCategories(): String = definedExternally

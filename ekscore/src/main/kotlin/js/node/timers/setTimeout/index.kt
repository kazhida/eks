@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("timers") JsQualifier("setTimeout")]
package js.node.timers.setTimeout

import kotlin.js.*

external fun __promisify__(ms: Number): Promise<Unit> = definedExternally
external fun <T> __promisify__(ms: Number, value: T): Promise<T> = definedExternally

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsQualifier("setImmediate")
package js.node.setImmediate

import kotlin.js.*

external fun __promisify__(): Promise<Unit> = definedExternally
external fun <T> __promisify__(value: T): Promise<T> = definedExternally

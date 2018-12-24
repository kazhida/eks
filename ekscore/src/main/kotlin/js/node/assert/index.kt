@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")

package js.node.assert

import kotlin.js.*

@JsModule("assert")
external fun internal(value: Any, message: String? = definedExternally /* null */): Unit = definedExternally
@JsModule("assert")
external fun internal(value: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
@JsModule("assert")
external fun internal(value: Any): Unit = definedExternally

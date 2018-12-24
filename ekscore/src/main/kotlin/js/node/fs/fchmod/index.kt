@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("fchmod")]
package js.node.fs.fchmod

import kotlin.js.*

external fun __promisify__(fd: Number, mode: String): Promise<Unit> = definedExternally
external fun __promisify__(fd: Number, mode: Number): Promise<Unit> = definedExternally

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("appendFile")]
package js.node.fs.appendFile

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external interface `T$76` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var mode: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var flag: String? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(file: String, data: Any, options: dynamic /* String? | `T$76`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(file: Number, data: Any, options: dynamic /* String? | `T$76`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(file: Buffer, data: Any, options: dynamic /* String? | `T$76`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(file: URL, data: Any, options: dynamic /* String? | `T$76`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally

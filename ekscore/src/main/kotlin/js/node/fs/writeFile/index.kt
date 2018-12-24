@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("writeFile")]
package js.node.fs.writeFile

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external interface `T$75` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var mode: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var flag: String? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, data: Any, options: dynamic /* String? | `T$75`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(path: Number, data: Any, options: dynamic /* String? | `T$75`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(path: Buffer, data: Any, options: dynamic /* String? | `T$75`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(path: URL, data: Any, options: dynamic /* String? | `T$75`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally

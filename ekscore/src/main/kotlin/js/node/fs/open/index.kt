@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("open")]
package js.node.fs.open

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external fun __promisify__(path: String, flags: String, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<Number> = definedExternally
external fun __promisify__(path: String, flags: Number, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<Number> = definedExternally
external fun __promisify__(path: Buffer, flags: String, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<Number> = definedExternally
external fun __promisify__(path: Buffer, flags: Number, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<Number> = definedExternally
external fun __promisify__(path: URL, flags: String, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<Number> = definedExternally
external fun __promisify__(path: URL, flags: Number, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<Number> = definedExternally

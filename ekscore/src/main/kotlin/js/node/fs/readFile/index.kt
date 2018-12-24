@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("readFile")]
package js.node.fs.readFile

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external interface `T$71` {
    var encoding: Nothing? get() = definedExternally; set(value) = definedExternally
    var flag: String? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: `T$71`? = definedExternally /* null */): Promise<Buffer> = definedExternally
external fun __promisify__(path: Number, options: `T$71`? = definedExternally /* null */): Promise<Buffer> = definedExternally
external fun __promisify__(path: Buffer, options: `T$71`? = definedExternally /* null */): Promise<Buffer> = definedExternally
external fun __promisify__(path: URL, options: `T$71`? = definedExternally /* null */): Promise<Buffer> = definedExternally
external interface `T$72` {
    var encoding: String
    var flag: String? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: String): Promise<String> = definedExternally
external fun __promisify__(path: String, options: `T$72`): Promise<String> = definedExternally
external fun __promisify__(path: Number, options: String): Promise<String> = definedExternally
external fun __promisify__(path: Number, options: `T$72`): Promise<String> = definedExternally
external fun __promisify__(path: Buffer, options: String): Promise<String> = definedExternally
external fun __promisify__(path: Buffer, options: `T$72`): Promise<String> = definedExternally
external fun __promisify__(path: URL, options: String): Promise<String> = definedExternally
external fun __promisify__(path: URL, options: `T$72`): Promise<String> = definedExternally
external interface `T$73` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var flag: String? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: dynamic /* String? | `T$73`? | Nothing? */ = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Number, options: dynamic /* String? | `T$73`? | Nothing? */ = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Buffer, options: dynamic /* String? | `T$73`? | Nothing? */ = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: URL, options: dynamic /* String? | `T$73`? | Nothing? */ = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally

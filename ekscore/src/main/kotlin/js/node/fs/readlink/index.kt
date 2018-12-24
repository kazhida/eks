@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("readlink")]
package js.node.fs.readlink

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external interface `T$45` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */ get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$45`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$45`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$45`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external interface `T$46` {
    var encoding: String /* "buffer" */
}
external fun __promisify__(path: String, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun __promisify__(path: String, options: `T$46`): Promise<Buffer> = definedExternally
external fun __promisify__(path: Buffer, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun __promisify__(path: Buffer, options: `T$46`): Promise<Buffer> = definedExternally
external fun __promisify__(path: URL, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun __promisify__(path: URL, options: `T$46`): Promise<Buffer> = definedExternally
external interface `T$47` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: String, options: `T$47`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: String, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Buffer, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Buffer, options: `T$47`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Buffer, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: URL, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: URL, options: `T$47`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: URL, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: String): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Buffer): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: URL): Promise<dynamic /* String | Buffer */> = definedExternally

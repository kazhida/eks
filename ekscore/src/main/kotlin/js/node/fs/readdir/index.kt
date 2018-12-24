@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("readdir")]
package js.node.fs.readdir

import js.node.Buffer
import js.node.fs.Dirent
import js.node.url.URL
import kotlin.js.*

external interface `T$61` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */
    var withFileTypes: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$61`? | Nothing? */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external fun __promisify__(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$61`? | Nothing? */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external fun __promisify__(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$61`? | Nothing? */ = definedExternally /* null */): Nothing = definedExternally
external interface `T$62` {
    var encoding: String /* "buffer" */
    var withFileTypes: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: String /* "buffer" */): Promise<Array<Buffer>> = definedExternally
external fun __promisify__(path: String, options: `T$62`): Promise<Array<Buffer>> = definedExternally
external fun __promisify__(path: Buffer, options: String /* "buffer" */): Promise<Array<Buffer>> = definedExternally
external fun __promisify__(path: Buffer, options: `T$62`): Promise<Array<Buffer>> = definedExternally
external fun __promisify__(path: URL, options: String /* "buffer" */): Promise<Array<Buffer>> = definedExternally
external fun __promisify__(path: URL, options: `T$62`): Promise<Array<Buffer>> = definedExternally
external interface `T$63` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var withFileTypes: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: String? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: String, options: `T$63`? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: String, options: Nothing? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: Buffer, options: String? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: Buffer, options: `T$63`? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: Buffer, options: Nothing? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: URL, options: String? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: URL, options: `T$63`? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: URL, options: Nothing? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external interface `T$64` {
    var withFileTypes: Boolean
}
external fun __promisify__(path: String, options: `T$64`): Promise<Array<Dirent>> = definedExternally
external fun __promisify__(path: Buffer, options: `T$64`): Promise<Array<Dirent>> = definedExternally
external fun __promisify__(path: URL, options: `T$64`): Promise<Array<Dirent>> = definedExternally
external fun __promisify__(path: String): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: Buffer): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun __promisify__(path: URL): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally

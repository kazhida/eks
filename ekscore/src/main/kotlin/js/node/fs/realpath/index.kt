@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("realpath")]
package js.node.fs.realpath

import js.node.Buffer
import js.node.ErrnoException
import js.node.url.URL
import kotlin.js.*

external interface `T$48` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */ get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$48`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$48`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$48`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external interface `T$49` {
    var encoding: String /* "buffer" */
}
external fun __promisify__(path: String, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun __promisify__(path: String, options: `T$49`): Promise<Buffer> = definedExternally
external fun __promisify__(path: Buffer, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun __promisify__(path: Buffer, options: `T$49`): Promise<Buffer> = definedExternally
external fun __promisify__(path: URL, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun __promisify__(path: URL, options: `T$49`): Promise<Buffer> = definedExternally
external interface `T$50` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(path: String, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: String, options: `T$50`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: String, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Buffer, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Buffer, options: `T$50`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Buffer, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: URL, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: URL, options: `T$50`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: URL, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun native(path: String, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$48` | Nothing? */, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun native(path: Buffer, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$48` | Nothing? */, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun native(path: URL, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$48` | Nothing? */, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun native(path: String, options: String /* "buffer" */, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun native(path: String, options: `T$49`, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun native(path: Buffer, options: String /* "buffer" */, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun native(path: Buffer, options: `T$49`, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun native(path: URL, options: String /* "buffer" */, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun native(path: URL, options: `T$49`, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun native(path: String, options: String, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun native(path: String, options: `T$50`, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun native(path: String, options: Nothing?, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun native(path: Buffer, options: String, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun native(path: Buffer, options: `T$50`, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun native(path: Buffer, options: Nothing?, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun native(path: URL, options: String, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun native(path: URL, options: `T$50`, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun native(path: URL, options: Nothing?, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun native(path: String, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun native(path: Buffer, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun native(path: URL, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun __promisify__(path: String): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: Buffer): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(path: URL): Promise<dynamic /* String | Buffer */> = definedExternally

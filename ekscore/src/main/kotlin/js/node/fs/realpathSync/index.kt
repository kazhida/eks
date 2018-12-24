@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("realpathSync")]
package js.node.fs.realpathSync

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external interface `T$51` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */ get() = definedExternally; set(value) = definedExternally
}
external fun native(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$51`? | Nothing? */ = definedExternally /* null */): String = definedExternally
external fun native(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$51`? | Nothing? */ = definedExternally /* null */): String = definedExternally
external fun native(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$51`? | Nothing? */ = definedExternally /* null */): String = definedExternally
external interface `T$52` {
    var encoding: String /* "buffer" */
}
external fun native(path: String, options: String /* "buffer" */): Buffer = definedExternally
external fun native(path: String, options: `T$52`): Buffer = definedExternally
external fun native(path: Buffer, options: String /* "buffer" */): Buffer = definedExternally
external fun native(path: Buffer, options: `T$52`): Buffer = definedExternally
external fun native(path: URL, options: String /* "buffer" */): Buffer = definedExternally
external fun native(path: URL, options: `T$52`): Buffer = definedExternally
external interface `T$53` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
}
external fun native(path: String, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun native(path: String, options: `T$53`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun native(path: String, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun native(path: Buffer, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun native(path: Buffer, options: `T$53`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun native(path: Buffer, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun native(path: URL, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun native(path: URL, options: `T$53`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun native(path: URL, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun native(path: String): dynamic /* String | Buffer */ = definedExternally
external fun native(path: Buffer): dynamic /* String | Buffer */ = definedExternally
external fun native(path: URL): dynamic /* String | Buffer */ = definedExternally

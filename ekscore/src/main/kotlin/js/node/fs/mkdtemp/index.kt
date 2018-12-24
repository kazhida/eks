@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("mkdtemp")]
package js.node.fs.mkdtemp

import js.node.Buffer
import kotlin.js.*

external interface `T$54` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */ get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(prefix: String, options: String? /* "ascii" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(prefix: String, options: String? /* "utf8" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(prefix: String, options: String? /* "utf16le" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(prefix: String, options: String? /* "ucs2" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(prefix: String, options: String? /* "base64" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(prefix: String, options: String? /* "latin1" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(prefix: String, options: String? /* "binary" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(prefix: String, options: String? /* "hex" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(prefix: String, options: `T$54`? = definedExternally /* null */): Promise<String> = definedExternally
external fun __promisify__(prefix: String, options: Nothing? = definedExternally /* null */): Promise<String> = definedExternally
external interface `T$55` {
    var encoding: String /* "buffer" */
}
external fun __promisify__(prefix: String, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun __promisify__(prefix: String, options: `T$55`): Promise<Buffer> = definedExternally
external interface `T$56` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(prefix: String, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(prefix: String, options: `T$56`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(prefix: String, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun __promisify__(prefix: String): Promise<String> = definedExternally
external fun __promisify__(prefix: String): Promise<dynamic /* String | Buffer */> = definedExternally

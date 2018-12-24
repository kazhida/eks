@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("child_process") JsQualifier("exec")]
package js.node.child_process.exec

import js.node.Buffer
import js.node.child_process.ExecOptions
import kotlin.js.*

external interface `T$26` {
    var stdout: String
    var stderr: String
}
external fun __promisify__(command: String): Promise<`T$26`> = definedExternally
external interface `T$27` {
    var encoding: String? /* "buffer" */
}
external interface `T$28` {
    var stdout: Buffer
    var stderr: Buffer
}
external fun __promisify__(command: String, options: `T$27` /* `T$27` & child_process.ExecOptions */): Promise<`T$28`> = definedExternally
external interface `T$29` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */
}
external fun __promisify__(command: String, options: `T$29` /* `T$29` & child_process.ExecOptions */): Promise<`T$26`> = definedExternally
external fun __promisify__(command: String, options: ExecOptions): Promise<`T$26`> = definedExternally
external interface `T$30` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
}
external interface `T$31` {
    var stdout: dynamic /* String | Buffer */
    var stderr: dynamic /* String | Buffer */
}
external fun __promisify__(command: String, options: `T$30`? /* `T$30` & child_process.ExecOptions */ = definedExternally /* null */): Promise<`T$31`> = definedExternally

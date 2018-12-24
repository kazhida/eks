@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("child_process") JsQualifier("execFile")]
package js.node.child_process.execFile

import js.node.Buffer
import js.node.child_process.ExecFileOptionsWithBufferEncoding
import js.node.child_process.ExecFileOptionsWithStringEncoding
import js.node.child_process.ExecFileOptionsWithOtherEncoding
import js.node.child_process.ExecFileOptions
import kotlin.js.*

external interface `T$32` {
    var stdout: String
    var stderr: String
}
external fun __promisify__(file: String): Promise<`T$32`> = definedExternally
external fun __promisify__(file: String, args: Array<String>?): Promise<`T$32`> = definedExternally
external interface `T$33` {
    var stdout: Buffer
    var stderr: Buffer
}
external fun __promisify__(file: String, options: ExecFileOptionsWithBufferEncoding): Promise<`T$33`> = definedExternally
external fun __promisify__(file: String, args: Array<String>?, options: ExecFileOptionsWithBufferEncoding): Promise<`T$33`> = definedExternally
external fun __promisify__(file: String, options: ExecFileOptionsWithStringEncoding): Promise<`T$32`> = definedExternally
external fun __promisify__(file: String, args: Array<String>?, options: ExecFileOptionsWithStringEncoding): Promise<`T$32`> = definedExternally
external interface `T$34` {
    var stdout: dynamic /* String | Buffer */
    var stderr: dynamic /* String | Buffer */
}
external fun __promisify__(file: String, options: ExecFileOptionsWithOtherEncoding): Promise<`T$34`> = definedExternally
external fun __promisify__(file: String, args: Array<String>?, options: ExecFileOptionsWithOtherEncoding): Promise<`T$34`> = definedExternally
external fun __promisify__(file: String, options: ExecFileOptions): Promise<`T$32`> = definedExternally
external fun __promisify__(file: String, args: Array<String>?, options: ExecFileOptions): Promise<`T$32`> = definedExternally
external interface `T$35` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(file: String, options: `T$35`? /* `T$35` & child_process.ExecFileOptions */): Promise<`T$34`> = definedExternally
external fun __promisify__(file: String, args: Array<String>?, options: `T$35`? /* `T$35` & child_process.ExecFileOptions */): Promise<`T$34`> = definedExternally

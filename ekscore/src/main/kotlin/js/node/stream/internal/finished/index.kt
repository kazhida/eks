@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("stream") JsQualifier("finished")]
package js.node.stream.internal.finished

import js.node.ReadWriteStream
import js.node.ReadableStream
import js.node.WritableStream
import kotlin.js.*

external fun __promisify__(stream: WritableStream): Promise<Unit> = definedExternally
external fun __promisify__(stream: ReadableStream): Promise<Unit> = definedExternally
external fun __promisify__(stream: ReadWriteStream): Promise<Unit> = definedExternally

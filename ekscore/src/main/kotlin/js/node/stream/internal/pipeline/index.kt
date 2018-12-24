@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("stream") JsQualifier("pipeline")]
package js.node.stream.internal.pipeline

import js.node.ReadWriteStream
import js.node.ReadableStream
import js.node.WritableStream
import kotlin.js.*

external fun __promisify__(stream1: ReadableStream, stream2: WritableStream): Promise<Unit> = definedExternally
external fun __promisify__(stream1: ReadableStream, stream2: ReadWriteStream, stream3: WritableStream): Promise<Unit> = definedExternally
external fun __promisify__(stream1: ReadableStream, stream2: ReadWriteStream, stream3: ReadWriteStream, stream4: WritableStream): Promise<Unit> = definedExternally
external fun __promisify__(stream1: ReadableStream, stream2: ReadWriteStream, stream3: ReadWriteStream, stream4: ReadWriteStream, stream5: WritableStream): Promise<Unit> = definedExternally
external fun __promisify__(streams: Array<dynamic /* WritableStream | ReadableStream | ReadWriteStream */>): Promise<Unit> = definedExternally
external fun __promisify__(stream1: ReadableStream, stream2: WritableStream, vararg streams: WritableStream): Promise<Unit> = definedExternally
external fun __promisify__(stream1: ReadableStream, stream2: WritableStream, vararg streams: ReadWriteStream): Promise<Unit> = definedExternally
external fun __promisify__(stream1: ReadableStream, stream2: ReadWriteStream, vararg streams: WritableStream): Promise<Unit> = definedExternally
external fun __promisify__(stream1: ReadableStream, stream2: ReadWriteStream, vararg streams: ReadWriteStream): Promise<Unit> = definedExternally

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("stream")
package js.node.stream.internal

import js.node.*
import kotlin.js.*

open external class Stream : js.node.stream.Internal
external interface ReadableOptions {
    var highWaterMark: Number? get() = definedExternally; set(value) = definedExternally
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var objectMode: Boolean? get() = definedExternally; set(value) = definedExternally
    val read: ((readable: Readable, size: Number) -> Unit)? get() = definedExternally
    val destroy: ((Writable, Error?, (Error?) -> Unit) -> Unit)? get() = definedExternally
}
open external class Readable(opts: ReadableOptions? = definedExternally /* null */) : Stream, ReadableStream {
    override var readable: Boolean = definedExternally
    open var readableHighWaterMark: Number = definedExternally
    open var readableLength: Number = definedExternally
    open fun _read(size: Number): Unit = definedExternally
    override fun read(size: Number?): Any = definedExternally
    override fun setEncoding(encoding: String): Readable /* this */ = definedExternally
    override fun pause(): Readable /* this */ = definedExternally
    override fun resume(): Readable /* this */ = definedExternally
    override fun isPaused(): Boolean = definedExternally
    override fun unpipe(destination: WritableStream?): Readable /* this */ = definedExternally
    open fun unshift(chunk: Any): Unit = definedExternally
    override fun wrap(oldStream: ReadableStream): Readable /* this */ = definedExternally
    open fun push(chunk: Any, encoding: String? = definedExternally /* null */): Boolean = definedExternally
    open fun _destroy(error: Error?, callback: (error: Error?) -> Unit): Unit = definedExternally
    open fun destroy(error: Error? = definedExternally /* null */): Unit = definedExternally
    open fun addListener(event: String /* "close" */, listener: () -> Unit): Readable /* this */ = definedExternally
    override fun addListener(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */ = definedExternally
    open fun addListener(event: String /* "end" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun addListener(event: String /* "readable" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */ = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    override fun addListener(event: Any?, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    open fun emit(event: String /* "close" */): Boolean = definedExternally
    open fun emit(event: String /* "data" */, chunk: Any): Boolean = definedExternally
    open fun emit(event: String /* "end" */): Boolean = definedExternally
    open fun emit(event: String /* "readable" */): Boolean = definedExternally
    open fun emit(event: String /* "error" */, err: Error): Boolean = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun on(event: String /* "close" */, listener: () -> Unit): Readable /* this */ = definedExternally
    override fun on(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */ = definedExternally
    open fun on(event: String /* "end" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun on(event: String /* "readable" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */ = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    override fun on(event: Any?, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    open fun once(event: String /* "close" */, listener: () -> Unit): Readable /* this */ = definedExternally
    override fun once(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */ = definedExternally
    open fun once(event: String /* "end" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun once(event: String /* "readable" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    override fun once(event: Any?, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    open fun prependListener(event: String /* "close" */, listener: () -> Unit): Readable /* this */ = definedExternally
    override fun prependListener(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */ = definedExternally
    open fun prependListener(event: String /* "end" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun prependListener(event: String /* "readable" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    override fun prependListener(event: Any?, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): Readable /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "end" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "readable" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    override fun prependOnceListener(event: Any?, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    open fun removeListener(event: String /* "close" */, listener: () -> Unit): Readable /* this */ = definedExternally
    override fun removeListener(event: String /* "data" */, listener: (chunk: Any) -> Unit): Readable /* this */ = definedExternally
    open fun removeListener(event: String /* "end" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun removeListener(event: String /* "readable" */, listener: () -> Unit): Readable /* this */ = definedExternally
    open fun removeListener(event: String /* "error" */, listener: (err: Error) -> Unit): Readable /* this */ = definedExternally
    override fun removeListener(event: String, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    override fun removeListener(event: Any?, listener: (args: Any) -> Unit): Readable /* this */ = definedExternally
    override fun <T : WritableStream> pipe(destination: T, options: `T$3`?): T = definedExternally
    override fun unshift(chunk: String) = definedExternally
    override fun unshift(chunk: Buffer) = definedExternally
}
external interface `T$109` {
    var chunk: Any
    var encoding: String
}
external interface WritableOptions {
    var highWaterMark: Number? get() = definedExternally; set(value) = definedExternally
    var decodeStrings: Boolean? get() = definedExternally; set(value) = definedExternally
    var objectMode: Boolean? get() = definedExternally; set(value) = definedExternally
    val write: ((writable: Writable, chunk: Any, encoding: String, callback: (error: Error? /*= null*/) -> Unit) -> Unit)? get() = definedExternally
    val writev: ((writable: Writable, chunks: Array<`T$109`>, callback: (error: Error? /*= null*/) -> Unit) -> Unit)? get() = definedExternally
    val destroy: ((writable: Writable, error: Error?, callback: (error: Error?) -> Unit) -> Unit)? get() = definedExternally
    val final: ((writable: Writable, callback: (error: Error? /*= null*/) -> Unit) -> Unit)? get() = definedExternally
}
open external class Writable(opts: WritableOptions? = definedExternally /* null */) : Stream, WritableStream {
    override var writable: Boolean = definedExternally
    open var writableHighWaterMark: Number = definedExternally
    open var writableLength: Number = definedExternally
    open fun _write(chunk: Any, encoding: String, callback: (error: Error? /*= null*/) -> Unit): Unit = definedExternally
    open fun _writev(chunks: Array<`T$109`>, callback: (error: Error? /*= null*/) -> Unit): Unit = definedExternally
    open fun _destroy(error: Error?, callback: (error: Error?) -> Unit): Unit = definedExternally
    open fun _final(callback: (error: Error? /*= null*/) -> Unit): Unit = definedExternally
    open fun write(chunk: Any, cb: ((error: Error?) -> Unit)? = definedExternally /* null */): Boolean = definedExternally
    open fun write(chunk: Any, encoding: String? = definedExternally /* null */, cb: ((error: Error?) -> Unit)? = definedExternally /* null */): Boolean = definedExternally
    open fun setDefaultEncoding(encoding: String): Writable /* this */ = definedExternally
    open fun end(cb: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun end(chunk: Any, cb: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun end(chunk: Any, encoding: String? = definedExternally /* null */, cb: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun cork(): Unit = definedExternally
    open fun uncork(): Unit = definedExternally
    open fun destroy(error: Error? = definedExternally /* null */): Unit = definedExternally
    open fun addListener(event: String /* "close" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun addListener(event: String /* "drain" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */ = definedExternally
    open fun addListener(event: String /* "finish" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun addListener(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    open fun addListener(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    override fun addListener(event: Any?, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    open fun emit(event: String /* "close" */): Boolean = definedExternally
    open fun emit(event: String /* "drain" */): Boolean = definedExternally
    open fun emit(event: String /* "error" */, err: Error): Boolean = definedExternally
    open fun emit(event: String /* "finish" */): Boolean = definedExternally
    open fun emit(event: String /* "pipe" */, src: Readable): Boolean = definedExternally
    open fun emit(event: String /* "unpipe" */, src: Readable): Boolean = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun on(event: String /* "close" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun on(event: String /* "drain" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */ = definedExternally
    open fun on(event: String /* "finish" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun on(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    open fun on(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    override fun on(event: Any?, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    open fun once(event: String /* "close" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun once(event: String /* "drain" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */ = definedExternally
    open fun once(event: String /* "finish" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun once(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    open fun once(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    override fun once(event: Any?, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    open fun prependListener(event: String /* "close" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun prependListener(event: String /* "drain" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */ = definedExternally
    open fun prependListener(event: String /* "finish" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun prependListener(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    open fun prependListener(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    override fun prependListener(event: Any?, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "drain" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "finish" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    override fun prependOnceListener(event: Any?, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    open fun removeListener(event: String /* "close" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun removeListener(event: String /* "drain" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun removeListener(event: String /* "error" */, listener: (err: Error) -> Unit): Writable /* this */ = definedExternally
    open fun removeListener(event: String /* "finish" */, listener: () -> Unit): Writable /* this */ = definedExternally
    open fun removeListener(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    open fun removeListener(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Writable /* this */ = definedExternally
    override fun removeListener(event: String, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    override fun removeListener(event: Any?, listener: (args: Any) -> Unit): Writable /* this */ = definedExternally
    override fun write(buffer: String, cb: Function<*>?): Boolean = definedExternally
    override fun write(buffer: Buffer, cb: Function<*>?): Boolean = definedExternally
    override fun write(str: String, encoding: String?, cb: Function<*>?): Boolean = definedExternally
    open fun write(chunk: Any): Boolean = definedExternally
    override fun end(cb: Function<*>?) = definedExternally
    override fun end(buffer: Buffer, cb: Function<*>?) = definedExternally
    override fun end(str: String, cb: Function<*>?) = definedExternally
    override fun end(str: String, encoding: String?, cb: Function<*>?) = definedExternally
    override fun end(str: String) = definedExternally
    open fun end(chunk: Any): Unit = definedExternally
}
external interface DuplexOptions : ReadableOptions, WritableOptions {
    override var highWaterMark: Number? get() = definedExternally; set(value) = definedExternally
    override var objectMode: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowHalfOpen: Boolean? get() = definedExternally; set(value) = definedExternally
    var readableObjectMode: Boolean? get() = definedExternally; set(value) = definedExternally
    var writableObjectMode: Boolean? get() = definedExternally; set(value) = definedExternally
    override val read: ((readable: Readable, size: Number) -> Unit)? get() = definedExternally
    override val write: ((writable: Writable, chunk: Any, encoding: String, (Error?) -> Unit) -> Unit)? get() = definedExternally
    override val writev: ((writable: Writable, callback: Array<`T$109`>, (error: Error?) -> Unit) -> Unit)? get() = definedExternally
    override val final: ((writable: Writable, (error: Error?) -> Unit) -> Unit)? get() = definedExternally
    override val destroy: ((writable: Writable, error: Error?, (error: Error?) -> Unit) -> Unit)? get() = definedExternally
}
// Note: Duplex extends both Readable and Writable.
open external class Duplex(opts: DuplexOptions? = definedExternally /* null */) : Stream, ReadableStream by Readable(opts), WritableStream by Writable(opts) {
    override var writable: Boolean = definedExternally
    open fun _write(chunk: Any, encoding: String, callback: (error: Error? /*= null*/) -> Unit): Unit = definedExternally
    open fun _writev(chunks: Array<`T$109`>, callback: (error: Error? /*= null*/) -> Unit): Unit = definedExternally
    open fun _destroy(error: Error?, callback: (error: Error?) -> Unit): Unit = definedExternally
    open fun _final(callback: (error: Error? /*= null*/) -> Unit): Unit = definedExternally
    open fun write(chunk: Any, cb: ((error: Error?) -> Unit)? = definedExternally /* null */): Boolean = definedExternally
    open fun write(chunk: Any, encoding: String? = definedExternally /* null */, cb: ((error: Error?) -> Unit)? = definedExternally /* null */): Boolean = definedExternally
    open fun setDefaultEncoding(encoding: String): Duplex /* this */ = definedExternally
    open fun end(cb: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun end(chunk: Any, cb: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun end(chunk: Any, encoding: String? = definedExternally /* null */, cb: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun cork(): Unit = definedExternally
    open fun uncork(): Unit = definedExternally
    open fun write(chunk: Any): Boolean = definedExternally
    open fun end(chunk: Any): Unit = definedExternally
}
external interface TransformOptions : DuplexOptions {
    override val read: ((readable: Readable, size: Number) -> Unit)? get() = definedExternally
    override val write: ((writable: Writable, chunk: Any, encoding: String, callback: (error: Error?) -> Unit) -> Unit)? get() = definedExternally
    override val writev: ((writable: Writable, chunks: Array<`T$109`>, callback: (error: Error?) -> Unit) -> Unit)? get() = definedExternally
    override val final: ((writable: Writable, callback: (error: Error?) -> Unit) -> Unit)? get() = definedExternally
    override val destroy: ((writable: Writable, error: Error?, (error: Error?) -> Unit) -> Unit)? get() = definedExternally
    val transform: ((transform: Transform, chunk: Any, encoding: String, callback: (error: Error? /*= null*/, data: Any? /*= null*/) -> Unit) -> Unit)? get() = definedExternally
    val flush: ((transform: Transform, callback: (error: Error? /*= null*/, data: Any? /*= null*/) -> Unit) -> Unit)? get() = definedExternally
}
open external class Transform(opts: TransformOptions? = definedExternally /* null */) : Duplex {
    open fun _transform(chunk: Any, encoding: String, callback: (error: Error? /*= null*/, data: Any? /*= null*/) -> Unit): Unit = definedExternally
    open fun _flush(callback: (error: Error? /*= null*/, data: Any? /*= null*/) -> Unit): Unit = definedExternally
}
open external class PassThrough : Transform
external fun finished(stream: WritableStream, callback: (err: ErrnoException? /*= null*/) -> Unit): () -> Unit = definedExternally
external fun finished(stream: ReadableStream, callback: (err: ErrnoException? /*= null*/) -> Unit): () -> Unit = definedExternally
external fun finished(stream: ReadWriteStream, callback: (err: ErrnoException? /*= null*/) -> Unit): () -> Unit = definedExternally
external fun <T : WritableStream> pipeline(stream1: ReadableStream, stream2: T, callback: ((err: ErrnoException) -> Unit)? = definedExternally /* null */): T = definedExternally
external fun <T : WritableStream> pipeline(stream1: ReadableStream, stream2: ReadWriteStream, stream3: T, callback: ((err: ErrnoException) -> Unit)? = definedExternally /* null */): T = definedExternally
external fun <T : WritableStream> pipeline(stream1: ReadableStream, stream2: ReadWriteStream, stream3: ReadWriteStream, stream4: T, callback: ((err: ErrnoException) -> Unit)? = definedExternally /* null */): T = definedExternally
external fun <T : WritableStream> pipeline(stream1: ReadableStream, stream2: ReadWriteStream, stream3: ReadWriteStream, stream4: ReadWriteStream, stream5: T, callback: ((err: ErrnoException) -> Unit)? = definedExternally /* null */): T = definedExternally
external fun pipeline(streams: Array<dynamic /* WritableStream | ReadableStream | ReadWriteStream */>, callback: ((err: ErrnoException) -> Unit)? = definedExternally /* null */): WritableStream = definedExternally
external fun pipeline(stream1: ReadableStream, stream2: WritableStream, vararg streams: WritableStream): WritableStream = definedExternally
external fun pipeline(stream1: ReadableStream, stream2: WritableStream, vararg streams: ReadWriteStream): WritableStream = definedExternally
external fun pipeline(stream1: ReadableStream, stream2: WritableStream, vararg streams: (err: ErrnoException) -> Unit): WritableStream = definedExternally
external fun pipeline(stream1: ReadableStream, stream2: ReadWriteStream, vararg streams: WritableStream): WritableStream = definedExternally
external fun pipeline(stream1: ReadableStream, stream2: ReadWriteStream, vararg streams: ReadWriteStream): WritableStream = definedExternally
external fun pipeline(stream1: ReadableStream, stream2: ReadWriteStream, vararg streams: (err: ErrnoException) -> Unit): WritableStream = definedExternally

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("zlib")
package js.node.zlib

import js.node.Buffer
import js.node.stream.internal.Transform
import kotlin.js.*

external interface ZlibOptions {
    var flush: Number? get() = definedExternally; set(value) = definedExternally
    var finishFlush: Number? get() = definedExternally; set(value) = definedExternally
    var chunkSize: Number? get() = definedExternally; set(value) = definedExternally
    var windowBits: Number? get() = definedExternally; set(value) = definedExternally
    var level: Number? get() = definedExternally; set(value) = definedExternally
    var memLevel: Number? get() = definedExternally; set(value) = definedExternally
    var strategy: Number? get() = definedExternally; set(value) = definedExternally
    var dictionary: dynamic /* Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */ get() = definedExternally; set(value) = definedExternally
}
external interface Zlib {
    var bytesRead: Number
    fun close(callback: (() -> Unit)? = definedExternally /* null */)
    fun flush(kind: Number? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */)
    fun flush(kind: (() -> Unit)? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */)
    fun flush()
}
external interface ZlibParams {
    fun params(level: Number, strategy: Number, callback: () -> Unit)
}
external interface ZlibReset {
    fun reset()
}
external interface Gzip : Transform, Zlib
external interface Gunzip : Transform, Zlib
external interface Deflate : Transform, Zlib, ZlibReset, ZlibParams
external interface Inflate : Transform, Zlib, ZlibReset
external interface DeflateRaw : Transform, Zlib, ZlibReset, ZlibParams
external interface InflateRaw : Transform, Zlib, ZlibReset
external interface Unzip : Transform, Zlib
external fun createGzip(options: ZlibOptions? = definedExternally /* null */): Gzip = definedExternally
external fun createGunzip(options: ZlibOptions? = definedExternally /* null */): Gunzip = definedExternally
external fun createDeflate(options: ZlibOptions? = definedExternally /* null */): Deflate = definedExternally
external fun createInflate(options: ZlibOptions? = definedExternally /* null */): Inflate = definedExternally
external fun createDeflateRaw(options: ZlibOptions? = definedExternally /* null */): DeflateRaw = definedExternally
external fun createInflateRaw(options: ZlibOptions? = definedExternally /* null */): InflateRaw = definedExternally
external fun createUnzip(options: ZlibOptions? = definedExternally /* null */): Unzip = definedExternally
external fun deflate(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun deflate(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun deflateSync(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions? = definedExternally /* null */): Buffer = definedExternally
external fun deflateRaw(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun deflateRaw(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun deflateRawSync(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions? = definedExternally /* null */): Buffer = definedExternally
external fun gzip(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun gzip(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun gzipSync(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions? = definedExternally /* null */): Buffer = definedExternally
external fun gunzip(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun gunzip(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun gunzipSync(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions? = definedExternally /* null */): Buffer = definedExternally
external fun inflate(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun inflate(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun inflateSync(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions? = definedExternally /* null */): Buffer = definedExternally
external fun inflateRaw(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun inflateRaw(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun inflateRawSync(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions? = definedExternally /* null */): Buffer = definedExternally
external fun unzip(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun unzip(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions, callback: (error: Error?, result: Buffer) -> Unit): Unit = definedExternally
external fun unzipSync(buf: dynamic /* String | Buffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: ZlibOptions? = definedExternally /* null */): Buffer = definedExternally
external var Z_NO_FLUSH: Number = definedExternally
external var Z_PARTIAL_FLUSH: Number = definedExternally
external var Z_SYNC_FLUSH: Number = definedExternally
external var Z_FULL_FLUSH: Number = definedExternally
external var Z_FINISH: Number = definedExternally
external var Z_BLOCK: Number = definedExternally
external var Z_TREES: Number = definedExternally
external var Z_OK: Number = definedExternally
external var Z_STREAM_END: Number = definedExternally
external var Z_NEED_DICT: Number = definedExternally
external var Z_ERRNO: Number = definedExternally
external var Z_STREAM_ERROR: Number = definedExternally
external var Z_DATA_ERROR: Number = definedExternally
external var Z_MEM_ERROR: Number = definedExternally
external var Z_BUF_ERROR: Number = definedExternally
external var Z_VERSION_ERROR: Number = definedExternally
external var Z_NO_COMPRESSION: Number = definedExternally
external var Z_BEST_SPEED: Number = definedExternally
external var Z_BEST_COMPRESSION: Number = definedExternally
external var Z_DEFAULT_COMPRESSION: Number = definedExternally
external var Z_FILTERED: Number = definedExternally
external var Z_HUFFMAN_ONLY: Number = definedExternally
external var Z_RLE: Number = definedExternally
external var Z_FIXED: Number = definedExternally
external var Z_DEFAULT_STRATEGY: Number = definedExternally
external var Z_BINARY: Number = definedExternally
external var Z_TEXT: Number = definedExternally
external var Z_ASCII: Number = definedExternally
external var Z_UNKNOWN: Number = definedExternally
external var Z_DEFLATED: Number = definedExternally

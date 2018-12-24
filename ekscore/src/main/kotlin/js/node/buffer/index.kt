@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("buffer")
package js.node.buffer

import js.node.Buffer
import js.node.SharedArrayBuffer
import kotlin.js.*

external interface ArrayBuffer
external interface Uint8Array
external interface ReadonlyArray<T>

external var INSPECT_MAX_BYTES: Number = definedExternally
external interface `T$8` {
    var prototype: Buffer
    fun from(arrayBuffer: SharedArrayBuffer, byteOffset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */): Buffer
    fun from(arrayBuffer: ArrayBuffer, byteOffset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */): Buffer
    fun from(data: Array<Any>): Buffer
    fun from(data: Uint8Array): Buffer
    fun from(str: String, encoding: String? = definedExternally /* null */): Buffer
    fun of(vararg items: Number): Buffer
    fun isBuffer(obj: Any): Boolean
    fun isEncoding(encoding: String): Boolean
    fun byteLength(string: dynamic /* String | SharedArrayBuffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, encoding: String? = definedExternally /* null */): Number
    fun concat(list: Array<Uint8Array>, totalLength: Number? = definedExternally /* null */): Buffer
    fun compare(buf1: Uint8Array, buf2: Uint8Array): Number
    fun alloc(size: Number, fill: String? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Buffer
    fun alloc(size: Number, fill: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Buffer
    fun alloc(size: Number, fill: Buffer? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Buffer
    fun allocUnsafe(size: Number): Buffer
    fun allocUnsafeSlow(size: Number): Buffer
    var poolSize: Number
    fun alloc(size: Number): Buffer
}
external var BuffType: `T$8` = definedExternally
external interface `T$9` {
    var prototype: Buffer
    fun isBuffer(obj: Any): Boolean
    fun byteLength(string: String, encoding: String? = definedExternally /* null */): Number
    fun concat(list: Array<Buffer>, totalLength: Number? = definedExternally /* null */): Buffer
}
external var SlowBuffType: `T$9` = definedExternally

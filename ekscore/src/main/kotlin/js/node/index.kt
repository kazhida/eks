@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")

package js.node

import js.node.buffer.ArrayBuffer
import js.node.buffer.Uint8Array
import kotlin.js.Console

external object Console {
    var Console: ConsoleConstructor get() = definedExternally; set(value) = definedExternally
    fun assert(value: Any, message: String? = definedExternally /* null */, vararg optionalParams: Any): Nothing = definedExternally
    fun clear(): Unit = definedExternally
    fun count(label: String? = definedExternally /* null */): Unit = definedExternally
    fun countReset(label: String? = definedExternally /* null */): Unit = definedExternally
    fun debug(message: Any? = definedExternally /* null */, vararg optionalParams: Any): Unit = definedExternally
    fun dir(obj: Any, options: InspectOptions? = definedExternally /* null */): Unit = definedExternally
    fun dirxml(vararg data: Any): Unit = definedExternally
    fun error(message: Any? = definedExternally /* null */, vararg optionalParams: Any): Unit = definedExternally
    fun group(vararg label: Any): Unit = definedExternally
    fun groupCollapsed(): Unit = definedExternally
    fun groupEnd(): Unit = definedExternally
    fun info(message: Any? = definedExternally /* null */, vararg optionalParams: Any): Unit = definedExternally
    fun log(message: Any? = definedExternally /* null */, vararg optionalParams: Any): Unit = definedExternally
    fun table(tabularData: Any, properties: Array<String>? = definedExternally /* null */): Unit = definedExternally
    fun time(label: String? = definedExternally /* null */): Unit = definedExternally
    fun timeEnd(label: String? = definedExternally /* null */): Unit = definedExternally
    fun timeLog(label: String? = definedExternally /* null */, vararg data: Any): Unit = definedExternally
    fun trace(message: Any? = definedExternally /* null */, vararg optionalParams: Any): Unit = definedExternally
    fun warn(message: Any? = definedExternally /* null */, vararg optionalParams: Any): Unit = definedExternally
    fun markTimeline(label: String? = definedExternally /* null */): Unit = definedExternally
    fun profile(label: String? = definedExternally /* null */): Unit = definedExternally
    fun profileEnd(label: String? = definedExternally /* null */): Unit = definedExternally
    fun timeStamp(label: String? = definedExternally /* null */): Unit = definedExternally
    fun timeline(label: String? = definedExternally /* null */): Unit = definedExternally
    fun timelineEnd(label: String? = definedExternally /* null */): Unit = definedExternally
}
external interface Error {
    var stack: String? get() = definedExternally; set(value) = definedExternally
}
external object ErrorConstructor {
    fun captureStackTrace(targetObject: Any, constructorOpt: Function<*>? = definedExternally /* null */): Unit = definedExternally
    var prepareStackTrace: ((err: Error, stackTraces: Array<CallSite>) -> Any)? get() = definedExternally; set(value) = definedExternally
    var stackTraceLimit: Number get() = definedExternally; set(value) = definedExternally
}
external interface MapConstructor
external interface WeakMapConstructor
external interface SetConstructor
external interface WeakSetConstructor
external interface Set<T>
external interface ReadonlySet<T>
external interface Iterable<T>
external interface Iterator<T> {
    fun next(value: Any? = definedExternally /* null */): IteratorResult<T>
}
external interface IteratorResult<T>
external interface AsyncIterableIterator<T>
external interface SymbolConstructor {
    var observable: Any?
    var iterator: Any?
    var asyncIterator: Any?
}
external var Symbol: SymbolConstructor = definedExternally
external interface SharedArrayBuffer {
    var byteLength: Number
    fun slice(begin: Number? = definedExternally /* null */, end: Number? = definedExternally /* null */): SharedArrayBuffer
}
//external fun String.trimLeft(): String = definedExternally
//external fun String.trimRight(): String = definedExternally
@JsModule("process")
external val process: Process = definedExternally
external var global: Global = definedExternally
@JsModule("console")
external val console: Console = definedExternally
external var __filename: String = definedExternally
external var __dirname: String = definedExternally
external fun setTimeout(callback: (args: Any) -> Unit, ms: Number, vararg args: Any): Timeout = definedExternally
external fun clearTimeout(timeoutId: Timeout): Unit = definedExternally
external fun setInterval(callback: (args: Any) -> Unit, ms: Number, vararg args: Any): Timeout = definedExternally
external fun clearInterval(intervalId: Timeout): Unit = definedExternally
external fun setImmediate(callback: (args: Any) -> Unit, vararg args: Any): Immediate = definedExternally
external fun clearImmediate(immediateId: Immediate): Unit = definedExternally
external interface NodeRequireFunction {
    @Suppress("deprecation")
    @nativeInvoke
    operator fun invoke(id: String): Any
}
external interface NodeRequire : NodeRequireFunction {
    var resolve: RequireResolve
    var cache: Any
    var extensions: NodeExtensions
    var main: NodeModule?
}
external interface `T$0` {
    var paths: Array<String>? get() = definedExternally; set(value) = definedExternally
}
external interface RequireResolve {
    @Suppress("deprecation")
    @nativeInvoke
    operator fun invoke(id: String, options: `T$0`? = definedExternally /* null */): String
    fun paths(request: String): Array<String>?
}
external interface NodeExtensions {
    @Suppress("deprecation")
    @nativeGetter
    operator fun get(ext: String): ((m: NodeModule, filename: String) -> Any)?
    @Suppress("deprecation")
    @nativeSetter
    operator fun set(ext: String, value: (m: NodeModule, filename: String) -> Any)
}
external var require: NodeRequire = definedExternally
external interface NodeModule {
    var exports: Any
    var require: NodeRequireFunction
    var id: String
    var filename: String
    var loaded: Boolean
    var parent: NodeModule?
    var children: Array<NodeModule>
    var paths: Array<String>
}
external var module: NodeModule = definedExternally
external var exports: Any = definedExternally
external object SlowBuffer {
    var prototype: Buffer = definedExternally
    fun isBuffer(obj: Any): Boolean = definedExternally
    fun byteLength(string: String, encoding: String? = definedExternally /* null */): Number = definedExternally
    fun concat(list: Array<Buffer>, totalLength: Number? = definedExternally /* null */): Buffer = definedExternally
}
external interface `T$1` {
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
external interface `T$2` {
    var type: String /* "Buffer" */
    var data: Array<Any>
}
external interface Buffer : Uint8Array {
    var constructor: `T$1`
    fun write(string: String, offset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Number
    fun toString(encoding: String? = definedExternally /* null */, start: Number? = definedExternally /* null */, end: Number? = definedExternally /* null */): String
    fun toJSON(): `T$2`
    fun equals(otherBuffer: Uint8Array): Boolean
    fun compare(otherBuffer: Uint8Array, targetStart: Number? = definedExternally /* null */, targetEnd: Number? = definedExternally /* null */, sourceStart: Number? = definedExternally /* null */, sourceEnd: Number? = definedExternally /* null */): Number
    fun copy(targetBuffer: Uint8Array, targetStart: Number? = definedExternally /* null */, sourceStart: Number? = definedExternally /* null */, sourceEnd: Number? = definedExternally /* null */): Number
    fun slice(start: Number?, end: Number?): Buffer
    fun writeUIntLE(value: Number, offset: Number, byteLength: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeUIntBE(value: Number, offset: Number, byteLength: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeIntLE(value: Number, offset: Number, byteLength: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeIntBE(value: Number, offset: Number, byteLength: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readUIntLE(offset: Number, byteLength: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readUIntBE(offset: Number, byteLength: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readIntLE(offset: Number, byteLength: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readIntBE(offset: Number, byteLength: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readUInt8(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readUInt16LE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readUInt16BE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readUInt32LE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readUInt32BE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readInt8(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readInt16LE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readInt16BE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readInt32LE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readInt32BE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readFloatLE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readFloatBE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readDoubleLE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun readDoubleBE(offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun swap16(): Buffer
    fun swap32(): Buffer
    fun swap64(): Buffer
    fun writeUInt8(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeUInt16LE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeUInt16BE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeUInt32LE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeUInt32BE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeInt8(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeInt16LE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeInt16BE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeInt32LE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeInt32BE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeFloatLE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeFloatBE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeDoubleLE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun writeDoubleBE(value: Number, offset: Number, noAssert: Boolean? = definedExternally /* null */): Number
    fun fill(value: Any, offset: Number? = definedExternally /* null */, end: Number? = definedExternally /* null */): Buffer /* this */
    fun indexOf(value: String, byteOffset: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Number
    fun indexOf(value: Number, byteOffset: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Number
    fun indexOf(value: Uint8Array, byteOffset: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Number
    fun lastIndexOf(value: String, byteOffset: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Number
    fun lastIndexOf(value: Number, byteOffset: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Number
    fun lastIndexOf(value: Uint8Array, byteOffset: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Number
    fun entries(): IterableIterator<dynamic /* JsTuple<Number, Number> */>
    fun includes(value: String, byteOffset: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Boolean
    fun includes(value: Number, byteOffset: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Boolean
    fun includes(value: Buffer, byteOffset: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Boolean
    fun keys(): IterableIterator<Number>
    fun values(): IterableIterator<Number>
    companion object {
        var prototype: Buffer = definedExternally
        fun from(arrayBuffer: SharedArrayBuffer, byteOffset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */): Buffer = definedExternally
        fun from(arrayBuffer: ArrayBuffer, byteOffset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */): Buffer = definedExternally
        fun from(data: Array<Any>): Buffer = definedExternally
        fun from(data: Uint8Array): Buffer = definedExternally
        fun from(str: String, encoding: String? = definedExternally /* null */): Buffer = definedExternally
        fun of(vararg items: Number): Buffer = definedExternally
        fun isBuffer(obj: Any): Boolean = definedExternally
        fun isEncoding(encoding: String): Boolean = definedExternally
        fun byteLength(string: dynamic /* String | SharedArrayBuffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, encoding: String? = definedExternally /* null */): Number = definedExternally
        fun concat(list: Array<Uint8Array>, totalLength: Number? = definedExternally /* null */): Buffer = definedExternally
        fun compare(buf1: Uint8Array, buf2: Uint8Array): Number = definedExternally
        fun alloc(size: Number, fill: String? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Buffer = definedExternally
        fun alloc(size: Number, fill: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Buffer = definedExternally
        fun alloc(size: Number, fill: Buffer? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Buffer = definedExternally
        fun allocUnsafe(size: Number): Buffer = definedExternally
        fun allocUnsafeSlow(size: Number): Buffer = definedExternally
        var poolSize: Number = definedExternally
        fun alloc(size: Number): Buffer = definedExternally
    }
}
external interface IterableIterator<T>

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("read")]
package js.node.fs.read

import kotlin.js.*

external interface `T$67`<TBuffer> {
    var bytesRead: Number
    var buffer: TBuffer
}
external fun <TBuffer /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> __promisify__(fd: Number, buffer: TBuffer, offset: Number, length: Number, position: Number?): Promise<`T$67`<TBuffer>> = definedExternally

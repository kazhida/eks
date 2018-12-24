@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("write")]
package js.node.fs.write

import kotlin.js.*

external interface `T$65`<TBuffer> {
    var bytesWritten: Number
    var buffer: TBuffer
}
external fun <TBuffer /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> __promisify__(fd: Number, buffer: TBuffer? = definedExternally /* null */, offset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */, position: Number? = definedExternally /* null */): Promise<`T$65`<TBuffer>> = definedExternally
external interface `T$66` {
    var bytesWritten: Number
    var buffer: String
}
external fun __promisify__(fd: Number, string: Any, position: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Promise<`T$66`> = definedExternally

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("string_decoder")
package js.node.string_decoder

import js.node.Buffer
import kotlin.js.*

external interface NodeStringDecoder {
    fun write(buffer: Buffer): String
    fun end(buffer: Buffer? = definedExternally /* null */): String
}
external object StringDecoder

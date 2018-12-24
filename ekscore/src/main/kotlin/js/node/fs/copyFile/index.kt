@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("copyFile")]
package js.node.fs.copyFile

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external fun __promisify__(src: String, dst: String, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(src: String, dst: Buffer, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(src: String, dst: URL, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(src: Buffer, dst: String, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(src: Buffer, dst: Buffer, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(src: Buffer, dst: URL, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(src: URL, dst: String, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(src: URL, dst: Buffer, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(src: URL, dst: URL, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally

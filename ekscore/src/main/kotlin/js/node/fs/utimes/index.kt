@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("utimes")]
package js.node.fs.utimes

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external fun __promisify__(path: String, atime: String, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun __promisify__(path: String, atime: Number, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun __promisify__(path: String, atime: Date, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun __promisify__(path: Buffer, atime: String, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun __promisify__(path: Buffer, atime: Number, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun __promisify__(path: Buffer, atime: Date, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun __promisify__(path: URL, atime: String, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun __promisify__(path: URL, atime: Number, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun __promisify__(path: URL, atime: Date, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally

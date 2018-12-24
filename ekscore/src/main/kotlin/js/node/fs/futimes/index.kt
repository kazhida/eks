@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("futimes")]
package js.node.fs.futimes

import kotlin.js.*

external fun __promisify__(fd: Number, atime: String, mtime: String): Promise<Unit> = definedExternally
external fun __promisify__(fd: Number, atime: String, mtime: Number): Promise<Unit> = definedExternally
external fun __promisify__(fd: Number, atime: String, mtime: Date): Promise<Unit> = definedExternally
external fun __promisify__(fd: Number, atime: Number, mtime: String): Promise<Unit> = definedExternally
external fun __promisify__(fd: Number, atime: Number, mtime: Number): Promise<Unit> = definedExternally
external fun __promisify__(fd: Number, atime: Number, mtime: Date): Promise<Unit> = definedExternally
external fun __promisify__(fd: Number, atime: Date, mtime: String): Promise<Unit> = definedExternally
external fun __promisify__(fd: Number, atime: Date, mtime: Number): Promise<Unit> = definedExternally
external fun __promisify__(fd: Number, atime: Date, mtime: Date): Promise<Unit> = definedExternally

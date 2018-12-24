@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("rename")]
package js.node.fs.rename

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external fun __promisify__(oldPath: String, newPath: String): Promise<Unit> = definedExternally
external fun __promisify__(oldPath: String, newPath: Buffer): Promise<Unit> = definedExternally
external fun __promisify__(oldPath: String, newPath: URL): Promise<Unit> = definedExternally
external fun __promisify__(oldPath: Buffer, newPath: String): Promise<Unit> = definedExternally
external fun __promisify__(oldPath: Buffer, newPath: Buffer): Promise<Unit> = definedExternally
external fun __promisify__(oldPath: Buffer, newPath: URL): Promise<Unit> = definedExternally
external fun __promisify__(oldPath: URL, newPath: String): Promise<Unit> = definedExternally
external fun __promisify__(oldPath: URL, newPath: Buffer): Promise<Unit> = definedExternally
external fun __promisify__(oldPath: URL, newPath: URL): Promise<Unit> = definedExternally

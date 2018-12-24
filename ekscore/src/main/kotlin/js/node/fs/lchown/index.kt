@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("lchown")]
package js.node.fs.lchown

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external fun __promisify__(path: String, uid: Number, gid: Number): Promise<Unit> = definedExternally
external fun __promisify__(path: Buffer, uid: Number, gid: Number): Promise<Unit> = definedExternally
external fun __promisify__(path: URL, uid: Number, gid: Number): Promise<Unit> = definedExternally

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("symlink")]
package js.node.fs.symlink

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external fun __promisify__(target: String, path: String, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(target: String, path: Buffer, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(target: String, path: URL, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(target: Buffer, path: String, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(target: Buffer, path: Buffer, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(target: Buffer, path: URL, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(target: URL, path: String, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(target: URL, path: Buffer, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(target: URL, path: URL, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally

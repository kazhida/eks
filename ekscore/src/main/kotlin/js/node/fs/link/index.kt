@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("link")]
package js.node.fs.link

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external fun link(existingPath: String, newPath: String): Promise<Unit> = definedExternally
external fun link(existingPath: String, newPath: Buffer): Promise<Unit> = definedExternally
external fun link(existingPath: String, newPath: URL): Promise<Unit> = definedExternally
external fun link(existingPath: Buffer, newPath: String): Promise<Unit> = definedExternally
external fun link(existingPath: Buffer, newPath: Buffer): Promise<Unit> = definedExternally
external fun link(existingPath: Buffer, newPath: URL): Promise<Unit> = definedExternally
external fun link(existingPath: URL, newPath: String): Promise<Unit> = definedExternally
external fun link(existingPath: URL, newPath: Buffer): Promise<Unit> = definedExternally
external fun link(existingPath: URL, newPath: URL): Promise<Unit> = definedExternally

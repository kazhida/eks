@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("exists")]
package js.node.fs.exists

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external fun __promisify__(path: String): Promise<Boolean> = definedExternally
external fun __promisify__(path: Buffer): Promise<Boolean> = definedExternally
external fun __promisify__(path: URL): Promise<Boolean> = definedExternally

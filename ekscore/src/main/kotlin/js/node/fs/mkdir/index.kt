@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
@file:[JsModule("fs") JsQualifier("mkdir")]
package js.node.fs.mkdir

import js.node.Buffer
import js.node.url.URL
import kotlin.js.*

external fun __promisify__(path: String, options: dynamic /* String? | Number? | fs.MakeDirectoryOptions? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(path: Buffer, options: dynamic /* String? | Number? | fs.MakeDirectoryOptions? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun __promisify__(path: URL, options: dynamic /* String? | Number? | fs.MakeDirectoryOptions? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally

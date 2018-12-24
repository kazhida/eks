@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("dns") JsQualifier("resolve4")]
package js.node.dns.resolve4

import js.node.dns.RecordWithTtl
import js.node.dns.ResolveOptions
import js.node.dns.ResolveWithTtlOptions
import kotlin.js.*

external fun __promisify__(hostname: String): Promise<Array<String>> = definedExternally
external fun __promisify__(hostname: String, options: ResolveWithTtlOptions): Promise<Array<RecordWithTtl>> = definedExternally
external fun __promisify__(hostname: String, options: ResolveOptions? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<dns.RecordWithTtl> */> = definedExternally

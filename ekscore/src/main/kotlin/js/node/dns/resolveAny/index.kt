@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("dns") JsQualifier("resolveAny")]
package js.node.dns.resolveAny

import kotlin.js.*

external fun __promisify__(hostname: String): Promise<Array<dynamic /* dns.AnyARecord | dns.AnyAaaaRecord | dns.AnyCnameRecord | dns.AnyMxRecord | dns.AnyNaptrRecord | dns.AnyNsRecord | dns.AnyPtrRecord | dns.AnySoaRecord | dns.AnySrvRecord | dns.AnyTxtRecord */>> = definedExternally

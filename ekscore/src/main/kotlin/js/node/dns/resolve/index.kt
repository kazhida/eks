@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("dns") JsQualifier("resolve")]
package js.node.dns.resolve

import js.node.dns.MxRecord
import js.node.dns.NaptrRecord
import js.node.dns.SoaRecord
import js.node.dns.SrvRecord
import kotlin.js.*

external fun __promisify__(hostname: String, rrtype: String? /* "A" */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String? /* "AAAA" */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String? /* "NS" */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String? /* "PTR" */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String? /* "CNAME" */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String /* "ANY" */): Promise<Array<dynamic /* dns.AnyARecord | dns.AnyAaaaRecord | dns.AnyCnameRecord | dns.AnyMxRecord | dns.AnyNaptrRecord | dns.AnyNsRecord | dns.AnyPtrRecord | dns.AnySoaRecord | dns.AnySrvRecord | dns.AnyTxtRecord */>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String /* "MX" */): Promise<Array<MxRecord>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String /* "NAPTR" */): Promise<Array<NaptrRecord>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String /* "SOA" */): Promise<SoaRecord> = definedExternally
external fun __promisify__(hostname: String, rrtype: String /* "SRV" */): Promise<Array<SrvRecord>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String /* "TXT" */): Promise<Array<Array<String>>> = definedExternally
external fun __promisify__(hostname: String, rrtype: String): Promise<dynamic /* Array<String> | dns.SoaRecord | Array<dynamic /* dns.AnyARecord | dns.AnyAaaaRecord | dns.AnyCnameRecord | dns.AnyMxRecord | dns.AnyNaptrRecord | dns.AnyNsRecord | dns.AnyPtrRecord | dns.AnySoaRecord | dns.AnySrvRecord | dns.AnyTxtRecord */> | Array<dns.MxRecord> | Array<dns.NaptrRecord> | Array<dns.SrvRecord> | Array<Array<String>> */> = definedExternally
external fun __promisify__(hostname: String): Promise<Array<String>> = definedExternally

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("dns") JsQualifier("resolveNaptr")]
package js.node.dns.resolveNaptr

import js.node.dns.NaptrRecord
import kotlin.js.*

external fun __promisify__(hostname: String): Promise<Array<NaptrRecord>> = definedExternally

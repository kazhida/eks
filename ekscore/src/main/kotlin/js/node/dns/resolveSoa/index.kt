@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("dns") JsQualifier("resolveSoa")]
package js.node.dns.resolveSoa

import js.node.dns.SoaRecord
import kotlin.js.*

external fun __promisify__(hostname: String): Promise<SoaRecord> = definedExternally

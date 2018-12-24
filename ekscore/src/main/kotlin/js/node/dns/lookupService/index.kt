@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("dns") JsQualifier("lookupService")]
package js.node.dns.lookupService

import kotlin.js.*

external interface `T$40` {
    var hostname: String
    var service: String
}
external fun __promisify__(address: String, port: Number): Promise<`T$40`> = definedExternally

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("dns") JsQualifier("lookup")]
package js.node.dns.lookup

import js.node.dns.LookupAddress
import js.node.dns.LookupAllOptions
import js.node.dns.LookupOneOptions
import js.node.dns.LookupOptions
import kotlin.js.*

external interface `T$37` {
    var address: Array<LookupAddress>
}
external fun __promisify__(hostname: String, options: LookupAllOptions): Promise<`T$37`> = definedExternally
external interface `T$38` {
    var address: String
    var family: Number
}
external fun __promisify__(hostname: String, options: Number? = definedExternally /* null */): Promise<`T$38`> = definedExternally
external fun __promisify__(hostname: String, options: LookupOneOptions? = definedExternally /* null */): Promise<`T$38`> = definedExternally
external interface `T$39` {
    var address: dynamic /* String | Array<dns.LookupAddress> */
    var family: Number? get() = definedExternally; set(value) = definedExternally
}
external fun __promisify__(hostname: String, options: Number? = definedExternally /* null */): Promise<`T$39`> = definedExternally
external fun __promisify__(hostname: String, options: LookupOptions? = definedExternally /* null */): Promise<`T$39`> = definedExternally
external fun __promisify__(hostname: String): Promise<`T$38`> = definedExternally
external fun __promisify__(hostname: String): Promise<`T$39`> = definedExternally

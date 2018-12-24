@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("dns")
package js.node.dns

import js.node.ErrnoException
import kotlin.js.*

external var ADDRCONFIG: Number = definedExternally
external var V4MAPPED: Number = definedExternally
external interface LookupOptions {
    var family: Number? get() = definedExternally; set(value) = definedExternally
    var hints: Number? get() = definedExternally; set(value) = definedExternally
    var all: Boolean? get() = definedExternally; set(value) = definedExternally
    var verbatim: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface LookupOneOptions : LookupOptions {
    override var all: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface LookupAllOptions : LookupOptions {
    override var all: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}
external interface LookupAddress {
    var address: String
    var family: Number
}
external fun lookup(hostname: String, family: Number, callback: (err: ErrnoException, address: String, family: Number) -> Unit): Unit = definedExternally
external fun lookup(hostname: String, options: LookupOneOptions, callback: (err: ErrnoException, address: String, family: Number) -> Unit): Unit = definedExternally
external fun lookup(hostname: String, options: LookupAllOptions, callback: (err: ErrnoException, addresses: Array<LookupAddress>) -> Unit): Unit = definedExternally
external fun lookup(hostname: String, options: LookupOptions, callback: (err: ErrnoException, address: dynamic /* String | Array<LookupAddress> */, family: Number) -> Unit): Unit = definedExternally
external fun lookup(hostname: String, callback: (err: ErrnoException, address: String, family: Number) -> Unit): Unit = definedExternally
external fun lookupService(address: String, port: Number, callback: (err: ErrnoException, hostname: String, service: String) -> Unit): Unit = definedExternally
external interface ResolveOptions {
    var ttl: Boolean
}
external interface ResolveWithTtlOptions : ResolveOptions {
    override var ttl: Boolean
}
external interface RecordWithTtl {
    var address: String
    var ttl: Number
}
external interface AnyARecord : RecordWithTtl {
    var type: String /* "A" */
}
external interface AnyAaaaRecord : RecordWithTtl {
    var type: String /* "AAAA" */
}
external interface MxRecord {
    var priority: Number
    var exchange: String
}
external interface AnyMxRecord : MxRecord {
    var type: String /* "MX" */
}
external interface NaptrRecord {
    var flags: String
    var service: String
    var regexp: String
    var replacement: String
    var order: Number
    var preference: Number
}
external interface AnyNaptrRecord : NaptrRecord {
    var type: String /* "NAPTR" */
}
external interface SoaRecord {
    var nsname: String
    var hostmaster: String
    var serial: Number
    var refresh: Number
    var retry: Number
    var expire: Number
    var minttl: Number
}
external interface AnySoaRecord : SoaRecord {
    var type: String /* "SOA" */
}
external interface SrvRecord {
    var priority: Number
    var weight: Number
    var port: Number
    var name: String
}
external interface AnySrvRecord : SrvRecord {
    var type: String /* "SRV" */
}
external interface AnyTxtRecord {
    var type: String /* "TXT" */
    var entries: Array<String>
}
external interface AnyNsRecord {
    var type: String /* "NS" */
    var value: String
}
external interface AnyPtrRecord {
    var type: String /* "PTR" */
    var value: String
}
external interface AnyCnameRecord {
    var type: String /* "CNAME" */
    var value: String
}
external fun resolve(hostname: String, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "A" */, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "AAAA" */, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "ANY" */, callback: (err: ErrnoException, addresses: Array<dynamic /* AnyARecord | AnyAaaaRecord | AnyCnameRecord | AnyMxRecord | AnyNaptrRecord | AnyNsRecord | AnyPtrRecord | AnySoaRecord | AnySrvRecord | AnyTxtRecord */>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "CNAME" */, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "MX" */, callback: (err: ErrnoException, addresses: Array<MxRecord>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "NAPTR" */, callback: (err: ErrnoException, addresses: Array<NaptrRecord>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "NS" */, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "PTR" */, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "SOA" */, callback: (err: ErrnoException, addresses: SoaRecord) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "SRV" */, callback: (err: ErrnoException, addresses: Array<SrvRecord>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String /* "TXT" */, callback: (err: ErrnoException, addresses: Array<Array<String>>) -> Unit): Unit = definedExternally
external fun resolve(hostname: String, rrtype: String, callback: (err: ErrnoException, addresses: dynamic /* Array<String> | SoaRecord | Array<dynamic /* AnyARecord | AnyAaaaRecord | AnyCnameRecord | AnyMxRecord | AnyNaptrRecord | AnyNsRecord | AnyPtrRecord | AnySoaRecord | AnySrvRecord | AnyTxtRecord */> | Array<MxRecord> | Array<NaptrRecord> | Array<SrvRecord> | Array<Array<String>> */) -> Unit): Unit = definedExternally
external fun resolve4(hostname: String, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolve4(hostname: String, options: ResolveWithTtlOptions, callback: (err: ErrnoException, addresses: Array<RecordWithTtl>) -> Unit): Unit = definedExternally
external fun resolve4(hostname: String, options: ResolveOptions, callback: (err: ErrnoException, addresses: dynamic /* Array<String> | Array<RecordWithTtl> */) -> Unit): Unit = definedExternally
external fun resolve6(hostname: String, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolve6(hostname: String, options: ResolveWithTtlOptions, callback: (err: ErrnoException, addresses: Array<RecordWithTtl>) -> Unit): Unit = definedExternally
external fun resolve6(hostname: String, options: ResolveOptions, callback: (err: ErrnoException, addresses: dynamic /* Array<String> | Array<RecordWithTtl> */) -> Unit): Unit = definedExternally
external fun resolveCname(hostname: String, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolveMx(hostname: String, callback: (err: ErrnoException, addresses: Array<MxRecord>) -> Unit): Unit = definedExternally
external fun resolveNaptr(hostname: String, callback: (err: ErrnoException, addresses: Array<NaptrRecord>) -> Unit): Unit = definedExternally
external fun resolveNs(hostname: String, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolvePtr(hostname: String, callback: (err: ErrnoException, addresses: Array<String>) -> Unit): Unit = definedExternally
external fun resolveSoa(hostname: String, callback: (err: ErrnoException, address: SoaRecord) -> Unit): Unit = definedExternally
external fun resolveSrv(hostname: String, callback: (err: ErrnoException, addresses: Array<SrvRecord>) -> Unit): Unit = definedExternally
external fun resolveTxt(hostname: String, callback: (err: ErrnoException, addresses: Array<Array<String>>) -> Unit): Unit = definedExternally
external fun resolveAny(hostname: String, callback: (err: ErrnoException, addresses: Array<dynamic /* AnyARecord | AnyAaaaRecord | AnyCnameRecord | AnyMxRecord | AnyNaptrRecord | AnyNsRecord | AnyPtrRecord | AnySoaRecord | AnySrvRecord | AnyTxtRecord */>) -> Unit): Unit = definedExternally
external fun reverse(ip: String, callback: (err: ErrnoException, hostnames: Array<String>) -> Unit): Unit = definedExternally
external fun setServers(servers: Array<String>): Unit = definedExternally
external fun getServers(): Array<String> = definedExternally
external var NODATA: String = definedExternally
external var FORMERR: String = definedExternally
external var SERVFAIL: String = definedExternally
external var NOTFOUND: String = definedExternally
external var NOTIMP: String = definedExternally
external var REFUSED: String = definedExternally
external var BADQUERY: String = definedExternally
external var BADNAME: String = definedExternally
external var BADFAMILY: String = definedExternally
external var BADRESP: String = definedExternally
external var CONNREFUSED: String = definedExternally
external var TIMEOUT: String = definedExternally
external var EOF: String = definedExternally
external var FILE: String = definedExternally
external var NOMEM: String = definedExternally
external var DESTRUCTION: String = definedExternally
external var BADSTR: String = definedExternally
external var BADFLAGS: String = definedExternally
external var NONAME: String = definedExternally
external var BADHINTS: String = definedExternally
external var NOTINITIALIZED: String = definedExternally
external var LOADIPHLPAPI: String = definedExternally
external var ADDRGETNETWORKPARAMS: String = definedExternally
external var CANCELLED: String = definedExternally
open external class Resolver {
    open var getServers: Any? = definedExternally
    open var setServers: Any? = definedExternally
    open var resolve: Any? = definedExternally
    open var resolve4: Any? = definedExternally
    open var resolve6: Any? = definedExternally
    open var resolveAny: Any? = definedExternally
    open var resolveCname: Any? = definedExternally
    open var resolveMx: Any? = definedExternally
    open var resolveNaptr: Any? = definedExternally
    open var resolveNs: Any? = definedExternally
    open var resolvePtr: Any? = definedExternally
    open var resolveSoa: Any? = definedExternally
    open var resolveSrv: Any? = definedExternally
    open var resolveTxt: Any? = definedExternally
    open var reverse: Any? = definedExternally
    open fun cancel(): Unit = definedExternally
}

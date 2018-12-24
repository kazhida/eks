@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("dgram")
package js.node.dgram

import js.node.Buffer
import js.node.ErrnoException
import js.node.buffer.Uint8Array
import js.node.dns.LookupOneOptions
import js.node.events.internal
import js.node.net.AddressInfo
import kotlin.js.*

external interface RemoteInfo {
    var address: String
    var family: String
    var port: Number
}
external interface BindOptions {
    var port: Number
    var address: String? get() = definedExternally; set(value) = definedExternally
    var exclusive: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface SocketOptions {
    var type: dynamic /* String /* "udp4" */ | String /* "udp6" */ */
    var reuseAddr: Boolean? get() = definedExternally; set(value) = definedExternally
    var recvBufferSize: Number? get() = definedExternally; set(value) = definedExternally
    var sendBufferSize: Number? get() = definedExternally; set(value) = definedExternally
    var lookup: ((hostname: String, options: LookupOneOptions, callback: (err: ErrnoException, address: String, family: Number) -> Unit) -> Unit)? get() = definedExternally; set(value) = definedExternally
}
external fun createSocket(type: String /* "udp4" */, callback: ((msg: Buffer, rinfo: RemoteInfo) -> Unit)? = definedExternally /* null */): Socket = definedExternally
external fun createSocket(type: String /* "udp6" */, callback: ((msg: Buffer, rinfo: RemoteInfo) -> Unit)? = definedExternally /* null */): Socket = definedExternally
external fun createSocket(options: SocketOptions, callback: ((msg: Buffer, rinfo: RemoteInfo) -> Unit)? = definedExternally /* null */): Socket = definedExternally
open external class Socket : internal.EventEmitter {
    open fun send(msg: String, port: Number, address: String? = definedExternally /* null */, callback: ((error: Error?, bytes: Number) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun send(msg: Array<Any>, port: Number, address: String? = definedExternally /* null */, callback: ((error: Error?, bytes: Number) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun send(msg: Buffer, port: Number, address: String? = definedExternally /* null */, callback: ((error: Error?, bytes: Number) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun send(msg: Uint8Array, port: Number, address: String? = definedExternally /* null */, callback: ((error: Error?, bytes: Number) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun send(msg: String, offset: Number, length: Number, port: Number, address: String? = definedExternally /* null */, callback: ((error: Error?, bytes: Number) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun send(msg: Buffer, offset: Number, length: Number, port: Number, address: String? = definedExternally /* null */, callback: ((error: Error?, bytes: Number) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun send(msg: Uint8Array, offset: Number, length: Number, port: Number, address: String? = definedExternally /* null */, callback: ((error: Error?, bytes: Number) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun bind(port: Number? = definedExternally /* null */, address: String? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun bind(port: Number? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun bind(callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun bind(options: BindOptions, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
    open fun close(callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun address(): dynamic /* String | net.AddressInfo */ = definedExternally
    open fun setBroadcast(flag: Boolean): Unit = definedExternally
    open fun setTTL(ttl: Number): Unit = definedExternally
    open fun setMulticastTTL(ttl: Number): Unit = definedExternally
    open fun setMulticastInterface(multicastInterface: String): Unit = definedExternally
    open fun setMulticastLoopback(flag: Boolean): Unit = definedExternally
    open fun addMembership(multicastAddress: String, multicastInterface: String? = definedExternally /* null */): Unit = definedExternally
    open fun dropMembership(multicastAddress: String, multicastInterface: String? = definedExternally /* null */): Unit = definedExternally
    open fun ref(): Socket /* this */ = definedExternally
    open fun unref(): Socket /* this */ = definedExternally
    open fun setRecvBufferSize(size: Number): Unit = definedExternally
    open fun setSendBufferSize(size: Number): Unit = definedExternally
    open fun getRecvBufferSize(): Number = definedExternally
    open fun getSendBufferSize(): Number = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun addListener(event: String /* "close" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun addListener(event: String /* "listening" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun addListener(event: String /* "message" */, listener: (msg: Buffer, rinfo: AddressInfo) -> Unit): Socket /* this */ = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun emit(event: String /* "close" */): Boolean = definedExternally
    open fun emit(event: String /* "error" */, err: Error): Boolean = definedExternally
    open fun emit(event: String /* "listening" */): Boolean = definedExternally
    open fun emit(event: String /* "message" */, msg: Buffer, rinfo: AddressInfo): Boolean = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun on(event: String /* "close" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun on(event: String /* "listening" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun on(event: String /* "message" */, listener: (msg: Buffer, rinfo: AddressInfo) -> Unit): Socket /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun once(event: String /* "close" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun once(event: String /* "listening" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun once(event: String /* "message" */, listener: (msg: Buffer, rinfo: AddressInfo) -> Unit): Socket /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun prependListener(event: String /* "close" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun prependListener(event: String /* "listening" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun prependListener(event: String /* "message" */, listener: (msg: Buffer, rinfo: AddressInfo) -> Unit): Socket /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "listening" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "message" */, listener: (msg: Buffer, rinfo: AddressInfo) -> Unit): Socket /* this */ = definedExternally
    open fun bind(): Unit = definedExternally
}

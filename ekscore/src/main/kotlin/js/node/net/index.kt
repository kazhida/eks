@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("net")
package js.node.net

import js.node.Buffer
import js.node.ErrnoException
import js.node.stream.internal.Duplex
import js.node.dns.LookupOneOptions
import js.node.events.internal.EventEmitter
import kotlin.js.*

external interface AddressInfo {
    var address: String
    var family: String
    var port: Number
}
external interface SocketConstructorOpts {
    var fd: Number? get() = definedExternally; set(value) = definedExternally
    var allowHalfOpen: Boolean? get() = definedExternally; set(value) = definedExternally
    var readable: Boolean? get() = definedExternally; set(value) = definedExternally
    var writable: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface TcpSocketConnectOpts {
    var port: Number
    var host: String? get() = definedExternally; set(value) = definedExternally
    var localAddress: String? get() = definedExternally; set(value) = definedExternally
    var localPort: Number? get() = definedExternally; set(value) = definedExternally
    var hints: Number? get() = definedExternally; set(value) = definedExternally
    var family: Number? get() = definedExternally; set(value) = definedExternally
    var lookup: ((hostname: String, options: LookupOneOptions, callback: (err: ErrnoException?, address: String, family: Number) -> Unit) -> Unit)? get() = definedExternally; set(value) = definedExternally
}
external interface IpcSocketConnectOpts {
    var path: String
}
open external class Socket(options: SocketConstructorOpts? = definedExternally /* null */) : Duplex {
    open fun write(buffer: Buffer): Boolean = definedExternally
    override fun write(buffer: Buffer, cb: Function<*>? /* null */): Boolean = definedExternally
    override fun write(buffer: String, cb: Function<*>? /* null */): Boolean = definedExternally
    override fun write(str: String, encoding: String?, cb: Function<*>?): Boolean = definedExternally
    open fun write(str: String, encoding: String? = definedExternally /* null */, fd: String? = definedExternally /* null */): Boolean = definedExternally
    open fun write(data: Any, encoding: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
    open fun connect(options: TcpSocketConnectOpts, connectionListener: Function<*>? = definedExternally /* null */): Socket /* this */ = definedExternally
    open fun connect(options: IpcSocketConnectOpts, connectionListener: Function<*>? = definedExternally /* null */): Socket /* this */ = definedExternally
    open fun connect(port: Number, host: String, connectionListener: Function<*>? = definedExternally /* null */): Socket /* this */ = definedExternally
    open fun connect(port: Number, connectionListener: Function<*>? = definedExternally /* null */): Socket /* this */ = definedExternally
    open fun connect(path: String, connectionListener: Function<*>? = definedExternally /* null */): Socket /* this */ = definedExternally
    open fun setEncoding(encoding: String?): Socket /* this */ = definedExternally
    override fun pause(): Socket /* this */ = definedExternally
    override fun resume(): Socket /* this */ = definedExternally
    open fun setTimeout(timeout: Number, callback: Function<*>? = definedExternally /* null */): Socket /* this */ = definedExternally
    open fun setNoDelay(noDelay: Boolean? = definedExternally /* null */): Socket /* this */ = definedExternally
    open fun setKeepAlive(enable: Boolean? = definedExternally /* null */, initialDelay: Number? = definedExternally /* null */): Socket /* this */ = definedExternally
    open fun address(): dynamic /* String | AddressInfo */ = definedExternally
    open fun unref(): Unit = definedExternally
    open fun ref(): Unit = definedExternally
    open var bufferSize: Number = definedExternally
    open var bytesRead: Number = definedExternally
    open var bytesWritten: Number = definedExternally
    open var connecting: Boolean = definedExternally
    open var destroyed: Boolean = definedExternally
    open var localAddress: String = definedExternally
    open var localPort: Number = definedExternally
    open var remoteAddress: String = definedExternally
    open var remoteFamily: String = definedExternally
    open var remotePort: Number = definedExternally
    open fun end(): Unit = definedExternally
    override fun end(buffer: Buffer, cb: Function<*>?): Unit = definedExternally
    override fun end(str: String, cb: Function<*>?): Unit = definedExternally
    override fun end(str: String, encoding: String?, cb: Function<*>?): Unit = definedExternally
    open fun end(data: Any? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Unit = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun addListener(event: String /* "close" */, listener: (had_error: Boolean) -> Unit): Socket /* this */ = definedExternally
    fun addListener(event: String /* "connect" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun addListener(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */ = definedExternally
    fun addListener(event: String /* "drain" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun addListener(event: String /* "end" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun addListener(event: String /* "lookup" */, listener: (err: Error, address: String, family: dynamic /* String | Number */, host: String) -> Unit): Socket /* this */ = definedExternally
    fun addListener(event: String /* "timeout" */, listener: () -> Unit): Socket /* this */ = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun emit(event: String /* "close" */, had_error: Boolean): Boolean = definedExternally
    fun emit(event: String /* "connect" */): Boolean = definedExternally
    open fun emit(event: String /* "data" */, data: Buffer): Boolean = definedExternally
    fun emit(event: String /* "drain" */): Boolean = definedExternally
    fun emit(event: String /* "end" */): Boolean = definedExternally
    fun emit(event: String /* "error" */, err: Error): Boolean = definedExternally
    open fun emit(event: String /* "lookup" */, err: Error, address: String, family: String, host: String): Boolean = definedExternally
    open fun emit(event: String /* "lookup" */, err: Error, address: String, family: Number, host: String): Boolean = definedExternally
    fun emit(event: String /* "timeout" */): Boolean = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun on(event: String /* "close" */, listener: (had_error: Boolean) -> Unit): Socket /* this */ = definedExternally
    fun on(event: String /* "connect" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun on(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */ = definedExternally
    fun on(event: String /* "drain" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun on(event: String /* "end" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun on(event: String /* "lookup" */, listener: (err: Error, address: String, family: dynamic /* String | Number */, host: String) -> Unit): Socket /* this */ = definedExternally
    fun on(event: String /* "timeout" */, listener: () -> Unit): Socket /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun once(event: String /* "close" */, listener: (had_error: Boolean) -> Unit): Socket /* this */ = definedExternally
    fun once(event: String /* "connect" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun once(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */ = definedExternally
    fun once(event: String /* "drain" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun once(event: String /* "end" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun once(event: String /* "lookup" */, listener: (err: Error, address: String, family: dynamic /* String | Number */, host: String) -> Unit): Socket /* this */ = definedExternally
    fun once(event: String /* "timeout" */, listener: () -> Unit): Socket /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun prependListener(event: String /* "close" */, listener: (had_error: Boolean) -> Unit): Socket /* this */ = definedExternally
    fun prependListener(event: String /* "connect" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun prependListener(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */ = definedExternally
    fun prependListener(event: String /* "drain" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun prependListener(event: String /* "end" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun prependListener(event: String /* "lookup" */, listener: (err: Error, address: String, family: dynamic /* String | Number */, host: String) -> Unit): Socket /* this */ = definedExternally
    fun prependListener(event: String /* "timeout" */, listener: () -> Unit): Socket /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Socket /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "close" */, listener: (had_error: Boolean) -> Unit): Socket /* this */ = definedExternally
    fun prependOnceListener(event: String /* "connect" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "data" */, listener: (data: Buffer) -> Unit): Socket /* this */ = definedExternally
    fun prependOnceListener(event: String /* "drain" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun prependOnceListener(event: String /* "end" */, listener: () -> Unit): Socket /* this */ = definedExternally
    fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Socket /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "lookup" */, listener: (err: Error, address: String, family: dynamic /* String | Number */, host: String) -> Unit): Socket /* this */ = definedExternally
    fun prependOnceListener(event: String /* "timeout" */, listener: () -> Unit): Socket /* this */ = definedExternally
    open fun write(str: String): Boolean = definedExternally
    override fun end(str: String): Unit = definedExternally
}
external interface ListenOptions {
    var port: Number? get() = definedExternally; set(value) = definedExternally
    var host: String? get() = definedExternally; set(value) = definedExternally
    var backlog: Number? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var exclusive: Boolean? get() = definedExternally; set(value) = definedExternally
    var readableAll: Boolean? get() = definedExternally; set(value) = definedExternally
    var writableAll: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface `T$41` {
    var allowHalfOpen: Boolean? get() = definedExternally; set(value) = definedExternally
    var pauseOnConnect: Boolean? get() = definedExternally; set(value) = definedExternally
}
open external class Server : EventEmitter {
    constructor(connectionListener: ((socket: Socket) -> Unit)? = definedExternally /* null */)
    constructor(options: `T$41`? = definedExternally /* null */, connectionListener: ((socket: Socket) -> Unit)? = definedExternally /* null */)
    open fun listen(port: Number? = definedExternally /* null */, hostname: String? = definedExternally /* null */, backlog: Number? = definedExternally /* null */, listeningListener: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun listen(port: Number? = definedExternally /* null */, hostname: String? = definedExternally /* null */, listeningListener: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun listen(port: Number? = definedExternally /* null */, backlog: Number? = definedExternally /* null */, listeningListener: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun listen(port: Number? = definedExternally /* null */, listeningListener: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun listen(path: String, backlog: Number? = definedExternally /* null */, listeningListener: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun listen(path: String, listeningListener: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun listen(options: ListenOptions, listeningListener: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun listen(handle: Any, backlog: Number? = definedExternally /* null */, listeningListener: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun listen(handle: Any, listeningListener: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun close(callback: Function<*>? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun address(): dynamic /* String | AddressInfo */ = definedExternally
    open fun getConnections(cb: (error: Error?, count: Number) -> Unit): Unit = definedExternally
    open fun ref(): Server /* this */ = definedExternally
    open fun unref(): Server /* this */ = definedExternally
    @Suppress("UNREACHABLE_CODE")
    open var maxConnections: Number = definedExternally
    @Suppress("UNREACHABLE_CODE")
    open var connections: Number = definedExternally
    @Suppress("UNREACHABLE_CODE")
    open var listening: Boolean = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): Server /* this */ = definedExternally
    open fun addListener(event: String /* "close" */, listener: () -> Unit): Server /* this */ = definedExternally
    open fun addListener(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */ = definedExternally
    open fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */ = definedExternally
    open fun addListener(event: String /* "listening" */, listener: () -> Unit): Server /* this */ = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun emit(event: String /* "close" */): Boolean = definedExternally
    open fun emit(event: String /* "connection" */, socket: Socket): Boolean = definedExternally
    open fun emit(event: String /* "error" */, err: Error): Boolean = definedExternally
    open fun emit(event: String /* "listening" */): Boolean = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): Server /* this */ = definedExternally
    open fun on(event: String /* "close" */, listener: () -> Unit): Server /* this */ = definedExternally
    open fun on(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */ = definedExternally
    open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */ = definedExternally
    open fun on(event: String /* "listening" */, listener: () -> Unit): Server /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): Server /* this */ = definedExternally
    open fun once(event: String /* "close" */, listener: () -> Unit): Server /* this */ = definedExternally
    open fun once(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */ = definedExternally
    open fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */ = definedExternally
    open fun once(event: String /* "listening" */, listener: () -> Unit): Server /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Server /* this */ = definedExternally
    open fun prependListener(event: String /* "close" */, listener: () -> Unit): Server /* this */ = definedExternally
    open fun prependListener(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */ = definedExternally
    open fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */ = definedExternally
    open fun prependListener(event: String /* "listening" */, listener: () -> Unit): Server /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Server /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): Server /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "connection" */, listener: (socket: Socket) -> Unit): Server /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Server /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "listening" */, listener: () -> Unit): Server /* this */ = definedExternally
    open fun listen(): Server /* this */ = definedExternally
    open fun listen(path: String): Server /* this */ = definedExternally
    open fun listen(handle: Any): Server /* this */ = definedExternally
}
external interface TcpNetConnectOpts : TcpSocketConnectOpts, SocketConstructorOpts {
    var timeout: Number? get() = definedExternally; set(value) = definedExternally
}
external interface IpcNetConnectOpts : IpcSocketConnectOpts, SocketConstructorOpts {
    var timeout: Number? get() = definedExternally; set(value) = definedExternally
}
external fun createServer(connectionListener: ((socket: Socket) -> Unit)? = definedExternally /* null */): Server = definedExternally
external fun createServer(options: `T$41`? = definedExternally /* null */, connectionListener: ((socket: Socket) -> Unit)? = definedExternally /* null */): Server = definedExternally
external fun connect(options: TcpNetConnectOpts, connectionListener: Function<*>? = definedExternally /* null */): Socket = definedExternally
external fun connect(options: IpcNetConnectOpts, connectionListener: Function<*>? = definedExternally /* null */): Socket = definedExternally
external fun connect(port: Number, host: String? = definedExternally /* null */, connectionListener: Function<*>? = definedExternally /* null */): Socket = definedExternally
external fun connect(path: String, connectionListener: Function<*>? = definedExternally /* null */): Socket = definedExternally
external fun createConnection(options: TcpNetConnectOpts, connectionListener: Function<*>? = definedExternally /* null */): Socket = definedExternally
external fun createConnection(options: IpcNetConnectOpts, connectionListener: Function<*>? = definedExternally /* null */): Socket = definedExternally
external fun createConnection(port: Number, host: String? = definedExternally /* null */, connectionListener: Function<*>? = definedExternally /* null */): Socket = definedExternally
external fun createConnection(path: String, connectionListener: Function<*>? = definedExternally /* null */): Socket = definedExternally
external fun isIP(input: String): Number = definedExternally
external fun isIPv4(input: String): Boolean = definedExternally
external fun isIPv6(input: String): Boolean = definedExternally
external fun createServer(): Server = definedExternally

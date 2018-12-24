@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("http")
package js.node.http

import js.node.http2.Http2Server
import js.node.net.Socket
import js.node.stream.internal.Readable
import js.node.stream.internal.Writable
import js.node.url.URL
import kotlin.js.*

@Suppress("deprecation")
external interface IncomingHttpHeaders {
    @nativeGetter
    operator fun get(header: String): dynamic /* String | Array<String> */
    @nativeSetter
    operator fun set(header: String, value: String)
    @nativeSetter
    operator fun set(header: String, value: Array<String>)
}
@Suppress("deprecation")
external interface OutgoingHttpHeaders {
    @nativeGetter
    operator fun get(header: String): dynamic /* String | Number | Array<String> | Nothing? */
    @nativeSetter
    operator fun set(header: String, value: String)
    @nativeSetter
    operator fun set(header: String, value: Number)
    @nativeSetter
    operator fun set(header: String, value: Array<String>)
    @nativeSetter
    operator fun set(header: String, value: Nothing?)
}
external interface ClientRequestArgs {
    var protocol: String? get() = definedExternally; set(value) = definedExternally
    var host: String? get() = definedExternally; set(value) = definedExternally
    var hostname: String? get() = definedExternally; set(value) = definedExternally
    var family: Number? get() = definedExternally; set(value) = definedExternally
    var port: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var defaultPort: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var localAddress: String? get() = definedExternally; set(value) = definedExternally
    var socketPath: String? get() = definedExternally; set(value) = definedExternally
    var method: String? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var headers: OutgoingHttpHeaders? get() = definedExternally; set(value) = definedExternally
    var auth: String? get() = definedExternally; set(value) = definedExternally
    var agent: dynamic /* Boolean | Agent */ get() = definedExternally; set(value) = definedExternally
    var _defaultAgent: Agent? get() = definedExternally; set(value) = definedExternally
    var timeout: Number? get() = definedExternally; set(value) = definedExternally
    var setHost: Boolean? get() = definedExternally; set(value) = definedExternally
    var createConnection: ((options: ClientRequestArgs, oncreate: (err: Error, socket: Socket) -> Unit) -> Socket)? get() = definedExternally; set(value) = definedExternally
}
open external class Server(requestListener: ((req: IncomingMessage, res: ServerResponse) -> Unit)? = definedExternally /* null */)  {
    open fun setTimeout(msecs: Number? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Server /* this */ = definedExternally
    open fun setTimeout(callback: () -> Unit): Server /* this */ = definedExternally
    open var maxHeadersCount: Number = definedExternally
    open var timeout: Number = definedExternally
    open var keepAliveTimeout: Number = definedExternally
}
open external class OutgoingMessage : Writable {
    open var upgrading: Boolean = definedExternally
    open var chunkedEncoding: Boolean = definedExternally
    open var shouldKeepAlive: Boolean = definedExternally
    open var useChunkedEncodingByDefault: Boolean = definedExternally
    open var sendDate: Boolean = definedExternally
    open var finished: Boolean = definedExternally
    open var headersSent: Boolean = definedExternally
    open var connection: Socket = definedExternally
    open fun setTimeout(msecs: Number, callback: (() -> Unit)? = definedExternally /* null */): OutgoingMessage /* this */ = definedExternally
    open fun setHeader(name: String, value: String): Unit = definedExternally
    open fun setHeader(name: String, value: Number): Unit = definedExternally
    open fun setHeader(name: String, value: Array<String>): Unit = definedExternally
    open fun setHeader(name: String, value: Nothing?): Unit = definedExternally
    open fun getHeader(name: String): dynamic /* String | Number | Array<String> | Nothing? */ = definedExternally
    open fun getHeaders(): OutgoingHttpHeaders = definedExternally
    open fun getHeaderNames(): Array<String> = definedExternally
    open fun hasHeader(name: String): Boolean = definedExternally
    open fun removeHeader(name: String): Unit = definedExternally
    open fun addTrailers(headers: OutgoingHttpHeaders): Unit = definedExternally
    open fun addTrailers(headers: Array<dynamic /* JsTuple<String, String> */>): Unit = definedExternally
    open fun flushHeaders(): Unit = definedExternally
}
open external class ServerResponse(req: IncomingMessage) : OutgoingMessage {
    open var statusCode: Number = definedExternally
    open var statusMessage: String = definedExternally
    open fun assignSocket(socket: Socket): Unit = definedExternally
    open fun detachSocket(socket: Socket): Unit = definedExternally
    open fun writeContinue(callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun writeHead(statusCode: Number, reasonPhrase: String? = definedExternally /* null */, headers: OutgoingHttpHeaders? = definedExternally /* null */): Unit = definedExternally
    open fun writeHead(statusCode: Number, headers: OutgoingHttpHeaders? = definedExternally /* null */): Unit = definedExternally
    open fun writeHead(statusCode: Number): Unit = definedExternally
}
open external class ClientRequest : OutgoingMessage {
    constructor(url: String, cb: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */)
    constructor(url: ClientRequestArgs, cb: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */)
    constructor(url: URL, cb: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */)
    @Suppress("UNREACHABLE_CODE")
    override var connection: Socket = definedExternally
    open fun abort(): Unit = definedExternally
    open fun onSocket(socket: Socket): Unit = definedExternally
    override fun setTimeout(msecs: Number, callback: (() -> Unit)? /* null */): ClientRequest /* this */ = definedExternally
    open fun setNoDelay(noDelay: Boolean? = definedExternally /* null */): Unit = definedExternally
    open fun setSocketKeepAlive(enable: Boolean? = definedExternally /* null */, initialDelay: Number? = definedExternally /* null */): Unit = definedExternally
}
@Suppress("deprecation")
external interface `T$10` {
    @nativeGetter
    operator fun get(key: String): String?
    @nativeSetter
    operator fun set(key: String, value: String?)
}
open external class IncomingMessage(socket: Socket) : Readable {
    open var httpVersion: String = definedExternally
    open var httpVersionMajor: Number = definedExternally
    open var httpVersionMinor: Number = definedExternally
    open var connection: Socket = definedExternally
    open var headers: IncomingHttpHeaders = definedExternally
    open var rawHeaders: Array<String> = definedExternally
    open var trailers: `T$10` = definedExternally
    open var rawTrailers: Array<String> = definedExternally
    open fun setTimeout(msecs: Number, callback: () -> Unit): IncomingMessage /* this */ = definedExternally
    open var method: String = definedExternally
    open var url: String = definedExternally
    open var statusCode: Number = definedExternally
    open var statusMessage: String = definedExternally
    open var socket: Socket = definedExternally
    fun destroy(error: Error?): Unit = definedExternally
}
external interface AgentOptions {
    var keepAlive: Boolean? get() = definedExternally; set(value) = definedExternally
    var keepAliveMsecs: Number? get() = definedExternally; set(value) = definedExternally
    var maxSockets: Number? get() = definedExternally; set(value) = definedExternally
    var maxFreeSockets: Number? get() = definedExternally; set(value) = definedExternally
    var timeout: Number? get() = definedExternally; set(value) = definedExternally
}
open external class Agent(opts: AgentOptions? = definedExternally /* null */) {
    open var maxFreeSockets: Number = definedExternally
    open var maxSockets: Number = definedExternally
    open var sockets: Any = definedExternally
    open var requests: Any = definedExternally
    open fun destroy(): Unit = definedExternally
}
external var METHODS: Array<String> = definedExternally
@Suppress("deprecation")
external object STATUS_CODES {
    @nativeGetter
    operator fun get(errorCode: Number): String?
    @nativeSetter
    operator fun set(errorCode: Number, value: String?)
    @nativeGetter
    operator fun get(errorCode: String): String?
    @nativeSetter
    operator fun set(errorCode: String, value: String?)
}
external fun createServer(requestListener: ((request: IncomingMessage, response: ServerResponse) -> Unit)? = definedExternally /* null */): Http2Server = definedExternally
external fun createClient(port: Number? = definedExternally /* null */, host: String? = definedExternally /* null */): Any = definedExternally
external interface RequestOptions : ClientRequestArgs
external fun request(options: String, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun request(options: URL, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun request(options: RequestOptions, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun request(url: String, options: RequestOptions, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun request(url: URL, options: RequestOptions, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(options: String, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(options: URL, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(options: RequestOptions, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(url: String, options: RequestOptions, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(url: URL, options: RequestOptions, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external var globalAgent: Agent = definedExternally

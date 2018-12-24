@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("http2")
package js.node.http2

import js.node.Buffer
import js.node.ErrnoException
import js.node.fs.Stats
import js.node.http.OutgoingHttpHeaders
import js.node.stream.internal.Duplex
import js.node.events.internal.EventEmitter
import js.node.net.Server
import js.node.net.Socket
import js.node.stream.internal.Readable
import js.node.tls.ConnectionOptions
import js.node.buffer.Uint8Array
import js.node.tls.TLSSocket
import js.node.tls.TlsOptions
import js.node.url.URL
import kotlin.js.*

external interface IncomingHttpStatusHeader
external interface IncomingHttpHeaders 
external interface StreamPriorityOptions {
    var exclusive: Boolean? get() = definedExternally; set(value) = definedExternally
    var parent: Number? get() = definedExternally; set(value) = definedExternally
    var weight: Number? get() = definedExternally; set(value) = definedExternally
    var silent: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface StreamState {
    var localWindowSize: Number? get() = definedExternally; set(value) = definedExternally
    var state: Number? get() = definedExternally; set(value) = definedExternally
    var streamLocalClose: Number? get() = definedExternally; set(value) = definedExternally
    var streamRemoteClose: Number? get() = definedExternally; set(value) = definedExternally
    var sumDependencyWeight: Number? get() = definedExternally; set(value) = definedExternally
    var weight: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ServerStreamResponseOptions {
    var endStream: Boolean? get() = definedExternally; set(value) = definedExternally
    var waitForTrailers: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface StatOptions {
    var offset: Number
    var length: Number
}
external interface ServerStreamFileResponseOptions {
    var statCheck: ((stats: Stats, headers: OutgoingHttpHeaders, statOptions: StatOptions) -> dynamic /* Boolean | Unit */)? get() = definedExternally; set(value) = definedExternally
    var getTrailers: ((trailers: OutgoingHttpHeaders) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var offset: Number? get() = definedExternally; set(value) = definedExternally
    var length: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ServerStreamFileResponseOptionsWithError : ServerStreamFileResponseOptions {
    var onError: ((err: ErrnoException) -> Unit)? get() = definedExternally; set(value) = definedExternally
}
external interface Http2Stream : Duplex {
    var aborted: Boolean
    var closed: Boolean
    var destroyed: Boolean
    var pending: Boolean
    var rstCode: Number
        var sentHeaders: OutgoingHttpHeaders
    var sentInfoHeaders: Array<OutgoingHttpHeaders>? get() = definedExternally; set(value) = definedExternally
    var sentTrailers: OutgoingHttpHeaders? get() = definedExternally; set(value) = definedExternally
    var session: Http2Session
    var state: StreamState
    var endAfterHeaders: Boolean
    fun close(code: Number? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */)
    fun priority(options: StreamPriorityOptions)
    fun setTimeout(msecs: Number, callback: (() -> Unit)? = definedExternally /* null */)
    override fun addListener(event: String, listener: (args: Any) -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "aborted" */, listener: () -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "close" */, listener: () -> Unit): Http2Stream /* this */
    override fun addListener(event: String /* "data" */, listener: (chunk: dynamic /* String | Buffer */) -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "drain" */, listener: () -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "end" */, listener: () -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "finish" */, listener: () -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number) -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "streamClosed" */, listener: (code: Number) -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "timeout" */, listener: () -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "trailers" */, listener: (trailers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Stream /* this */
    fun addListener(event: String /* "wantTrailers" */, listener: () -> Unit): Http2Stream /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any?, vararg args: Any): Boolean
    fun emit(event: String /* "aborted" */): Boolean
    fun emit(event: String /* "close" */): Boolean
    fun emit(event: String /* "data" */, chunk: String): Boolean
    fun emit(event: String /* "data" */, chunk: Buffer): Boolean
    fun emit(event: String /* "drain" */): Boolean
    fun emit(event: String /* "end" */): Boolean
    fun emit(event: String /* "error" */, err: Error): Boolean
    fun emit(event: String /* "finish" */): Boolean
    fun emit(event: String /* "frameError" */, frameType: Number, errorCode: Number): Boolean
    fun emit(event: String /* "pipe" */, src: Readable): Boolean
    fun emit(event: String /* "unpipe" */, src: Readable): Boolean
    fun emit(event: String /* "streamClosed" */, code: Number): Boolean
    fun emit(event: String /* "timeout" */): Boolean
    fun emit(event: String /* "trailers" */, trailers: IncomingHttpHeaders, flags: Number): Boolean
    fun emit(event: String /* "wantTrailers" */): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): Http2Stream /* this */
    fun on(event: String /* "aborted" */, listener: () -> Unit): Http2Stream /* this */
    fun on(event: String /* "close" */, listener: () -> Unit): Http2Stream /* this */
    override fun on(event: String /* "data" */, listener: (chunk: dynamic /* String | Buffer */) -> Unit): Http2Stream /* this */
    fun on(event: String /* "drain" */, listener: () -> Unit): Http2Stream /* this */
    fun on(event: String /* "end" */, listener: () -> Unit): Http2Stream /* this */
    fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Stream /* this */
    fun on(event: String /* "finish" */, listener: () -> Unit): Http2Stream /* this */
    fun on(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number) -> Unit): Http2Stream /* this */
    fun on(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun on(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun on(event: String /* "streamClosed" */, listener: (code: Number) -> Unit): Http2Stream /* this */
    fun on(event: String /* "timeout" */, listener: () -> Unit): Http2Stream /* this */
    fun on(event: String /* "trailers" */, listener: (trailers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Stream /* this */
    fun on(event: String /* "wantTrailers" */, listener: () -> Unit): Http2Stream /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Http2Stream /* this */
    fun once(event: String /* "aborted" */, listener: () -> Unit): Http2Stream /* this */
    fun once(event: String /* "close" */, listener: () -> Unit): Http2Stream /* this */
    override fun once(event: String /* "data" */, listener: (chunk: dynamic /* String | Buffer */) -> Unit): Http2Stream /* this */
    fun once(event: String /* "drain" */, listener: () -> Unit): Http2Stream /* this */
    fun once(event: String /* "end" */, listener: () -> Unit): Http2Stream /* this */
    fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Stream /* this */
    fun once(event: String /* "finish" */, listener: () -> Unit): Http2Stream /* this */
    fun once(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number) -> Unit): Http2Stream /* this */
    fun once(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun once(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun once(event: String /* "streamClosed" */, listener: (code: Number) -> Unit): Http2Stream /* this */
    fun once(event: String /* "timeout" */, listener: () -> Unit): Http2Stream /* this */
    fun once(event: String /* "trailers" */, listener: (trailers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Stream /* this */
    fun once(event: String /* "wantTrailers" */, listener: () -> Unit): Http2Stream /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "aborted" */, listener: () -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "close" */, listener: () -> Unit): Http2Stream /* this */
    override fun prependListener(event: String /* "data" */, listener: (chunk: dynamic /* String | Buffer */) -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "drain" */, listener: () -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "end" */, listener: () -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "finish" */, listener: () -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number) -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "streamClosed" */, listener: (code: Number) -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "timeout" */, listener: () -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "trailers" */, listener: (trailers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Stream /* this */
    fun prependListener(event: String /* "wantTrailers" */, listener: () -> Unit): Http2Stream /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "aborted" */, listener: () -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): Http2Stream /* this */
    override fun prependOnceListener(event: String /* "data" */, listener: (chunk: dynamic /* String | Buffer */) -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "drain" */, listener: () -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "end" */, listener: () -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "finish" */, listener: () -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number) -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "pipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "unpipe" */, listener: (src: Readable) -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "streamClosed" */, listener: (code: Number) -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "timeout" */, listener: () -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "trailers" */, listener: (trailers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Stream /* this */
    fun prependOnceListener(event: String /* "wantTrailers" */, listener: () -> Unit): Http2Stream /* this */
    fun sendTrailers(headers: OutgoingHttpHeaders): Http2Stream /* this */
}
external interface ClientHttp2Stream : Http2Stream {
    override fun addListener(event: String, listener: (args: Any) -> Unit): ClientHttp2Stream /* this */
    override fun addListener(event: String /* "headers" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun addListener(event: String /* "push" */, listener: (headers: IncomingHttpHeaders, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun addListener(event: String /* "response" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any?, vararg args: Any): Boolean
    override fun emit(event: String /* "headers" */, trailers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number): Boolean
    override fun emit(event: String /* "push" */, trailers: IncomingHttpHeaders, flags: Number): Boolean
    override fun emit(event: String /* "response" */, trailers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): ClientHttp2Stream /* this */
    override fun on(event: String /* "headers" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun on(event: String /* "push" */, listener: (headers: IncomingHttpHeaders, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun on(event: String /* "response" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): ClientHttp2Stream /* this */
    override fun once(event: String /* "headers" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun once(event: String /* "push" */, listener: (headers: IncomingHttpHeaders, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun once(event: String /* "response" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): ClientHttp2Stream /* this */
    override fun prependListener(event: String /* "headers" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun prependListener(event: String /* "push" */, listener: (headers: IncomingHttpHeaders, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun prependListener(event: String /* "response" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): ClientHttp2Stream /* this */
    override fun prependOnceListener(event: String /* "headers" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun prependOnceListener(event: String /* "push" */, listener: (headers: IncomingHttpHeaders, flags: Number) -> Unit): ClientHttp2Stream /* this */
    override fun prependOnceListener(event: String /* "response" */, listener: (headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Stream /* this */
}
external interface ServerHttp2Stream : Http2Stream {
    fun additionalHeaders(headers: OutgoingHttpHeaders)
    var headersSent: Boolean
    var pushAllowed: Boolean
    fun pushStream(headers: OutgoingHttpHeaders, callback: ((err: Error?, pushStream: ServerHttp2Stream, headers: OutgoingHttpHeaders) -> Unit)? = definedExternally /* null */)
    fun pushStream(headers: OutgoingHttpHeaders, options: StreamPriorityOptions? = definedExternally /* null */, callback: ((err: Error?, pushStream: ServerHttp2Stream, headers: OutgoingHttpHeaders) -> Unit)? = definedExternally /* null */)
    fun respond(headers: OutgoingHttpHeaders? = definedExternally /* null */, options: ServerStreamResponseOptions? = definedExternally /* null */)
    fun respondWithFD(fd: Number, headers: OutgoingHttpHeaders? = definedExternally /* null */, options: ServerStreamFileResponseOptions? = definedExternally /* null */)
    fun respondWithFile(path: String, headers: OutgoingHttpHeaders? = definedExternally /* null */, options: ServerStreamFileResponseOptionsWithError? = definedExternally /* null */)
    fun pushStream(headers: OutgoingHttpHeaders)
}
external interface Settings {
    var headerTableSize: Number? get() = definedExternally; set(value) = definedExternally
    var enablePush: Boolean? get() = definedExternally; set(value) = definedExternally
    var initialWindowSize: Number? get() = definedExternally; set(value) = definedExternally
    var maxFrameSize: Number? get() = definedExternally; set(value) = definedExternally
    var maxConcurrentStreams: Number? get() = definedExternally; set(value) = definedExternally
    var maxHeaderListSize: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ClientSessionRequestOptions {
    var endStream: Boolean? get() = definedExternally; set(value) = definedExternally
    var exclusive: Boolean? get() = definedExternally; set(value) = definedExternally
    var parent: Number? get() = definedExternally; set(value) = definedExternally
    var weight: Number? get() = definedExternally; set(value) = definedExternally
    var getTrailers: ((trailers: OutgoingHttpHeaders, flags: Number) -> Unit)? get() = definedExternally; set(value) = definedExternally
}
external interface SessionState {
    var effectiveLocalWindowSize: Number? get() = definedExternally; set(value) = definedExternally
    var effectiveRecvDataLength: Number? get() = definedExternally; set(value) = definedExternally
    var nextStreamID: Number? get() = definedExternally; set(value) = definedExternally
    var localWindowSize: Number? get() = definedExternally; set(value) = definedExternally
    var lastProcStreamID: Number? get() = definedExternally; set(value) = definedExternally
    var remoteWindowSize: Number? get() = definedExternally; set(value) = definedExternally
    var outboundQueueSize: Number? get() = definedExternally; set(value) = definedExternally
    var deflateDynamicTableSize: Number? get() = definedExternally; set(value) = definedExternally
    var inflateDynamicTableSize: Number? get() = definedExternally; set(value) = definedExternally
}
external interface Http2Session : EventEmitter {
    var alpnProtocol: String? get() = definedExternally; set(value) = definedExternally
    fun close(callback: (() -> Unit)? = definedExternally /* null */)
    var closed: Boolean
    var connecting: Boolean
    fun destroy(error: Error? = definedExternally /* null */, code: Number? = definedExternally /* null */)
    var destroyed: Boolean
    var encrypted: Boolean? get() = definedExternally; set(value) = definedExternally
    fun goaway(code: Number? = definedExternally /* null */, lastStreamID: Number? = definedExternally /* null */, opaqueData: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */ = definedExternally /* null */)
    var localSettings: Settings
    var originSet: Array<String>? get() = definedExternally; set(value) = definedExternally
    var pendingSettingsAck: Boolean
    fun ping(callback: (err: Error?, duration: Number, payload: Buffer) -> Unit): Boolean
    fun ping(payload: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, callback: (err: Error?, duration: Number, payload: Buffer) -> Unit): Boolean
    fun ref()
    var remoteSettings: Settings
    fun rstStream(stream: Http2Stream, code: Number? = definedExternally /* null */)
    fun setTimeout(msecs: Number, callback: (() -> Unit)? = definedExternally /* null */)
    var socket: dynamic /* net.Socket | TLSSocket */
    var state: SessionState
    fun priority(stream: Http2Stream, options: StreamPriorityOptions)
    fun settings(settings: Settings)
    var type: Number
    fun unref()
    override fun addListener(event: String, listener: (args: Any) -> Unit): Http2Session /* this */
    fun addListener(event: String /* "close" */, listener: () -> Unit): Http2Session /* this */
    fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Session /* this */
    fun addListener(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number, streamID: Number) -> Unit): Http2Session /* this */
    fun addListener(event: String /* "goaway" */, listener: (errorCode: Number, lastStreamID: Number, opaqueData: Buffer) -> Unit): Http2Session /* this */
    fun addListener(event: String /* "localSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun addListener(event: String /* "remoteSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun addListener(event: String /* "timeout" */, listener: () -> Unit): Http2Session /* this */
    fun addListener(event: String /* "ping" */, listener: () -> Unit): Http2Session /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any?, vararg args: Any): Boolean
    fun emit(event: String /* "close" */): Boolean
    fun emit(event: String /* "error" */, err: Error): Boolean
    fun emit(event: String /* "frameError" */, frameType: Number, errorCode: Number, streamID: Number): Boolean
    fun emit(event: String /* "goaway" */, errorCode: Number, lastStreamID: Number, opaqueData: Buffer): Boolean
    fun emit(event: String /* "localSettings" */, settings: Settings): Boolean
    fun emit(event: String /* "remoteSettings" */, settings: Settings): Boolean
    fun emit(event: String /* "timeout" */): Boolean
    fun emit(event: String /* "ping" */): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): Http2Session /* this */
    fun on(event: String /* "close" */, listener: () -> Unit): Http2Session /* this */
    fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Session /* this */
    fun on(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number, streamID: Number) -> Unit): Http2Session /* this */
    fun on(event: String /* "goaway" */, listener: (errorCode: Number, lastStreamID: Number, opaqueData: Buffer) -> Unit): Http2Session /* this */
    fun on(event: String /* "localSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun on(event: String /* "remoteSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun on(event: String /* "timeout" */, listener: () -> Unit): Http2Session /* this */
    fun on(event: String /* "ping" */, listener: () -> Unit): Http2Session /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Http2Session /* this */
    fun once(event: String /* "close" */, listener: () -> Unit): Http2Session /* this */
    fun once(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Session /* this */
    fun once(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number, streamID: Number) -> Unit): Http2Session /* this */
    fun once(event: String /* "goaway" */, listener: (errorCode: Number, lastStreamID: Number, opaqueData: Buffer) -> Unit): Http2Session /* this */
    fun once(event: String /* "localSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun once(event: String /* "remoteSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun once(event: String /* "timeout" */, listener: () -> Unit): Http2Session /* this */
    fun once(event: String /* "ping" */, listener: () -> Unit): Http2Session /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Http2Session /* this */
    fun prependListener(event: String /* "close" */, listener: () -> Unit): Http2Session /* this */
    fun prependListener(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Session /* this */
    fun prependListener(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number, streamID: Number) -> Unit): Http2Session /* this */
    fun prependListener(event: String /* "goaway" */, listener: (errorCode: Number, lastStreamID: Number, opaqueData: Buffer) -> Unit): Http2Session /* this */
    fun prependListener(event: String /* "localSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun prependListener(event: String /* "remoteSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun prependListener(event: String /* "timeout" */, listener: () -> Unit): Http2Session /* this */
    fun prependListener(event: String /* "ping" */, listener: () -> Unit): Http2Session /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Http2Session /* this */
    fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): Http2Session /* this */
    fun prependOnceListener(event: String /* "error" */, listener: (err: Error) -> Unit): Http2Session /* this */
    fun prependOnceListener(event: String /* "frameError" */, listener: (frameType: Number, errorCode: Number, streamID: Number) -> Unit): Http2Session /* this */
    fun prependOnceListener(event: String /* "goaway" */, listener: (errorCode: Number, lastStreamID: Number, opaqueData: Buffer) -> Unit): Http2Session /* this */
    fun prependOnceListener(event: String /* "localSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun prependOnceListener(event: String /* "remoteSettings" */, listener: (settings: Settings) -> Unit): Http2Session /* this */
    fun prependOnceListener(event: String /* "timeout" */, listener: () -> Unit): Http2Session /* this */
    fun prependOnceListener(event: String /* "ping" */, listener: () -> Unit): Http2Session /* this */
}
external interface ClientHttp2Session : Http2Session {
    fun request(headers: OutgoingHttpHeaders? = definedExternally /* null */, options: ClientSessionRequestOptions? = definedExternally /* null */): ClientHttp2Stream
    override fun addListener(event: String, listener: (args: Any) -> Unit): ClientHttp2Session /* this */
    fun addListener(event: String /* "altsvc" */, listener: (alt: String, origin: String, stream: Number) -> Unit): ClientHttp2Session /* this */
    fun addListener(event: String /* "connect" */, listener: (session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ClientHttp2Session /* this */
    fun addListener(event: String /* "stream" */, listener: (stream: ClientHttp2Stream, headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Session /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any?, vararg args: Any): Boolean
    fun emit(event: String /* "altsvc" */, alt: String, origin: String, stream: Number): Boolean
    fun emit(event: String /* "connect" */, session: ClientHttp2Session, socket: Socket): Boolean
    fun emit(event: String /* "connect" */, session: ClientHttp2Session, socket: TLSSocket): Boolean
    fun emit(event: String /* "stream" */, stream: ClientHttp2Stream, headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): ClientHttp2Session /* this */
    fun on(event: String /* "altsvc" */, listener: (alt: String, origin: String, stream: Number) -> Unit): ClientHttp2Session /* this */
    fun on(event: String /* "connect" */, listener: (session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ClientHttp2Session /* this */
    fun on(event: String /* "stream" */, listener: (stream: ClientHttp2Stream, headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Session /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): ClientHttp2Session /* this */
    fun once(event: String /* "altsvc" */, listener: (alt: String, origin: String, stream: Number) -> Unit): ClientHttp2Session /* this */
    fun once(event: String /* "connect" */, listener: (session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ClientHttp2Session /* this */
    fun once(event: String /* "stream" */, listener: (stream: ClientHttp2Stream, headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Session /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): ClientHttp2Session /* this */
    fun prependListener(event: String /* "altsvc" */, listener: (alt: String, origin: String, stream: Number) -> Unit): ClientHttp2Session /* this */
    fun prependListener(event: String /* "connect" */, listener: (session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ClientHttp2Session /* this */
    fun prependListener(event: String /* "stream" */, listener: (stream: ClientHttp2Stream, headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Session /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): ClientHttp2Session /* this */
    fun prependOnceListener(event: String /* "altsvc" */, listener: (alt: String, origin: String, stream: Number) -> Unit): ClientHttp2Session /* this */
    fun prependOnceListener(event: String /* "connect" */, listener: (session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ClientHttp2Session /* this */
    fun prependOnceListener(event: String /* "stream" */, listener: (stream: ClientHttp2Stream, headers: IncomingHttpHeaders /* IncomingHttpHeaders & IncomingHttpStatusHeader */, flags: Number) -> Unit): ClientHttp2Session /* this */
}
external interface AlternativeServiceOptions {
    var origin: dynamic /* String | Number | url.URL */
}
external interface ServerHttp2Session : Http2Session {
    fun altsvc(alt: String, originOrStream: String)
    fun altsvc(alt: String, originOrStream: Number)
    fun altsvc(alt: String, originOrStream: URL)
    fun altsvc(alt: String, originOrStream: AlternativeServiceOptions)
    var server: dynamic /* Http2Server | Http2SecureServer */
    override fun addListener(event: String, listener: (args: Any) -> Unit): ServerHttp2Session /* this */
    fun addListener(event: String /* "connect" */, listener: (session: ServerHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ServerHttp2Session /* this */
    fun addListener(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): ServerHttp2Session /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any?, vararg args: Any): Boolean
    fun emit(event: String /* "connect" */, session: ServerHttp2Session, socket: Socket): Boolean
    fun emit(event: String /* "connect" */, session: ServerHttp2Session, socket: TLSSocket): Boolean
    fun emit(event: String /* "stream" */, stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): ServerHttp2Session /* this */
    fun on(event: String /* "connect" */, listener: (session: ServerHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ServerHttp2Session /* this */
    fun on(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): ServerHttp2Session /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): ServerHttp2Session /* this */
    fun once(event: String /* "connect" */, listener: (session: ServerHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ServerHttp2Session /* this */
    fun once(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): ServerHttp2Session /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): ServerHttp2Session /* this */
    fun prependListener(event: String /* "connect" */, listener: (session: ServerHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ServerHttp2Session /* this */
    fun prependListener(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): ServerHttp2Session /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): ServerHttp2Session /* this */
    fun prependOnceListener(event: String /* "connect" */, listener: (session: ServerHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit): ServerHttp2Session /* this */
    fun prependOnceListener(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): ServerHttp2Session /* this */
}
external interface SessionOptions {
    var maxDeflateDynamicTableSize: Number? get() = definedExternally; set(value) = definedExternally
    var maxReservedRemoteStreams: Number? get() = definedExternally; set(value) = definedExternally
    var maxSendHeaderBlockLength: Number? get() = definedExternally; set(value) = definedExternally
    var paddingStrategy: Number? get() = definedExternally; set(value) = definedExternally
    var peerMaxConcurrentStreams: Number? get() = definedExternally; set(value) = definedExternally
    var selectPadding: ((frameLen: Number, maxFrameLen: Number) -> Number)? get() = definedExternally; set(value) = definedExternally
    var settings: Settings? get() = definedExternally; set(value) = definedExternally
    var createConnection: ((option: SessionOptions) -> Duplex)? get() = definedExternally; set(value) = definedExternally
}
external interface SecureClientSessionOptions : SessionOptions, ConnectionOptions
external interface SecureServerSessionOptions : SessionOptions, TlsOptions
external interface ServerOptions : SessionOptions {
    var allowHTTP1: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface SecureServerOptions : SecureServerSessionOptions {
    var allowHTTP1: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface Http2Server : Server {
    override fun addListener(event: String, listener: (args: Any) -> Unit): Http2Server /* this */
    fun addListener(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    fun addListener(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    override fun addListener(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2Server /* this */
    fun addListener(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Server /* this */
    override fun addListener(event: String /* "timeout" */, listener: () -> Unit): Http2Server /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any?, vararg args: Any): Boolean
    fun emit(event: String /* "checkContinue" */, request: Http2ServerRequest, response: Http2ServerResponse): Boolean
    fun emit(event: String /* "request" */, request: Http2ServerRequest, response: Http2ServerResponse): Boolean
    override fun emit(event: String /* "sessionError" */, err: Error): Boolean
    fun emit(event: String /* "stream" */, stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number): Boolean
    override fun emit(event: String /* "timeout" */): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): Http2Server /* this */
    fun on(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    fun on(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    override fun on(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2Server /* this */
    fun on(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Server /* this */
    override fun on(event: String /* "timeout" */, listener: () -> Unit): Http2Server /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Http2Server /* this */
    fun once(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    fun once(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    override fun once(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2Server /* this */
    fun once(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Server /* this */
    override fun once(event: String /* "timeout" */, listener: () -> Unit): Http2Server /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Http2Server /* this */
    fun prependListener(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    fun prependListener(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    override fun prependListener(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2Server /* this */
    fun prependListener(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Server /* this */
    override fun prependListener(event: String /* "timeout" */, listener: () -> Unit): Http2Server /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Http2Server /* this */
    fun prependOnceListener(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    fun prependOnceListener(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2Server /* this */
    override fun prependOnceListener(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2Server /* this */
    fun prependOnceListener(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2Server /* this */
    override fun prependOnceListener(event: String /* "timeout" */, listener: () -> Unit): Http2Server /* this */
}
external interface Http2SecureServer : Server {
    override fun addListener(event: String, listener: (args: Any) -> Unit): Http2SecureServer /* this */
    fun addListener(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    fun addListener(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    override fun addListener(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2SecureServer /* this */
    fun addListener(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2SecureServer /* this */
    override fun addListener(event: String /* "timeout" */, listener: () -> Unit): Http2SecureServer /* this */
    fun addListener(event: String /* "unknownProtocol" */, listener: (socket: TLSSocket) -> Unit): Http2SecureServer /* this */
    override fun emit(event: String, vararg args: Any): Boolean
    override fun emit(event: Any?, vararg args: Any): Boolean
    fun emit(event: String /* "checkContinue" */, request: Http2ServerRequest, response: Http2ServerResponse): Boolean
    fun emit(event: String /* "request" */, request: Http2ServerRequest, response: Http2ServerResponse): Boolean
    override fun emit(event: String /* "sessionError" */, err: Error): Boolean
    fun emit(event: String /* "stream" */, stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number): Boolean
    override fun emit(event: String /* "timeout" */): Boolean
    fun emit(event: String /* "unknownProtocol" */, socket: TLSSocket): Boolean
    override fun on(event: String, listener: (args: Any) -> Unit): Http2SecureServer /* this */
    fun on(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    fun on(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    override fun on(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2SecureServer /* this */
    fun on(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2SecureServer /* this */
    override fun on(event: String /* "timeout" */, listener: () -> Unit): Http2SecureServer /* this */
    fun on(event: String /* "unknownProtocol" */, listener: (socket: TLSSocket) -> Unit): Http2SecureServer /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): Http2SecureServer /* this */
    fun once(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    fun once(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    override fun once(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2SecureServer /* this */
    fun once(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2SecureServer /* this */
    override fun once(event: String /* "timeout" */, listener: () -> Unit): Http2SecureServer /* this */
    fun once(event: String /* "unknownProtocol" */, listener: (socket: TLSSocket) -> Unit): Http2SecureServer /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Http2SecureServer /* this */
    fun prependListener(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    fun prependListener(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    override fun prependListener(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2SecureServer /* this */
    fun prependListener(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2SecureServer /* this */
    override fun prependListener(event: String /* "timeout" */, listener: () -> Unit): Http2SecureServer /* this */
    fun prependListener(event: String /* "unknownProtocol" */, listener: (socket: TLSSocket) -> Unit): Http2SecureServer /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Http2SecureServer /* this */
    fun prependOnceListener(event: String /* "checkContinue" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    fun prependOnceListener(event: String /* "request" */, listener: (request: Http2ServerRequest, response: Http2ServerResponse) -> Unit): Http2SecureServer /* this */
    override fun prependOnceListener(event: String /* "sessionError" */, listener: (err: Error) -> Unit): Http2SecureServer /* this */
    fun prependOnceListener(event: String /* "stream" */, listener: (stream: ServerHttp2Stream, headers: IncomingHttpHeaders, flags: Number) -> Unit): Http2SecureServer /* this */
    override fun prependOnceListener(event: String /* "timeout" */, listener: () -> Unit): Http2SecureServer /* this */
    fun prependOnceListener(event: String /* "unknownProtocol" */, listener: (socket: TLSSocket) -> Unit): Http2SecureServer /* this */
}
open external class Http2ServerRequest : Readable {
    open var headers: IncomingHttpHeaders = definedExternally
    open var httpVersion: String = definedExternally
    open var method: String = definedExternally
    open var rawHeaders: Array<String> = definedExternally
    open var rawTrailers: Array<String> = definedExternally
    open fun setTimeout(msecs: Number, callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open var socket: dynamic /* net.Socket | TLSSocket */ = definedExternally
    open var stream: ServerHttp2Stream = definedExternally
    open var trailers: IncomingHttpHeaders = definedExternally
    open var url: String = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): Http2ServerRequest /* this */ = definedExternally
    open fun addListener(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerRequest /* this */ = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun emit(event: String /* "aborted" */, hadError: Boolean, code: Number): Boolean = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): Http2ServerRequest /* this */ = definedExternally
    open fun on(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerRequest /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): Http2ServerRequest /* this */ = definedExternally
    open fun once(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerRequest /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Http2ServerRequest /* this */ = definedExternally
    open fun prependListener(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerRequest /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Http2ServerRequest /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerRequest /* this */ = definedExternally
}
open external class Http2ServerResponse : EventEmitter {
    open fun addTrailers(trailers: OutgoingHttpHeaders): Unit = definedExternally
    open var connection: dynamic /* net.Socket | TLSSocket */ = definedExternally
    open fun end(callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun end(data: String? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun end(data: Buffer? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun end(data: String? = definedExternally /* null */, encoding: String? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun end(data: Buffer? = definedExternally /* null */, encoding: String? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open var finished: Boolean = definedExternally
    open fun getHeader(name: String): String = definedExternally
    open fun getHeaderNames(): Array<String> = definedExternally
    open fun getHeaders(): OutgoingHttpHeaders = definedExternally
    open fun hasHeader(name: String): Boolean = definedExternally
    open var headersSent: Boolean = definedExternally
    open fun removeHeader(name: String): Unit = definedExternally
    open var sendDate: Boolean = definedExternally
    open fun setHeader(name: String, value: String): Unit = definedExternally
    open fun setHeader(name: String, value: Number): Unit = definedExternally
    open fun setHeader(name: String, value: Array<String>): Unit = definedExternally
    open fun setHeader(name: String, value: Nothing?): Unit = definedExternally
    open fun setTimeout(msecs: Number, callback: (() -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open var socket: dynamic /* net.Socket | TLSSocket */ = definedExternally
    open var statusCode: Number = definedExternally
    open var statusMessage: String /* "" */ = definedExternally
    open var stream: ServerHttp2Stream = definedExternally
    open fun write(chunk: String, callback: ((err: Error) -> Unit)? = definedExternally /* null */): Boolean = definedExternally
    open fun write(chunk: Buffer, callback: ((err: Error) -> Unit)? = definedExternally /* null */): Boolean = definedExternally
    open fun write(chunk: String, encoding: String? = definedExternally /* null */, callback: ((err: Error) -> Unit)? = definedExternally /* null */): Boolean = definedExternally
    open fun write(chunk: Buffer, encoding: String? = definedExternally /* null */, callback: ((err: Error) -> Unit)? = definedExternally /* null */): Boolean = definedExternally
    open fun writeContinue(): Unit = definedExternally
    open fun writeHead(statusCode: Number, headers: OutgoingHttpHeaders? = definedExternally /* null */): Unit = definedExternally
    open fun writeHead(statusCode: Number, statusMessage: String? = definedExternally /* null */, headers: OutgoingHttpHeaders? = definedExternally /* null */): Unit = definedExternally
    open fun createPushResponse(headers: OutgoingHttpHeaders, callback: (err: Error?, res: Http2ServerResponse) -> Unit): Unit = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun addListener(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun addListener(event: String /* "close" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun addListener(event: String /* "drain" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun addListener(event: String /* "error" */, listener: (error: Error) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun addListener(event: String /* "finish" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    override fun emit(event: String, vararg args: Any): Boolean = definedExternally
    override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun emit(event: String /* "aborted" */, hadError: Boolean, code: Number): Boolean = definedExternally
    open fun emit(event: String /* "close" */): Boolean = definedExternally
    open fun emit(event: String /* "drain" */): Boolean = definedExternally
    open fun emit(event: String /* "error" */, error: Error): Boolean = definedExternally
    open fun emit(event: String /* "finish" */): Boolean = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun on(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun on(event: String /* "close" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun on(event: String /* "drain" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun on(event: String /* "error" */, listener: (error: Error) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun on(event: String /* "finish" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun once(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun once(event: String /* "close" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun once(event: String /* "drain" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun once(event: String /* "error" */, listener: (error: Error) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun once(event: String /* "finish" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependListener(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependListener(event: String /* "close" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependListener(event: String /* "drain" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependListener(event: String /* "error" */, listener: (error: Error) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependListener(event: String /* "finish" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "aborted" */, listener: (hadError: Boolean, code: Number) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "drain" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "error" */, listener: (error: Error) -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "finish" */, listener: () -> Unit): Http2ServerResponse /* this */ = definedExternally
    open fun end(): Unit = definedExternally
    open fun write(chunk: String): Boolean = definedExternally
    open fun write(chunk: Buffer): Boolean = definedExternally
    open fun writeHead(statusCode: Number): Unit = definedExternally
}
external fun getDefaultSettings(): Settings = definedExternally
external fun getPackedSettings(settings: Settings): Settings = definedExternally
external fun getUnpackedSettings(buf: Buffer): Settings = definedExternally
external fun getUnpackedSettings(buf: Uint8Array): Settings = definedExternally
external fun createServer(onRequestHandler: ((request: Http2ServerRequest, response: Http2ServerResponse) -> Unit)? = definedExternally /* null */): Http2Server = definedExternally
external fun createServer(options: ServerOptions, onRequestHandler: ((request: Http2ServerRequest, response: Http2ServerResponse) -> Unit)? = definedExternally /* null */): Http2Server = definedExternally
external fun createSecureServer(onRequestHandler: ((request: Http2ServerRequest, response: Http2ServerResponse) -> Unit)? = definedExternally /* null */): Http2SecureServer = definedExternally
external fun createSecureServer(options: SecureServerOptions, onRequestHandler: ((request: Http2ServerRequest, response: Http2ServerResponse) -> Unit)? = definedExternally /* null */): Http2SecureServer = definedExternally
external fun connect(authority: String, listener: ((session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit)? = definedExternally /* null */): ClientHttp2Session = definedExternally
external fun connect(authority: URL, listener: ((session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit)? = definedExternally /* null */): ClientHttp2Session = definedExternally
external fun connect(authority: String, options: SessionOptions? = definedExternally /* null */, listener: ((session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit)? = definedExternally /* null */): ClientHttp2Session = definedExternally
external fun connect(authority: String, options: SecureClientSessionOptions? = definedExternally /* null */, listener: ((session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit)? = definedExternally /* null */): ClientHttp2Session = definedExternally
external fun connect(authority: URL, options: SessionOptions? = definedExternally /* null */, listener: ((session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit)? = definedExternally /* null */): ClientHttp2Session = definedExternally
external fun connect(authority: URL, options: SecureClientSessionOptions? = definedExternally /* null */, listener: ((session: ClientHttp2Session, socket: dynamic /* net.Socket | TLSSocket */) -> Unit)? = definedExternally /* null */): ClientHttp2Session = definedExternally
external fun connect(authority: String): ClientHttp2Session = definedExternally
external fun connect(authority: URL): ClientHttp2Session = definedExternally

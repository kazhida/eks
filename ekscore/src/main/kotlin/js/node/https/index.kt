@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("https")
package js.node.https

import js.node.http.ClientRequest
import js.node.http.IncomingMessage
import js.node.http.RequestOptions
import js.node.http.ServerResponse
import js.node.tls.ConnectionOptions
import js.node.tls.SecureContextOptions
import js.node.url.URL
import kotlin.js.*

external interface AgentOptions : js.node.http.AgentOptions, ConnectionOptions {
    override var rejectUnauthorized: Boolean? get() = definedExternally; set(value) = definedExternally
    var maxCachedSessions: Number? get() = definedExternally; set(value) = definedExternally
}
open external class Agent(options: AgentOptions? = definedExternally /* null */) : js.node.http.Agent {
    open var options: AgentOptions = definedExternally
}
open external class Server : js.node.tls.Server {
    open fun setTimeout(callback: () -> Unit): Server /* this */ = definedExternally
    open fun setTimeout(msecs: Number? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Server /* this */ = definedExternally
    open var timeout: Number = definedExternally
    open var keepAliveTimeout: Number = definedExternally
}
external fun createServer(options: SecureContextOptions /* tls.SecureContextOptions & tls.TlsOptions */, requestListener: ((req: IncomingMessage, res: ServerResponse) -> Unit)? = definedExternally /* null */): Server = definedExternally
external interface `T$19` {
    var rejectUnauthorized: Boolean? get() = definedExternally; set(value) = definedExternally
    var servername: String? get() = definedExternally; set(value) = definedExternally
}
external fun request(options: String, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun request(options: URL, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun request(options: RequestOptions /* RequestOptions & tls.SecureContextOptions & `T$19` */, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun request(url: String, options: RequestOptions /* RequestOptions & tls.SecureContextOptions & `T$19` */, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun request(url: URL, options: RequestOptions /* RequestOptions & tls.SecureContextOptions & `T$19` */, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(options: String, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(options: URL, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(options: RequestOptions /* RequestOptions & tls.SecureContextOptions & `T$19` */, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(url: String, options: RequestOptions /* RequestOptions & tls.SecureContextOptions & `T$19` */, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external fun get(url: URL, options: RequestOptions /* RequestOptions & tls.SecureContextOptions & `T$19` */, callback: ((res: IncomingMessage) -> Unit)? = definedExternally /* null */): ClientRequest = definedExternally
external var globalAgent: Agent = definedExternally

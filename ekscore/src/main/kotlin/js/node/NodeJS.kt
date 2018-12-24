@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")

package js.node

import js.node.buffer.ArrayBuffer
import js.node.buffer.Uint8Array
import kotlin.js.*

external interface InspectOptions {
    var showHidden: Boolean? get() = definedExternally; set(value) = definedExternally
    var depth: Number? get() = definedExternally; set(value) = definedExternally
    var colors: Boolean? get() = definedExternally; set(value) = definedExternally
    var customInspect: Boolean? get() = definedExternally; set(value) = definedExternally
    var showProxy: Boolean? get() = definedExternally; set(value) = definedExternally
    var maxArrayLength: Number? get() = definedExternally; set(value) = definedExternally
    var breakLength: Number? get() = definedExternally; set(value) = definedExternally
    var compact: Boolean? get() = definedExternally; set(value) = definedExternally
    var sorted: dynamic /* Boolean | (a: String, b: String) -> Number */ get() = definedExternally; set(value) = definedExternally
}
external interface ConsoleConstructorOptions {
    var stdout: WritableStream
    var stderr: WritableStream? get() = definedExternally; set(value) = definedExternally
    var ignoreErrors: Boolean? get() = definedExternally; set(value) = definedExternally
    var colorMode: dynamic /* Boolean | String /* "auto" */ */ get() = definedExternally; set(value) = definedExternally
}
external interface ConsoleConstructor {
    var prototype: Console
}
external interface CallSite {
    fun getThis(): Any
    fun getTypeName(): String?
    fun getFunction(): Function<*>?
    fun getFunctionName(): String?
    fun getMethodName(): String?
    fun getFileName(): String?
    fun getLineNumber(): Number?
    fun getColumnNumber(): Number?
    fun getEvalOrigin(): String?
    fun isToplevel(): Boolean
    fun isEval(): Boolean
    fun isNative(): Boolean
    fun isConstructor(): Boolean
}
external interface ErrnoException : Error {
    var errno: Number? get() = definedExternally; set(value) = definedExternally
    var code: String? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var syscall: String? get() = definedExternally; set(value) = definedExternally
    override var stack: String? get() = definedExternally; set(value) = definedExternally
}
open external class EventEmitter {
    open fun addListener(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun addListener(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun on(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun on(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun once(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun once(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun removeListener(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun removeListener(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun off(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun off(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun removeAllListeners(event: String? = definedExternally /* null */): EventEmitter /* this */ = definedExternally
    open fun removeAllListeners(event: Any? = definedExternally /* null */): EventEmitter /* this */ = definedExternally
    open fun setMaxListeners(n: Number): EventEmitter /* this */ = definedExternally
    open fun getMaxListeners(): Number = definedExternally
    open fun listeners(event: String): Array<Function<*>> = definedExternally
    open fun listeners(event: Any?): Array<Function<*>> = definedExternally
    open fun rawListeners(event: String): Array<Function<*>> = definedExternally
    open fun rawListeners(event: Any?): Array<Function<*>> = definedExternally
    open fun emit(event: String, vararg args: Any): Boolean = definedExternally
    open fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
    open fun listenerCount(type: String): Number = definedExternally
    open fun listenerCount(type: Any?): Number = definedExternally
    open fun prependListener(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun prependListener(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun prependOnceListener(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun prependOnceListener(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
    open fun eventNames(): Array<dynamic /* String | Any? */> = definedExternally
    open fun removeAllListeners(): EventEmitter /* this */ = definedExternally
}
external interface `T$3` {
    var end: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface ReadableStream : EventEmitter {
    var readable: Boolean
    fun read(size: Number? = definedExternally /* null */): dynamic /* String | Buffer */
    fun setEncoding(encoding: String): ReadableStream /* this */
    fun pause(): ReadableStream /* this */
    fun resume(): ReadableStream /* this */
    fun isPaused(): Boolean
    fun <T : WritableStream> pipe(destination: T, options: `T$3`? = definedExternally /* null */): T
    fun unpipe(destination: WritableStream? = definedExternally /* null */): ReadableStream /* this */
    fun unshift(chunk: String)
    fun unshift(chunk: Buffer)
    fun wrap(oldStream: ReadableStream): ReadableStream /* this */
}
external interface WritableStream : EventEmitter {
    var writable: Boolean
    fun write(buffer: String, cb: Function<*>? = definedExternally /* null */): Boolean
    fun write(buffer: Buffer, cb: Function<*>? = definedExternally /* null */): Boolean
    fun write(str: String, encoding: String? = definedExternally /* null */, cb: Function<*>? = definedExternally /* null */): Boolean
    fun end(cb: Function<*>? = definedExternally /* null */)
    fun end(buffer: Buffer, cb: Function<*>? = definedExternally /* null */)
    fun end(str: String, cb: Function<*>? = definedExternally /* null */)
    fun end(str: String, encoding: String? = definedExternally /* null */, cb: Function<*>? = definedExternally /* null */)
    fun end(str: String)
}
external interface ReadWriteStream : ReadableStream, WritableStream
external interface Events : EventEmitter
external interface Domain : Events {
    fun run(fn: Function<*>)
    fun add(emitter: Events)
    fun remove(emitter: Events)
    fun bind(cb: (err: Error, data: Any) -> Any): Any
    fun intercept(cb: (data: Any) -> Any): Any
//    fun addListener(event: String, listener: (args: Any) -> Unit): Domain /* this */
//    fun on(event: String, listener: (args: Any) -> Unit): Domain /* this */
//    fun once(event: String, listener: (args: Any) -> Unit): Domain /* this */
//    fun removeListener(event: String, listener: (args: Any) -> Unit): Domain /* this */
//    fun removeAllListeners(event: String? = definedExternally /* null */): Domain /* this */
}
external interface MemoryUsage {
    var rss: Number
    var heapTotal: Number
    var heapUsed: Number
    var external: Number
}
external interface CpuUsage {
    var user: Number
    var system: Number
}
external interface ProcessRelease {
    var name: String
    var sourceUrl: String? get() = definedExternally; set(value) = definedExternally
    var headersUrl: String? get() = definedExternally; set(value) = definedExternally
    var libUrl: String? get() = definedExternally; set(value) = definedExternally
    var lts: String? get() = definedExternally; set(value) = definedExternally
}
external interface ProcessVersions {
    var http_parser: String
    var node: String
    var v8: String
    var ares: String
    var uv: String
    var zlib: String
    var modules: String
    var openssl: String
}
external interface Socket : ReadWriteStream {
    var isTTY: Boolean? get() = definedExternally; set(value) = definedExternally
}
@Suppress("deprecation")
external interface ProcessEnv {
    @nativeGetter
    operator fun get(key: String): String?
    @nativeSetter
    operator fun set(key: String, value: String?)
}
external interface WriteStream : Socket {
    var writableHighWaterMark: Number
    var writableLength: Number
    var columns: Number? get() = definedExternally; set(value) = definedExternally
    var rows: Number? get() = definedExternally; set(value) = definedExternally
    fun _write(chunk: Any, encoding: String, callback: Function<*>)
    fun _destroy(err: Error?, callback: Function<*>)
    fun _final(callback: Function<*>)
    fun setDefaultEncoding(encoding: String): WriteStream /* this */
    fun cork()
    fun uncork()
    fun destroy(error: Error? = definedExternally /* null */)
}
external interface ReadStream : Socket {
    var readableHighWaterMark: Number
    var readableLength: Number
    var isRaw: Boolean? get() = definedExternally; set(value) = definedExternally
    val setRawMode: ((mode: Boolean) -> Unit)? get() = definedExternally
    fun _read(size: Number)
    fun _destroy(err: Error?, callback: Function<*>)
    fun push(chunk: Any, encoding: String? = definedExternally /* null */): Boolean
    fun destroy(error: Error? = definedExternally /* null */)
}
external interface `T$4` {
    var cflags: Array<Any>
    var default_configuration: String
    var defines: Array<String>
    var include_dirs: Array<String>
    var libraries: Array<String>
}
external interface `T$5` {
    var clang: Number
    var host_arch: String
    var node_install_npm: Boolean
    var node_install_waf: Boolean
    var node_prefix: String
    var node_shared_openssl: Boolean
    var node_shared_v8: Boolean
    var node_shared_zlib: Boolean
    var node_use_dtrace: Boolean
    var node_use_etw: Boolean
    var node_use_openssl: Boolean
    var target_arch: String
    var v8_no_strict_aliasing: Number
    var v8_use_snapshot: Boolean
    var visibility: String
}
external interface `T$6` {
    var target_defaults: `T$4`
    var variables: `T$5`
}
external interface Process : EventEmitter {
    var stdout: WriteStream
    var stderr: WriteStream
    var stdin: ReadStream
    fun openStdin(): Socket
    var argv: Array<String>
    var argv0: String
    var execArgv: Array<String>
    var execPath: String
    fun abort()
    fun chdir(directory: String)
    fun cwd(): String
    var debugPort: Number
    fun emitWarning(warning: String, name: String? = definedExternally /* null */, ctor: Function<*>? = definedExternally /* null */)
    fun emitWarning(warning: Error, name: String? = definedExternally /* null */, ctor: Function<*>? = definedExternally /* null */)
    var env: ProcessEnv
    fun exit(code: Number? = definedExternally /* null */): Any?
    var exitCode: Number
    fun getgid(): Number
    fun setgid(id: String)
    fun setgid(id: Number)
    fun getuid(): Number
    fun setuid(id: String)
    fun setuid(id: Number)
    fun geteuid(): Number
    fun seteuid(id: String)
    fun seteuid(id: Number)
    fun getegid(): Number
    fun setegid(id: String)
    fun setegid(id: Number)
    fun getgroups(): Array<Number>
    fun setgroups(groups: Array<dynamic /* String | Number */>)
    fun setUncaughtExceptionCaptureCallback(cb: ((err: Error) -> Unit)?)
    fun hasUncaughtExceptionCaptureCallback(): Boolean
    var version: String
    var versions: ProcessVersions
    var config: `T$6`
    fun kill(pid: Number, signal: String? = definedExternally /* null */)
    fun kill(pid: Number, signal: Number? = definedExternally /* null */)
    var pid: Number
    var ppid: Number
    var title: String
    var arch: String
    var platform: dynamic /* String /* "aix" */ | String /* "android" */ | String /* "darwin" */ | String /* "freebsd" */ | String /* "linux" */ | String /* "openbsd" */ | String /* "sunos" */ | String /* "win32" */ | String /* "cygwin" */ */
    var mainModule: NodeModule? get() = definedExternally; set(value) = definedExternally
    fun memoryUsage(): MemoryUsage
    fun cpuUsage(previousValue: CpuUsage? = definedExternally /* null */): CpuUsage
    fun nextTick(callback: Function<*>, vararg args: Any)
    var release: ProcessRelease
    fun umask(mask: Number? = definedExternally /* null */): Number
    fun uptime(): Number
    fun hrtime(time: dynamic /* JsTuple<Number, Number> */ = definedExternally /* null */): dynamic /* JsTuple<Number, Number> */
    var domain: Domain
    val send: ((message: Any, sendHandle: Any? /*= null*/) -> Unit)? get() = definedExternally
    fun disconnect()
    var connected: Boolean
    var allowedNodeEnvironmentFlags: ReadonlySet<String>
    fun addListener(event: String /* "beforeExit" */, listener: (code: Number) -> Unit): Process /* this */
    fun addListener(event: String /* "disconnect" */, listener: () -> Unit): Process /* this */
    fun addListener(event: String /* "exit" */, listener: (code: Number) -> Unit): Process /* this */
    fun addListener(event: String /* "rejectionHandled" */, listener: (promise: Promise<Any>) -> Unit): Process /* this */
    fun addListener(event: String /* "uncaughtException" */, listener: (error: Error) -> Unit): Process /* this */
    fun addListener(event: String /* "unhandledRejection" */, listener: (reason: Any, promise: Promise<Any>) -> Unit): Process /* this */
    fun addListener(event: String /* "warning" */, listener: (warning: Error) -> Unit): Process /* this */
    fun addListener(event: String /* "message" */, listener: (message: Any, sendHandle: Any) -> Unit): Process /* this */
    override fun addListener(event: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */, listener: (signal: Any /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */) -> Unit): Process /* this */
    fun addListener(event: String /* "newListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun addListener(event: String /* "removeListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun addListener(event: String /* "multipleResolves" */, listener: (type: dynamic /* String /* "resolve" */ | String /* "reject" */ */, promise: Promise<Any>, value: Any) -> Unit): Process /* this */
    fun emit(event: String /* "beforeExit" */, code: Number): Boolean
    fun emit(event: String /* "disconnect" */): Boolean
    fun emit(event: String /* "exit" */, code: Number): Boolean
    fun emit(event: String /* "rejectionHandled" */, promise: Promise<Any>): Boolean
    fun emit(event: String /* "uncaughtException" */, error: Error): Boolean
    fun emit(event: String /* "unhandledRejection" */, reason: Any, promise: Promise<Any>): Boolean
    fun emit(event: String /* "warning" */, warning: Error): Boolean
    fun emit(event: String /* "message" */, message: Any, sendHandle: Any): Process /* this */
    fun emit(event: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */, signal: String /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */): Boolean
    fun emit(event: String /* "newListener" */, eventName: String, listener: (args: Any) -> Unit): Process /* this */
    fun emit(event: String /* "newListener" */, eventName: Any?, listener: (args: Any) -> Unit): Process /* this */
    fun emit(event: String /* "removeListener" */, eventName: String, listener: (args: Any) -> Unit): Process /* this */
    fun emit(event: String /* "multipleResolves" */, listener: (type: dynamic /* String /* "resolve" */ | String /* "reject" */ */, promise: Promise<Any>, value: Any) -> Unit): Process /* this */
    fun on(event: String /* "beforeExit" */, listener: (code: Number) -> Unit): Process /* this */
    fun on(event: String /* "disconnect" */, listener: () -> Unit): Process /* this */
    fun on(event: String /* "exit" */, listener: (code: Number) -> Unit): Process /* this */
    fun on(event: String /* "rejectionHandled" */, listener: (promise: Promise<Any>) -> Unit): Process /* this */
    fun on(event: String /* "uncaughtException" */, listener: (error: Error) -> Unit): Process /* this */
    fun on(event: String /* "unhandledRejection" */, listener: (reason: Any, promise: Promise<Any>) -> Unit): Process /* this */
    fun on(event: String /* "warning" */, listener: (warning: Error) -> Unit): Process /* this */
    fun on(event: String /* "message" */, listener: (message: Any, sendHandle: Any) -> Unit): Process /* this */
    override fun on(event: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */, listener: (signal: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */) -> Unit): Process /* this */
    fun on(event: String /* "newListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun on(event: String /* "removeListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun on(event: String /* "multipleResolves" */, listener: (type: dynamic /* String /* "resolve" */ | String /* "reject" */ */, promise: Promise<Any>, value: Any) -> Unit): Process /* this */
    fun once(event: String /* "beforeExit" */, listener: (code: Number) -> Unit): Process /* this */
    fun once(event: String /* "disconnect" */, listener: () -> Unit): Process /* this */
    fun once(event: String /* "exit" */, listener: (code: Number) -> Unit): Process /* this */
    fun once(event: String /* "rejectionHandled" */, listener: (promise: Promise<Any>) -> Unit): Process /* this */
    fun once(event: String /* "uncaughtException" */, listener: (error: Error) -> Unit): Process /* this */
    fun once(event: String /* "unhandledRejection" */, listener: (reason: Any, promise: Promise<Any>) -> Unit): Process /* this */
    fun once(event: String /* "warning" */, listener: (warning: Error) -> Unit): Process /* this */
    fun once(event: String /* "message" */, listener: (message: Any, sendHandle: Any) -> Unit): Process /* this */
    override fun once(event: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */, listener: (signal: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */) -> Unit): Process /* this */
    fun once(event: String /* "newListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun once(event: String /* "removeListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun once(event: String /* "multipleResolves" */, listener: (type: dynamic /* String /* "resolve" */ | String /* "reject" */ */, promise: Promise<Any>, value: Any) -> Unit): Process /* this */
    fun prependListener(event: String /* "beforeExit" */, listener: (code: Number) -> Unit): Process /* this */
    fun prependListener(event: String /* "disconnect" */, listener: () -> Unit): Process /* this */
    fun prependListener(event: String /* "exit" */, listener: (code: Number) -> Unit): Process /* this */
    fun prependListener(event: String /* "rejectionHandled" */, listener: (promise: Promise<Any>) -> Unit): Process /* this */
    fun prependListener(event: String /* "uncaughtException" */, listener: (error: Error) -> Unit): Process /* this */
    fun prependListener(event: String /* "unhandledRejection" */, listener: (reason: Any, promise: Promise<Any>) -> Unit): Process /* this */
    fun prependListener(event: String /* "warning" */, listener: (warning: Error) -> Unit): Process /* this */
    fun prependListener(event: String /* "message" */, listener: (message: Any, sendHandle: Any) -> Unit): Process /* this */
    override fun prependListener(event: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */, listener: (signal: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */) -> Unit): Process /* this */
    fun prependListener(event: String /* "newListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun prependListener(event: String /* "removeListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun prependListener(event: String /* "multipleResolves" */, listener: (type: dynamic /* String /* "resolve" */ | String /* "reject" */ */, promise: Promise<Any>, value: Any) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "beforeExit" */, listener: (code: Number) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "disconnect" */, listener: () -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "exit" */, listener: (code: Number) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "rejectionHandled" */, listener: (promise: Promise<Any>) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "uncaughtException" */, listener: (error: Error) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "unhandledRejection" */, listener: (reason: Any, promise: Promise<Any>) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "warning" */, listener: (warning: Error) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "message" */, listener: (message: Any, sendHandle: Any) -> Unit): Process /* this */
    override fun prependOnceListener(event: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */, listener: (signal: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "newListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "removeListener" */, listener: (type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit): Process /* this */
    fun prependOnceListener(event: String /* "multipleResolves" */, listener: (type: dynamic /* String /* "resolve" */ | String /* "reject" */ */, promise: Promise<Any>, value: Any) -> Unit): Process /* this */
    override fun listeners(event: String /* "beforeExit" */): Array<(code: Number) -> Unit>
    override fun listeners(event: String /* "disconnect" */): Array<() -> Unit>
    override fun listeners(event: String /* "exit" */): Array<(code: Number) -> Unit>
    override fun listeners(event: String /* "rejectionHandled" */): Array<(promise: Promise<Any>) -> Unit>
    override fun listeners(event: String /* "uncaughtException" */): Array<(error: Error) -> Unit>
    override fun listeners(event: String /* "unhandledRejection" */): Array<(reason: Any, promise: Promise<Any>) -> Unit>
    override fun listeners(event: String /* "warning" */): Array<(warning: Error) -> Unit>
    override fun listeners(event: String /* "message" */): Array<(message: Any, sendHandle: Any) -> Unit>
    override fun listeners(event: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */): Array<(signal: dynamic /* String /* "SIGABRT" */ | String /* "SIGALRM" */ | String /* "SIGBUS" */ | String /* "SIGCHLD" */ | String /* "SIGCONT" */ | String /* "SIGFPE" */ | String /* "SIGHUP" */ | String /* "SIGILL" */ | String /* "SIGINT" */ | String /* "SIGIO" */ | String /* "SIGIOT" */ | String /* "SIGKILL" */ | String /* "SIGPIPE" */ | String /* "SIGPOLL" */ | String /* "SIGPROF" */ | String /* "SIGPWR" */ | String /* "SIGQUIT" */ | String /* "SIGSEGV" */ | String /* "SIGSTKFLT" */ | String /* "SIGSTOP" */ | String /* "SIGSYS" */ | String /* "SIGTERM" */ | String /* "SIGTRAP" */ | String /* "SIGTSTP" */ | String /* "SIGTTIN" */ | String /* "SIGTTOU" */ | String /* "SIGUNUSED" */ | String /* "SIGURG" */ | String /* "SIGUSR1" */ | String /* "SIGUSR2" */ | String /* "SIGVTALRM" */ | String /* "SIGWINCH" */ | String /* "SIGXCPU" */ | String /* "SIGXFSZ" */ | String /* "SIGBREAK" */ | String /* "SIGLOST" */ | String /* "SIGINFO" */ */) -> Unit>
    override fun listeners(event: String /* "newListener" */): Array<(type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit>
    override fun listeners(event: String /* "removeListener" */): Array<(type: dynamic /* String | Any? */, listener: (args: Any) -> Unit) -> Unit>
    override fun listeners(event: String /* "multipleResolves" */): Array<(type: dynamic /* String /* "resolve" */ | String /* "reject" */ */, promise: Promise<Any>, value: Any) -> Unit>
    fun kill(pid: Number)
}
external interface `T$7` {
    var prototype: Buffer
    fun from(arrayBuffer: SharedArrayBuffer, byteOffset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */): Buffer
    fun from(arrayBuffer: ArrayBuffer, byteOffset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */): Buffer
    fun from(data: Array<Any>): Buffer
    fun from(data: Uint8Array): Buffer
    fun from(str: String, encoding: String? = definedExternally /* null */): Buffer
    fun of(vararg items: Number): Buffer
    fun isBuffer(obj: Any): Boolean
    fun isEncoding(encoding: String): Boolean
    fun byteLength(string: dynamic /* String | SharedArrayBuffer | Uint8Array | ArrayBuffer | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, encoding: String? = definedExternally /* null */): Number
    fun concat(list: Array<Uint8Array>, totalLength: Number? = definedExternally /* null */): Buffer
    fun compare(buf1: Uint8Array, buf2: Uint8Array): Number
    fun alloc(size: Number, fill: String? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Buffer
    fun alloc(size: Number, fill: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Buffer
    fun alloc(size: Number, fill: Buffer? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Buffer
    fun allocUnsafe(size: Number): Buffer
    fun allocUnsafeSlow(size: Number): Buffer
    var poolSize: Number
    fun alloc(size: Number): Buffer
}
external interface Global {
//    var Array: ArrayConstructor
//    var ArrayBuffer: ArrayBufferConstructor
//    var Boolean: BooleanConstructor
    var Buffer: `T$7`
//    var DataView: DataViewConstructor
//    var Date: DateConstructor
    var Error: ErrorConstructor
//    var EvalError: EvalErrorConstructor
//    var Float32Array: Float32ArrayConstructor
//    var Float64Array: Float64ArrayConstructor
//    var Function: FunctionConstructor
    var GLOBAL: Global
    var Infinity: Number
//    var Int16Array: Int16ArrayConstructor
//    var Int32Array: Int32ArrayConstructor
//    var Int8Array: Int8ArrayConstructor
    var Intl: Any?
    var JSON: JSON
    var Map: MapConstructor
//    var Math: Math
    var NaN: Number
//    var Number: NumberConstructor
//    var Object: ObjectConstructor
    var Promise: Function<*>
//    var RangeError: RangeErrorConstructor
//    var ReferenceError: ReferenceErrorConstructor
//    var RegExp: RegExpConstructor
    var Set: SetConstructor
//    var String: StringConstructor
    var Symbol: Function<*>
//    var SyntaxError: SyntaxErrorConstructor
//    var TypeError: TypeErrorConstructor
//    var URIError: URIErrorConstructor
//    var Uint16Array: Uint16ArrayConstructor
//    var Uint32Array: Uint32ArrayConstructor
//    var Uint8Array: Uint8ArrayConstructor
    var Uint8ClampedArray: Function<*>
    var WeakMap: WeakMapConstructor
    var WeakSet: WeakSetConstructor
    var clearImmediate: (immediateId: Immediate) -> Unit
    var clearInterval: (intervalId: Timeout) -> Unit
    var clearTimeout: (timeoutId: Timeout) -> Unit
    var console: Console
    var decodeURI: Any?
    var decodeURIComponent: Any?
    var encodeURI: Any?
    var encodeURIComponent: Any?
    var escape: (str: String) -> String
    var eval: Any?
    var global: Global
    var isFinite: Any?
    var isNaN: Any?
    var parseFloat: Any?
    var parseInt: Any?
    var process: Process
    var root: Global
    var setImmediate: (callback: (args: Any) -> Unit, args: Any) -> Immediate
    var setInterval: (callback: (args: Any) -> Unit, ms: Number, args: Any) -> Timeout
    var setTimeout: (callback: (args: Any) -> Unit, ms: Number, args: Any) -> Timeout
    var undefined: dynamic /* "TypeQuery" kind unsupported yet here! (index.d.ts:1025:19 to 1025:36) */
    var unescape: (str: String) -> String
    var gc: () -> Unit
    var v8debug: Any? get() = definedExternally; set(value) = definedExternally
}
external interface Timer {
    fun ref()
    fun refresh()
    fun unref()
}
open external class Immediate {
    open fun ref(): Unit = definedExternally
    open fun unref(): Unit = definedExternally
    open var _onImmediate: Function<*> = definedExternally
}
open external class Timeout : Timer {
    override fun ref(): Unit = definedExternally
    override fun refresh(): Unit = definedExternally
    override fun unref(): Unit = definedExternally
}
@JsModule("module")
open external class Module(id: String, parent: Module? = definedExternally /* null */) {
    open var exports: Any = definedExternally
    open var require: NodeRequireFunction = definedExternally
    open var id: String = definedExternally
    open var filename: String = definedExternally
    open var loaded: Boolean = definedExternally
    open var parent: Module? = definedExternally
    open var children: Array<Module> = definedExternally
    open var paths: Array<String> = definedExternally
    companion object {
        fun runMain(): Unit = definedExternally
        fun wrap(code: String): String = definedExternally
        fun createRequireFromPath(path: String): (path: String) -> Any = definedExternally
        var builtinModules: Array<String> = definedExternally
        var Module: Any? = definedExternally
    }
}

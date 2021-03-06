@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")

package js.node.events

import js.node.EventEmitter
import kotlin.js.*

@JsModule("events")
open external class internal : EventEmitter {
    open class EventEmitter : internal {
        override fun addListener(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun addListener(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun on(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun on(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun once(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun once(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun prependListener(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun prependListener(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun prependOnceListener(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun removeListener(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun removeListener(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun off(event: String, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun off(event: Any?, listener: (args: Any) -> Unit): EventEmitter /* this */ = definedExternally
        override fun removeAllListeners(event: String?): EventEmitter /* this */ = definedExternally
        override fun removeAllListeners(event: Any?): EventEmitter /* this */ = definedExternally
        override fun setMaxListeners(n: Number): EventEmitter /* this */ = definedExternally
        override fun getMaxListeners(): Number = definedExternally
        override fun listeners(event: String): Array<Function<*>> = definedExternally
        override fun listeners(event: Any?): Array<Function<*>> = definedExternally
        override fun rawListeners(event: String): Array<Function<*>> = definedExternally
        override fun rawListeners(event: Any?): Array<Function<*>> = definedExternally
        override fun emit(event: String, vararg args: Any): Boolean = definedExternally
        override fun emit(event: Any?, vararg args: Any): Boolean = definedExternally
        override fun eventNames(): Array<dynamic /* String | Any? */> = definedExternally
        override fun listenerCount(type: String): Number = definedExternally
        override fun listenerCount(type: Any?): Number = definedExternally
        companion object {
            fun listenerCount(emitter: EventEmitter, event: String): Number = definedExternally
            fun listenerCount(emitter: EventEmitter, event: Any?): Number = definedExternally
            var defaultMaxListeners: Number = definedExternally
        }
        override fun removeAllListeners(): EventEmitter /* this */ = definedExternally
    }
}

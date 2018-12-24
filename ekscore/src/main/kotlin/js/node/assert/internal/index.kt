@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("assert")
package js.node.assert.internal

import kotlin.js.Promise
import kotlin.js.RegExp
import js.node.Error

external interface `T$114` {
    var message: String? get() = definedExternally; set(value) = definedExternally
    var actual: Any? get() = definedExternally; set(value) = definedExternally
    var expected: Any? get() = definedExternally; set(value) = definedExternally
    var operator: String? get() = definedExternally; set(value) = definedExternally
    var stackStartFn: Function<*>? get() = definedExternally; set(value) = definedExternally
}
open external class AssertionError(options: `T$114`? = definedExternally /* null */) : Error {
    override var stack: String? get() = definedExternally //To change initializer of created properties use File | Settings | File Templates.
    var name: String = definedExternally
    var message: String = definedExternally
    open var actual: Any = definedExternally
    open var expected: Any = definedExternally
    open var operator: String = definedExternally
    open var generatedMessage: Boolean = definedExternally
    open var code: String /* "ERR_ASSERTION" */ = definedExternally
}
external fun fail(message: String? = definedExternally /* null */): Any? = definedExternally
external fun fail(message: Error? = definedExternally /* null */): Any? = definedExternally
external fun fail(actual: Any, expected: Any, message: String? = definedExternally /* null */, operator: String? = definedExternally /* null */, stackStartFn: Function<*>? = definedExternally /* null */): Any? = definedExternally
external fun fail(actual: Any, expected: Any, message: Error? = definedExternally /* null */, operator: String? = definedExternally /* null */, stackStartFn: Function<*>? = definedExternally /* null */): Any? = definedExternally
external fun ok(value: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun ok(value: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun equal(actual: Any, expected: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun equal(actual: Any, expected: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun notEqual(actual: Any, expected: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun notEqual(actual: Any, expected: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun deepEqual(actual: Any, expected: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun deepEqual(actual: Any, expected: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun notDeepEqual(actual: Any, expected: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun notDeepEqual(actual: Any, expected: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun strictEqual(actual: Any, expected: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun strictEqual(actual: Any, expected: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun notStrictEqual(actual: Any, expected: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun notStrictEqual(actual: Any, expected: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun deepStrictEqual(actual: Any, expected: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun deepStrictEqual(actual: Any, expected: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun notDeepStrictEqual(actual: Any, expected: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun notDeepStrictEqual(actual: Any, expected: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, message: String? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, error: Any, message: String? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, error: Any, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, error: Function<*>, message: String? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, error: Function<*>, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, error: RegExp, message: String? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, error: RegExp, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, error: Error, message: String? = definedExternally /* null */): Unit = definedExternally
external fun throws(block: Function<*>, error: Error, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun doesNotThrow(block: Function<*>, message: String? = definedExternally /* null */): Unit = definedExternally
external fun doesNotThrow(block: Function<*>, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun doesNotThrow(block: Function<*>, error: Function<*>, message: String? = definedExternally /* null */): Unit = definedExternally
external fun doesNotThrow(block: Function<*>, error: Function<*>, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun doesNotThrow(block: Function<*>, error: RegExp, message: String? = definedExternally /* null */): Unit = definedExternally
external fun doesNotThrow(block: Function<*>, error: RegExp, message: Error? = definedExternally /* null */): Unit = definedExternally
external fun ifError(value: Any): Unit = definedExternally
external fun rejects(block: Function<*>, message: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Function<*>, message: Error? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Promise<Any>, message: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Promise<Any>, message: Error? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Function<*>, error: Any, message: dynamic /* String? | Error? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Function<*>, error: Function<*>, message: dynamic /* String? | Error? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Function<*>, error: RegExp, message: dynamic /* String? | Error? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Function<*>, error: Error, message: dynamic /* String? | Error? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Promise<Any>, error: Any, message: dynamic /* String? | Error? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Promise<Any>, error: Function<*>, message: dynamic /* String? | Error? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Promise<Any>, error: RegExp, message: dynamic /* String? | Error? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rejects(block: Promise<Any>, error: Error, message: dynamic /* String? | Error? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Function<*>, message: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Function<*>, message: Error? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Promise<Any>, message: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Promise<Any>, message: Error? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Function<*>, error: Function<*>, message: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Function<*>, error: Function<*>, message: Error? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Function<*>, error: RegExp, message: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Function<*>, error: RegExp, message: Error? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Promise<Any>, error: Function<*>, message: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Promise<Any>, error: Function<*>, message: Error? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Promise<Any>, error: RegExp, message: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun doesNotReject(block: Promise<Any>, error: RegExp, message: Error? = definedExternally /* null */): Promise<Unit> = definedExternally
external var strict: Any? = definedExternally
external fun fail(): Any? = definedExternally
external fun fail(actual: Any, expected: Any): Any? = definedExternally
external fun ok(value: Any): Unit = definedExternally
external fun equal(actual: Any, expected: Any): Unit = definedExternally
external fun notEqual(actual: Any, expected: Any): Unit = definedExternally
external fun deepEqual(actual: Any, expected: Any): Unit = definedExternally
external fun notDeepEqual(actual: Any, expected: Any): Unit = definedExternally
external fun strictEqual(actual: Any, expected: Any): Unit = definedExternally
external fun notStrictEqual(actual: Any, expected: Any): Unit = definedExternally
external fun deepStrictEqual(actual: Any, expected: Any): Unit = definedExternally
external fun notDeepStrictEqual(actual: Any, expected: Any): Unit = definedExternally
external fun throws(block: Function<*>): Unit = definedExternally
external fun throws(block: Function<*>, error: Any): Unit = definedExternally
external fun throws(block: Function<*>, error: Function<*>): Unit = definedExternally
external fun throws(block: Function<*>, error: RegExp): Unit = definedExternally
external fun throws(block: Function<*>, error: Error): Unit = definedExternally
external fun doesNotThrow(block: Function<*>): Unit = definedExternally
external fun doesNotThrow(block: Function<*>, error: Function<*>): Unit = definedExternally
external fun doesNotThrow(block: Function<*>, error: RegExp): Unit = definedExternally
external fun rejects(block: Function<*>): Promise<Unit> = definedExternally
external fun rejects(block: Promise<Any>): Promise<Unit> = definedExternally
external fun doesNotReject(block: Function<*>): Promise<Unit> = definedExternally
external fun doesNotReject(block: Promise<Any>): Promise<Unit> = definedExternally
external fun doesNotReject(block: Function<*>, error: Function<*>): Promise<Unit> = definedExternally
external fun doesNotReject(block: Function<*>, error: RegExp): Promise<Unit> = definedExternally
external fun doesNotReject(block: Promise<Any>, error: Function<*>): Promise<Unit> = definedExternally
external fun doesNotReject(block: Promise<Any>, error: RegExp): Promise<Unit> = definedExternally

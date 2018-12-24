@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("timers")
package js.node.timers

import js.node.Immediate
import js.node.Timeout
import kotlin.js.*

external fun setTimeout(callback: (args: Any) -> Unit, ms: Number, vararg args: Any): Timeout = definedExternally
external fun clearTimeout(timeoutId: Timeout): Unit = definedExternally
external fun setInterval(callback: (args: Any) -> Unit, ms: Number, vararg args: Any): Timeout = definedExternally
external fun clearInterval(intervalId: Timeout): Unit = definedExternally
external fun setImmediate(callback: (args: Any) -> Unit, vararg args: Any): Immediate = definedExternally
external fun clearImmediate(immediateId: Immediate): Unit = definedExternally

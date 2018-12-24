@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("querystring")
package js.node.querystring

import kotlin.js.*

external interface StringifyOptions {
    var encodeURIComponent: Function<*>? get() = definedExternally; set(value) = definedExternally
}
external interface ParseOptions {
    var maxKeys: Number? get() = definedExternally; set(value) = definedExternally
    var decodeURIComponent: Function<*>? get() = definedExternally; set(value) = definedExternally
}
@Suppress("deprecation")
external interface ParsedUrlQuery {
    @nativeGetter
    operator fun get(key: String): dynamic /* String | Array<String> */
    @nativeSetter
    operator fun set(key: String, value: String)
    @nativeSetter
    operator fun set(key: String, value: Array<String>)
}
external fun stringify(obj: Any? = definedExternally /* null */, sep: String? = definedExternally /* null */, eq: String? = definedExternally /* null */, options: StringifyOptions? = definedExternally /* null */): String = definedExternally
external fun parse(str: String, sep: String? = definedExternally /* null */, eq: String? = definedExternally /* null */, options: ParseOptions? = definedExternally /* null */): ParsedUrlQuery = definedExternally
external fun escape(str: String): String = definedExternally
external fun unescape(str: String): String = definedExternally

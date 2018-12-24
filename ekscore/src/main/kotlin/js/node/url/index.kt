@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("url")
package js.node.url

import js.node.IterableIterator
import js.node.Iterable
import js.node.querystring.ParsedUrlQuery
import kotlin.js.*

external interface UrlObjectCommon {
    var auth: String? get() = definedExternally; set(value) = definedExternally
    var hash: String? get() = definedExternally; set(value) = definedExternally
    var host: String? get() = definedExternally; set(value) = definedExternally
    var hostname: String? get() = definedExternally; set(value) = definedExternally
    var href: String? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var pathname: String? get() = definedExternally; set(value) = definedExternally
    var protocol: String? get() = definedExternally; set(value) = definedExternally
    var search: String? get() = definedExternally; set(value) = definedExternally
    var slashes: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface UrlObject : UrlObjectCommon {
    var port: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var query: dynamic /* String | Json | Nothing? */ get() = definedExternally; set(value) = definedExternally
}
external interface Url : UrlObjectCommon {
    var port: String? get() = definedExternally; set(value) = definedExternally
    var query: dynamic /* String | querystring.ParsedUrlQuery | Nothing? */ get() = definedExternally; set(value) = definedExternally
}
external interface UrlWithParsedQuery : Url {
    override var query: ParsedUrlQuery
}
external interface UrlWithStringQuery : Url {
    override var query: String?
}
external fun parse(urlStr: String): UrlWithStringQuery = definedExternally
external fun parse(urlStr: String, parseQueryString: Boolean?, slashesDenoteHost: Boolean? = definedExternally /* null */): UrlWithStringQuery = definedExternally
external fun parse(urlStr: String, parseQueryString: Boolean, slashesDenoteHost: Boolean? = definedExternally /* null */): UrlWithParsedQuery = definedExternally
external fun parse(urlStr: String, parseQueryString: Boolean, slashesDenoteHost: Boolean? = definedExternally /* null */): Url = definedExternally
external fun format(URL: URL, options: URLFormatOptions? = definedExternally /* null */): String = definedExternally
external fun format(urlObject: String): String = definedExternally
external fun format(urlObject: UrlObject): String = definedExternally
external fun resolve(from: String, to: String): String = definedExternally
external fun domainToASCII(domain: String): String = definedExternally
external fun domainToUnicode(domain: String): String = definedExternally
external fun fileURLToPath(url: String): String = definedExternally
external fun fileURLToPath(url: URL): String = definedExternally
external fun pathToFileURL(url: String): URL = definedExternally
external interface URLFormatOptions {
    var auth: Boolean? get() = definedExternally; set(value) = definedExternally
    var fragment: Boolean? get() = definedExternally; set(value) = definedExternally
    var search: Boolean? get() = definedExternally; set(value) = definedExternally
    var unicode: Boolean? get() = definedExternally; set(value) = definedExternally
}
@Suppress("UNREACHABLE_CODE")
open external class URL {
    constructor(input: String, base: String? = definedExternally /* null */)
    constructor(input: String, base: URL? = definedExternally /* null */)
    open var hash: String = definedExternally
    open var host: String = definedExternally
    open var hostname: String = definedExternally
    open var href: String = definedExternally
    open var origin: String = definedExternally
    open var password: String = definedExternally
    open var pathname: String = definedExternally
    open var port: String = definedExternally
    open var protocol: String = definedExternally
    open var search: String = definedExternally
    open var searchParams: URLSearchParams = definedExternally
    open var username: String = definedExternally
    override fun toString(): String = definedExternally
    open fun toJSON(): String = definedExternally
}
@Suppress("deprecation")
external interface `T$36` {
    @nativeGetter
    operator fun get(key: String): dynamic /* String | Array<String> */
    @nativeSetter
    operator fun set(key: String, value: String)
    @nativeSetter
    operator fun set(key: String, value: Array<String>)
}
open external class URLSearchParams : Iterable<dynamic /* JsTuple<String, String> */> {
    constructor(init: String? = definedExternally /* null */)
    constructor(init: Array<dynamic /* JsTuple<String, String> */>? = definedExternally /* null */)
    constructor(init: URLSearchParams? = definedExternally /* null */)
    constructor(init: Iterable<dynamic /* JsTuple<String, String> */>? = definedExternally /* null */)
    constructor(init: `T$36`? = definedExternally /* null */)
    open fun append(name: String, value: String): Unit = definedExternally
    open fun delete(name: String): Unit = definedExternally
    open fun entries(): IterableIterator<dynamic /* JsTuple<String, String> */> = definedExternally
    open fun forEach(callback: (value: String, name: String, searchParams: URLSearchParams /* this */) -> Unit): Unit = definedExternally
    open fun get(name: String): String? = definedExternally
    open fun getAll(name: String): Array<String> = definedExternally
    open fun has(name: String): Boolean = definedExternally
    open fun keys(): IterableIterator<String> = definedExternally
    open fun set(name: String, value: String): Unit = definedExternally
    open fun sort(): Unit = definedExternally
    override fun toString(): String = definedExternally
    open fun values(): IterableIterator<String> = definedExternally
    open fun iterator(): Iterator<dynamic> = definedExternally
}

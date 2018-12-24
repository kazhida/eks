@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("tty")
package js.node.tty

import js.node.net.Socket
import kotlin.js.*

external fun isatty(fd: Number): Boolean = definedExternally
open external class ReadStream : Socket {
    open var isRaw: Boolean = definedExternally
    open fun setRawMode(mode: Boolean): Unit = definedExternally
    open var isTTY: Boolean = definedExternally
}
open external class WriteStream : Socket {
    open var columns: Number = definedExternally
    open var rows: Number = definedExternally
    open var isTTY: Boolean = definedExternally
}

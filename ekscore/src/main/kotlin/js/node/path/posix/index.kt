@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("path") JsQualifier("posix")]
package js.node.path.posix

import js.node.path.FormatInputPathObject
import js.node.path.ParsedPath
import kotlin.js.*

external fun normalize(p: String): String = definedExternally
external fun join(vararg paths: Any): String = definedExternally
external fun resolve(vararg pathSegments: Any): String = definedExternally
external fun isAbsolute(p: String): Boolean = definedExternally
external fun relative(from: String, to: String): String = definedExternally
external fun dirname(p: String): String = definedExternally
external fun basename(p: String, ext: String? = definedExternally /* null */): String = definedExternally
external fun extname(p: String): String = definedExternally
external var sep: String = definedExternally
external var delimiter: String = definedExternally
external fun parse(p: String): ParsedPath = definedExternally
external fun format(pP: FormatInputPathObject): String = definedExternally

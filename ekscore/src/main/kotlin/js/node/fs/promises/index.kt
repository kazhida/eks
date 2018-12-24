@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("fs") JsQualifier("promises")]
package js.node.fs.promises

import js.node.Buffer
import js.node.fs.Stats
import js.node.url.URL
import kotlin.js.*

external interface `T$83` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var mode: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var flag: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
}
external interface `T$84`<TBuffer> {
    var bytesRead: Number
    var buffer: TBuffer
}
external interface `T$85` {
    var encoding: Nothing? get() = definedExternally; set(value) = definedExternally
    var flag: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
}
external interface `T$86` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */
    var flag: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
}
external interface `T$87` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var flag: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
}
external interface `T$88`<TBuffer> {
    var bytesWritten: Number
    var buffer: TBuffer
}
external interface `T$89` {
    var bytesWritten: Number
    var buffer: String
}
external interface FileHandle {
    var fd: Number
    fun appendFile(data: Any, options: String? = definedExternally /* null */): Promise<Unit>
    fun appendFile(data: Any, options: `T$83`? = definedExternally /* null */): Promise<Unit>
    fun appendFile(data: Any, options: Nothing? = definedExternally /* null */): Promise<Unit>
    fun chown(uid: Number, gid: Number): Promise<Unit>
    fun chmod(mode: String): Promise<Unit>
    fun chmod(mode: Number): Promise<Unit>
    fun datasync(): Promise<Unit>
    fun sync(): Promise<Unit>
    fun <TBuffer /* Buffer | Uint8Array */> read(buffer: TBuffer, offset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */, position: Number? = definedExternally /* null */): Promise<`T$84`<TBuffer>>
    fun readFile(options: `T$85`? = definedExternally /* null */): Promise<Buffer>
    fun readFile(options: String /* "ascii" */): Promise<String>
    fun readFile(options: String /* "utf8" */): Promise<String>
    fun readFile(options: String /* "utf16le" */): Promise<String>
    fun readFile(options: String /* "ucs2" */): Promise<String>
    fun readFile(options: String /* "base64" */): Promise<String>
    fun readFile(options: String /* "latin1" */): Promise<String>
    fun readFile(options: String /* "binary" */): Promise<String>
    fun readFile(options: String /* "hex" */): Promise<String>
    fun readFile(options: `T$86`): Promise<String>
    fun readFile(options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */>
    fun readFile(options: `T$87`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */>
    fun readFile(options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */>
    fun stat(): Promise<Stats>
    fun truncate(len: Number? = definedExternally /* null */): Promise<Unit>
    fun utimes(atime: String, mtime: String): Promise<Unit>
    fun utimes(atime: String, mtime: Number): Promise<Unit>
    fun utimes(atime: String, mtime: Date): Promise<Unit>
    fun utimes(atime: Number, mtime: String): Promise<Unit>
    fun utimes(atime: Number, mtime: Number): Promise<Unit>
    fun utimes(atime: Number, mtime: Date): Promise<Unit>
    fun utimes(atime: Date, mtime: String): Promise<Unit>
    fun utimes(atime: Date, mtime: Number): Promise<Unit>
    fun utimes(atime: Date, mtime: Date): Promise<Unit>
    fun <TBuffer /* Buffer | Uint8Array */> write(buffer: TBuffer, offset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */, position: Number? = definedExternally /* null */): Promise<`T$88`<TBuffer>>
    fun write(data: Any, position: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Promise<`T$89`>
    fun writeFile(data: Any, options: String? = definedExternally /* null */): Promise<Unit>
    fun writeFile(data: Any, options: `T$83`? = definedExternally /* null */): Promise<Unit>
    fun writeFile(data: Any, options: Nothing? = definedExternally /* null */): Promise<Unit>
    fun close(): Promise<Unit>
    fun appendFile(data: Any): Promise<Unit>
    fun readFile(): Promise<dynamic /* String | Buffer */>
    fun writeFile(data: Any): Promise<Unit>
}
external fun access(path: String, mode: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun access(path: Buffer, mode: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun access(path: URL, mode: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun copyFile(src: String, dest: String, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun copyFile(src: String, dest: Buffer, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun copyFile(src: String, dest: URL, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun copyFile(src: Buffer, dest: String, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun copyFile(src: Buffer, dest: Buffer, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun copyFile(src: Buffer, dest: URL, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun copyFile(src: URL, dest: String, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun copyFile(src: URL, dest: Buffer, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun copyFile(src: URL, dest: URL, flags: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun open(path: String, flags: String, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<FileHandle> = definedExternally
external fun open(path: String, flags: Number, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<FileHandle> = definedExternally
external fun open(path: Buffer, flags: String, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<FileHandle> = definedExternally
external fun open(path: Buffer, flags: Number, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<FileHandle> = definedExternally
external fun open(path: URL, flags: String, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<FileHandle> = definedExternally
external fun open(path: URL, flags: Number, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Promise<FileHandle> = definedExternally
external fun <TBuffer /* Buffer | Uint8Array */> read(handle: FileHandle, buffer: TBuffer, offset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */, position: Number? = definedExternally /* null */): Promise<`T$84`<TBuffer>> = definedExternally
external fun <TBuffer /* Buffer | Uint8Array */> write(handle: FileHandle, buffer: TBuffer, offset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */, position: Number? = definedExternally /* null */): Promise<`T$88`<TBuffer>> = definedExternally
external fun write(handle: FileHandle, string: Any, position: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Promise<`T$89`> = definedExternally
external fun rename(oldPath: String, newPath: String): Promise<Unit> = definedExternally
external fun rename(oldPath: String, newPath: Buffer): Promise<Unit> = definedExternally
external fun rename(oldPath: String, newPath: URL): Promise<Unit> = definedExternally
external fun rename(oldPath: Buffer, newPath: String): Promise<Unit> = definedExternally
external fun rename(oldPath: Buffer, newPath: Buffer): Promise<Unit> = definedExternally
external fun rename(oldPath: Buffer, newPath: URL): Promise<Unit> = definedExternally
external fun rename(oldPath: URL, newPath: String): Promise<Unit> = definedExternally
external fun rename(oldPath: URL, newPath: Buffer): Promise<Unit> = definedExternally
external fun rename(oldPath: URL, newPath: URL): Promise<Unit> = definedExternally
external fun truncate(path: String, len: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun truncate(path: Buffer, len: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun truncate(path: URL, len: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun ftruncate(handle: FileHandle, len: Number? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun rmdir(path: String): Promise<Unit> = definedExternally
external fun rmdir(path: Buffer): Promise<Unit> = definedExternally
external fun rmdir(path: URL): Promise<Unit> = definedExternally
external fun fdatasync(handle: FileHandle): Promise<Unit> = definedExternally
external fun fsync(handle: FileHandle): Promise<Unit> = definedExternally
external fun mkdir(path: String, options: dynamic /* String? | Number? | fs.MakeDirectoryOptions? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun mkdir(path: Buffer, options: dynamic /* String? | Number? | fs.MakeDirectoryOptions? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun mkdir(path: URL, options: dynamic /* String? | Number? | fs.MakeDirectoryOptions? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external interface `T$90` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */ get() = definedExternally; set(value) = definedExternally
}
external fun readdir(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$90`? | Nothing? */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external fun readdir(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$90`? | Nothing? */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external fun readdir(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$90`? | Nothing? */ = definedExternally /* null */): Promise<Array<String>> = definedExternally
external interface `T$91` {
    var encoding: String /* "buffer" */
}
external fun readdir(path: String, options: String /* "buffer" */): Promise<Array<Buffer>> = definedExternally
external fun readdir(path: String, options: `T$91`): Promise<Array<Buffer>> = definedExternally
external fun readdir(path: Buffer, options: String /* "buffer" */): Promise<Array<Buffer>> = definedExternally
external fun readdir(path: Buffer, options: `T$91`): Promise<Array<Buffer>> = definedExternally
external fun readdir(path: URL, options: String /* "buffer" */): Promise<Array<Buffer>> = definedExternally
external fun readdir(path: URL, options: `T$91`): Promise<Array<Buffer>> = definedExternally
external interface `T$92` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
}
external fun readdir(path: String, options: String? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: String, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: String, options: Nothing? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: Buffer, options: String? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: Buffer, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: Buffer, options: Nothing? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: URL, options: String? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: URL, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: URL, options: Nothing? = definedExternally /* null */): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readlink(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$90`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun readlink(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$90`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun readlink(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$90`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun readlink(path: String, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun readlink(path: String, options: `T$91`): Promise<Buffer> = definedExternally
external fun readlink(path: Buffer, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun readlink(path: Buffer, options: `T$91`): Promise<Buffer> = definedExternally
external fun readlink(path: URL, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun readlink(path: URL, options: `T$91`): Promise<Buffer> = definedExternally
external fun readlink(path: String, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: String, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: String, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: Buffer, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: Buffer, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: Buffer, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: URL, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: URL, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: URL, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun symlink(target: String, path: String, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun symlink(target: String, path: Buffer, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun symlink(target: String, path: URL, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun symlink(target: Buffer, path: String, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun symlink(target: Buffer, path: Buffer, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun symlink(target: Buffer, path: URL, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun symlink(target: URL, path: String, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun symlink(target: URL, path: Buffer, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun symlink(target: URL, path: URL, type: String? = definedExternally /* null */): Promise<Unit> = definedExternally
external fun fstat(handle: FileHandle): Promise<Stats> = definedExternally
external fun lstat(path: String): Promise<Stats> = definedExternally
external fun lstat(path: Buffer): Promise<Stats> = definedExternally
external fun lstat(path: URL): Promise<Stats> = definedExternally
external fun stat(path: String): Promise<Stats> = definedExternally
external fun stat(path: Buffer): Promise<Stats> = definedExternally
external fun stat(path: URL): Promise<Stats> = definedExternally
external fun link(existingPath: String, newPath: String): Promise<Unit> = definedExternally
external fun link(existingPath: String, newPath: Buffer): Promise<Unit> = definedExternally
external fun link(existingPath: String, newPath: URL): Promise<Unit> = definedExternally
external fun link(existingPath: Buffer, newPath: String): Promise<Unit> = definedExternally
external fun link(existingPath: Buffer, newPath: Buffer): Promise<Unit> = definedExternally
external fun link(existingPath: Buffer, newPath: URL): Promise<Unit> = definedExternally
external fun link(existingPath: URL, newPath: String): Promise<Unit> = definedExternally
external fun link(existingPath: URL, newPath: Buffer): Promise<Unit> = definedExternally
external fun link(existingPath: URL, newPath: URL): Promise<Unit> = definedExternally
external fun unlink(path: String): Promise<Unit> = definedExternally
external fun unlink(path: Buffer): Promise<Unit> = definedExternally
external fun unlink(path: URL): Promise<Unit> = definedExternally
external fun fchmod(handle: FileHandle, mode: String): Promise<Unit> = definedExternally
external fun fchmod(handle: FileHandle, mode: Number): Promise<Unit> = definedExternally
external fun chmod(path: String, mode: String): Promise<Unit> = definedExternally
external fun chmod(path: String, mode: Number): Promise<Unit> = definedExternally
external fun chmod(path: Buffer, mode: String): Promise<Unit> = definedExternally
external fun chmod(path: Buffer, mode: Number): Promise<Unit> = definedExternally
external fun chmod(path: URL, mode: String): Promise<Unit> = definedExternally
external fun chmod(path: URL, mode: Number): Promise<Unit> = definedExternally
external fun lchmod(path: String, mode: String): Promise<Unit> = definedExternally
external fun lchmod(path: String, mode: Number): Promise<Unit> = definedExternally
external fun lchmod(path: Buffer, mode: String): Promise<Unit> = definedExternally
external fun lchmod(path: Buffer, mode: Number): Promise<Unit> = definedExternally
external fun lchmod(path: URL, mode: String): Promise<Unit> = definedExternally
external fun lchmod(path: URL, mode: Number): Promise<Unit> = definedExternally
external fun lchown(path: String, uid: Number, gid: Number): Promise<Unit> = definedExternally
external fun lchown(path: Buffer, uid: Number, gid: Number): Promise<Unit> = definedExternally
external fun lchown(path: URL, uid: Number, gid: Number): Promise<Unit> = definedExternally
external fun fchown(handle: FileHandle, uid: Number, gid: Number): Promise<Unit> = definedExternally
external fun chown(path: String, uid: Number, gid: Number): Promise<Unit> = definedExternally
external fun chown(path: Buffer, uid: Number, gid: Number): Promise<Unit> = definedExternally
external fun chown(path: URL, uid: Number, gid: Number): Promise<Unit> = definedExternally
external fun utimes(path: String, atime: String, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun utimes(path: String, atime: Number, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun utimes(path: String, atime: Date, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun utimes(path: Buffer, atime: String, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun utimes(path: Buffer, atime: Number, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun utimes(path: Buffer, atime: Date, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun utimes(path: URL, atime: String, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun utimes(path: URL, atime: Number, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun utimes(path: URL, atime: Date, mtime: dynamic /* String | Number | Date */): Promise<Unit> = definedExternally
external fun futimes(handle: FileHandle, atime: String, mtime: String): Promise<Unit> = definedExternally
external fun futimes(handle: FileHandle, atime: String, mtime: Number): Promise<Unit> = definedExternally
external fun futimes(handle: FileHandle, atime: String, mtime: Date): Promise<Unit> = definedExternally
external fun futimes(handle: FileHandle, atime: Number, mtime: String): Promise<Unit> = definedExternally
external fun futimes(handle: FileHandle, atime: Number, mtime: Number): Promise<Unit> = definedExternally
external fun futimes(handle: FileHandle, atime: Number, mtime: Date): Promise<Unit> = definedExternally
external fun futimes(handle: FileHandle, atime: Date, mtime: String): Promise<Unit> = definedExternally
external fun futimes(handle: FileHandle, atime: Date, mtime: Number): Promise<Unit> = definedExternally
external fun futimes(handle: FileHandle, atime: Date, mtime: Date): Promise<Unit> = definedExternally
external fun realpath(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$90`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun realpath(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$90`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun realpath(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$90`? | Nothing? */ = definedExternally /* null */): Promise<String> = definedExternally
external fun realpath(path: String, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun realpath(path: String, options: `T$91`): Promise<Buffer> = definedExternally
external fun realpath(path: Buffer, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun realpath(path: Buffer, options: `T$91`): Promise<Buffer> = definedExternally
external fun realpath(path: URL, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun realpath(path: URL, options: `T$91`): Promise<Buffer> = definedExternally
external fun realpath(path: String, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: String, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: String, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: Buffer, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: Buffer, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: Buffer, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: URL, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: URL, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: URL, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun mkdtemp(prefix: String, options: String? /* "ascii" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: String? /* "utf8" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: String? /* "utf16le" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: String? /* "ucs2" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: String? /* "base64" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: String? /* "latin1" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: String? /* "binary" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: String? /* "hex" */ = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: `T$90`? = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: Nothing? = definedExternally /* null */): Promise<String> = definedExternally
external fun mkdtemp(prefix: String, options: String /* "buffer" */): Promise<Buffer> = definedExternally
external fun mkdtemp(prefix: String, options: `T$91`): Promise<Buffer> = definedExternally
external fun mkdtemp(prefix: String, options: String? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun mkdtemp(prefix: String, options: `T$92`? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun mkdtemp(prefix: String, options: Nothing? = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun writeFile(path: String, data: Any, options: dynamic /* String? | `T$83`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun writeFile(path: Buffer, data: Any, options: dynamic /* String? | `T$83`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun writeFile(path: URL, data: Any, options: dynamic /* String? | `T$83`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun writeFile(path: FileHandle, data: Any, options: dynamic /* String? | `T$83`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun appendFile(path: String, data: Any, options: dynamic /* String? | `T$83`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun appendFile(path: Buffer, data: Any, options: dynamic /* String? | `T$83`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun appendFile(path: URL, data: Any, options: dynamic /* String? | `T$83`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun appendFile(path: FileHandle, data: Any, options: dynamic /* String? | `T$83`? | Nothing? */ = definedExternally /* null */): Promise<Unit> = definedExternally
external fun readFile(path: String, options: `T$85`? = definedExternally /* null */): Promise<Buffer> = definedExternally
external fun readFile(path: Buffer, options: `T$85`? = definedExternally /* null */): Promise<Buffer> = definedExternally
external fun readFile(path: URL, options: `T$85`? = definedExternally /* null */): Promise<Buffer> = definedExternally
external fun readFile(path: FileHandle, options: `T$85`? = definedExternally /* null */): Promise<Buffer> = definedExternally
external fun readFile(path: String, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$86` */): Promise<String> = definedExternally
external fun readFile(path: Buffer, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$86` */): Promise<String> = definedExternally
external fun readFile(path: URL, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$86` */): Promise<String> = definedExternally
external fun readFile(path: FileHandle, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$86` */): Promise<String> = definedExternally
external fun readFile(path: String, options: dynamic /* String? | `T$87`? | Nothing? */ = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readFile(path: Buffer, options: dynamic /* String? | `T$87`? | Nothing? */ = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readFile(path: URL, options: dynamic /* String? | `T$87`? | Nothing? */ = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readFile(path: FileHandle, options: dynamic /* String? | `T$87`? | Nothing? */ = definedExternally /* null */): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readdir(path: String): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: Buffer): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readdir(path: URL): Promise<dynamic /* Array<String> | Array<Buffer> */> = definedExternally
external fun readlink(path: String): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: Buffer): Promise<dynamic /* String | Buffer */> = definedExternally
external fun readlink(path: URL): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: String): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: Buffer): Promise<dynamic /* String | Buffer */> = definedExternally
external fun realpath(path: URL): Promise<dynamic /* String | Buffer */> = definedExternally
external fun mkdtemp(prefix: String): Promise<String> = definedExternally
external fun mkdtemp(prefix: String): Promise<dynamic /* String | Buffer */> = definedExternally

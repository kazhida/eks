@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("fs")
package js.node.fs

import js.node.Buffer
import js.node.ErrnoException
import js.node.events.internal.EventEmitter
import js.node.stream.internal.Readable
import js.node.stream.internal.Writable
import js.node.url.URL
import kotlin.js.*

open external class Stats {
    open fun isFile(): Boolean = definedExternally
    open fun isDirectory(): Boolean = definedExternally
    open fun isBlockDevice(): Boolean = definedExternally
    open fun isCharacterDevice(): Boolean = definedExternally
    open fun isSymbolicLink(): Boolean = definedExternally
    open fun isFIFO(): Boolean = definedExternally
    open fun isSocket(): Boolean = definedExternally
    open var dev: Number = definedExternally
    open var ino: Number = definedExternally
    open var mode: Number = definedExternally
    open var nlink: Number = definedExternally
    open var uid: Number = definedExternally
    open var gid: Number = definedExternally
    open var rdev: Number = definedExternally
    open var size: Number = definedExternally
    open var blksize: Number = definedExternally
    open var blocks: Number = definedExternally
    open var atimeMs: Number = definedExternally
    open var mtimeMs: Number = definedExternally
    open var ctimeMs: Number = definedExternally
    open var birthtimeMs: Number = definedExternally
    open var atime: Date = definedExternally
    open var mtime: Date = definedExternally
    open var ctime: Date = definedExternally
    open var birthtime: Date = definedExternally
}
open external class Dirent {
    open fun isFile(): Boolean = definedExternally
    open fun isDirectory(): Boolean = definedExternally
    open fun isBlockDevice(): Boolean = definedExternally
    open fun isCharacterDevice(): Boolean = definedExternally
    open fun isSymbolicLink(): Boolean = definedExternally
    open fun isFIFO(): Boolean = definedExternally
    open fun isSocket(): Boolean = definedExternally
    open var name: String = definedExternally
}
external interface FSWatcher : EventEmitter {
    fun close()
    override fun addListener(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun addListener(event: String /* "change" */, listener: (eventType: String, filename: dynamic /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun addListener(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
    override fun on(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun on(event: String /* "change" */, listener: (eventType: String, filename: dynamic /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun on(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
    override fun once(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun once(event: String /* "change" */, listener: (eventType: String, filename: dynamic /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun once(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
    override fun prependListener(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun prependListener(event: String /* "change" */, listener: (eventType: String, filename: dynamic /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun prependListener(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): FSWatcher /* this */
    fun prependOnceListener(event: String /* "change" */, listener: (eventType: String, filename: dynamic /* String | Buffer */) -> Unit): FSWatcher /* this */
    fun prependOnceListener(event: String /* "error" */, listener: (error: Error) -> Unit): FSWatcher /* this */
}
open external class ReadStream : Readable {
    open fun close(): Unit = definedExternally
    open var bytesRead: Number = definedExternally
    open var path: dynamic /* String | Buffer */ = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): ReadStream /* this */ = definedExternally
    open fun addListener(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */ = definedExternally
    override fun addListener(event: String /* "close" */, listener: () -> Unit): ReadStream /* this */ = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): ReadStream /* this */ = definedExternally
    open fun on(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */ = definedExternally
    override fun on(event: String /* "close" */, listener: () -> Unit): ReadStream /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): ReadStream /* this */ = definedExternally
    open fun once(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */ = definedExternally
    override fun once(event: String /* "close" */, listener: () -> Unit): ReadStream /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): ReadStream /* this */ = definedExternally
    open fun prependListener(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */ = definedExternally
    override fun prependListener(event: String /* "close" */, listener: () -> Unit): ReadStream /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): ReadStream /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "open" */, listener: (fd: Number) -> Unit): ReadStream /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): ReadStream /* this */ = definedExternally
}
open external class WriteStream : Writable {
    open fun close(): Unit = definedExternally
    open var bytesWritten: Number = definedExternally
    open var path: dynamic /* String | Buffer */ = definedExternally
    override fun addListener(event: String, listener: (args: Any) -> Unit): WriteStream /* this */ = definedExternally
    open fun addListener(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */ = definedExternally
    override fun addListener(event: String /* "close" */, listener: () -> Unit): WriteStream /* this */ = definedExternally
    override fun on(event: String, listener: (args: Any) -> Unit): WriteStream /* this */ = definedExternally
    open fun on(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */ = definedExternally
    override fun on(event: String /* "close" */, listener: () -> Unit): WriteStream /* this */ = definedExternally
    override fun once(event: String, listener: (args: Any) -> Unit): WriteStream /* this */ = definedExternally
    open fun once(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */ = definedExternally
    override fun once(event: String /* "close" */, listener: () -> Unit): WriteStream /* this */ = definedExternally
    override fun prependListener(event: String, listener: (args: Any) -> Unit): WriteStream /* this */ = definedExternally
    open fun prependListener(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */ = definedExternally
    override fun prependListener(event: String /* "close" */, listener: () -> Unit): WriteStream /* this */ = definedExternally
    override fun prependOnceListener(event: String, listener: (args: Any) -> Unit): WriteStream /* this */ = definedExternally
    open fun prependOnceListener(event: String /* "open" */, listener: (fd: Number) -> Unit): WriteStream /* this */ = definedExternally
    override fun prependOnceListener(event: String /* "close" */, listener: () -> Unit): WriteStream /* this */ = definedExternally
}
external fun rename(oldPath: String, newPath: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rename(oldPath: String, newPath: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rename(oldPath: String, newPath: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rename(oldPath: Buffer, newPath: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rename(oldPath: Buffer, newPath: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rename(oldPath: Buffer, newPath: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rename(oldPath: URL, newPath: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rename(oldPath: URL, newPath: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rename(oldPath: URL, newPath: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun renameSync(oldPath: String, newPath: String): Unit = definedExternally
external fun renameSync(oldPath: String, newPath: Buffer): Unit = definedExternally
external fun renameSync(oldPath: String, newPath: URL): Unit = definedExternally
external fun renameSync(oldPath: Buffer, newPath: String): Unit = definedExternally
external fun renameSync(oldPath: Buffer, newPath: Buffer): Unit = definedExternally
external fun renameSync(oldPath: Buffer, newPath: URL): Unit = definedExternally
external fun renameSync(oldPath: URL, newPath: String): Unit = definedExternally
external fun renameSync(oldPath: URL, newPath: Buffer): Unit = definedExternally
external fun renameSync(oldPath: URL, newPath: URL): Unit = definedExternally
external fun truncate(path: String, len: Number?, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun truncate(path: Buffer, len: Number?, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun truncate(path: URL, len: Number?, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun truncate(path: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun truncate(path: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun truncate(path: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun truncateSync(path: String, len: Number? = definedExternally /* null */): Unit = definedExternally
external fun truncateSync(path: Buffer, len: Number? = definedExternally /* null */): Unit = definedExternally
external fun truncateSync(path: URL, len: Number? = definedExternally /* null */): Unit = definedExternally
external fun ftruncate(fd: Number, len: Number?, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun ftruncate(fd: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun ftruncateSync(fd: Number, len: Number? = definedExternally /* null */): Unit = definedExternally
external fun chown(path: String, uid: Number, gid: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun chown(path: Buffer, uid: Number, gid: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun chown(path: URL, uid: Number, gid: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun chownSync(path: String, uid: Number, gid: Number): Unit = definedExternally
external fun chownSync(path: Buffer, uid: Number, gid: Number): Unit = definedExternally
external fun chownSync(path: URL, uid: Number, gid: Number): Unit = definedExternally
external fun fchown(fd: Number, uid: Number, gid: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun fchownSync(fd: Number, uid: Number, gid: Number): Unit = definedExternally
external fun lchown(path: String, uid: Number, gid: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun lchown(path: Buffer, uid: Number, gid: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun lchown(path: URL, uid: Number, gid: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun lchownSync(path: String, uid: Number, gid: Number): Unit = definedExternally
external fun lchownSync(path: Buffer, uid: Number, gid: Number): Unit = definedExternally
external fun lchownSync(path: URL, uid: Number, gid: Number): Unit = definedExternally
external fun chmod(path: String, mode: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun chmod(path: String, mode: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun chmod(path: Buffer, mode: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun chmod(path: Buffer, mode: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun chmod(path: URL, mode: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun chmod(path: URL, mode: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun chmodSync(path: String, mode: String): Unit = definedExternally
external fun chmodSync(path: String, mode: Number): Unit = definedExternally
external fun chmodSync(path: Buffer, mode: String): Unit = definedExternally
external fun chmodSync(path: Buffer, mode: Number): Unit = definedExternally
external fun chmodSync(path: URL, mode: String): Unit = definedExternally
external fun chmodSync(path: URL, mode: Number): Unit = definedExternally
external fun fchmod(fd: Number, mode: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun fchmod(fd: Number, mode: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun fchmodSync(fd: Number, mode: String): Unit = definedExternally
external fun fchmodSync(fd: Number, mode: Number): Unit = definedExternally
external fun lchmod(path: String, mode: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun lchmod(path: String, mode: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun lchmod(path: Buffer, mode: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun lchmod(path: Buffer, mode: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun lchmod(path: URL, mode: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun lchmod(path: URL, mode: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun lchmodSync(path: String, mode: String): Unit = definedExternally
external fun lchmodSync(path: String, mode: Number): Unit = definedExternally
external fun lchmodSync(path: Buffer, mode: String): Unit = definedExternally
external fun lchmodSync(path: Buffer, mode: Number): Unit = definedExternally
external fun lchmodSync(path: URL, mode: String): Unit = definedExternally
external fun lchmodSync(path: URL, mode: Number): Unit = definedExternally
external fun stat(path: String, callback: (err: ErrnoException, stats: Stats) -> Unit): Unit = definedExternally
external fun stat(path: Buffer, callback: (err: ErrnoException, stats: Stats) -> Unit): Unit = definedExternally
external fun stat(path: URL, callback: (err: ErrnoException, stats: Stats) -> Unit): Unit = definedExternally
external fun statSync(path: String): Stats = definedExternally
external fun statSync(path: Buffer): Stats = definedExternally
external fun statSync(path: URL): Stats = definedExternally
external fun fstat(fd: Number, callback: (err: ErrnoException, stats: Stats) -> Unit): Unit = definedExternally
external fun fstatSync(fd: Number): Stats = definedExternally
external fun lstat(path: String, callback: (err: ErrnoException, stats: Stats) -> Unit): Unit = definedExternally
external fun lstat(path: Buffer, callback: (err: ErrnoException, stats: Stats) -> Unit): Unit = definedExternally
external fun lstat(path: URL, callback: (err: ErrnoException, stats: Stats) -> Unit): Unit = definedExternally
external fun lstatSync(path: String): Stats = definedExternally
external fun lstatSync(path: Buffer): Stats = definedExternally
external fun lstatSync(path: URL): Stats = definedExternally
external fun link(existingPath: String, newPath: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun link(existingPath: String, newPath: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun link(existingPath: String, newPath: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun link(existingPath: Buffer, newPath: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun link(existingPath: Buffer, newPath: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun link(existingPath: Buffer, newPath: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun link(existingPath: URL, newPath: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun link(existingPath: URL, newPath: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun link(existingPath: URL, newPath: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun linkSync(existingPath: String, newPath: String): Unit = definedExternally
external fun linkSync(existingPath: String, newPath: Buffer): Unit = definedExternally
external fun linkSync(existingPath: String, newPath: URL): Unit = definedExternally
external fun linkSync(existingPath: Buffer, newPath: String): Unit = definedExternally
external fun linkSync(existingPath: Buffer, newPath: Buffer): Unit = definedExternally
external fun linkSync(existingPath: Buffer, newPath: URL): Unit = definedExternally
external fun linkSync(existingPath: URL, newPath: String): Unit = definedExternally
external fun linkSync(existingPath: URL, newPath: Buffer): Unit = definedExternally
external fun linkSync(existingPath: URL, newPath: URL): Unit = definedExternally
external fun symlink(target: String, path: String, type: dynamic /* String /* "dir" */ | String /* "file" */ | String /* "junction" */ */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: String, path: Buffer, type: dynamic /* String /* "dir" */ | String /* "file" */ | String /* "junction" */ */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: String, path: URL, type: dynamic /* String /* "dir" */ | String /* "file" */ | String /* "junction" */ */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: Buffer, path: String, type: dynamic /* String /* "dir" */ | String /* "file" */ | String /* "junction" */ */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: Buffer, path: Buffer, type: dynamic /* String /* "dir" */ | String /* "file" */ | String /* "junction" */ */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: Buffer, path: URL, type: dynamic /* String /* "dir" */ | String /* "file" */ | String /* "junction" */ */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: URL, path: String, type: dynamic /* String /* "dir" */ | String /* "file" */ | String /* "junction" */ */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: URL, path: Buffer, type: dynamic /* String /* "dir" */ | String /* "file" */ | String /* "junction" */ */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: URL, path: URL, type: dynamic /* String /* "dir" */ | String /* "file" */ | String /* "junction" */ */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: String, path: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: String, path: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: String, path: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: Buffer, path: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: Buffer, path: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: Buffer, path: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: URL, path: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: URL, path: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlink(target: URL, path: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun symlinkSync(target: String, path: String, type: dynamic /* String? /* "dir" */ | String? /* "file" */ | String? /* "junction" */ */ = definedExternally /* null */): Unit = definedExternally
external fun symlinkSync(target: String, path: Buffer, type: dynamic /* String? /* "dir" */ | String? /* "file" */ | String? /* "junction" */ */ = definedExternally /* null */): Unit = definedExternally
external fun symlinkSync(target: String, path: URL, type: dynamic /* String? /* "dir" */ | String? /* "file" */ | String? /* "junction" */ */ = definedExternally /* null */): Unit = definedExternally
external fun symlinkSync(target: Buffer, path: String, type: dynamic /* String? /* "dir" */ | String? /* "file" */ | String? /* "junction" */ */ = definedExternally /* null */): Unit = definedExternally
external fun symlinkSync(target: Buffer, path: Buffer, type: dynamic /* String? /* "dir" */ | String? /* "file" */ | String? /* "junction" */ */ = definedExternally /* null */): Unit = definedExternally
external fun symlinkSync(target: Buffer, path: URL, type: dynamic /* String? /* "dir" */ | String? /* "file" */ | String? /* "junction" */ */ = definedExternally /* null */): Unit = definedExternally
external fun symlinkSync(target: URL, path: String, type: dynamic /* String? /* "dir" */ | String? /* "file" */ | String? /* "junction" */ */ = definedExternally /* null */): Unit = definedExternally
external fun symlinkSync(target: URL, path: Buffer, type: dynamic /* String? /* "dir" */ | String? /* "file" */ | String? /* "junction" */ */ = definedExternally /* null */): Unit = definedExternally
external fun symlinkSync(target: URL, path: URL, type: dynamic /* String? /* "dir" */ | String? /* "file" */ | String? /* "junction" */ */ = definedExternally /* null */): Unit = definedExternally
external interface `T$42` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */ get() = definedExternally; set(value) = definedExternally
}
external fun readlink(path: String, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$42` | Nothing? */, callback: (err: ErrnoException, linkString: String) -> Unit): Unit = definedExternally
external fun readlink(path: Buffer, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$42` | Nothing? */, callback: (err: ErrnoException, linkString: String) -> Unit): Unit = definedExternally
external fun readlink(path: URL, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$42` | Nothing? */, callback: (err: ErrnoException, linkString: String) -> Unit): Unit = definedExternally
external interface `T$43` {
    var encoding: String /* "buffer" */
}
external fun readlink(path: String, options: String /* "buffer" */, callback: (err: ErrnoException, linkString: Buffer) -> Unit): Unit = definedExternally
external fun readlink(path: String, options: `T$43`, callback: (err: ErrnoException, linkString: Buffer) -> Unit): Unit = definedExternally
external fun readlink(path: Buffer, options: String /* "buffer" */, callback: (err: ErrnoException, linkString: Buffer) -> Unit): Unit = definedExternally
external fun readlink(path: Buffer, options: `T$43`, callback: (err: ErrnoException, linkString: Buffer) -> Unit): Unit = definedExternally
external fun readlink(path: URL, options: String /* "buffer" */, callback: (err: ErrnoException, linkString: Buffer) -> Unit): Unit = definedExternally
external fun readlink(path: URL, options: `T$43`, callback: (err: ErrnoException, linkString: Buffer) -> Unit): Unit = definedExternally
external interface `T$44` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
}
external fun readlink(path: String, options: String, callback: (err: ErrnoException, linkString: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readlink(path: String, options: `T$44`, callback: (err: ErrnoException, linkString: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readlink(path: String, options: Nothing?, callback: (err: ErrnoException, linkString: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readlink(path: Buffer, options: String, callback: (err: ErrnoException, linkString: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readlink(path: Buffer, options: `T$44`, callback: (err: ErrnoException, linkString: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readlink(path: Buffer, options: Nothing?, callback: (err: ErrnoException, linkString: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readlink(path: URL, options: String, callback: (err: ErrnoException, linkString: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readlink(path: URL, options: `T$44`, callback: (err: ErrnoException, linkString: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readlink(path: URL, options: Nothing?, callback: (err: ErrnoException, linkString: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readlink(path: String, callback: (err: ErrnoException, linkString: String) -> Unit): Unit = definedExternally
external fun readlink(path: Buffer, callback: (err: ErrnoException, linkString: String) -> Unit): Unit = definedExternally
external fun readlink(path: URL, callback: (err: ErrnoException, linkString: String) -> Unit): Unit = definedExternally
external fun readlinkSync(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$42`? | Nothing? */ = definedExternally /* null */): String = definedExternally
external fun readlinkSync(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$42`? | Nothing? */ = definedExternally /* null */): String = definedExternally
external fun readlinkSync(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$42`? | Nothing? */ = definedExternally /* null */): String = definedExternally
external fun readlinkSync(path: String, options: String /* "buffer" */): Buffer = definedExternally
external fun readlinkSync(path: String, options: `T$43`): Buffer = definedExternally
external fun readlinkSync(path: Buffer, options: String /* "buffer" */): Buffer = definedExternally
external fun readlinkSync(path: Buffer, options: `T$43`): Buffer = definedExternally
external fun readlinkSync(path: URL, options: String /* "buffer" */): Buffer = definedExternally
external fun readlinkSync(path: URL, options: `T$43`): Buffer = definedExternally
external fun readlinkSync(path: String, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: String, options: `T$44`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: String, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: Buffer, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: Buffer, options: `T$44`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: Buffer, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: URL, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: URL, options: `T$44`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: URL, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun realpath(path: String, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$42` | Nothing? */, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun realpath(path: Buffer, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$42` | Nothing? */, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun realpath(path: URL, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$42` | Nothing? */, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun realpath(path: String, options: String /* "buffer" */, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun realpath(path: String, options: `T$43`, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun realpath(path: Buffer, options: String /* "buffer" */, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun realpath(path: Buffer, options: `T$43`, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun realpath(path: URL, options: String /* "buffer" */, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun realpath(path: URL, options: `T$43`, callback: (err: ErrnoException, resolvedPath: Buffer) -> Unit): Unit = definedExternally
external fun realpath(path: String, options: String, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun realpath(path: String, options: `T$44`, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun realpath(path: String, options: Nothing?, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun realpath(path: Buffer, options: String, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun realpath(path: Buffer, options: `T$44`, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun realpath(path: Buffer, options: Nothing?, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun realpath(path: URL, options: String, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun realpath(path: URL, options: `T$44`, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun realpath(path: URL, options: Nothing?, callback: (err: ErrnoException, resolvedPath: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun realpath(path: String, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun realpath(path: Buffer, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun realpath(path: URL, callback: (err: ErrnoException, resolvedPath: String) -> Unit): Unit = definedExternally
external fun realpathSync(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$42`? | Nothing? */ = definedExternally /* null */): String = definedExternally
external fun realpathSync(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$42`? | Nothing? */ = definedExternally /* null */): String = definedExternally
external fun realpathSync(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$42`? | Nothing? */ = definedExternally /* null */): String = definedExternally
external fun realpathSync(path: String, options: String /* "buffer" */): Buffer = definedExternally
external fun realpathSync(path: String, options: `T$43`): Buffer = definedExternally
external fun realpathSync(path: Buffer, options: String /* "buffer" */): Buffer = definedExternally
external fun realpathSync(path: Buffer, options: `T$43`): Buffer = definedExternally
external fun realpathSync(path: URL, options: String /* "buffer" */): Buffer = definedExternally
external fun realpathSync(path: URL, options: `T$43`): Buffer = definedExternally
external fun realpathSync(path: String, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: String, options: `T$44`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: String, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: Buffer, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: Buffer, options: `T$44`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: Buffer, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: URL, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: URL, options: `T$44`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: URL, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun unlink(path: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun unlink(path: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun unlink(path: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun unlinkSync(path: String): Unit = definedExternally
external fun unlinkSync(path: Buffer): Unit = definedExternally
external fun unlinkSync(path: URL): Unit = definedExternally
external fun rmdir(path: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rmdir(path: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rmdir(path: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun rmdirSync(path: String): Unit = definedExternally
external fun rmdirSync(path: Buffer): Unit = definedExternally
external fun rmdirSync(path: URL): Unit = definedExternally
external interface MakeDirectoryOptions {
    var recursive: Boolean? get() = definedExternally; set(value) = definedExternally
    var mode: Number? get() = definedExternally; set(value) = definedExternally
}
external fun mkdir(path: String, options: dynamic /* String | Number | MakeDirectoryOptions | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun mkdir(path: Buffer, options: dynamic /* String | Number | MakeDirectoryOptions | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun mkdir(path: URL, options: dynamic /* String | Number | MakeDirectoryOptions | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun mkdir(path: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun mkdir(path: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun mkdir(path: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun mkdirSync(path: String, options: dynamic /* String? | Number? | MakeDirectoryOptions? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun mkdirSync(path: Buffer, options: dynamic /* String? | Number? | MakeDirectoryOptions? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun mkdirSync(path: URL, options: dynamic /* String? | Number? | MakeDirectoryOptions? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String /* "ascii" */, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String /* "utf8" */, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String /* "utf16le" */, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String /* "ucs2" */, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String /* "base64" */, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String /* "latin1" */, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String /* "binary" */, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String /* "hex" */, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: `T$42`, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: Nothing?, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String /* "buffer" */, callback: (err: ErrnoException, folder: Buffer) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: `T$43`, callback: (err: ErrnoException, folder: Buffer) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: String, callback: (err: ErrnoException, folder: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: `T$44`, callback: (err: ErrnoException, folder: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, options: Nothing?, callback: (err: ErrnoException, folder: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun mkdtemp(prefix: String, callback: (err: ErrnoException, folder: String) -> Unit): Unit = definedExternally
external fun mkdtempSync(prefix: String, options: String? /* "ascii" */ = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: String? /* "utf8" */ = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: String? /* "utf16le" */ = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: String? /* "ucs2" */ = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: String? /* "base64" */ = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: String? /* "latin1" */ = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: String? /* "binary" */ = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: String? /* "hex" */ = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: `T$42`? = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: Nothing? = definedExternally /* null */): String = definedExternally
external fun mkdtempSync(prefix: String, options: String /* "buffer" */): Buffer = definedExternally
external fun mkdtempSync(prefix: String, options: `T$43`): Buffer = definedExternally
external fun mkdtempSync(prefix: String, options: String? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun mkdtempSync(prefix: String, options: `T$44`? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun mkdtempSync(prefix: String, options: Nothing? = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external interface `T$57` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */
    var withFileTypes: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun readdir(path: String, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$57` | Nothing? */, callback: (err: ErrnoException, files: Array<String>) -> Unit): Unit = definedExternally
external fun readdir(path: Buffer, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$57` | Nothing? */, callback: (err: ErrnoException, files: Array<String>) -> Unit): Unit = definedExternally
external fun readdir(path: URL, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$57` | Nothing? */, callback: (err: ErrnoException, files: Array<String>) -> Unit): Unit = definedExternally
external interface `T$58` {
    var encoding: String /* "buffer" */
    var withFileTypes: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun readdir(path: String, options: String /* "buffer" */, callback: (err: ErrnoException, files: Array<Buffer>) -> Unit): Unit = definedExternally
external fun readdir(path: String, options: `T$58`, callback: (err: ErrnoException, files: Array<Buffer>) -> Unit): Unit = definedExternally
external fun readdir(path: Buffer, options: String /* "buffer" */, callback: (err: ErrnoException, files: Array<Buffer>) -> Unit): Unit = definedExternally
external fun readdir(path: Buffer, options: `T$58`, callback: (err: ErrnoException, files: Array<Buffer>) -> Unit): Unit = definedExternally
external fun readdir(path: URL, options: String /* "buffer" */, callback: (err: ErrnoException, files: Array<Buffer>) -> Unit): Unit = definedExternally
external fun readdir(path: URL, options: `T$58`, callback: (err: ErrnoException, files: Array<Buffer>) -> Unit): Unit = definedExternally
external interface `T$59` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var withFileTypes: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun readdir(path: String, options: String, callback: (err: ErrnoException, files: dynamic /* Array<String> | Array<Buffer> */) -> Unit): Unit = definedExternally
external fun readdir(path: String, options: `T$59`, callback: (err: ErrnoException, files: dynamic /* Array<String> | Array<Buffer> */) -> Unit): Unit = definedExternally
external fun readdir(path: String, options: Nothing?, callback: (err: ErrnoException, files: dynamic /* Array<String> | Array<Buffer> */) -> Unit): Unit = definedExternally
external fun readdir(path: Buffer, options: String, callback: (err: ErrnoException, files: dynamic /* Array<String> | Array<Buffer> */) -> Unit): Unit = definedExternally
external fun readdir(path: Buffer, options: `T$59`, callback: (err: ErrnoException, files: dynamic /* Array<String> | Array<Buffer> */) -> Unit): Unit = definedExternally
external fun readdir(path: Buffer, options: Nothing?, callback: (err: ErrnoException, files: dynamic /* Array<String> | Array<Buffer> */) -> Unit): Unit = definedExternally
external fun readdir(path: URL, options: String, callback: (err: ErrnoException, files: dynamic /* Array<String> | Array<Buffer> */) -> Unit): Unit = definedExternally
external fun readdir(path: URL, options: `T$59`, callback: (err: ErrnoException, files: dynamic /* Array<String> | Array<Buffer> */) -> Unit): Unit = definedExternally
external fun readdir(path: URL, options: Nothing?, callback: (err: ErrnoException, files: dynamic /* Array<String> | Array<Buffer> */) -> Unit): Unit = definedExternally
external fun readdir(path: String, callback: (err: ErrnoException, files: Array<String>) -> Unit): Unit = definedExternally
external fun readdir(path: Buffer, callback: (err: ErrnoException, files: Array<String>) -> Unit): Unit = definedExternally
external fun readdir(path: URL, callback: (err: ErrnoException, files: Array<String>) -> Unit): Unit = definedExternally
external interface `T$60` {
    var withFileTypes: Boolean
}
external fun readdir(path: String, options: `T$60`, callback: (err: ErrnoException, files: Array<Dirent>) -> Unit): Unit = definedExternally
external fun readdir(path: Buffer, options: `T$60`, callback: (err: ErrnoException, files: Array<Dirent>) -> Unit): Unit = definedExternally
external fun readdir(path: URL, options: `T$60`, callback: (err: ErrnoException, files: Array<Dirent>) -> Unit): Unit = definedExternally
external fun readdirSync(path: String, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$57`? | Nothing? */ = definedExternally /* null */): Array<String> = definedExternally
external fun readdirSync(path: Buffer, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$57`? | Nothing? */ = definedExternally /* null */): Array<String> = definedExternally
external fun readdirSync(path: URL, options: dynamic /* String? /* "ascii" */ | String? /* "utf8" */ | String? /* "utf16le" */ | String? /* "ucs2" */ | String? /* "base64" */ | String? /* "latin1" */ | String? /* "binary" */ | String? /* "hex" */ | `T$57`? | Nothing? */ = definedExternally /* null */): Array<String> = definedExternally
external fun readdirSync(path: String, options: String /* "buffer" */): Array<Buffer> = definedExternally
external fun readdirSync(path: String, options: `T$58`): Array<Buffer> = definedExternally
external fun readdirSync(path: Buffer, options: String /* "buffer" */): Array<Buffer> = definedExternally
external fun readdirSync(path: Buffer, options: `T$58`): Array<Buffer> = definedExternally
external fun readdirSync(path: URL, options: String /* "buffer" */): Array<Buffer> = definedExternally
external fun readdirSync(path: URL, options: `T$58`): Array<Buffer> = definedExternally
external fun readdirSync(path: String, options: String? = definedExternally /* null */): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: String, options: `T$59`? = definedExternally /* null */): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: String, options: Nothing? = definedExternally /* null */): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: Buffer, options: String? = definedExternally /* null */): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: Buffer, options: `T$59`? = definedExternally /* null */): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: Buffer, options: Nothing? = definedExternally /* null */): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: URL, options: String? = definedExternally /* null */): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: URL, options: `T$59`? = definedExternally /* null */): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: URL, options: Nothing? = definedExternally /* null */): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: String, options: `T$60`): Array<Dirent> = definedExternally
external fun readdirSync(path: Buffer, options: `T$60`): Array<Dirent> = definedExternally
external fun readdirSync(path: URL, options: `T$60`): Array<Dirent> = definedExternally
external fun close(fd: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun closeSync(fd: Number): Unit = definedExternally
external fun open(path: String, flags: String, mode: dynamic /* String | Number */, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: String, flags: Number, mode: dynamic /* String | Number */, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: Buffer, flags: String, mode: dynamic /* String | Number */, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: Buffer, flags: Number, mode: dynamic /* String | Number */, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: URL, flags: String, mode: dynamic /* String | Number */, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: URL, flags: Number, mode: dynamic /* String | Number */, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: String, flags: String, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: String, flags: Number, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: Buffer, flags: String, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: Buffer, flags: Number, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: URL, flags: String, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun open(path: URL, flags: Number, callback: (err: ErrnoException, fd: Number) -> Unit): Unit = definedExternally
external fun openSync(path: String, flags: String, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Number = definedExternally
external fun openSync(path: String, flags: Number, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Number = definedExternally
external fun openSync(path: Buffer, flags: String, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Number = definedExternally
external fun openSync(path: Buffer, flags: Number, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Number = definedExternally
external fun openSync(path: URL, flags: String, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Number = definedExternally
external fun openSync(path: URL, flags: Number, mode: dynamic /* String? | Number? */ = definedExternally /* null */): Number = definedExternally
external fun utimes(path: String, atime: String, mtime: dynamic /* String | Number | Date */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun utimes(path: String, atime: Number, mtime: dynamic /* String | Number | Date */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun utimes(path: String, atime: Date, mtime: dynamic /* String | Number | Date */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun utimes(path: Buffer, atime: String, mtime: dynamic /* String | Number | Date */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun utimes(path: Buffer, atime: Number, mtime: dynamic /* String | Number | Date */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun utimes(path: Buffer, atime: Date, mtime: dynamic /* String | Number | Date */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun utimes(path: URL, atime: String, mtime: dynamic /* String | Number | Date */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun utimes(path: URL, atime: Number, mtime: dynamic /* String | Number | Date */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun utimes(path: URL, atime: Date, mtime: dynamic /* String | Number | Date */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun utimesSync(path: String, atime: String, mtime: dynamic /* String | Number | Date */): Unit = definedExternally
external fun utimesSync(path: String, atime: Number, mtime: dynamic /* String | Number | Date */): Unit = definedExternally
external fun utimesSync(path: String, atime: Date, mtime: dynamic /* String | Number | Date */): Unit = definedExternally
external fun utimesSync(path: Buffer, atime: String, mtime: dynamic /* String | Number | Date */): Unit = definedExternally
external fun utimesSync(path: Buffer, atime: Number, mtime: dynamic /* String | Number | Date */): Unit = definedExternally
external fun utimesSync(path: Buffer, atime: Date, mtime: dynamic /* String | Number | Date */): Unit = definedExternally
external fun utimesSync(path: URL, atime: String, mtime: dynamic /* String | Number | Date */): Unit = definedExternally
external fun utimesSync(path: URL, atime: Number, mtime: dynamic /* String | Number | Date */): Unit = definedExternally
external fun utimesSync(path: URL, atime: Date, mtime: dynamic /* String | Number | Date */): Unit = definedExternally
external fun futimes(fd: Number, atime: String, mtime: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun futimes(fd: Number, atime: String, mtime: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun futimes(fd: Number, atime: String, mtime: Date, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun futimes(fd: Number, atime: Number, mtime: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun futimes(fd: Number, atime: Number, mtime: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun futimes(fd: Number, atime: Number, mtime: Date, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun futimes(fd: Number, atime: Date, mtime: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun futimes(fd: Number, atime: Date, mtime: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun futimes(fd: Number, atime: Date, mtime: Date, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun futimesSync(fd: Number, atime: String, mtime: String): Unit = definedExternally
external fun futimesSync(fd: Number, atime: String, mtime: Number): Unit = definedExternally
external fun futimesSync(fd: Number, atime: String, mtime: Date): Unit = definedExternally
external fun futimesSync(fd: Number, atime: Number, mtime: String): Unit = definedExternally
external fun futimesSync(fd: Number, atime: Number, mtime: Number): Unit = definedExternally
external fun futimesSync(fd: Number, atime: Number, mtime: Date): Unit = definedExternally
external fun futimesSync(fd: Number, atime: Date, mtime: String): Unit = definedExternally
external fun futimesSync(fd: Number, atime: Date, mtime: Number): Unit = definedExternally
external fun futimesSync(fd: Number, atime: Date, mtime: Date): Unit = definedExternally
external fun fsync(fd: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun fsyncSync(fd: Number): Unit = definedExternally
external fun <TBuffer /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> write(fd: Number, buffer: TBuffer, offset: Number?, length: Number?, position: Number?, callback: (err: ErrnoException, written: Number, buffer: TBuffer) -> Unit): Unit = definedExternally
external fun <TBuffer /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> write(fd: Number, buffer: TBuffer, offset: Number?, length: Number?, callback: (err: ErrnoException, written: Number, buffer: TBuffer) -> Unit): Unit = definedExternally
external fun <TBuffer /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> write(fd: Number, buffer: TBuffer, offset: Number?, callback: (err: ErrnoException, written: Number, buffer: TBuffer) -> Unit): Unit = definedExternally
external fun <TBuffer /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> write(fd: Number, buffer: TBuffer, callback: (err: ErrnoException, written: Number, buffer: TBuffer) -> Unit): Unit = definedExternally
external fun write(fd: Number, string: Any, position: Number?, encoding: String?, callback: (err: ErrnoException, written: Number, str: String) -> Unit): Unit = definedExternally
external fun write(fd: Number, string: Any, position: Number?, callback: (err: ErrnoException, written: Number, str: String) -> Unit): Unit = definedExternally
external fun write(fd: Number, string: Any, callback: (err: ErrnoException, written: Number, str: String) -> Unit): Unit = definedExternally
external fun writeSync(fd: Number, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, offset: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */, position: Number? = definedExternally /* null */): Number = definedExternally
external fun writeSync(fd: Number, string: Any, position: Number? = definedExternally /* null */, encoding: String? = definedExternally /* null */): Number = definedExternally
external fun <TBuffer /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> read(fd: Number, buffer: TBuffer, offset: Number, length: Number, position: Number?, callback: ((err: ErrnoException, bytesRead: Number, buffer: TBuffer) -> Unit)? = definedExternally /* null */): Unit = definedExternally
external fun readSync(fd: Number, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, offset: Number, length: Number, position: Number?): Number = definedExternally
external interface `T$68` {
    var encoding: Nothing? get() = definedExternally; set(value) = definedExternally
    var flag: String? get() = definedExternally; set(value) = definedExternally
}
external fun readFile(path: String, options: `T$68`?, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit = definedExternally
external fun readFile(path: Number, options: `T$68`?, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit = definedExternally
external fun readFile(path: Buffer, options: `T$68`?, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit = definedExternally
external fun readFile(path: URL, options: `T$68`?, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit = definedExternally
external interface `T$69` {
    var encoding: String
    var flag: String? get() = definedExternally; set(value) = definedExternally
}
external fun readFile(path: String, options: String, callback: (err: ErrnoException, data: String) -> Unit): Unit = definedExternally
external fun readFile(path: String, options: `T$69`, callback: (err: ErrnoException, data: String) -> Unit): Unit = definedExternally
external fun readFile(path: Number, options: String, callback: (err: ErrnoException, data: String) -> Unit): Unit = definedExternally
external fun readFile(path: Number, options: `T$69`, callback: (err: ErrnoException, data: String) -> Unit): Unit = definedExternally
external fun readFile(path: Buffer, options: String, callback: (err: ErrnoException, data: String) -> Unit): Unit = definedExternally
external fun readFile(path: Buffer, options: `T$69`, callback: (err: ErrnoException, data: String) -> Unit): Unit = definedExternally
external fun readFile(path: URL, options: String, callback: (err: ErrnoException, data: String) -> Unit): Unit = definedExternally
external fun readFile(path: URL, options: `T$69`, callback: (err: ErrnoException, data: String) -> Unit): Unit = definedExternally
external interface `T$70` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var flag: String? get() = definedExternally; set(value) = definedExternally
}
external fun readFile(path: String, options: dynamic /* String | `T$70` | Nothing? */, callback: (err: ErrnoException, data: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readFile(path: Number, options: dynamic /* String | `T$70` | Nothing? */, callback: (err: ErrnoException, data: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readFile(path: Buffer, options: dynamic /* String | `T$70` | Nothing? */, callback: (err: ErrnoException, data: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readFile(path: URL, options: dynamic /* String | `T$70` | Nothing? */, callback: (err: ErrnoException, data: dynamic /* String | Buffer */) -> Unit): Unit = definedExternally
external fun readFile(path: String, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit = definedExternally
external fun readFile(path: Number, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit = definedExternally
external fun readFile(path: Buffer, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit = definedExternally
external fun readFile(path: URL, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit = definedExternally
external fun readFileSync(path: String, options: `T$68`? = definedExternally /* null */): Buffer = definedExternally
external fun readFileSync(path: Number, options: `T$68`? = definedExternally /* null */): Buffer = definedExternally
external fun readFileSync(path: Buffer, options: `T$68`? = definedExternally /* null */): Buffer = definedExternally
external fun readFileSync(path: URL, options: `T$68`? = definedExternally /* null */): Buffer = definedExternally
external fun readFileSync(path: String, options: String): String = definedExternally
external fun readFileSync(path: String, options: `T$69`): String = definedExternally
external fun readFileSync(path: Number, options: String): String = definedExternally
external fun readFileSync(path: Number, options: `T$69`): String = definedExternally
external fun readFileSync(path: Buffer, options: String): String = definedExternally
external fun readFileSync(path: Buffer, options: `T$69`): String = definedExternally
external fun readFileSync(path: URL, options: String): String = definedExternally
external fun readFileSync(path: URL, options: `T$69`): String = definedExternally
external fun readFileSync(path: String, options: dynamic /* String? | `T$70`? | Nothing? */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readFileSync(path: Number, options: dynamic /* String? | `T$70`? | Nothing? */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readFileSync(path: Buffer, options: dynamic /* String? | `T$70`? | Nothing? */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external fun readFileSync(path: URL, options: dynamic /* String? | `T$70`? | Nothing? */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
external interface `T$74` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var mode: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var flag: String? get() = definedExternally; set(value) = definedExternally
}
external fun writeFile(path: String, data: Any, options: dynamic /* String | `T$74` | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun writeFile(path: Number, data: Any, options: dynamic /* String | `T$74` | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun writeFile(path: Buffer, data: Any, options: dynamic /* String | `T$74` | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun writeFile(path: URL, data: Any, options: dynamic /* String | `T$74` | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun writeFile(path: String, data: Any, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun writeFile(path: Number, data: Any, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun writeFile(path: Buffer, data: Any, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun writeFile(path: URL, data: Any, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun writeFileSync(path: String, data: Any, options: dynamic /* String? | `T$74`? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun writeFileSync(path: Number, data: Any, options: dynamic /* String? | `T$74`? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun writeFileSync(path: Buffer, data: Any, options: dynamic /* String? | `T$74`? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun writeFileSync(path: URL, data: Any, options: dynamic /* String? | `T$74`? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun appendFile(file: String, data: Any, options: dynamic /* String | `T$74` | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun appendFile(file: Number, data: Any, options: dynamic /* String | `T$74` | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun appendFile(file: Buffer, data: Any, options: dynamic /* String | `T$74` | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun appendFile(file: URL, data: Any, options: dynamic /* String | `T$74` | Nothing? */, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun appendFile(file: String, data: Any, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun appendFile(file: Number, data: Any, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun appendFile(file: Buffer, data: Any, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun appendFile(file: URL, data: Any, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun appendFileSync(file: String, data: Any, options: dynamic /* String? | `T$74`? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun appendFileSync(file: Number, data: Any, options: dynamic /* String? | `T$74`? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun appendFileSync(file: Buffer, data: Any, options: dynamic /* String? | `T$74`? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external fun appendFileSync(file: URL, data: Any, options: dynamic /* String? | `T$74`? | Nothing? */ = definedExternally /* null */): Unit = definedExternally
external interface `T$77` {
    var persistent: Boolean? get() = definedExternally; set(value) = definedExternally
    var interval: Number? get() = definedExternally; set(value) = definedExternally
}
external fun watchFile(filename: String, options: `T$77`?, listener: (curr: Stats, prev: Stats) -> Unit): Unit = definedExternally
external fun watchFile(filename: Buffer, options: `T$77`?, listener: (curr: Stats, prev: Stats) -> Unit): Unit = definedExternally
external fun watchFile(filename: URL, options: `T$77`?, listener: (curr: Stats, prev: Stats) -> Unit): Unit = definedExternally
external fun watchFile(filename: String, listener: (curr: Stats, prev: Stats) -> Unit): Unit = definedExternally
external fun watchFile(filename: Buffer, listener: (curr: Stats, prev: Stats) -> Unit): Unit = definedExternally
external fun watchFile(filename: URL, listener: (curr: Stats, prev: Stats) -> Unit): Unit = definedExternally
external fun unwatchFile(filename: String, listener: ((curr: Stats, prev: Stats) -> Unit)? = definedExternally /* null */): Unit = definedExternally
external fun unwatchFile(filename: Buffer, listener: ((curr: Stats, prev: Stats) -> Unit)? = definedExternally /* null */): Unit = definedExternally
external fun unwatchFile(filename: URL, listener: ((curr: Stats, prev: Stats) -> Unit)? = definedExternally /* null */): Unit = definedExternally
external interface `T$78` {
    var encoding: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ */ get() = definedExternally; set(value) = definedExternally
    var persistent: Boolean? get() = definedExternally; set(value) = definedExternally
    var recursive: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun watch(filename: String, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$78` | Nothing? */, listener: ((event: String, filename: String) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: Buffer, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$78` | Nothing? */, listener: ((event: String, filename: String) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: URL, options: dynamic /* String /* "ascii" */ | String /* "utf8" */ | String /* "utf16le" */ | String /* "ucs2" */ | String /* "base64" */ | String /* "latin1" */ | String /* "binary" */ | String /* "hex" */ | `T$78` | Nothing? */, listener: ((event: String, filename: String) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external interface `T$79` {
    var encoding: String /* "buffer" */
    var persistent: Boolean? get() = definedExternally; set(value) = definedExternally
    var recursive: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun watch(filename: String, options: String /* "buffer" */, listener: ((event: String, filename: Buffer) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: String, options: `T$79`, listener: ((event: String, filename: Buffer) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: Buffer, options: String /* "buffer" */, listener: ((event: String, filename: Buffer) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: Buffer, options: `T$79`, listener: ((event: String, filename: Buffer) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: URL, options: String /* "buffer" */, listener: ((event: String, filename: Buffer) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: URL, options: `T$79`, listener: ((event: String, filename: Buffer) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external interface `T$80` {
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var persistent: Boolean? get() = definedExternally; set(value) = definedExternally
    var recursive: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun watch(filename: String, options: String, listener: ((event: String, filename: dynamic /* String | Buffer */) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: String, options: `T$80`, listener: ((event: String, filename: dynamic /* String | Buffer */) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: String, options: Nothing?, listener: ((event: String, filename: dynamic /* String | Buffer */) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: Buffer, options: String, listener: ((event: String, filename: dynamic /* String | Buffer */) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: Buffer, options: `T$80`, listener: ((event: String, filename: dynamic /* String | Buffer */) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: Buffer, options: Nothing?, listener: ((event: String, filename: dynamic /* String | Buffer */) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: URL, options: String, listener: ((event: String, filename: dynamic /* String | Buffer */) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: URL, options: `T$80`, listener: ((event: String, filename: dynamic /* String | Buffer */) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: URL, options: Nothing?, listener: ((event: String, filename: dynamic /* String | Buffer */) -> Unit)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: String, listener: ((event: String, filename: String) -> Any)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: Buffer, listener: ((event: String, filename: String) -> Any)? = definedExternally /* null */): FSWatcher = definedExternally
external fun watch(filename: URL, listener: ((event: String, filename: String) -> Any)? = definedExternally /* null */): FSWatcher = definedExternally
external fun exists(path: String, callback: (exists: Boolean) -> Unit): Unit = definedExternally
external fun exists(path: Buffer, callback: (exists: Boolean) -> Unit): Unit = definedExternally
external fun exists(path: URL, callback: (exists: Boolean) -> Unit): Unit = definedExternally
external fun existsSync(path: String): Boolean = definedExternally
external fun existsSync(path: Buffer): Boolean = definedExternally
external fun existsSync(path: URL): Boolean = definedExternally
external fun access(path: String, mode: Number?, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun access(path: Buffer, mode: Number?, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun access(path: URL, mode: Number?, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun access(path: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun access(path: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun access(path: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun accessSync(path: String, mode: Number? = definedExternally /* null */): Unit = definedExternally
external fun accessSync(path: Buffer, mode: Number? = definedExternally /* null */): Unit = definedExternally
external fun accessSync(path: URL, mode: Number? = definedExternally /* null */): Unit = definedExternally
external interface `T$81` {
    var flags: String? get() = definedExternally; set(value) = definedExternally
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var fd: Number? get() = definedExternally; set(value) = definedExternally
    var mode: Number? get() = definedExternally; set(value) = definedExternally
    var autoClose: Boolean? get() = definedExternally; set(value) = definedExternally
    var start: Number? get() = definedExternally; set(value) = definedExternally
    var end: Number? get() = definedExternally; set(value) = definedExternally
    var highWaterMark: Number? get() = definedExternally; set(value) = definedExternally
}
external fun createReadStream(path: String, options: String? = definedExternally /* null */): ReadStream = definedExternally
external fun createReadStream(path: String, options: `T$81`? = definedExternally /* null */): ReadStream = definedExternally
external fun createReadStream(path: Buffer, options: String? = definedExternally /* null */): ReadStream = definedExternally
external fun createReadStream(path: Buffer, options: `T$81`? = definedExternally /* null */): ReadStream = definedExternally
external fun createReadStream(path: URL, options: String? = definedExternally /* null */): ReadStream = definedExternally
external fun createReadStream(path: URL, options: `T$81`? = definedExternally /* null */): ReadStream = definedExternally
external interface `T$82` {
    var flags: String? get() = definedExternally; set(value) = definedExternally
    var encoding: String? get() = definedExternally; set(value) = definedExternally
    var fd: Number? get() = definedExternally; set(value) = definedExternally
    var mode: Number? get() = definedExternally; set(value) = definedExternally
    var autoClose: Boolean? get() = definedExternally; set(value) = definedExternally
    var start: Number? get() = definedExternally; set(value) = definedExternally
}
external fun createWriteStream(path: String, options: String? = definedExternally /* null */): WriteStream = definedExternally
external fun createWriteStream(path: String, options: `T$82`? = definedExternally /* null */): WriteStream = definedExternally
external fun createWriteStream(path: Buffer, options: String? = definedExternally /* null */): WriteStream = definedExternally
external fun createWriteStream(path: Buffer, options: `T$82`? = definedExternally /* null */): WriteStream = definedExternally
external fun createWriteStream(path: URL, options: String? = definedExternally /* null */): WriteStream = definedExternally
external fun createWriteStream(path: URL, options: `T$82`? = definedExternally /* null */): WriteStream = definedExternally
external fun fdatasync(fd: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun fdatasyncSync(fd: Number): Unit = definedExternally
external fun copyFile(src: String, dest: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: String, dest: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: String, dest: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: Buffer, dest: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: Buffer, dest: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: Buffer, dest: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: URL, dest: String, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: URL, dest: Buffer, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: URL, dest: URL, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: String, dest: String, flags: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: String, dest: Buffer, flags: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: String, dest: URL, flags: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: Buffer, dest: String, flags: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: Buffer, dest: Buffer, flags: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: Buffer, dest: URL, flags: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: URL, dest: String, flags: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: URL, dest: Buffer, flags: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFile(src: URL, dest: URL, flags: Number, callback: (err: ErrnoException) -> Unit): Unit = definedExternally
external fun copyFileSync(src: String, dest: String, flags: Number? = definedExternally /* null */): Unit = definedExternally
external fun copyFileSync(src: String, dest: Buffer, flags: Number? = definedExternally /* null */): Unit = definedExternally
external fun copyFileSync(src: String, dest: URL, flags: Number? = definedExternally /* null */): Unit = definedExternally
external fun copyFileSync(src: Buffer, dest: String, flags: Number? = definedExternally /* null */): Unit = definedExternally
external fun copyFileSync(src: Buffer, dest: Buffer, flags: Number? = definedExternally /* null */): Unit = definedExternally
external fun copyFileSync(src: Buffer, dest: URL, flags: Number? = definedExternally /* null */): Unit = definedExternally
external fun copyFileSync(src: URL, dest: String, flags: Number? = definedExternally /* null */): Unit = definedExternally
external fun copyFileSync(src: URL, dest: Buffer, flags: Number? = definedExternally /* null */): Unit = definedExternally
external fun copyFileSync(src: URL, dest: URL, flags: Number? = definedExternally /* null */): Unit = definedExternally
external fun readlinkSync(path: String): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: Buffer): dynamic /* String | Buffer */ = definedExternally
external fun readlinkSync(path: URL): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: String): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: Buffer): dynamic /* String | Buffer */ = definedExternally
external fun realpathSync(path: URL): dynamic /* String | Buffer */ = definedExternally
external fun mkdtempSync(prefix: String): String = definedExternally
external fun mkdtempSync(prefix: String): dynamic /* String | Buffer */ = definedExternally
external fun readdirSync(path: String): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: Buffer): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun readdirSync(path: URL): dynamic /* Array<String> | Array<Buffer> */ = definedExternally
external fun createReadStream(path: String): ReadStream = definedExternally
external fun createReadStream(path: Buffer): ReadStream = definedExternally
external fun createReadStream(path: URL): ReadStream = definedExternally
external fun createWriteStream(path: String): WriteStream = definedExternally
external fun createWriteStream(path: Buffer): WriteStream = definedExternally
external fun createWriteStream(path: URL): WriteStream = definedExternally

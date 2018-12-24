@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:JsModule("crypto")
package js.node.crypto

import js.node.Buffer
import js.node.ReadWriteStream
import js.node.WritableStream
import js.node.stream.internal.TransformOptions
import js.node.stream.internal.WritableOptions
import kotlin.js.*

external interface Certificate {
    fun exportChallenge(spkac: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer
    fun exportPublicKey(spkac: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer
    fun verifySpkac(spkac: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Boolean
    companion object {
        @nativeInvoke
        @Suppress("deprecation")
        operator fun invoke(): js.node.crypto.Certificate
    }
}
external var fips: Boolean = definedExternally
external interface CredentialDetails {
    var pfx: String
    var key: String
    var passphrase: String
    var cert: String
    var ca: dynamic /* String | Array<String> */
    var crl: dynamic /* String | Array<String> */
    var ciphers: String
}
external interface Credentials {
    var context: Any? get() = definedExternally; set(value) = definedExternally
}
external fun createCredentials(details: CredentialDetails): Credentials = definedExternally
external fun createHash(algorithm: String, options: TransformOptions? = definedExternally /* null */): Hash = definedExternally
external fun createHmac(algorithm: String, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: TransformOptions? = definedExternally /* null */): Hmac = definedExternally
external interface Hash : ReadWriteStream {
    fun update(data: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Hash
    fun update(data: String, input_encoding: String /* "ascii" */): Hash
    fun update(data: String, input_encoding: String /* "utf8" */): Hash
    fun update(data: String, input_encoding: String /* "latin1" */): Hash
    fun digest(): Buffer
    fun digest(encoding: String /* "base64" */): String
    fun digest(encoding: String /* "latin1" */): String
    fun digest(encoding: String /* "hex" */): String
}
external interface Hmac : ReadWriteStream {
    fun update(data: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Hmac
    fun update(data: String, input_encoding: String /* "ascii" */): Hmac
    fun update(data: String, input_encoding: String /* "utf8" */): Hmac
    fun update(data: String, input_encoding: String /* "latin1" */): Hmac
    fun digest(): Buffer
    fun digest(encoding: String /* "base64" */): String
    fun digest(encoding: String /* "latin1" */): String
    fun digest(encoding: String /* "hex" */): String
}
external interface CipherCCMOptions : TransformOptions {
    var authTagLength: Number
}
external interface CipherGCMOptions : TransformOptions {
    var authTagLength: Number? get() = definedExternally; set(value) = definedExternally
}
external fun createCipher(algorithm: String /* "aes-128-ccm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): CipherCCM = definedExternally
external fun createCipher(algorithm: String /* "aes-192-ccm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): CipherCCM = definedExternally
external fun createCipher(algorithm: String /* "aes-256-ccm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): CipherCCM = definedExternally
external fun createCipher(algorithm: String /* "aes-128-gcm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): CipherGCM = definedExternally
external fun createCipher(algorithm: String /* "aes-192-gcm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): CipherGCM = definedExternally
external fun createCipher(algorithm: String /* "aes-256-gcm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): CipherGCM = definedExternally
external fun createCipher(algorithm: String, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: TransformOptions? = definedExternally /* null */): Cipher = definedExternally
external fun createCipheriv(algorithm: String /* "aes-128-ccm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): CipherCCM = definedExternally
external fun createCipheriv(algorithm: String /* "aes-192-ccm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): CipherCCM = definedExternally
external fun createCipheriv(algorithm: String /* "aes-256-ccm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): CipherCCM = definedExternally
external fun createCipheriv(algorithm: String /* "aes-128-gcm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): CipherGCM = definedExternally
external fun createCipheriv(algorithm: String /* "aes-192-gcm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): CipherGCM = definedExternally
external fun createCipheriv(algorithm: String /* "aes-256-gcm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): CipherGCM = definedExternally
external fun createCipheriv(algorithm: String, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: TransformOptions? = definedExternally /* null */): Cipher = definedExternally
external interface Cipher : ReadWriteStream {
    fun update(data: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer
    fun update(data: String, input_encoding: String /* "ascii" */): Buffer
    fun update(data: String, input_encoding: String /* "utf8" */): Buffer
    fun update(data: String, input_encoding: String /* "binary" */): Buffer
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, output_encoding: String /* "base64" */): String
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, output_encoding: String /* "binary" */): String
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, output_encoding: String /* "hex" */): String
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, input_encoding: Any, output_encoding: String /* "base64" */): String
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, input_encoding: Any, output_encoding: String /* "binary" */): String
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, input_encoding: Any, output_encoding: String /* "hex" */): String
    fun update(data: String, input_encoding: String /* "ascii" */, output_encoding: String /* "base64" */): String
    fun update(data: String, input_encoding: String /* "ascii" */, output_encoding: String /* "binary" */): String
    fun update(data: String, input_encoding: String /* "ascii" */, output_encoding: String /* "hex" */): String
    fun update(data: String, input_encoding: String /* "utf8" */, output_encoding: String /* "base64" */): String
    fun update(data: String, input_encoding: String /* "utf8" */, output_encoding: String /* "binary" */): String
    fun update(data: String, input_encoding: String /* "utf8" */, output_encoding: String /* "hex" */): String
    fun update(data: String, input_encoding: String /* "binary" */, output_encoding: String /* "base64" */): String
    fun update(data: String, input_encoding: String /* "binary" */, output_encoding: String /* "binary" */): String
    fun update(data: String, input_encoding: String /* "binary" */, output_encoding: String /* "hex" */): String
    fun final(): Buffer
    fun final(output_encoding: String): String
    fun setAutoPadding(auto_padding: Boolean? = definedExternally /* null */): Cipher /* this */
}
external interface `T$97` {
    var plaintextLength: Number
}
external interface CipherCCM : Cipher {
    fun setAAD(buffer: Buffer, options: `T$97`): CipherCCM /* this */
    fun getAuthTag(): Buffer
}
external interface CipherGCM : Cipher {
    fun setAAD(buffer: Buffer, options: `T$97`? = definedExternally /* null */): CipherGCM /* this */
    fun getAuthTag(): Buffer
}
external fun createDecipher(algorithm: String /* "aes-128-ccm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): DecipherCCM = definedExternally
external fun createDecipher(algorithm: String /* "aes-192-ccm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): DecipherCCM = definedExternally
external fun createDecipher(algorithm: String /* "aes-256-ccm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): DecipherCCM = definedExternally
external fun createDecipher(algorithm: String /* "aes-128-gcm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): DecipherGCM = definedExternally
external fun createDecipher(algorithm: String /* "aes-192-gcm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): DecipherGCM = definedExternally
external fun createDecipher(algorithm: String /* "aes-256-gcm" */, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): DecipherGCM = definedExternally
external fun createDecipher(algorithm: String, password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: TransformOptions? = definedExternally /* null */): Decipher = definedExternally
external fun createDecipheriv(algorithm: String /* "aes-128-ccm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): DecipherCCM = definedExternally
external fun createDecipheriv(algorithm: String /* "aes-192-ccm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): DecipherCCM = definedExternally
external fun createDecipheriv(algorithm: String /* "aes-256-ccm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherCCMOptions): DecipherCCM = definedExternally
external fun createDecipheriv(algorithm: String /* "aes-128-gcm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): DecipherGCM = definedExternally
external fun createDecipheriv(algorithm: String /* "aes-192-gcm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): DecipherGCM = definedExternally
external fun createDecipheriv(algorithm: String /* "aes-256-gcm" */, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: CipherGCMOptions? = definedExternally /* null */): DecipherGCM = definedExternally
external fun createDecipheriv(algorithm: String, key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iv: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: TransformOptions? = definedExternally /* null */): Decipher = definedExternally
external interface Decipher : ReadWriteStream {
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer
    fun update(data: String, input_encoding: String /* "base64" */): Buffer
    fun update(data: String, input_encoding: String /* "binary" */): Buffer
    fun update(data: String, input_encoding: String /* "hex" */): Buffer
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, input_encoding: Any, output_encoding: String /* "ascii" */): String
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, input_encoding: Any, output_encoding: String /* "utf8" */): String
    fun update(data: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, input_encoding: Any, output_encoding: String /* "binary" */): String
    fun update(data: String, input_encoding: String /* "base64" */, output_encoding: String /* "ascii" */): String
    fun update(data: String, input_encoding: String /* "base64" */, output_encoding: String /* "utf8" */): String
    fun update(data: String, input_encoding: String /* "base64" */, output_encoding: String /* "binary" */): String
    fun update(data: String, input_encoding: String /* "binary" */, output_encoding: String /* "ascii" */): String
    fun update(data: String, input_encoding: String /* "binary" */, output_encoding: String /* "utf8" */): String
    fun update(data: String, input_encoding: String /* "binary" */, output_encoding: String /* "binary" */): String
    fun update(data: String, input_encoding: String /* "hex" */, output_encoding: String /* "ascii" */): String
    fun update(data: String, input_encoding: String /* "hex" */, output_encoding: String /* "utf8" */): String
    fun update(data: String, input_encoding: String /* "hex" */, output_encoding: String /* "binary" */): String
    fun final(): Buffer
    fun final(output_encoding: String): String
    fun setAutoPadding(auto_padding: Boolean? = definedExternally /* null */): Decipher /* this */
}
external interface DecipherCCM : Decipher {
    fun setAuthTag(buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): DecipherCCM /* this */
    fun setAAD(buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: `T$97`): DecipherCCM /* this */
}
external interface DecipherGCM : Decipher {
    fun setAuthTag(buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): DecipherGCM /* this */
    fun setAAD(buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, options: `T$97`? = definedExternally /* null */): DecipherGCM /* this */
}
external fun createSign(algorithm: String, options: WritableOptions? = definedExternally /* null */): Signer = definedExternally
external interface `T$98` {
    var key: String
    var passphrase: String? get() = definedExternally; set(value) = definedExternally
    var padding: Number? get() = definedExternally; set(value) = definedExternally
    var saltLength: Number? get() = definedExternally; set(value) = definedExternally
}
external interface Signer : WritableStream {
    fun update(data: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Signer
    fun update(data: String, input_encoding: String /* "ascii" */): Signer
    fun update(data: String, input_encoding: String /* "utf8" */): Signer
    fun update(data: String, input_encoding: String /* "latin1" */): Signer
    fun sign(private_key: String): Buffer
    fun sign(private_key: `T$98`): Buffer
    fun sign(private_key: String, output_format: String /* "base64" */): String
    fun sign(private_key: String, output_format: String /* "latin1" */): String
    fun sign(private_key: String, output_format: String /* "hex" */): String
    fun sign(private_key: `T$98`, output_format: String /* "base64" */): String
    fun sign(private_key: `T$98`, output_format: String /* "latin1" */): String
    fun sign(private_key: `T$98`, output_format: String /* "hex" */): String
}
external fun createVerify(algorith: String, options: WritableOptions? = definedExternally /* null */): Verify = definedExternally
external interface Verify : WritableStream {
    fun update(data: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Verify
    fun update(data: String, input_encoding: String /* "ascii" */): Verify
    fun update(data: String, input_encoding: String /* "utf8" */): Verify
    fun update(data: String, input_encoding: String /* "latin1" */): Verify
    fun verify(`object`: String, signature: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Boolean
    fun verify(`object`: Any, signature: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Boolean
    fun verify(`object`: String, signature: String, signature_format: String /* "base64" */): Boolean
    fun verify(`object`: String, signature: String, signature_format: String /* "latin1" */): Boolean
    fun verify(`object`: String, signature: String, signature_format: String /* "hex" */): Boolean
    fun verify(`object`: Any, signature: String, signature_format: String /* "base64" */): Boolean
    fun verify(`object`: Any, signature: String, signature_format: String /* "latin1" */): Boolean
    fun verify(`object`: Any, signature: String, signature_format: String /* "hex" */): Boolean
}
external fun createDiffieHellman(prime_length: Number, generator: dynamic /* Number | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */ = definedExternally /* null */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "base64" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "latin1" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "hex" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "base64" */, generator: dynamic /* Number | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "latin1" */, generator: dynamic /* Number | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "hex" */, generator: dynamic /* Number | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "base64" */, generator: String, generator_encoding: String /* "base64" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "base64" */, generator: String, generator_encoding: String /* "latin1" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "base64" */, generator: String, generator_encoding: String /* "hex" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "latin1" */, generator: String, generator_encoding: String /* "base64" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "latin1" */, generator: String, generator_encoding: String /* "latin1" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "latin1" */, generator: String, generator_encoding: String /* "hex" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "hex" */, generator: String, generator_encoding: String /* "base64" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "hex" */, generator: String, generator_encoding: String /* "latin1" */): DiffieHellman = definedExternally
external fun createDiffieHellman(prime: String, prime_encoding: String /* "hex" */, generator: String, generator_encoding: String /* "hex" */): DiffieHellman = definedExternally
external interface DiffieHellman {
    fun generateKeys(): Buffer
    fun generateKeys(encoding: String /* "base64" */): String
    fun generateKeys(encoding: String /* "latin1" */): String
    fun generateKeys(encoding: String /* "hex" */): String
    fun computeSecret(other_public_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer
    fun computeSecret(other_public_key: String, input_encoding: String /* "base64" */): Buffer
    fun computeSecret(other_public_key: String, input_encoding: String /* "latin1" */): Buffer
    fun computeSecret(other_public_key: String, input_encoding: String /* "hex" */): Buffer
    fun computeSecret(other_public_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, output_encoding: String /* "base64" */): String
    fun computeSecret(other_public_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, output_encoding: String /* "latin1" */): String
    fun computeSecret(other_public_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, output_encoding: String /* "hex" */): String
    fun computeSecret(other_public_key: String, input_encoding: String /* "base64" */, output_encoding: String /* "base64" */): String
    fun computeSecret(other_public_key: String, input_encoding: String /* "base64" */, output_encoding: String /* "latin1" */): String
    fun computeSecret(other_public_key: String, input_encoding: String /* "base64" */, output_encoding: String /* "hex" */): String
    fun computeSecret(other_public_key: String, input_encoding: String /* "latin1" */, output_encoding: String /* "base64" */): String
    fun computeSecret(other_public_key: String, input_encoding: String /* "latin1" */, output_encoding: String /* "latin1" */): String
    fun computeSecret(other_public_key: String, input_encoding: String /* "latin1" */, output_encoding: String /* "hex" */): String
    fun computeSecret(other_public_key: String, input_encoding: String /* "hex" */, output_encoding: String /* "base64" */): String
    fun computeSecret(other_public_key: String, input_encoding: String /* "hex" */, output_encoding: String /* "latin1" */): String
    fun computeSecret(other_public_key: String, input_encoding: String /* "hex" */, output_encoding: String /* "hex" */): String
    fun getPrime(): Buffer
    fun getPrime(encoding: String /* "base64" */): String
    fun getPrime(encoding: String /* "latin1" */): String
    fun getPrime(encoding: String /* "hex" */): String
    fun getGenerator(): Buffer
    fun getGenerator(encoding: String /* "base64" */): String
    fun getGenerator(encoding: String /* "latin1" */): String
    fun getGenerator(encoding: String /* "hex" */): String
    fun getPublicKey(): Buffer
    fun getPublicKey(encoding: String /* "base64" */): String
    fun getPublicKey(encoding: String /* "latin1" */): String
    fun getPublicKey(encoding: String /* "hex" */): String
    fun getPrivateKey(): Buffer
    fun getPrivateKey(encoding: String /* "base64" */): String
    fun getPrivateKey(encoding: String /* "latin1" */): String
    fun getPrivateKey(encoding: String /* "hex" */): String
    fun setPublicKey(public_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */)
    fun setPublicKey(public_key: String, encoding: String)
    fun setPrivateKey(private_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */)
    fun setPrivateKey(private_key: String, encoding: String)
    var verifyError: Number
}
external fun getDiffieHellman(group_name: String): DiffieHellman = definedExternally
external fun pbkdf2(password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, salt: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iterations: Number, keylen: Number, digest: String, callback: (err: Error?, derivedKey: Buffer) -> Any): Unit = definedExternally
external fun pbkdf2Sync(password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, salt: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, iterations: Number, keylen: Number, digest: String): Buffer = definedExternally
external fun randomBytes(size: Number): Buffer = definedExternally
external fun randomBytes(size: Number, callback: (err: Error?, buf: Buffer) -> Unit): Unit = definedExternally
external fun pseudoRandomBytes(size: Number): Buffer = definedExternally
external fun pseudoRandomBytes(size: Number, callback: (err: Error?, buf: Buffer) -> Unit): Unit = definedExternally
external fun <T /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> randomFillSync(buffer: T, offset: Number? = definedExternally /* null */, size: Number? = definedExternally /* null */): T = definedExternally
external fun <T /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> randomFill(buffer: T, callback: (err: Error?, buf: T) -> Unit): Unit = definedExternally
external fun <T /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> randomFill(buffer: T, offset: Number, callback: (err: Error?, buf: T) -> Unit): Unit = definedExternally
external fun <T /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */> randomFill(buffer: T, offset: Number, size: Number, callback: (err: Error?, buf: T) -> Unit): Unit = definedExternally
external interface ScryptOptions {
    var N: Number? get() = definedExternally; set(value) = definedExternally
    var r: Number? get() = definedExternally; set(value) = definedExternally
    var p: Number? get() = definedExternally; set(value) = definedExternally
    var maxmem: Number? get() = definedExternally; set(value) = definedExternally
}
external fun scrypt(password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, salt: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, keylen: Number, callback: (err: Error?, derivedKey: Buffer) -> Unit): Unit = definedExternally
external fun scrypt(password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, salt: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, keylen: Number, options: ScryptOptions, callback: (err: Error?, derivedKey: Buffer) -> Unit): Unit = definedExternally
external fun scryptSync(password: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, salt: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, keylen: Number, options: ScryptOptions? = definedExternally /* null */): Buffer = definedExternally
external interface RsaPublicKey {
    var key: String
    var padding: Number? get() = definedExternally; set(value) = definedExternally
}
external interface RsaPrivateKey {
    var key: String
    var passphrase: String? get() = definedExternally; set(value) = definedExternally
    var padding: Number? get() = definedExternally; set(value) = definedExternally
}
external fun publicEncrypt(public_key: String, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer = definedExternally
external fun publicEncrypt(public_key: RsaPublicKey, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer = definedExternally
external fun privateDecrypt(private_key: String, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer = definedExternally
external fun privateDecrypt(private_key: RsaPrivateKey, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer = definedExternally
external fun privateEncrypt(private_key: String, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer = definedExternally
external fun privateEncrypt(private_key: RsaPrivateKey, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer = definedExternally
external fun publicDecrypt(public_key: String, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer = definedExternally
external fun publicDecrypt(public_key: RsaPublicKey, buffer: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer = definedExternally
external fun getCiphers(): Array<String> = definedExternally
external fun getCurves(): Array<String> = definedExternally
external fun getHashes(): Array<String> = definedExternally
open external class ECDH {
    open fun generateKeys(): Buffer = definedExternally
    open fun generateKeys(encoding: String /* "base64" */, format: String? /* "uncompressed" */ = definedExternally /* null */): String = definedExternally
    open fun generateKeys(encoding: String /* "base64" */, format: String? /* "compressed" */ = definedExternally /* null */): String = definedExternally
    open fun generateKeys(encoding: String /* "base64" */, format: String? /* "hybrid" */ = definedExternally /* null */): String = definedExternally
    open fun generateKeys(encoding: String /* "latin1" */, format: String? /* "uncompressed" */ = definedExternally /* null */): String = definedExternally
    open fun generateKeys(encoding: String /* "latin1" */, format: String? /* "compressed" */ = definedExternally /* null */): String = definedExternally
    open fun generateKeys(encoding: String /* "latin1" */, format: String? /* "hybrid" */ = definedExternally /* null */): String = definedExternally
    open fun generateKeys(encoding: String /* "hex" */, format: String? /* "uncompressed" */ = definedExternally /* null */): String = definedExternally
    open fun generateKeys(encoding: String /* "hex" */, format: String? /* "compressed" */ = definedExternally /* null */): String = definedExternally
    open fun generateKeys(encoding: String /* "hex" */, format: String? /* "hybrid" */ = definedExternally /* null */): String = definedExternally
    open fun computeSecret(other_public_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Buffer = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "base64" */): Buffer = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "latin1" */): Buffer = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "hex" */): Buffer = definedExternally
    open fun computeSecret(other_public_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, output_encoding: String /* "base64" */): String = definedExternally
    open fun computeSecret(other_public_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, output_encoding: String /* "latin1" */): String = definedExternally
    open fun computeSecret(other_public_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, output_encoding: String /* "hex" */): String = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "base64" */, output_encoding: String /* "base64" */): String = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "base64" */, output_encoding: String /* "latin1" */): String = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "base64" */, output_encoding: String /* "hex" */): String = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "latin1" */, output_encoding: String /* "base64" */): String = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "latin1" */, output_encoding: String /* "latin1" */): String = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "latin1" */, output_encoding: String /* "hex" */): String = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "hex" */, output_encoding: String /* "base64" */): String = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "hex" */, output_encoding: String /* "latin1" */): String = definedExternally
    open fun computeSecret(other_public_key: String, input_encoding: String /* "hex" */, output_encoding: String /* "hex" */): String = definedExternally
    open fun getPrivateKey(): Buffer = definedExternally
    open fun getPrivateKey(encoding: String /* "base64" */): String = definedExternally
    open fun getPrivateKey(encoding: String /* "latin1" */): String = definedExternally
    open fun getPrivateKey(encoding: String /* "hex" */): String = definedExternally
    open fun getPublicKey(): Buffer = definedExternally
    open fun getPublicKey(encoding: String /* "base64" */, format: String? /* "uncompressed" */ = definedExternally /* null */): String = definedExternally
    open fun getPublicKey(encoding: String /* "base64" */, format: String? /* "compressed" */ = definedExternally /* null */): String = definedExternally
    open fun getPublicKey(encoding: String /* "base64" */, format: String? /* "hybrid" */ = definedExternally /* null */): String = definedExternally
    open fun getPublicKey(encoding: String /* "latin1" */, format: String? /* "uncompressed" */ = definedExternally /* null */): String = definedExternally
    open fun getPublicKey(encoding: String /* "latin1" */, format: String? /* "compressed" */ = definedExternally /* null */): String = definedExternally
    open fun getPublicKey(encoding: String /* "latin1" */, format: String? /* "hybrid" */ = definedExternally /* null */): String = definedExternally
    open fun getPublicKey(encoding: String /* "hex" */, format: String? /* "uncompressed" */ = definedExternally /* null */): String = definedExternally
    open fun getPublicKey(encoding: String /* "hex" */, format: String? /* "compressed" */ = definedExternally /* null */): String = definedExternally
    open fun getPublicKey(encoding: String /* "hex" */, format: String? /* "hybrid" */ = definedExternally /* null */): String = definedExternally
    open fun setPrivateKey(private_key: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Unit = definedExternally
    open fun setPrivateKey(private_key: String, encoding: String /* "base64" */): Unit = definedExternally
    open fun setPrivateKey(private_key: String, encoding: String /* "latin1" */): Unit = definedExternally
    open fun setPrivateKey(private_key: String, encoding: String /* "hex" */): Unit = definedExternally
    companion object {
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String, inputEncoding: String? /* "base64" */ = definedExternally /* null */, outputEncoding: String? /* "base64" */ = definedExternally /* null */, format: dynamic /* String? /* "uncompressed" */ | String? /* "compressed" */ | String? /* "hybrid" */ */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String, inputEncoding: String? /* "base64" */ = definedExternally /* null */, outputEncoding: String? /* "latin1" */ = definedExternally /* null */, format: dynamic /* String? /* "uncompressed" */ | String? /* "compressed" */ | String? /* "hybrid" */ */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String, inputEncoding: String? /* "base64" */ = definedExternally /* null */, outputEncoding: String? /* "hex" */ = definedExternally /* null */, format: dynamic /* String? /* "uncompressed" */ | String? /* "compressed" */ | String? /* "hybrid" */ */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String, inputEncoding: String? /* "latin1" */ = definedExternally /* null */, outputEncoding: String? /* "base64" */ = definedExternally /* null */, format: dynamic /* String? /* "uncompressed" */ | String? /* "compressed" */ | String? /* "hybrid" */ */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String, inputEncoding: String? /* "latin1" */ = definedExternally /* null */, outputEncoding: String? /* "latin1" */ = definedExternally /* null */, format: dynamic /* String? /* "uncompressed" */ | String? /* "compressed" */ | String? /* "hybrid" */ */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String, inputEncoding: String? /* "latin1" */ = definedExternally /* null */, outputEncoding: String? /* "hex" */ = definedExternally /* null */, format: dynamic /* String? /* "uncompressed" */ | String? /* "compressed" */ | String? /* "hybrid" */ */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String, inputEncoding: String? /* "hex" */ = definedExternally /* null */, outputEncoding: String? /* "base64" */ = definedExternally /* null */, format: dynamic /* String? /* "uncompressed" */ | String? /* "compressed" */ | String? /* "hybrid" */ */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String, inputEncoding: String? /* "hex" */ = definedExternally /* null */, outputEncoding: String? /* "latin1" */ = definedExternally /* null */, format: dynamic /* String? /* "uncompressed" */ | String? /* "compressed" */ | String? /* "hybrid" */ */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String, inputEncoding: String? /* "hex" */ = definedExternally /* null */, outputEncoding: String? /* "hex" */ = definedExternally /* null */, format: dynamic /* String? /* "uncompressed" */ | String? /* "compressed" */ | String? /* "hybrid" */ */ = definedExternally /* null */): dynamic /* String | Buffer */ = definedExternally
        fun convertKey(key: dynamic /* String | Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, curve: String): dynamic /* String | Buffer */ = definedExternally
    }
    open fun generateKeys(encoding: String /* "base64" */): String = definedExternally
    open fun generateKeys(encoding: String /* "latin1" */): String = definedExternally
    open fun generateKeys(encoding: String /* "hex" */): String = definedExternally
    open fun getPublicKey(encoding: String /* "base64" */): String = definedExternally
    open fun getPublicKey(encoding: String /* "latin1" */): String = definedExternally
    open fun getPublicKey(encoding: String /* "hex" */): String = definedExternally
}
external fun createECDH(curve_name: String): ECDH = definedExternally
external fun timingSafeEqual(a: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */, b: dynamic /* Buffer | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | Float32Array | Float64Array | DataView */): Boolean = definedExternally
external var DEFAULT_ENCODING: String = definedExternally
external interface BasePrivateKeyEncodingOptions<T /* String /* "pem" */ | String /* "der" */ */> {
    var format: T
    var cipher: String
    var passphrase: String
}
external interface `T$99`<PubF> {
    var type: dynamic /* String /* "pkcs1" */ | String /* "spki" */ */
    var format: PubF
}
external interface `T$100` {
    var type: dynamic /* String /* "pkcs1" */ | String /* "pkcs8" */ */
}
external interface RSAKeyPairOptions<PubF /* String /* "pem" */ | String /* "der" */ */, PrivF /* String /* "pem" */ | String /* "der" */ */> {
    var modulusLength: Number
    var publicExponent: Number? get() = definedExternally; set(value) = definedExternally
    var publicKeyEncoding: `T$99`<PubF>
    var privateKeyEncoding: BasePrivateKeyEncodingOptions<PrivF> /* BasePrivateKeyEncodingOptions<PrivF> & `T$100` */
}
external interface `T$101`<PubF> {
    var type: String /* "spki" */
    var format: PubF
}
external interface `T$102` {
    var type: String /* "pkcs8" */
}
external interface DSAKeyPairOptions<PubF /* String /* "pem" */ | String /* "der" */ */, PrivF /* String /* "pem" */ | String /* "der" */ */> {
    var modulusLength: Number
    var divisorLength: Number
    var publicKeyEncoding: `T$101`<PubF>
    var privateKeyEncoding: BasePrivateKeyEncodingOptions<PrivF> /* BasePrivateKeyEncodingOptions<PrivF> & `T$102` */
}
external interface `T$103` {
    var type: dynamic /* String /* "pkcs8" */ | String /* "sec1" */ */
}
external interface ECKeyPairOptions<PubF /* String /* "pem" */ | String /* "der" */ */, PrivF /* String /* "pem" */ | String /* "der" */ */> {
    var namedCurve: String
    var publicKeyEncoding: `T$99`<PubF>
    var privateKeyEncoding: BasePrivateKeyEncodingOptions<PrivF> /* BasePrivateKeyEncodingOptions<PrivF> & `T$103` */
}
external interface KeyPairSyncResult<T1 /* String | Buffer */, T2 /* String | Buffer */> {
    var publicKey: T1
    var privateKey: T2
}
external fun generateKeyPairSync(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "pem" */, String /* "pem" */>): KeyPairSyncResult<String, String> = definedExternally
external fun generateKeyPairSync(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "pem" */, String /* "der" */>): KeyPairSyncResult<String, Buffer> = definedExternally
external fun generateKeyPairSync(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "der" */, String /* "pem" */>): KeyPairSyncResult<Buffer, String> = definedExternally
external fun generateKeyPairSync(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "der" */, String /* "der" */>): KeyPairSyncResult<Buffer, Buffer> = definedExternally
external fun generateKeyPairSync(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "pem" */, String /* "pem" */>): KeyPairSyncResult<String, String> = definedExternally
external fun generateKeyPairSync(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "pem" */, String /* "der" */>): KeyPairSyncResult<String, Buffer> = definedExternally
external fun generateKeyPairSync(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "der" */, String /* "pem" */>): KeyPairSyncResult<Buffer, String> = definedExternally
external fun generateKeyPairSync(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "der" */, String /* "der" */>): KeyPairSyncResult<Buffer, Buffer> = definedExternally
external fun generateKeyPairSync(type: String /* "ec" */, options: ECKeyPairOptions<String /* "pem" */, String /* "pem" */>): KeyPairSyncResult<String, String> = definedExternally
external fun generateKeyPairSync(type: String /* "ec" */, options: ECKeyPairOptions<String /* "pem" */, String /* "der" */>): KeyPairSyncResult<String, Buffer> = definedExternally
external fun generateKeyPairSync(type: String /* "ec" */, options: ECKeyPairOptions<String /* "der" */, String /* "pem" */>): KeyPairSyncResult<Buffer, String> = definedExternally
external fun generateKeyPairSync(type: String /* "ec" */, options: ECKeyPairOptions<String /* "der" */, String /* "der" */>): KeyPairSyncResult<Buffer, Buffer> = definedExternally
external fun generateKeyPair(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "pem" */, String /* "pem" */>, callback: (err: Error?, publicKey: String, privateKey: String) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "pem" */, String /* "der" */>, callback: (err: Error?, publicKey: String, privateKey: Buffer) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "der" */, String /* "pem" */>, callback: (err: Error?, publicKey: Buffer, privateKey: String) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "der" */, String /* "der" */>, callback: (err: Error?, publicKey: Buffer, privateKey: Buffer) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "pem" */, String /* "pem" */>, callback: (err: Error?, publicKey: String, privateKey: String) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "pem" */, String /* "der" */>, callback: (err: Error?, publicKey: String, privateKey: Buffer) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "der" */, String /* "pem" */>, callback: (err: Error?, publicKey: Buffer, privateKey: String) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "der" */, String /* "der" */>, callback: (err: Error?, publicKey: Buffer, privateKey: Buffer) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "ec" */, options: ECKeyPairOptions<String /* "pem" */, String /* "pem" */>, callback: (err: Error?, publicKey: String, privateKey: String) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "ec" */, options: ECKeyPairOptions<String /* "pem" */, String /* "der" */>, callback: (err: Error?, publicKey: String, privateKey: Buffer) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "ec" */, options: ECKeyPairOptions<String /* "der" */, String /* "pem" */>, callback: (err: Error?, publicKey: Buffer, privateKey: String) -> Unit): Unit = definedExternally
external fun generateKeyPair(type: String /* "ec" */, options: ECKeyPairOptions<String /* "der" */, String /* "der" */>, callback: (err: Error?, publicKey: Buffer, privateKey: Buffer) -> Unit): Unit = definedExternally

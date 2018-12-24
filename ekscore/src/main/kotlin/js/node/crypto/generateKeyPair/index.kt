@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "UNUSED")
@file:[JsModule("crypto") JsQualifier("generateKeyPair")]
package js.node.crypto.generateKeyPair

import js.node.Buffer
import js.node.crypto.RSAKeyPairOptions
import js.node.crypto.DSAKeyPairOptions
import js.node.crypto.ECKeyPairOptions
import kotlin.js.*

external interface `T$104` {
    var publicKey: String
    var privateKey: String
}
external fun __promisify__(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "pem" */, String /* "pem" */>): Promise<`T$104`> = definedExternally
external interface `T$105` {
    var publicKey: String
    var privateKey: Buffer
}
external fun __promisify__(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "pem" */, String /* "der" */>): Promise<`T$105`> = definedExternally
external interface `T$106` {
    var publicKey: Buffer
    var privateKey: String
}
external fun __promisify__(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "der" */, String /* "pem" */>): Promise<`T$106`> = definedExternally
external interface `T$107` {
    var publicKey: Buffer
    var privateKey: Buffer
}
external fun __promisify__(type: String /* "rsa" */, options: RSAKeyPairOptions<String /* "der" */, String /* "der" */>): Promise<`T$107`> = definedExternally
external fun __promisify__(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "pem" */, String /* "pem" */>): Promise<`T$104`> = definedExternally
external fun __promisify__(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "pem" */, String /* "der" */>): Promise<`T$105`> = definedExternally
external fun __promisify__(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "der" */, String /* "pem" */>): Promise<`T$106`> = definedExternally
external fun __promisify__(type: String /* "dsa" */, options: DSAKeyPairOptions<String /* "der" */, String /* "der" */>): Promise<`T$107`> = definedExternally
external fun __promisify__(type: String /* "ec" */, options: ECKeyPairOptions<String /* "pem" */, String /* "pem" */>): Promise<`T$104`> = definedExternally
external fun __promisify__(type: String /* "ec" */, options: ECKeyPairOptions<String /* "pem" */, String /* "der" */>): Promise<`T$105`> = definedExternally
external fun __promisify__(type: String /* "ec" */, options: ECKeyPairOptions<String /* "der" */, String /* "pem" */>): Promise<`T$106`> = definedExternally
external fun __promisify__(type: String /* "ec" */, options: ECKeyPairOptions<String /* "der" */, String /* "der" */>): Promise<`T$107`> = definedExternally

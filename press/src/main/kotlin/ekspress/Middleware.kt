/*
 * ekspress
 *
 * ミドルウェアを作るのに必要なものをまとめたモジュール
 * async/awaitを前提にしているが、本当はlaunch/joinだよねとかいわないこと。
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

import kotlin.coroutines.experimental.*
import kotlin.js.Promise

/**
 * ekspressがサポートするメソッドは、当面、この5種類
 *
 * 本当はここにある必要はないのだけど、
 * ミドルウェアを作る時にここにあった方がいいかなと思ったので、ここに置いた。
 */
enum class Method {
    HEAD,
    GET,
    PUT,
    POST,
    DELETE
}

/**
 * Expressでのミドルウェアに相当する関数型
 *
 * @args context コンテキスト
 * @args next 次に実行するMiddlewareに処理を渡すための関数
 */
typealias Handler = suspend (context: Context, next: NextProc)->Unit

/**
 * express.jsやkoa.jsでのnext()は、クロージャなので、
 * Application内のクラスで代用している
 * ここでは、そのインターフェースだけ決めている
 * @args context コンテキスト
 * @return プロミス（なので、await()を呼ぶ必要がある）
 */
typealias NextProc = (context: Context)->Promise<Unit>

/**
 * 引数も返値も持たないコールバック関数型
 */
typealias Procedure = ()->Unit

/**
 * 非同期な処理をを行う関数
 * 返値には特に意味は無いので、launchという名前の方が適切だが、
 * await()との対比としてasyncとした
 */
@Suppress("unused")
fun async(block: suspend ()->Unit): Promise<Unit> {
    val continuation = object : Continuation<Unit> {
        override val context: CoroutineContext get() = EmptyCoroutineContext
        override fun resume(value: Unit) {}
        override fun resumeWithException(exception: Throwable) = throw exception
    }
    block.startCoroutine(continuation)
    return Promise.resolve(Unit)
}

/**
 * 非同期処理の完了を待つ拡張メソッド
 */
@Suppress("unused")
suspend fun <T> Promise<T>.await(): T = suspendCoroutine { continuation ->
    then(
            onFulfilled = { continuation.resume(it) },
            onRejected = { continuation.resumeWithException(it) }
    )
}

/**
 * ミドルウェアの大本
 */
interface Middleware {

    /**
     * ハンドラ
     * コンテキストにエラーが含まれているかどうかで、
     * errorHandle()とrequestHandler()を使い分けている
     * このメソッド自体、openなので、override可能
     *
     * @args context コンテキスト
     * @args next 次に実行するMiddlewareに処理を渡すための管理オブジェクト
     */
    suspend fun handle(context: Context, next: NextProc) {
        if (context.hasError) {
            errorHandle(context, next)
        } else {
            requestHandle(context, next)
        }
    }

    /**
     * 正常時のリクエスト・ハンドラ
     *
     * @args context コンテキスト
     * @args next 次に実行するMiddlewareに処理を渡すための管理オブジェクト
     */
    suspend fun requestHandle(context: Context, next: NextProc)

    /**
     * エラー・ハンドラ
     *
     * @args context コンテキスト
     * @args next 次に実行するMiddlewareに処理を渡すための管理オブジェクト
     */
    suspend fun errorHandle(context: Context, next: NextProc)

    /**
     * エラーはスルーする実装になっているので、
     * 正常なリクエストだけを扱いたい場合は、
     * このクラスを継承する。
     */
    @Suppress("unused")
    interface OnRequest : Middleware {
        override suspend fun  errorHandle(context: Context, next: NextProc) {
            next(context).await()
        }

        /**
         * 正常時の処理をラムダで渡すことによってミドルウェアを生成するクラス
         *
         * @args handler 正常時の処理を行う関数
         */
        class Instant(private val handler: Handler) : OnRequest {
            override suspend fun requestHandle(context: Context, next: NextProc) = handler(context, next)
        }
    }

    /**
     * 正常なリクエストはスルーする実装になっているので、
     * エラー・ハンドラの場合は、このクラスを継承する
     */
    @Suppress("unused")
    interface OnError : Middleware {
        override suspend fun requestHandle(context: Context, next: NextProc) {
            next(context).await()
        }

        /**
         * エラー時の処理をラムダで渡すことによってミドルウェアを生成するクラス
         *
         * @args handler エラー時の処理を行う関数
         */
        class Instant(private val handler: Handler) : OnError {
            override suspend fun errorHandle(context: Context, next: NextProc) = handler(context, next)
        }
    }

    /**
     * ロギングなど必ずnextを処理することがわかっているミドルウェアを生成するクラス
     */
    @Suppress("unused")
    class Interceptor(private val handler: (context: Context)->Unit) : Middleware {

        override suspend fun handle(context: Context, next: NextProc) {
            async {
                handler(context)
            }
            next(context).await()
        }

        override suspend fun requestHandle(context: Context, next: NextProc) {
            next(context).await()
        }

        override suspend fun errorHandle(context: Context, next: NextProc) {
            next(context).await()
        }
    }
}

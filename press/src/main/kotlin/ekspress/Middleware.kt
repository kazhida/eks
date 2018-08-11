/*
 * ekspress
 *
 * ミドルウェアを作るのに必要なものをまとめたモジュール
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress

/**
 * ekspressがサポートするメソッドは、当面、この4種類
 *
 * 本当はここにある必要はないのだけど、
 * ミドルウェアを作る時にここにあった方がいいかなと思ったので、ここに置いた。
 */
enum class Method {
    GET,
    PUT,
    POST,
    DELETE
}

/**
 * Expressでのミドルウェアに相当する関数型
 *
 * @args context コンテキスト
 * @args next 次に実行するMiddlewareに処理を渡すための管理オブジェクト
 */
typealias Handler = (context: Context, next: NextProc)->Unit

/**
 * 引数も返値も持たないコールバック関数型
 */
typealias EmptyCallback = ()->Unit

/**
 * Expressでのnext()は、クロージャなので、Applicationないのクラスで代用している
 * ここでは、そのインターフェースだけ決めている
 */
interface NextProc {
    /**
     * @args context コンテキスト
     */
    fun call(context: Context)
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
    fun handle(context: Context, next: NextProc?) {
        if (next != null) {
            if (context.hasError) {
                errorHandle(context, next)
            } else {
                requestHandle(context, next)
            }
        }
    }

    /**
     * 正常時のリクエスト・ハンドラ
     *
     * @args context コンテキスト
     * @args next 次に実行するMiddlewareに処理を渡すための管理オブジェクト
     */
    fun requestHandle(context: Context, next: NextProc)

    /**
     * エラー・ハンドラ
     *
     * @args context コンテキスト
     * @args next 次に実行するMiddlewareに処理を渡すための管理オブジェクト
     */
    fun errorHandle(context: Context, next: NextProc)

    /**
     * エラーはスルーする実装になっているので、
     * 正常なリクエストだけを扱いたい場合は、
     * このクラスを継承する。
     */
    @Suppress("unused")
    interface OnRequest : Middleware {
        override fun errorHandle(context: Context, next: NextProc) { next.call(context) }

        /**
         * 正常時の処理をラムダで渡すことによってミドルウェアを生成するクラス
         *
         * @args handler 正常時の処理を行う関数
         */
        class Instant(private val handler: Handler) : OnRequest {
            override fun requestHandle(context: Context, next: NextProc) = handler(context, next)
        }
    }

    /**
     * 正常なリクエストはスルーする実装になっているので、
     * エラー・ハンドラの場合は、このクラスを継承する
     */
    @Suppress("unused")
    interface OnError : Middleware {
        override fun requestHandle(context: Context, next: NextProc) { next.call(context) }

        /**
         * エラー時の処理をラムダで渡すことによってミドルウェアを生成するクラス
         *
         * @args handler エラー時の処理を行う関数
         */
        class Instant(private val handler: Handler) : OnError {
            override fun errorHandle(context: Context, next: NextProc) = handler(context, next)
        }
    }
}

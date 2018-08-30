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
 * @return 次のMiddlewareに渡すコンテキスト
 */
typealias Handler = (context: Context)->Context

/**
 * 引数も返値も持たないコールバック関数型
 */
typealias Procedure = ()->Unit

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
     * @return 次のMiddlewareに渡すコンテキスト
     */
    fun handle(context: Context): Context

    /**
     * 正常時の処理をラムダで渡すことによってミドルウェアを生成するクラス
     *
     * @args handler 正常時の処理を行う関数
     */
    @Suppress("unused")
    class Handle(private val handler: Handler) : Middleware {
        override fun handle(context: Context): Context = handler(context)
    }

    /**
     * ロギングなどのようにコンテキストを変更しないミドルウェアを生成するクラス
     *
     * @args interceptor 処理を行う関数
     */
    @Suppress("Unused")
    class Through(private val interceptor: (Context)->Unit) : Middleware {
        override fun handle(context: Context): Context = context.also { interceptor(it) }
    }
}

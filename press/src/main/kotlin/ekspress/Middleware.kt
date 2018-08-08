package ekspress

typealias NextProc = (route: Any?)->Unit
typealias Handler = (context: Context, next: NextProc)->Unit

abstract class Middleware {
    abstract fun handle(context: Context, next: NextProc)

    class Instant(private val handler: Handler) : Middleware() {
        override fun handle(context: Context, next: NextProc) = handler(context, next)
    }
}

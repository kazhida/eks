package ekspress

enum class Method {
    ALL,
    GET,
    PUT,
    POST,
    DELETE
}

class Application(
        rootPath: String = "/"
) : Middleware() {

    val host: String = ""

    private fun use(method: Method, path: String, middleware: Middleware) {

    }

    fun use(path: String, middleware: Middleware) = use(Method.ALL, path, middleware)
    fun get(path: String, middleware: Middleware)  = use(Method.GET, path, middleware)
    fun put(path: String, middleware: Middleware)  = use(Method.PUT, path, middleware)
    fun post(path: String, middleware: Middleware)  = use(Method.POST, path, middleware)
    fun delete(path: String, middleware: Middleware) = use(Method.DELETE, path, middleware)

    fun listen(port: Int, connected: (app: Application)->Unit) {

    }

    override fun handle(context: Context, next: NextProc) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

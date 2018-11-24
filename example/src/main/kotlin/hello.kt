import ekspress.Application

fun main(args: Array<String>) {
    println("Hello JavaScript!")

    val app = Application()

    app.get("/") {
        ctx -> ctx.ok200("text/plain", "i am a beautiful butterfly")
    }

    app.listen(3000, null) {
        println("Listening on port 3000")
    }
}

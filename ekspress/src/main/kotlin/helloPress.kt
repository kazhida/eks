
fun helloPress(s: String): String {
    val prefix = "press:"
    val suffix = "!"
    val result = "$prefix $s $suffix"
    console.log("return $result")
    return result
}

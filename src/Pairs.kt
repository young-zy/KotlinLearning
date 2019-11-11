val equipment = "fishnet" to "catching fish"
val equipment2 = "fishnet" to "catching fish" to "of big size" to "and strong"

val fishnet = "fishnet" to "catching fish"

fun main() {
    println(equipment2)

    //destructuring
//    val (tool, use) = fishnet
//    println("The $tool is a tool for $use")
    //to list
    println(fishnet.toList())

    //use: return more than one value in function
    val (tool, use) = giveMeATool()
    println(tool + use)
}

fun giveMeATool(): Pair<String, String> {
    return ("fishnet" to "catching")
}
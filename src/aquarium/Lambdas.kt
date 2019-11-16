package aquarium

fun main() {
    { println("Hello Fish") }()
    val waterFilter = { dirty: Int -> dirty / 2 }
    waterFilter(30)         //15
    val myFish = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))
    val str = myFish.filter { it.name.contains("i") }.joinToString(", ") { it.name }      //Flipper, Moby Dick
    println(str)
}


data class Fish(val name: String)
package aquarium5

data class Fish(var name: String)

fun main() {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

    with(fish.name) {
        capitalize()
    }
    myWith(fish.name) {
        println(capitalize())    //block function
    }
    println(fish.run { name })
    println(fish.apply { })    //return fish object

    val fish2: Fish = Fish("splashy").apply { name = "Sharky" }
    println(fish2.name)

    // run returns the return value of the lambda
    // apply returns the object after the lambda is executed
    // let returns the  copy of the changed object

    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it + 31 })
}


fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

package aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {
    val size: Int

    init {
        println("first init block")
    }

    constructor() : this(true, 9) {
        println("running secondary constructor")
    }

    init {
        size = if (friendly) {
            volumeNeeded
        } else {
            volumeNeeded * 2
        }
    }

    init {
        println("last init block")
    }
}

fun makeDefaultFish() = Fish(true, 50) // helper function

fun fishExample() {
    val fish = Fish(true, 20)
    println()

}
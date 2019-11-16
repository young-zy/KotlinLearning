package aquarium

class OldFish(val friendly: Boolean = true, volumeNeeded: Int) {
    val size: Int = if (friendly) {
        volumeNeeded
    } else {
        volumeNeeded * 2
    }

    init {
        println("first init block")
    }

    constructor() : this(true, 9) {
        println("running secondary constructor")
    }

    init {
        println("last init block")
    }
}

fun makeDefaultFish() = OldFish(true, 50) // helper function

fun fishExample() {
    val fish = OldFish(true, 20)
    println(fish)

}
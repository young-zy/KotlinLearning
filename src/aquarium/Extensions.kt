package aquarium

fun String.hasSpaces() = find { it == ' ' } != null

fun extensionsExample() {
    "Does it have spaces?".hasSpaces() // true
}

open class AquariumPlant(val color: String, private val size: Int)

fun AquariumFish.isRed() = color == "Red" //don't have access to private variable

class GreenLeafyPlant(size: Int) : AquariumPlant("Green", size)

fun AquariumPlant.print() = println("AquariumPlant")

fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print() // GreenLeafyPlant
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print() // AquariumPlant

    //external function is resolved statically
    //(at compile time)
    //so it checks the type to execute
}

//extension properties
val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun AquariumPlant?.pull() {
    this?.apply {
        println("resolving $this")
    }
}

fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull()
}
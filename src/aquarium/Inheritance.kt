package aquarium

interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

abstract class AquariumFish : FishAction {
    abstract val color: String
    override fun eat() = println("yum")
}

fun main() {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}
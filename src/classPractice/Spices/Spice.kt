package classPractice.Spices

fun main() {
    val curry = Curry("new curry")
    println("curry's color is ${curry.color}")

}

abstract class Spice(var name: String, var spiciness: String = "mild") {

    abstract fun prepareSpice()

    init {
        println("$name $heat")
    }

    var heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }
        set(value) {

        }
}
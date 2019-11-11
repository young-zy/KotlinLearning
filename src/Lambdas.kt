import kotlin.random.Random

fun main() {
    gameplay(rollDice2(4))
}

val rollDice = { sides: Int -> if (sides == 0) 0 else Random.nextInt(sides) + 1 }

val rollDice2: (Int) -> Int = { sides -> if (sides == 0) 0 else Random.nextInt(sides) + 1 }

fun gameplay(operation: Int) {
    println(operation)
}
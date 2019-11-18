package aquarium5

val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

fun main() {
    println(numbers.divisibleBy { it.rem(3) })
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val res = mutableListOf<Int>()
    this.forEach {
        if (block(it) == 0) {
            res.add(it)
        }
    }
    return res
}
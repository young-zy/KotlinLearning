package collections

fun main() {
    val list = listOf<Int>(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    println(list.reversed())
}

fun reverseList(list: List<Int>): List<Int> {
    val result: MutableList<Int> = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        result.add(list.get(i))
    }
    return result
}
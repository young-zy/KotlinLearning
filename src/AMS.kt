fun main() {
    eagerExample()
    feedTheFish()
    repeat(2) {
        println("A fish is swimming")
    }
//    println( canAddFish(10.0, listOf(3,3,3)))
//    println( canAddFish(8.0, listOf(2,2,2), hasDecorations = false) )
//    println( canAddFish(9.0, listOf(1,1,3), 3) )
//    println( canAddFish(10.0, listOf(), 7, true))

}

var dirty = 20

val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) { dirty ->
        dirty + 50
    }
}

fun getDirtySensorReading() = 20

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = 20
): Boolean {

//    val isTooHot = temperature>30
//    val isDirty = dirty > 30
//    val isSunday = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"


fun canAddFish(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true
): Boolean {
//    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
    var sum = 0
    for (fish in currentFish) {
        sum += fish
    }
    var res: Boolean
    if (hasDecorations) {
        if (tankSize * 0.8 < sum + fishSize) {
            return false
        }
    } else {
        if (tankSize < sum + fishSize) {
            return false
        }
    }
    return true
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eats $food")
    if (shouldChangeWater(day)) {
        println("change the water today")
    }

    dirtyProcessor()
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "Flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter { it[0] == 'p' }
    println(eager)

    // apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    val lazymap = decorations.asSequence().map {
        println("map: $it")
        it
    }
    println(lazymap)
    println("first: ${lazymap.first()}")
    println("all: ${lazymap.toList()}")
}


enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game {
    var path: MutableList<Directions> = mutableListOf(Directions.START)
    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }
    val end = {
        path.add(Directions.END)
        println("Game Over")
        println(path)
        path.clear()
        false
    }

    fun move(where: () -> Boolean) {
//        where.invoke()
        where()         //same??
        //move location
    }

    fun makeMove(dir: String) {
        move(
            when (dir) {
                "n" -> north
                "s" -> south
                "e" -> east
                "w" -> west
                else -> north
            }
        )

    }

}

fun main() {
    val game = Game()
//    game.north
//    game.east
//    game.south
//    game.west
//    game.end
//    println(game.path)
    while (true) {
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine() ?: "n")
    }
}


class Location(val width: Int = 4, val height: Int = 4) {
    val map = Array(width) { arrayOfNulls<String>(height) }

    init {
        for (i in 0..3) {
            for (j in 0..3) {
                map[i][j] = (i * 4 + j).toString()
            }
        }
    }

    fun updateLocation() {

    }

}
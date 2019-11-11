package aquarium

object MobyDickWhale {

    val author = "Herman Melville"

    fun jump() {
        //..
    }
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

sealed class Seal //can only used in this file, compiler gives extra check

class SeaLion : Seal()
class Walrus : Seal()
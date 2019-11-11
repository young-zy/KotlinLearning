package classPractice

class SimpleSpice {
    var name: String = "curry"
    var spiciness: String = "mild"
    var heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 5
                else -> 0
            }
        }
        set(value) {}
}
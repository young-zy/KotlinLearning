import java.util.*

fun main() {
    println("Your fortune is: ${getFortuneCookie()}")

    var fortune: String = ""
    while (!fortune.contains("Take it easy")) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
    }
}

fun getFortune(birthday: Int): String {
    val fortuneWords = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    val index = when (birthday) {
        28 or 31 -> 1
        in 1..7 -> 4
        else -> birthday.rem(fortuneWords.size)
    }
    return fortuneWords[index]
}

fun getBirthday(): Int {
    print("Enter your birthday:")
    return readLine()?.toIntOrNull() ?: 1
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun getFortuneCookie(): String {
    val fortuneWords = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    print("Enter your birthday:")
    var birthday = 1
    birthday = readLine()?.toIntOrNull() ?: 1
    return fortuneWords[birthday.rem(fortuneWords.size)]
}

fun dayOfWeek() {
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    var date: String? = null
    when (day) {
        1 -> date = "Sunday"
        2 -> date = "Monday"
        3 -> date = "Tuesday"
        4 -> date = "Wednesday"
        5 -> date = "Thursday"
        6 -> date = "Friday"
        7 -> date = "Saturday"
    }
    println(date)
}
const val maximumBorrowNum = 10

fun main() {

}

fun canBorrow(borrowedBooks: Int): Boolean {
    return (borrowedBooks < maximumBorrowNum)
}

object Constants {
    const val BASE_URL = "https://BASE_URL.com/"
}
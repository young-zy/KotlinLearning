package classPractice

import Constants

open class Book(var title: String, var author: String, var year: String, var pages: Int = 300) {
    private var currentPage = 0
    open fun readPage() {
        currentPage++
    }

    fun titleAndAuthor(): Pair<String, String> = title to author
    fun titleAndAuthorANDYear(): Triple<String, String, String> = Triple(title, author, year)
    fun printUrl() {
        println(Constants.BASE_URL + "$title.html")
    }

    companion object {
        const val BASE_URL = "https://BASE_URL.com/"
    }
}

class eBook(title: String, author: String, var format: String = "text", year: String) : Book(title, author, year) {
    private var wordCount = 0
    override fun readPage() {
        wordCount += 250
    }
}

fun main() {
    val book = Book("book", "author", "2019")
    val bookProperty = book.titleAndAuthorANDYear()
    println("Here is your book ${bookProperty.first} written by ${bookProperty.second} in ${bookProperty.third}.")
}
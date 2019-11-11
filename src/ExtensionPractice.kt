import classPractice.Book

fun Book.getWeight() = (pages * 1.5)

fun Book.tornPages(page: Int) {
    if (pages >= page) pages -= page
    else pages = 0
}

class Puppy {
    fun playWithBook(book: Book) {
        book.tornPages((0..12).random())
    }
}

fun main() {
    val puppy = Puppy()
    val book = Book("title", "author", "2019")
    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }
    println("Done")
}
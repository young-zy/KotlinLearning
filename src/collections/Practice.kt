package collections

fun main() {
    var allBooks: Set<String> = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    var library: Map<String, Set<String>> = mapOf("Shakespeare" to allBooks)
    library.any { it.value.contains("Hamlet") }
    var moreBooks = mutableMapOf<String, String>("title" to "author")
    moreBooks.getOrPut("newTitle") { "newAuthor" }
    println(moreBooks)
}
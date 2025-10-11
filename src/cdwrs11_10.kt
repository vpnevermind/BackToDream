fun feast(beast: String, dish: String): Boolean = beast.first() == dish.first() && beast.last() == dish.last()

fun main() {
    feast("great blue heron", "garlic naan")
}
fun parse(data: String): List<Int> {
    val result = mutableListOf<Int>()
    var value = 0
    for (c in data) {
        when (c) {
            'i' -> value += 1
            'd' -> value -= 1
            's' -> value *= value
            'o' -> result.add(value)
        }
    }
    return result
}

fun main() {
    println(parse("iiisdosodddddiso").joinToString(" "))
}
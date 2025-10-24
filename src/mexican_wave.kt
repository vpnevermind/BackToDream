fun wave(str: String): List<String> {
    val result = mutableListOf<String>()
    for (i in 0..str.lastIndex) {
        if (str[i] != ' ') {
            val upChar = str[i].uppercaseChar()
            val ready = str.toMutableList()
            ready[i] = upChar
            val resStr = ready.joinToString("")
            result.add(resStr)
        }
    }
    return result
}

fun main() {
}
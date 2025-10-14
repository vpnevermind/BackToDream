fun high(str: String) : String {
    var winner = ""
    str.split(" ").forEach {
        val score = it.toCharArray().sumOf { it.code - 96 }
        if (score > winner.toCharArray().sumOf { it.code - 96 }) winner = it
    }
    return winner
}
fun main() {
    println("climbing".toCharArray().sumOf { it.code - 96 })
    println("volcano".toCharArray().sumOf { it.code - 96 })
    println('z'.code)
    println(high("what time are we climbing up the volcano"))
}
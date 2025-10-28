fun main() {
    println(multiplicationTable(5)[1].joinToString(""))
}

fun multiplicationTable(size: Int): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    for (i in 1..size) {
        val pre = IntArray(size) { index -> (index+1)* i}
        result.add(pre)
    }
    return result.toTypedArray()
}
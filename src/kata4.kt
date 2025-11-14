fun main() {
    val test = intArrayOf(-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9 , 10, 11, 14, 15, 17, 18, 19, 20)
    println(rangeExtraction(test))
}

fun rangeExtraction(arr: IntArray): String {
    val result = mutableListOf<String>()
    var currentArray = mutableListOf<Int>(arr[0])
    for (i in 1 until arr.size) {
        if (arr[i] == arr[i-1] + 1) {
            currentArray.add(arr[i])
        } else {
            when (currentArray.size) {
                1 -> result.add("${currentArray.last()}")
                2 -> currentArray.forEach { result.add("$it") }
                else -> result.add("${currentArray.first()}-${currentArray.last()}")
            }
            currentArray.clear()
            currentArray.add(arr[i])
        }
    }
    if (currentArray.isNotEmpty()) {
        when (currentArray.size) {
            1 -> result.add("${currentArray.last()}")
            2 -> currentArray.forEach { result.add("$it") }
            else -> result.add("${currentArray.first()}-${currentArray.last()}")
        }
    }
    return result.joinToString(",")
}
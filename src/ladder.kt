fun maps(x: IntArray): IntArray =
    x.map { it * 2 }.toIntArray()

fun nameValue(arr: Array<String>): IntArray {
    return arr.mapIndexed{ index, str ->
        str.filter { it != ' ' }.map {it.code - 96}.sum() * (index + 1)}.toIntArray()
}

//fun deleteNth(elements:IntArray, maxOcurrences:Int): IntArray {
//    return elements.filterIndexed { i, el -> elements.take(i+1).count{it == el} <= maxOcurrences }.toIntArray()
//}

//fun deleteNth(elements:IntArray, maxOcurrences:Int): IntArray {
//    val newElements = elements.toMutableList()
//    for (e in elements) {
//        val counted = newElements.count { it == e}
//        if (counted >= maxOcurrences ) {
//            repeat(counted - maxOcurrences) {
//                val last = newElements.lastIndexOf(e)
//                newElements.removeAt(last)
//            }
//        }
//    }
//    return newElements.toIntArray()
//}

fun deleteNth(elements:IntArray, maxOcurrences:Int): IntArray {
    val newElements = elements.toMutableList()
    for (v in elements.groupBy{it}.values.filter { it.size > maxOcurrences }) {
            repeat(v.size - maxOcurrences) {
                val last = newElements.lastIndexOf(v[0])
                newElements.removeAt(last)
            }
    }
    return newElements.toIntArray()
}

fun main() {
    println(deleteNth(intArrayOf(1,1,2,3,4,5,6,1,1,2,3,2, 1), 2).joinToString())


}
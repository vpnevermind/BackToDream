fun sqInRect(lng:Int, wdth:Int):List<Int>? {
    if (lng == wdth) return null
    val resList = ArrayList<Int>()
    var l = lng
    var w = wdth
    while(l != 0 && w != 0) {
        val smaller = minOf(l, w)
        resList.add(smaller)

        if (l == maxOf(l, w)) {
            l -= smaller
        } else {
            w -= smaller
        }
    }
    return resList
}

fun main() {
    println(sqInRect(5,5)?.joinToString(" "))
}
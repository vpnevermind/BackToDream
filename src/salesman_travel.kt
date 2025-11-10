fun travel(r:String, zipcode:String):String {
    val addresses = mutableMapOf<String, MutableList<Pair<String, String>>>()
        val res =  r.split(',').forEach{ it ->
        val code = it.takeLast(8)
        val num = it.takeWhile { it.isDigit() }
        val address = it.dropLast(9).drop(num.length + 1)
        addresses.getOrPut(code) { mutableListOf() }.add(Pair(address, num))
    }
    if (addresses.containsKey(zipcode)) {
        var result = "$zipcode:"
        val (a, n) = addresses[zipcode]!!.unzip()
        result += a.joinToString(",")
        result += "/${n.joinToString(",")}"
        return result
        }
    return "$zipcode:/"
    }

fun main() {
    println(travel("123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432", "OH 43071"))
}
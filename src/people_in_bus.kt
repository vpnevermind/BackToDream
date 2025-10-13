fun people(busStops: Array<Pair<Int, Int>>) : Int {
    var getOnBus = 0
    var getOutBus = 0
    for (p in busStops) {
        getOnBus += p.first
        getOutBus += p.second
    }
    return getOnBus - getOutBus
}

fun people1(busStops: Array<Pair<Int, Int>>) : Int {
    var peopleInTheBus = 0
    busStops.forEach { peopleInTheBus += it.first; peopleInTheBus -= it.second }
    return peopleInTheBus
}

fun main() {
    println(people1(arrayOf(3 to 0,9 to 1,4 to 8,12 to 2,6 to 1,7 to 8)))
}
fun outed(meet: Map<String, Int>, boss: String): String {
    val people = meet.size
    println(people)
    var totalScore = 0.0
    meet.entries.forEach { totalScore += if (it.key == boss) it.value * 2 else it.value }
    return if (totalScore / people <= 5.0)  {
        "Get Out Now!"
    } else {
        "Nice Work Champ!"
    }
}

fun main() {
    println(outed(mapOf("laura" to 2, "saajid" to 2, "alex" to 3, "john" to 8, "mr" to 6), "john"))
}
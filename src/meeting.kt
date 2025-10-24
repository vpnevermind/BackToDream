fun meeting(s: String): String {
    return s.split(";").map { user -> user.split(":").reversed().joinToString(":").uppercase() }.sorted()
        .joinToString("") { user -> "(${user.replace(":", ", ")})" }
}

fun main() {
    val test = listOf("CORWILLRAPHAEL", "CORWILLALFRED").sorted().joinToString(" ")
    println(test)
    println(meeting("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"))
}
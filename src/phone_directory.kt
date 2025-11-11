import kotlin.text.isDigit
import kotlin.text.isLetter
import kotlin.text.isWhitespace

fun phone(strng: String, num: String): String {
    val res = strng.split('\n').map { str ->
        val name = str.substringAfter('<').substringBefore('>')
        val tel = str.substringAfter('+').takeWhile { it.isDigit() || it == '-'}
        val address = str.replace(name, "").replace(tel, "")
            .map { if (it.isDigit() || it.isWhitespace() || it.isLetter() || it == '.' || it == '-') it else " "  }
            .joinToString("").trim().split(" ")
            .filter { it.isNotEmpty() }.joinToString(" ")
        Triple(tel, name, address)
    }.filter { it.first == num }
    return when (res.size) {
        0 -> "Error => Not found: $num"
        1 -> "Phone => ${res.first().first}, Name => ${res.first().second}, Address => ${res.first().third}"
        else -> "Error => Too many people: $num"
    }
}


fun main() {
    val dr = ("/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
            + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
            + "<Q Salinge> Main Street, +1-098-512-2222, Denve\n" + "<R Salinge> Main Street, +1-098-512-2222, Denve\n"
            + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n")

    println(phone(dr, "5-555-555-5555"))


}


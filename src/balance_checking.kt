import java.util.Locale

fun balance(book: String): String {
    val clearList = book.split("\n").filter{it.isNotBlank()}.map { str ->
         str.filter { it.isWhitespace() || it.isDigit() || it.isLetter() || it == '.'}
            .trim().replace(Regex("\\s+"), " ")
    }

    val result = mutableListOf<String>("Original Balance: ${clearList[0]}")
    var balance = clearList[0].toDouble()
    var totalExpenses = 0.0

    for (i in 1..<clearList.size) {
        val price = clearList[i].split(' ').last { it.isNotEmpty() }.toDouble()
        balance -= price
        totalExpenses += price
        result.add("${clearList[i]} Balance ${String.format(Locale.US, "%.2f", balance)}")
    }

    val averageExpense = totalExpenses / (clearList.size-1).toDouble()
    result.add("Total expense  ${String.format(Locale.US, "%.2f", totalExpenses)}")
    result.add("Average expense  ${String.format(Locale.US, "%.2f", averageExpense)}")

    return result.joinToString("\\r\\n")
}


fun main() {
    val test = "1000.00!=\n  125   Market !=:  125.45\n126 Hardware =34.95\n127 Video! 7.45\n128 Book :14.32\n129 Gasoline ::16.10\n"
    val test1 = "Original Balance: 1000.00\\r\\n125 Market 125.45 Balance 874.55\\r\\n126 Hardware 34.95 Balance 839.60\\r\\n127 Video 7.45 Balance 832.15\\r\\n128 Book 14.32 Balance 817.83\\r\\n129 Gasoline 16.10 Balance 801.73\\r\\nTotal expense  198.27\\r\\nAverage expense  39.65"
    val test2 = "1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n" + "123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00,?;\n129 Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?"
    println(balance(test))
    println(balance(test2))
}
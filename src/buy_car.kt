import kotlin.math.roundToInt

fun main() {
    print(nbMonths(
        8000, 12000, 500, 1.0
    ))
}

fun nbMonths(
    startPriceOld: Int,
    startPriceNew: Int,
    savingperMonth: Int,
    percentLossByMonth: Double
): Pair<Int, Int> {
    var startPriceOld = startPriceOld.toDouble()
    var startPriceNew = startPriceNew.toDouble()
    var percentLossByMonth = percentLossByMonth

    var month = 0
    var reminder = startPriceOld

    while (startPriceNew > reminder) {
        month++
        if (month % 2 == 0 && month != 0) percentLossByMonth += 0.5
        startPriceNew -= ((startPriceNew * percentLossByMonth) / 100.0)
        startPriceOld -= ((startPriceOld * percentLossByMonth) / 100.0)
        reminder = startPriceOld + (month * savingperMonth)
    }
    return Pair<Int, Int>(month, (reminder - startPriceNew).roundToInt())
}
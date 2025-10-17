fun whichNote(keyPressCount : Int) : String {
    val keys = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
    if (keyPressCount % 88 == 0) return "C"
    return if (keyPressCount <= 88) {
        keys[((keyPressCount - 1) % keys.size) % 88]
    } else {
        val x = keyPressCount / 88
        val y = keyPressCount - 88 * x
        keys[(((y - 1) % keys.size) % 88)]
    }
}

fun main() {
    println(whichNote(2288))
    println((2288 / 88) )
}
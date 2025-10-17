fun unless(b: Boolean, x: () -> Unit) {
    if (!b) x()
}
fun until(condition: () -> Boolean, x: () -> Unit) {
    while (!condition()) x()
}
fun forceRun(x: () -> Unit) {
    try {
        x()
    } catch (e: Throwable) {

    }
}
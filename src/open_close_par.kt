fun validParentheses(str: String): Boolean {
    var pCoeff = 0
    for (c in str) {
        if (c == '(') pCoeff++ else pCoeff--
    }
    return pCoeff == 0
}
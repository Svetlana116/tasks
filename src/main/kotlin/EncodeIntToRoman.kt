fun main(args: Array<String>) {
    val digits = listOf<Int>(20, 34, 590, 600, 2000, 3999)
    for (d in digits) {
        println("$d = ${encodeIntToRoman(d)}" )
    }
}

val romans = mapOf(
    1000 to "M",
    900 to "CM",
    500 to "D",
    400 to "CD",
    100 to "C",
    90 to "XC",
    50 to "L",
    40 to "XL",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I"
)

fun encodeIntToRoman(number: Int): String? {
    if (number > 3999 || number < 1) {
        return null
    }
    var num = number
    var digit = ""
    for ((a, b) in romans.entries) {
        while (num >= a) {
            num -= a
            digit += b
        }
    }
    return digit
}

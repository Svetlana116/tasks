/*
Нам дана произвольная строка, содержащая числа, символы и спец. символы. Необходимо найти самое большое число в строке.
 (вариации задачи: найти сумму всех чисел в строке, найти самое длинное слово в строке)

 Пример: "fRETre3445 43#$% 32424234 #$@$34 2323"
 Ответ: 32424234
*/

fun main(args: Array<String>) {
    val string = "fRETre3445 43#% 32424234 #$@34 2323"
    val listOfStrings = stringToWords(string)
    val listOfDigits = findIntInList(listOfStrings)
    println(listOfDigits.maxOrNull())
}

fun findIntInList(listOfStrings: List<String>): MutableList<Int> {
    val listOfDigits = mutableListOf<Int>()
    for (s in listOfStrings) {
        val t = s.filter { it.isDigit() }
        listOfDigits.add(t.toInt())
    }
    return listOfDigits
}

fun stringToWords(s : String) = s.trim().splitToSequence(' ')
    .filter { it.isNotEmpty() }
    .toList()

/*
Нам дан список слов, нужно найти слова, которые имеют анаграммы в данном списке. Анаграмма - это когда переставив буквы в одном слове мы можем получить второе слово (cat > act)

 Пример: ['cat', 'act', 'dinosaur', 'testing', 'setting']
 Ответ: ['cat', 'act', 'testing', 'setting']
 */

fun main(args: Array<String>){

    class WordWithIndex(val word: String, val index: Int)

    fun charSort(word: String) = word.toCharArray().sorted().joinToString("")

    fun getAnagrams(words: List<String>) : List<String> =
        words
            .mapIndexed { index, s -> WordWithIndex(charSort(s), index) }
            .groupBy { it.word }
            .toList()
            .map { it -> it.second.map { words[it.index] } }
            .filter { it.size > 1 }
            .flatten()

    println(getAnagrams(listOf("cat", "act", "dinosaur", "testing", "setting")))
}

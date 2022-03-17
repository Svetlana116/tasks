fun main(args: Array<String>){

    class WordWithIndex(val word: String, val index: Int)

    fun charSort(word: String) = word.toCharArray().sorted().joinToString("")

    fun wordArraySort(array: Array<WordWithIndex>) = array.sortedArrayWith { a,b -> a.word.compareTo(b.word)}

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







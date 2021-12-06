fun main() {
    fun countIncreases(
        input: List<Int>,
        groupSize: Int = 1
    ): Int {
        var count=0
        val size: Int = input.size
        for (i in 0 until(size-groupSize))
            if ((input.slice(i+1 until i+1+groupSize)).sum() >
            (input.slice(i until i+groupSize)).sum()) count+=1
        return count
    }

    val input = readInputAsInts("Day01")
    println("Part 1: ${countIncreases(input)}")
    println("Part 2: ${countIncreases(input,3)}")
}
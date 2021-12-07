fun main() {
    fun intoBuckets(
        input: List<Int>
    ): LongArray {
        val buckets = LongArray(9) { 0 }
        for (i in input) buckets[i] = buckets[i]+1
        //for (i in input) buckets.set(i,buckets.get(i)+1)
        return buckets
    }
    fun calculatePopulation(
        input: LongArray,
        days: Int
    ): Long {
        var currentInput = input
        for (d in 0 until days) {
            val tempInput = LongArray(9) { 0 }
            for (i in currentInput.indices) {
                if (i == 0) {
                    tempInput[6] += currentInput[i]
                    tempInput[8] += currentInput[i]
                }
                else tempInput[i - 1] += currentInput[i]
            }
            currentInput=tempInput
        }
        return currentInput.sum()
    }
    val input = readInput("Day06")
    val start = input[0].split(",".toRegex()).map(String::toInt)
    val startBuckets = intoBuckets(start)
    println("Part 1: ${calculatePopulation(startBuckets,80)}")
    println("Part 2: ${calculatePopulation(startBuckets,256)}")
}

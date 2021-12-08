fun main() {
    fun part1(
        input: IntArray
    ): Int {
        var minFuel = -1
        for (i in input.minOrNull()?.until(input.maxOrNull()!!)!!) {
            var fuel = 0
            for (j in input) fuel += if(i > j) i-j else j-i
            if (minFuel==-1 || fuel < minFuel) minFuel=fuel
        }
        return minFuel
    }
    fun part2(
        input: IntArray
    ): Int {
        var minFuel = -1
        for (i in input.minOrNull()?.until(input.maxOrNull()!!)!!) {
            var fuel = 0
            for (j in input) {
                fuel += if(i > j) {
                    IntArray(i-j) { 1 * (it + 1) }.sum()
                } else {
                    IntArray(j-i) { 1 * (it + 1) }.sum()
                }

            }
            if (minFuel==-1 || fuel < minFuel) minFuel=fuel
        }
        return minFuel
    }
    val input = readInput("Day07")
    val start = input[0].split(",".toRegex()).map(String::toInt).toIntArray()
    println("Part 1: ${part1(start)}")
    println("Part 2: ${part2(start)}")
}
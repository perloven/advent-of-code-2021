package se.perloven.aoc2021.day1

import java.io.File

private const val INPUT_FILENAME = "day1/sonarsweep-input.txt"

fun main() {
    val sonarSweep = SonarSweep()
    val singleIncreases = sonarSweep.getSingleMeasurementIncreases(INPUT_FILENAME)
    val tripleSumIncreases = sonarSweep.getTripleSumIncreases(INPUT_FILENAME)
    println("Number of depth measurement increases: $singleIncreases")
    println("Number of triple sum measurement increases: $tripleSumIncreases")
}

class SonarSweep {
    fun getSingleMeasurementIncreases(fileName: String): Int {
        val measurements = getResourceFile(fileName).getIntLines()
        return calculateSingleIncreases(measurements)
    }

    fun getTripleSumIncreases(fileName: String): Int {
        val measurements = getResourceFile(fileName).getIntLines()
        return calculateTripleSumIncreases(measurements)
    }

    private fun getResourceFile(fileName: String): File {
        return File(ClassLoader.getSystemResource(fileName).file)
    }

    private fun File.getIntLines(): List<Int> {
        return this.bufferedReader().readLines().asSequence()
            .map { it.toInt() }
            .toList()
    }

    private fun calculateSingleIncreases(values: List<Int>): Int {
        var increases = 0
        var prev: Int? = null
        for (cur in values) {
            if (prev != null && cur > prev){
                increases++
            }
            prev = cur
        }

        return increases
    }

    private fun calculateTripleSumIncreases(values: List<Int>): Int {
        return values.windowed(3, 1).map { it.sum() }.windowed(2, 1).count { it[1] > it[0] } // thanks Ravi
    }
}
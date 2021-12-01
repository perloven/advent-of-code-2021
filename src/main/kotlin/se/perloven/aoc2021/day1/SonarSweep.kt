package se.perloven.aoc2021.day1

import java.io.File

private const val INPUT_FILENAME = "day1/sonarsweep-input.txt"

fun main() {
    val increases = SonarSweep().getMeasurementIncreases(INPUT_FILENAME)
    println("Number of depth measurement increases: $increases")
}

class SonarSweep {
    fun getMeasurementIncreases(fileName: String): Int {
        val measurements = getResourceFile(fileName).getIntLines()
        return calculateIncreases(measurements)
    }

    private fun getResourceFile(fileName: String): File {
        return File(ClassLoader.getSystemResource(fileName).file)
    }

    private fun File.getIntLines(): List<Int> {
        return this.bufferedReader().readLines().asSequence()
            .map { it.toInt() }
            .toList()
    }

    private fun calculateIncreases(values: List<Int>): Int {
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
}
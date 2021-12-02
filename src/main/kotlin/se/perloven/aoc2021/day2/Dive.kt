package se.perloven.aoc2021.day2

import se.perloven.aoc2021.getResourceFile

fun main() {
    val file = getResourceFile("day2/dive-input.txt")
    val position = Position()
    file.forEachLine {
        val splitLine = it.split(" ")
        position.modify(splitLine[0], splitLine[1].toInt())
    }
    println("Result ${position.getResult()}")
}

class Position(var horizontalPosition:Int = 0, var depth: Int = 0) {
    fun modify(command: String, value: Int) {
        when (command) {
            "forward" -> horizontalPosition += value
            "up" -> depth -= value
            "down" -> depth += value
        }
    }

    fun getResult() = horizontalPosition * depth
}
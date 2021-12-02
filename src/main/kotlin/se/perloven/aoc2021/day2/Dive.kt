package se.perloven.aoc2021.day2

import se.perloven.aoc2021.getResourceFile

fun main() {
    println("Result task 1: ${task1()}")
    println("Result task 2: ${task2()}")
}

private fun task1(): Int {
    val file = getResourceFile("day2/dive-input.txt")
    val position = Position()
    file.forEachLine {
        val splitLine = it.split(" ")
        position.modify(splitLine[0], splitLine[1].toInt())
    }
    return position.getResult()
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

fun task2(): Int {
    val file = getResourceFile("day2/dive-input.txt")
    val position = AimedPosition()
    file.forEachLine {
        val splitLine = it.split(" ")
        position.modify(splitLine[0], splitLine[1].toInt())
    }
    return position.getResult()
}

class AimedPosition(
    private var horizontalPosition: Int = 0,
    private var depth: Int = 0,
    private var aim: Int = 0
) {
    fun modify(command: String, value: Int) {
        when (command) {
            "forward" -> {
                horizontalPosition += value
                depth += aim * value
            }
            "up" -> aim -= value
            "down" -> aim += value
        }
    }

    fun getResult() = horizontalPosition * depth
}
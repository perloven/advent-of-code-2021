package se.perloven.aoc2021

import java.io.File

fun getResourceFile(fileName: String): File {
    return File(ClassLoader.getSystemResource(fileName).file)
}
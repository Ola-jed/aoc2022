package day2

import java.io.File

fun main(args: Array<String>) {
    val inputFilePath = args[0]
    val fileContent = File(inputFilePath).readLines()
    val plays = extractPlays(fileContent)

    val total = plays.sumOf { computeScore(it.second, it.first) }
    println("The score you should get is $total")
}
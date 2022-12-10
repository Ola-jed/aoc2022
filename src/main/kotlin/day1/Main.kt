package day1

import java.io.File

fun main(args: Array<String>) {
    val inputFilePath = args[0]
    val fileContent = File(inputFilePath).readLines()
    val elves = extractElvesFromInput(fileContent)
    val topCaloricElf = getTopCaloricElf(elves)
    println("The elf ${topCaloricElf.number} has the most calories : ${topCaloricElf.calories}")
    val topThreeCaloricElves = getMostCaloricElves(elves)
    println("The total for the most 3 caloric elves is : ${topThreeCaloricElves.sumOf { it.calories }}")
}
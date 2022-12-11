package day10

import java.io.File

fun main(args: Array<String>) {
    val fileContent = File(args.first()).readLines()
    // Part 1
    val parser = Parser(fileContent)
    val instructions = parser.getInstructions()
    val cpu = CPU(instructions)
    val signalStrengths = cpu.getSignalStrengths(listOf(20, 60, 100, 140, 180, 220))
    val sum = signalStrengths.sum()
    println("The sum of the signal strengths is $sum")
}
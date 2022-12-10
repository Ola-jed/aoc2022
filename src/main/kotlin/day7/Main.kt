package day7

import java.io.File

const val criticalFileSize = 100_000

fun main(args: Array<String> /* Pass the path to the input file as a command line argument */) {
    // Part 1
    val fileContent = File(args.first()).readLines()
    val parser = Parser(fileContent)
    val homeDir = parser.parse()
    val directories = homeDir.flat()
    val totalSize = directories.map { it.size() }.filter { it <= criticalFileSize }.sum()
    println(totalSize)

    // Part 2
}
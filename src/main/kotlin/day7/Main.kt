package day7

import java.io.File

const val criticalFileSize = 100_000
const val totalDiskSpace = 70000000
const val requiredFreeSpace = 30000000

fun main(args: Array<String> /* Pass the path to the input file as a command line argument */) {
    // Part 1
    val fileContent = File(args.first()).readLines()
    val parser = Parser(fileContent)
    val homeDir = parser.parse()
    val directories = homeDir.flat()
    val totalSize = directories.map { it.size() }.filter { it <= criticalFileSize }.sum()
    println("Part 1 : $totalSize")

    // Part 2
    val usedSpace = homeDir.size()
    val freeSpace = totalDiskSpace - usedSpace
    val spaceToFree = requiredFreeSpace - freeSpace
    val deletableDirSize = findSmallestDeletableDirectorySize(directories, spaceToFree)
    println("Part 2 : $deletableDirSize")
}

fun findSmallestDeletableDirectorySize(directories: List<Directory>, spaceToFree: Int): Int {
    return directories.map { it.size() }.sortedBy { it }.first { it >= spaceToFree }
}
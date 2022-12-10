package day1

typealias Elves = List<Elf>

fun extractElvesFromInput(input: List<String>): Elves {
    val elves = mutableListOf<Elf>()
    var caloriesSum = 0
    var elvesIndex = 1

    input.forEach {
        if(it.isBlank()) {
            elves.add(Elf(elvesIndex, caloriesSum))
            elvesIndex++
            caloriesSum = 0
        } else {
            caloriesSum += it.toInt()
        }
    }

    return elves
}

fun getTopCaloricElf(elves: Elves): Elf = elves.maxBy { it.calories }
fun getMostCaloricElves(elves: Elves, top: Int = 3): Elves = elves.sortedByDescending { it.calories }.take(top)


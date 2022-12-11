package day10

class Parser(private val fileContent: List<String>) {
    fun getInstructions(): List<Instruction> = fileContent.map(::parseLine)

    private fun parseLine(line: String): Instruction = if(line == NOOP_STR_VALUE) {
        Noop
    } else {
        AddX(line.drop(ADDX_STR_VALUE_LENGTH).toInt())
    }

    companion object {
        const val NOOP_STR_VALUE = "noop"
        const val ADDX_STR_VALUE_LENGTH = 5
    }
}
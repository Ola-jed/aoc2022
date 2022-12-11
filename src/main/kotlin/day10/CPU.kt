package day10

class CPU(private val instructions: List<Instruction>) {
    fun getSignalStrengths(cycles: List<Int>): List<Int> {
        val signalStrengths = mutableListOf<Int>()
        var registerValue = 1
        var cycleInc = 0

        for (instruction in instructions) {
            // Find from cycles where cycle ϵ ]cycleInc;(cycleInc + AddX.cyclesToComplete)]
            // And add the (registerValue * cycle) to the signalStrengths
            // Because a cycle can be obtained while working on the register

            val maybeCycleToHandle = cycles
                .firstOrNull { cycleInc < it && it <= (cycleInc + instruction.cyclesToComplete) }
            if (maybeCycleToHandle != null) {
                signalStrengths.add(registerValue * maybeCycleToHandle)
            }

            if (instruction is Noop) {
                cycleInc += Noop.cyclesToComplete
            } else if (instruction is AddX) {
                cycleInc += instruction.cyclesToComplete
                registerValue += instruction.value
            }
        }

        return signalStrengths
    }
}
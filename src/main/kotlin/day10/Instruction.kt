package day10

sealed class Instruction {
    abstract val cyclesToComplete: Int
}

data class AddX(val value: Int) : Instruction() {
    override val cyclesToComplete: Int
        get() = 2
}

object Noop : Instruction() {
    override val cyclesToComplete: Int
        get() = 1
}
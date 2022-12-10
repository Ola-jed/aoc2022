package day2

sealed class Play(val numberValue: Int) {
    object Rock: Play(1)
    object Paper: Play(2)
    object Scissors: Play(3)

    companion object {
        private const val A = "A"
        private const val B = "B"
        private const val C = "C"

        private const val X = "X"
        private const val Y = "Y"
        private const val Z = "Z"

        private fun fromFirstColumn(value: String): Play = when (value) {
            A -> Rock
            B -> Paper
            C -> Scissors
            else -> throw IllegalArgumentException()
        }

        private fun fromSecondColumn(value: String): Play = when (value) {
            X -> Rock
            Y -> Paper
            Z -> Scissors
            else -> throw IllegalArgumentException()
        }

        fun fromColumns(value : String): Pair<Play, Play> {
            val split = value.split(" ")
            return Pair(fromFirstColumn(split[0]), fromSecondColumn(split[1]))
        }
    }
}


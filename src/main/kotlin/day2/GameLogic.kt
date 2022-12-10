package day2

const val LOSS_SCORE = 0
const val DRAW_SCORE = 3
const val WIN_SCORE = 6

val GAME_OPPOSITION_RULES = mapOf(
    Pair(Play.Rock, Play.Rock) to DRAW_SCORE,
    Pair(Play.Rock, Play.Paper) to LOSS_SCORE,
    Pair(Play.Rock, Play.Scissors) to WIN_SCORE,
    Pair(Play.Paper, Play.Rock) to WIN_SCORE,
    Pair(Play.Paper, Play.Paper) to DRAW_SCORE,
    Pair(Play.Paper, Play.Scissors) to LOSS_SCORE,
    Pair(Play.Scissors, Play.Rock) to LOSS_SCORE,
    Pair(Play.Scissors, Play.Paper) to WIN_SCORE,
    Pair(Play.Scissors, Play.Scissors) to DRAW_SCORE
)

fun computeScore(myPlay: Play, opponentPlay: Play): Int {
    return (GAME_OPPOSITION_RULES[Pair(myPlay, opponentPlay)] ?: throw IllegalArgumentException()) + myPlay.numberValue
}
fun extractPlays(rawData: List<String>): List<Pair<Play, Play>> = rawData.map(Play.Companion::fromColumns)
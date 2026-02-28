
class Solution {

    private companion object {
        const val PLAYER_ONE = 0
        const val PLAYER_TWO = 1
        const val NUMBER_OF_PLAYERS = 2
        const val NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS = 6
    }

    fun scoreDifference(scoresPerGame: IntArray): Int {
        var activePlayer = PLAYER_ONE
        val scoresPerPlayer = IntArray(NUMBER_OF_PLAYERS)

        for (i in scoresPerGame.indices) {
            activePlayer = getNextActivePlayer(i, scoresPerGame[i], activePlayer)
            scoresPerPlayer[activePlayer] += scoresPerGame[i]
        }
        return scoresPerPlayer[PLAYER_ONE] - scoresPerPlayer[PLAYER_TWO]
    }

    private fun getNextActivePlayer(index: Int, scoreCurrentGame: Int, previousActivePlayer: Int): Int {
        var nextActivePlayer = previousActivePlayer
        if (isOdd(scoreCurrentGame)) {
            nextActivePlayer = nextActivePlayer xor 1
        }
        if ((index + 1) % NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS == 0) {
            nextActivePlayer = nextActivePlayer xor 1
        }
        return nextActivePlayer
    }

    private fun isOdd(value: Int): Boolean {
        return value % 2 == 1
    }
}

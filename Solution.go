
package main

const PLAYER_ONE = 0
const PLAYER_TWO = 1
const NUMBER_OF_PLAYERS = 2
const NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS = 6

func scoreDifference(scoresPerGame []int) int {
    activePlayer := PLAYER_ONE
    scoresPerPlayer := make([]int, NUMBER_OF_PLAYERS)

    for i := range scoresPerGame {
        activePlayer = getNextActivePlayer(i, scoresPerGame[i], activePlayer)
        scoresPerPlayer[activePlayer] += scoresPerGame[i]
    }
    return scoresPerPlayer[PLAYER_ONE] - scoresPerPlayer[PLAYER_TWO]
}

func getNextActivePlayer(index int, scoreCurrentGame int, previousActivePlayer int) int {
    nextActivePlayer := previousActivePlayer
    if isOdd(scoreCurrentGame) {
        nextActivePlayer ^= 1
    }
    if (index+1) % NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS == 0 {
        nextActivePlayer ^= 1
    }
    return nextActivePlayer
}

func isOdd(value int) bool {
    return value % 2 == 1
}

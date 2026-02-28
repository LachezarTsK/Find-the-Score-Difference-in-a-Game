
/**
 * @param {number[]} scoresPerGame
 * @return {number}
 */
var scoreDifference = function (scoresPerGame) {
    let activePlayer = Util.PLAYER_ONE;
    const scoresPerPlayer = new Array(Util.NUMBER_OF_PLAYERS).fill(0);

    for (let i = 0; i < scoresPerGame.length; ++i) {
        activePlayer = getNextActivePlayer(i, scoresPerGame[i], activePlayer);
        scoresPerPlayer[activePlayer] += scoresPerGame[i];
    }
    return scoresPerPlayer[Util.PLAYER_ONE] - scoresPerPlayer[Util.PLAYER_TWO];
};

/**
 * @param {number} index
 * @param {number} scoreCurrentGame
 * @param {number} previousActivePlayer
 * @return {number}
 */
function getNextActivePlayer(index, scoreCurrentGame, previousActivePlayer) {
    let nextActivePlayer = previousActivePlayer;
    if (isOdd(scoreCurrentGame)) {
        nextActivePlayer ^= 1;
    }
    if ((index + 1) % Util.NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS === 0) {
        nextActivePlayer ^= 1;
    }
    return nextActivePlayer;
}

/**
 * @param {number} value
 * @return {boolean}
 */
function isOdd(value) {
    return value % 2 === 1;
}

class Util {
    static PLAYER_ONE = 0;
    static PLAYER_TWO = 1;
    static NUMBER_OF_PLAYERS = 2;
    static NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS = 6;
}

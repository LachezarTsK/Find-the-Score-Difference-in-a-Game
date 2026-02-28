
public class Solution {

    private static final int PLAYER_ONE = 0;
    private static final int PLAYER_TWO = 1;
    private static final int NUMBER_OF_PLAYERS = 2;
    private static final int NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS = 6;

    public int scoreDifference(int[] scoresPerGame) {
        int activePlayer = PLAYER_ONE;
        int[] scoresPerPlayer = new int[NUMBER_OF_PLAYERS];

        for (int i = 0; i < scoresPerGame.length; ++i) {
            activePlayer = getNextActivePlayer(i, scoresPerGame[i], activePlayer);
            scoresPerPlayer[activePlayer] += scoresPerGame[i];
        }
        return scoresPerPlayer[PLAYER_ONE] - scoresPerPlayer[PLAYER_TWO];
    }

    private static int getNextActivePlayer(int index, int scoreCurrentGame, int previousActivePlayer) {
        int nextActivePlayer = previousActivePlayer;
        if (isOdd(scoreCurrentGame)) {
            nextActivePlayer ^= 1;
        }
        if ((index + 1) % NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS == 0) {
            nextActivePlayer ^= 1;
        }
        return nextActivePlayer;
    }

    private static boolean isOdd(int value) {
        return value % 2 == 1;
    }
}

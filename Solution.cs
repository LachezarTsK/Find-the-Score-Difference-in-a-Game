
using System;

public class Solution
{
    private static readonly int PLAYER_ONE = 0;
    private static readonly int PLAYER_TWO = 1;
    private static readonly int NUMBER_OF_PLAYERS = 2;
    private static readonly int NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS = 6;

    public int ScoreDifference(int[] scoresPerGame)
    {
        int activePlayer = PLAYER_ONE;
        int[] scoresPerPlayer = new int[NUMBER_OF_PLAYERS];

        for (int i = 0; i < scoresPerGame.Length; ++i)
        {
            activePlayer = getNextActivePlayer(i, scoresPerGame[i], activePlayer);
            scoresPerPlayer[activePlayer] += scoresPerGame[i];
        }
        return scoresPerPlayer[PLAYER_ONE] - scoresPerPlayer[PLAYER_TWO];
    }

    private static int getNextActivePlayer(int index, int scoreCurrentGame, int previousActivePlayer)
    {
        int nextActivePlayer = previousActivePlayer;
        if (isOdd(scoreCurrentGame))
        {
            nextActivePlayer ^= 1;
        }
        if ((index + 1) % NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS == 0)
        {
            nextActivePlayer ^= 1;
        }
        return nextActivePlayer;
    }

    private static bool isOdd(int value)
    {
        return value % 2 == 1;
    }
}


#include <array>
#include <vector>
using namespace std;

class Solution {

    static const int PLAYER_ONE = 0;
    static const int PLAYER_TWO = 1;
    static const int NUMBER_OF_PLAYERS = 2;
    static const int NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS = 6;

public:
    int scoreDifference(const vector<int>& scoresPerGame) const {
        int activePlayer = PLAYER_ONE;
        array<int, NUMBER_OF_PLAYERS> scoresPerPlayer{};

        for (int i = 0; i < scoresPerGame.size(); ++i) {
            activePlayer = getNextActivePlayer(i, scoresPerGame[i], activePlayer);
            scoresPerPlayer[activePlayer] += scoresPerGame[i];
        }
        return scoresPerPlayer[PLAYER_ONE] - scoresPerPlayer[PLAYER_TWO];
    }

private:
    static int getNextActivePlayer(int index, int scoreCurrentGame, int previousActivePlayer) {
        int nextActivePlayer = previousActivePlayer;
        if (isOdd(scoreCurrentGame)) {
            nextActivePlayer ^= 1;
        }
        if ((index + 1) % NUMBER_OF_GAMES_UPON_WHICH_TO_SWITCH_PLAYERS == 0) {
            nextActivePlayer ^= 1;
        }
        return nextActivePlayer;
    }

    static bool isOdd(int value) {
        return value % 2 == 1;
    }
};

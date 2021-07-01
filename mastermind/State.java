package mastermind;

public class State
{
    private int gameState = Constants.STANDBY;
    private int guessCount = 0;

    public int getGameState () {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public void incrementGuessCount() {
        guessCount++;
    }

    public void resetGuessCount() {
        guessCount = 0;
    }
}

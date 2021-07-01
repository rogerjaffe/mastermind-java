package mastermind;

public class Players {

    private Player[] players;
    private int whoIsSecret = 0;   // Player 0 provides the secret first

    public Players() {
        players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
    }

    public Player getSecretPlayer() {
        return players[whoIsSecret];
    }

    public Player getGuessPlayer() {
        return players[(whoIsSecret + 1) % 2];
    }

    public void addToScore(int increment) {
        players[(whoIsSecret + 1) % 2].addToScore(increment);
    }

    public void switchPlayers() {
        whoIsSecret = (whoIsSecret + 1) % 2;
    }
} 

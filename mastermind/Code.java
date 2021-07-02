package mastermind;
import java.util.Arrays;

public class Code {

    private String[] secret = null;
    private String[] guess = null;
    private String[] feedback = null;

    public String[] getSecret() {
        return secret;
    }

    public void setSecret(String[] secret) {
        this.secret = secret;
    }

    public String[] getGuess() {
        return guess;
    }

    public void setGuess(String[] guess) {
        this.guess = guess;
    }

    public String[] getFeedback() {
        return feedback;
    }

    public boolean isGuessCorrect() {
        return guess.equals(secret);
    }

    // Returns true if feedback completed
    public boolean computeFeedback() {

        if (secret.length == 0 || guess.length == 0) {
            feedback = null;
            return false;

        } else if (secret.length != guess.length) {
            feedback = null;
            return false;
        }

        int length = secret.length;
        boolean[] usedList = new boolean[length];
        feedback = new String[length];
        Arrays.fill(feedback, "");

        for (int i=0; i<length; i++) {
            if (secret[i].equals(guess[i])) {
                feedback[i] = guess[i];
                usedList[i] = true;
            }
        }

        for (int guessIdx=0; guessIdx<length; guessIdx++) {
            if (feedback[guessIdx].equals("")) {
                for (int secretIdx=0; secretIdx<length; secretIdx++) {
                    if (guess[guessIdx].equals(secret[secretIdx]) &&
                    !usedList[secretIdx]) {

                        feedback[guessIdx] = Constants.PRESENT;
                        usedList[secretIdx] = true;
                        secretIdx = length;
                    }
                }
            }
        }

        for (int feedbackIdx=0; feedbackIdx<length; feedbackIdx++) {
            if (feedback[feedbackIdx].equals("")) {
                feedback[feedbackIdx] = Constants.NOT_PRESENT;
            }
        }

        return true;

    }
}

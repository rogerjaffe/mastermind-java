package mastermind;
import java.util.Scanner;

public class View {

    public String getStringFromKeyboard(String prompt, String p1, String p2) {
        System.out.printf(prompt, p1, p2);
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        return inputString;
    }

    public void printScore(int p1Score, int p2Score) {
        System.out.printf(Constants.CURRENT_SCORE, p1Score, p2Score);
    }

    public void printWinMessage(String name, int numberOfGuesses) {
        System.out.printf(Constants.SOLVED, name, numberOfGuesses);
    }

    public void printDivider(String[] guess) {
        String buffer = "";
        for (String digit : guess) {
            buffer += Constants.DIVIDER;
        }
        buffer += Constants.DIVIDER_FINISH;
        System.out.println(buffer);
    }

    public void printGuess(String[] guess) {
        String buffer = "";
        for (String digit : guess) {
            buffer += "| " + digit + " ";
        }
        buffer += Constants.DIVIDER_FINISH;
        System.out.println("Guess:    "+buffer);
    }

    public void printSecret(String[] secret) {
        String buffer = "";
        for (String digit : secret) {
            buffer += "| " + digit + " ";
        }
        buffer += Constants.DIVIDER_FINISH;
        System.out.println("Secret number: "+buffer);

    }

    public void printFeedback(String[] feedback) {
        String buffer = "";
        for (String digit : feedback) {
            buffer += "| " + digit + " ";
        }
        buffer += Constants.DIVIDER_FINISH;
        System.out.println("Feedback: "+buffer);
    }

    public void clearTerminal() {
        System.out.print('\u000C');
    }

    public boolean validateSecret(String[] code) {
        String _secret = String.join("", code);
        try {
            Integer c = new Integer(_secret); // convert to integer
            return true;
        } catch (Exception e) {
            return false;            // conversion error
        }
    }

    public boolean validateGuess(String[] secret, String[] guess) {
        if (validateSecret(guess)) {
            return secret.length == guess.length;
        } else {
            return false;
        }
    }
}

package mastermind;

/**
 * Mastermind game state constants
 */
public class Constants
{
    // gameState values
    public static final int STANDBY = 0;
    public static final int GET_NAMES = 1;
    public static final int GET_SECRET = 2;
    public static final int GET_GUESS = 3;
    public static final int GET_FEEDBACK = 4;
    public static final int QUIT = 5;
    
    // Symbols
    public static final String PRESENT = "+";
    public static final String NOT_PRESENT = "•";

    // Output strings
    public static final String DIVIDER = "|---";
    public static final String DIVIDER_FINISH = "|";
    public static final String WELCOME = "Thanks for playing Mastermind!";
    public static final String GET_SECRET_CODE_PROMPT = "Enter the new secret code using digits 0-9";
    public static final String GET_PLAYER_NAMES = "Enter the player names separated by a comma: ";
    public static final String ENTER_SECRET = "Player %s: What is your secret number? ";
    public static final String ENTER_GUESS = "Player %s: Enter a %d-digit guess: ";
    public static final String SOLVED = "Congratulations %s! You solved the puzzle in %d guesses.";
    public static final String CURRENT_SCORE = "Current score: Player 1: %d | Player 2: %d";
    public static final String GET_NAME_ERROR = "Please enter two names";
}

package mastermind;

public class Controller {

  private View view;
  private State state;
  private Players players;
  private Code code;

  public Controller() {
    view = new View();
    state = new State();
    players = new Players();
    code = new Code();
  }

  public void runEventLoop() {

    // While the state doesn't tell us to quit...
    while (state.getGameState() != Constants.QUIT) {

      // STANDBY then switch to GET_SECRET
      if (state.getGameState() == Constants.STANDBY) {
        state.setGameState(Constants.GET_NAMES);

      } else if (state.getGameState() == Constants.GET_NAMES) {
        String[] names = view.getStringArrayFromKeyboard(Constants.GET_PLAYER_NAMES, null, null);
        if (names[0].length() > 0 && names[1].length() > 0) {
          players.getSecretPlayer().setName(names[0]);
          players.getGuessPlayer().setName(names[1]);
          state.setGameState(Constants.GET_SECRET);
        } else {
          System.out.println(Constants.GET_NAME_ERROR);
        }

      // GET_SECRET then switch to GET_GUESS
      } else if (state.getGameState() == Constants.GET_SECRET) {
        String[] newSecret = view.getStringArrayFromKeyboard(Constants.GET_SECRET_CODE_PROMPT, null, null);
        if (!view.validateSecret(newSecret)) {
          System.out.println("Your secret code must only contain digits 0 through 9");
        } else {
          view.clearTerminal();
          code.setSecret(newSecret);
          state.setGameState(Constants.GET_GUESS);
        }

      // GET_GUESS -> validate guess and save
      } else if (state.getGameState() == Constants.GET_GUESS) {
        String[] newGuess = view.getStringArrayFromKeyboard(
          Constants.ENTER_GUESS, 
          players.getGuessPlayer().getName(), 
          (new Integer(code.getSecret().length)).toString()
        );
        if (view.validateGuess(code.getSecret(), newGuess)) {
          System.out.println("Your secret code must only contain digits 0 through 9");
        } else {
          view.printGuess(code.getGuess());
          code.setGuess(newGuess);
          state.incrementGuessCount();
          state.setGameState(Constants.GET_FEEDBACK);
        }

        // COMPUTE_FEEDBACK -> analyze guess / offer feedback
      } else if (state.getGameState() == Constants.GET_FEEDBACK) {
        if (code.isGuessCorrect()) {
          players.getGuessPlayer().addToScore(state.getGuessCount());
          state.resetGuessCount();
          view.printWinMessage(players.getGuessPlayer().getName(), state.getGuessCount());
          players.switchPlayers();
          state.setGameState(Constants.GET_SECRET);
        } else {
          state.incrementGuessCount();
          code.computeFeedback();
          view.printFeedback(code.getFeedback());
          state.setGameState(Constants.GET_GUESS);
        }
      }
    }
    view.printScore(players.getSecretPlayer().getScore(),
                    players.getGuessPlayer().getScore());
    System.exit(0);
  }

  public static void main(String[] args) {
    Controller controller = new Controller();
    controller.runEventLoop();
  }
}

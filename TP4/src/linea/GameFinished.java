package linea;

public class GameFinished extends GameStates {

    public static final String GAME_FINISHED = "Game finished!";

    public boolean finished() {
        return true;
    }

    public void playRedAt(int column, ConnectFour aaConnectFour) {
        throw new RuntimeException(GAME_FINISHED);
    }

    public void playBlueAt(int column, ConnectFour aaConnectFour) {
        throw new RuntimeException(GAME_FINISHED);
    }

    public char grabTheCorrespondingChip() {
        return ' ';
    }

    public String whoIsPlaying() {
        return GAME_FINISHED;
    }

    public GameStates nextTurn() {
        return this ;
    }
}

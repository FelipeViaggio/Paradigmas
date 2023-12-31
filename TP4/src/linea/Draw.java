package linea;

public class Draw extends GameStates {

    public static final String GAME_FINISHED_IT_S_A_DRAW = "Game finished! It's a draw!";

    public boolean finished() {
        return true;
    }

    public void playRedAt(int column, ConnectFour aaConnectFour) {
        throw new RuntimeException(GAME_FINISHED_IT_S_A_DRAW);
    }

    public void playBlueAt(int column, ConnectFour aaConnectFour) {
        throw new RuntimeException(GAME_FINISHED_IT_S_A_DRAW);
    }

    public char grabTheCorrespondingChip() {
        return ' ';
    }

    public String whoIsPlaying() {
        return GAME_FINISHED_IT_S_A_DRAW;
    }

    public GameStates nextTurn() {
        return this ;
    }

}

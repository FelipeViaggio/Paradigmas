package linea;

public class WinnerDiagonally extends GameModes {

    public boolean correspondingGameMode(char mode) {
        return mode == 'B'; }

    public boolean finished(ConnectFour game, int column) {
        return game.isGameOverDiagonally(column); }
}

package linea;

public class WinnerInAnyDirection extends GameModes {

    public boolean correspondingGameMode(char mode) {
        return mode == 'C'; }

    public boolean finished(ConnectFour game, int column) {
        return game.isGameOverVerticallyOrHorizontally( column ) || game.isGameOverDiagonally( column ); }
}

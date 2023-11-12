package linea;

public class WinnerVerticallyHorizontally extends GameModes {

    public boolean correspondingGameMode(char mode) {
        return mode == 'A';
    }

    public boolean finished(ConnectFour game, int column) {
        return game.isGameOverVerticallyOrHorizontally(column);
    }
}

package linea;

public class VerticalHorizontal extends GameModes {
    public boolean letter(char mode) {
        return mode == 'A';
    }

    public boolean winningStrategies(ConnectFour game, int pos) {
        return game.verticalWin(pos) || game.horizontalWin(pos);
    }
}
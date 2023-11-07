package linea;

public class Diagonal extends GameModes {
    public boolean letter(char mode) {
        return mode == 'B';
    }

    public boolean winningStrategies(ConnectFour game, int pos) {
        return game.rightDiagonalWin(pos) || game.leftDiagonalWin(pos);
    }
}

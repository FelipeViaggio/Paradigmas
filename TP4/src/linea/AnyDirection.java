package linea;

public class AnyDirection extends GameModes {
    public boolean letter(char mode) {
        return mode == 'C';
    }

    public boolean winningStrategies(ConnectFour game, int pos) {
        return game.verticalWin(pos) || game.horizontalWin(pos) || game.rightDiagonalWin(pos) || game.leftDiagonalWin(pos);
    }
}

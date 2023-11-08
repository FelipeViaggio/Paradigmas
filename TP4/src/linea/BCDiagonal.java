package linea;

public class BCDiagonal extends BBGameModes {
    public boolean letter(char mode) {
        return mode == 'B';
    }

    public boolean winningStrategies(AAConnectFour game, int pos) {
        return !game.completedBoard() && (game.rightDiagonalWin(pos) || game.leftDiagonalWin(pos));
    }
}

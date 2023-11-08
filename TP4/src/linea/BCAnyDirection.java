package linea;

public class BCAnyDirection extends BBGameModes {
    public boolean letter(char mode) {
        return mode == 'C';
    }

    public boolean winningStrategies(AAConnectFour game, int pos) {
        return game.verticalWin(pos) || game.horizontalWin(pos) || game.rightDiagonalWin(pos) || game.leftDiagonalWin(pos);
    }
}

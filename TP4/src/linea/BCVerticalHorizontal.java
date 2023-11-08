package linea;

public class BCVerticalHorizontal extends BBGameModes {
    public boolean letter(char mode) {
        return mode == 'A';
    }

    public boolean winningStrategies(AAConnectFour game, int pos) {
        return !game.completedBoard() && (game.verticalWin(pos) || game.horizontalWin(pos));
    }
}

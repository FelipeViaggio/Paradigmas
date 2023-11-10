package linea;

public class BCDiagonal extends BBGameModes {
    public boolean letter(char mode) {
        return mode == 'B';
    }

    public boolean finished(AAConnectFour game, int pos) {
        return game.isGameOverDiagonally(pos);
    }
}

package linea;

public class BCVerticalHorizontal extends BBGameModes {
    public boolean letter(char mode) {
        return mode == 'A';
    }

    public boolean finished(AAConnectFour game, int pos) {
        return game.winnerVerticallyorHorizontally(pos) || game.isGameOverDiagonally(pos);
    }
}

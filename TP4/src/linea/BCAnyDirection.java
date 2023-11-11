package linea;

public class BCAnyDirection extends BBGameModes {
    public boolean letter(char mode) {
        return mode == 'C';
    }

    public boolean finished(AAConnectFour game, int column) {
        return game.winnerVerticallyorHorizontally( column ) || game.isGameOverDiagonally( column );
    }
}

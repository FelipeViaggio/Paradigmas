package linea;

public class CDRedTurn extends CCTurns {

    public void playRedAt(int column, AAConnectFour game) {
        game.placeChipInColumn( column );
     }

    public boolean redTurn() {
        return true;
    }

    public void playBlueAt(int column, AAConnectFour aaConnectFour) {
        throw new RuntimeException("Not your turn!");
    }

    public char grabTheCorrespondingChip() {
        return 'X';
    }

    public String whoIsPlaying() {
        return "Red";
    }

    public CCTurns nextTurn() {
        return new CDBlueTurn();
    }
}

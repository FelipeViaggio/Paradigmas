package linea;

public class CDRedTurn extends CCTurns {

    public void playRedAt(int column, AAConnectFour aaConnectFour) {
        aaConnectFour.placeChipInColumn( column );
     }

    public void playBlueAt(int column, AAConnectFour aaConnectFour) {
        throw new RuntimeException("Not your turn!");
    }

    public String getCurrentChip() {
        return "X";
    }

    public String whoIsPlaying() {
        return "Red";
    }

    public CCTurns nextTurn() {
        return new CDBlueTurn();
    }
}

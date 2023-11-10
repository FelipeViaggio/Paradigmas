package linea;

public class CDBlueTurn extends CCTurns {
    public void playRedAt(int column, AAConnectFour aaConnectFour) {
        throw new RuntimeException("Not your turn!");
    }

    public void playBlueAt(int column, AAConnectFour aaConnectFour) {
        aaConnectFour.placeChipInColumn( column );
    }

    public String getCurrentChip() {
        return "0";
    }

    public String whoIsPlaying() {
        return "Blue";
    }

    public CCTurns nextTurn() {
        return new CDRedTurn();
    }
}

package linea;

public class BlueTurn extends GameStates {

    public boolean blueTurn() {
        return true;
    }

    public void playRedAt(int column, ConnectFour aaConnectFour) {
        throw new RuntimeException("Not your turn!");
    }

    public void playBlueAt(int column, ConnectFour aaConnectFour) {
        aaConnectFour.placeChipInColumn( column );
    }

    public char grabTheCorrespondingChip() {
        return '0';
    }

    public String whoIsPlaying() {
        return "Blue";
    }

    public GameStates nextTurn() {
        return new RedTurn();
    }

}

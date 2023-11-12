package linea;

public class RedTurn extends GameStates {

    public boolean redTurn() {
        return true;
    }

    public void playRedAt(int column, ConnectFour game) {
        game.placeChipInColumn( column );
     }

    public void playBlueAt(int column, ConnectFour aaConnectFour) {
        throw new RuntimeException("Not your turn!");
    }

    public char grabTheCorrespondingChip() {
        return 'X';
    }

    public String whoIsPlaying() {
        return "Red";
    }

    public GameStates nextTurn() {
        return new BlueTurn();
    }

}

package linea;

public abstract class GameStates {

    public boolean finished() {
        return false;
    }

    public boolean redTurn() {
        return false;
    }

    public boolean blueTurn() {
        return false;
    }

    public abstract void playRedAt(int column, ConnectFour aaConnectFour);

    public abstract void playBlueAt(int column, ConnectFour aaConnectFour);

    public abstract char grabTheCorrespondingChip();

    public abstract String whoIsPlaying();

    public abstract GameStates nextTurn();
}

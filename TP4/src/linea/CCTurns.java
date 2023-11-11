package linea;

public abstract class CCTurns {

    public boolean finished() {
        return false;
    }

    public boolean redTurn() {
        return false;
    }

    public boolean blueTurn() {
        return false;
    }

    public abstract void playBlueAt(int pos, AAConnectFour aaConnectFour);

    public abstract void playRedAt(int pos, AAConnectFour aaConnectFour);

    public abstract String getCurrentChip();

    public abstract String whoIsPlaying();

    public abstract CCTurns nextTurn();

}

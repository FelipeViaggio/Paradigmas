package linea;

public class Draw extends CCTurns {
    public void playRedAt(int column, AAConnectFour aaConnectFour) {
        throw new RuntimeException("Game finished!");
    }

    public void playBlueAt(int column, AAConnectFour aaConnectFour) {
        throw new RuntimeException("Game finished!");
    }

    public String getCurrentChip() {
        return " ";
    }

    public String whoIsPlaying() {
        return "Game finished!";
    }

    public CCTurns nextTurn() {
        return this ;
    }
}

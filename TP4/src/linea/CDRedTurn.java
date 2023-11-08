package linea;

public class CDRedTurn extends CCTurns {
    public CCTurns next() {
        return new CDlueTurn();
    }

    public void playRed() {}

    public void playBlue() {
        throw new RuntimeException("Not your turn!");
    }
}
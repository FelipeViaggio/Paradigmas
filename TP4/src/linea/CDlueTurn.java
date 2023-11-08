package linea;

public class CDlueTurn extends CCTurns {
    public CCTurns next() {
        return new CDRedTurn();
    }

    public void playRed() {
        throw new RuntimeException("Not your turn!");
    }

    public void playBlue() {}
}

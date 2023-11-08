package linea;

public class CDBlueTurn extends CCTurns {
    public CCTurns playRed(int column, CCTurns turn) {
        throw new RuntimeException("Not your turn!");
    }

    public void playBlue() {}
}

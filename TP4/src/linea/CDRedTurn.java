package linea;

public class CDRedTurn extends CCTurns {
    public CCTurns playRed(int column, CCTurns turn) {
        AAConnectFour.gameBoard.get(column - 1).add("X");
        return new CDBlueTurn();
    }

    public CCTurns playBlue(int column, CCTurns turn) {throw new RuntimeException("Not your turn!");};
}

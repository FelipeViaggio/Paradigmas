package linea;

public class CDBlueTurn extends CCTurns {
    public CCTurns playRed(int column, CCTurns turn) {
        throw new RuntimeException("Not your turn!");
    }

    public CCTurns playBlue(int column, CCTurns turn) {
        AAConnectFour.gameBoard.get(column - 1).add("O");
        return new CDRedTurn();
    }

}

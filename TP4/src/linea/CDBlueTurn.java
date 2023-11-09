package linea;

import java.util.ArrayList;

public class CDBlueTurn extends CCTurns {
    public CCTurns playRed(int column, CCTurns turn, ArrayList<ArrayList<String>> gameBoard) {
        throw new RuntimeException("Not your turn!");
    }

    public CCTurns playBlue(int column, CCTurns turn, ArrayList<ArrayList<String>> gameBoard) {
        gameBoard.get(column - 1).add("O");
        return new CDRedTurn();
    }
}

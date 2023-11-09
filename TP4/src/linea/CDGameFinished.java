package linea;

import java.util.ArrayList;

public class CDGameFinished extends CCTurns {
    public CCTurns playRed(int column, CCTurns turn, ArrayList<ArrayList<String>> gameBoard) {
        throw new RuntimeException("Game finished!");
    }

    public CCTurns playBlue(int column, CCTurns turn, ArrayList<ArrayList<String>> gameBoard) {
        throw new RuntimeException("Game finished!");
    }
}

package linea;

import java.util.ArrayList;

public abstract class CCTurns {
    public abstract CCTurns playRed(int column, CCTurns turn, ArrayList<ArrayList<String>> gameBoard);
    public abstract CCTurns playBlue(int column, CCTurns turn, ArrayList<ArrayList<String>> gameBoard);
}

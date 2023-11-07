package linea;

import java.util.ArrayList;

public abstract class Chips {
    public abstract boolean isRed();
    public abstract Chips chipBelow(ArrayList<ArrayList<Chips>> board, int column, int row);
}

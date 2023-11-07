package linea;

import java.util.ArrayList;

public class RedChip extends Chips {

    public boolean isRed() {
        return true;
    }

    public Chips chipBelow(ArrayList<ArrayList<Chips>> board, int column, int row) {
        if (row > 0 && board.get(column).get(row - 1) == null) {
            return new RedChip();
        } else {
            return null;
        }
    }
}

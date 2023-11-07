package linea;

import java.util.ArrayList;

public class BlueChip extends Chips {
    public boolean isRed() {
        return false;
    }

    public Chips chipBelow(ArrayList<ArrayList<Chips>> board, int column, int row) {
        if (row > 0 && board.get(column).get(row - 1) == null) {
            return new BlueChip();
        } else {
            return null;
        }
    }
}

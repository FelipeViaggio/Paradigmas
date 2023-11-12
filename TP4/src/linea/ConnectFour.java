package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectFour {

    public static final String COLUMN_OUT_OF_BOUNDS = "Column out of bounds";
    public static final String COLUMN_IS_FULL = "Column is full";

    private int base;
    private int height;
    private ArrayList<ArrayList<String>> gameBoard;
    private GameModes mode;
    private GameStates currentTurn;
    private String currentPlayer;
    private String winner = "There is no winner yet";

    public ConnectFour(int base, int height, char mode ) {
        this.currentTurn = new RedTurn();
        this.currentPlayer = "Red";
        this.base = base;
        this.height = height;
        this.mode = GameModes.chosenMode(mode);
        this.gameBoard = new ArrayList<>();
        IntStream.range(0, base).forEach(i -> gameBoard.add(new ArrayList<>()));
    }

    public void placeChipInColumn( int column ) {
        if (theColumnIsOutOfBounds(column)) {
            throw new RuntimeException(COLUMN_OUT_OF_BOUNDS);
        } else if (theColumnIsFull(column)) {
            throw new RuntimeException(COLUMN_IS_FULL);
        } else {
            String chip = String.valueOf(currentTurn.grabTheCorrespondingChip());
            gameBoard.get(column - 1).add(chip);
            this.currentTurn = getNextTurnIfGameNotOver(column - 1);
            this.currentPlayer = currentTurn.whoIsPlaying();
        }
    }

    public void playRedAt( int column ) {
        currentTurn.playRedAt(column, this);
    }

    public void playBlueAt ( int column ) {
        currentTurn.playBlueAt(column, this);
    }

    public boolean redTurn() {
        return currentTurn.redTurn();
    }

    public boolean blueTurn() {
        return currentTurn.blueTurn();
    }

    public String winner () {
        return winner;
    }

    public boolean finished() {
        return currentTurn.finished();
    }

    public boolean itIsADraw() {
        int totalSpaces = base * height;
        int totalChips = gameBoard.stream()
                .mapToInt(List::size)
                .sum();

        return totalSpaces == totalChips;
    }

    public GameStates getNextTurnIfGameNotOver(int column) {
        if (itIsADraw()) {
            return new Draw();
        } else if (mode.finished(this, column)) {
            this.winner = this.currentPlayer;
            return new GameFinished();
        }
        return currentTurn.nextTurn();
    }

    public char getCurrentChip ( int colIndex, int rowIndex){
        if (!theColumnIsOutOfBounds(colIndex + 1) && rowExistsInColumn(colIndex, rowIndex)) {
                return gameBoard.get(colIndex).get(rowIndex).charAt(0);
            }
        return ' ' ;
    }

    public boolean isGameOverVerticallyOrHorizontally(int column) {
        int rowIndex = getRowIndex(column);
        char currentPlayerChip = getCurrentChip(column, rowIndex);

        return checkRowWin(column, rowIndex, currentPlayerChip) || checkColumnWin(column, rowIndex, currentPlayerChip);
    }

    private boolean checkRowWin(int column, int rowIndex, char player) {
        return IntStream.rangeClosed(column - 3, column)
                .filter(col -> col >= 0 && col < base)
                .anyMatch(col -> IntStream.rangeClosed(col, col + 3)
                        .allMatch(c -> getCurrentChip(c, rowIndex) == player));
    }

    private boolean checkColumnWin(int column, int rowIndex, char player) {
        return IntStream.rangeClosed(rowIndex - 3, rowIndex)
                .filter(row -> row >= 0 && row < height)
                .anyMatch(row -> IntStream.rangeClosed(row, row + 3)
                        .allMatch(r -> getCurrentChip(column, r) == player));
    }

    public boolean isGameOverDiagonally(int column) {
        return checkGameOverDiagonally(column, 1) || checkGameOverDiagonally(column, -1);
    }

    private boolean checkGameOverDiagonally(int column, int direction) {
        int rowIndex = getRowIndex(column);
        char currentPlayerChip = getCurrentChip(column, rowIndex);

        return IntStream.range(0, 4)
                .mapToObj(i -> IntStream.range(0, 4)
                        .allMatch(j -> getCurrentChip(column + i + j * direction, rowIndex + i - j) == currentPlayerChip))
                        .anyMatch(hasWon -> hasWon);
    }

    public String show() {
        StringBuilder board = new StringBuilder();
        IntStream.range(0, height).forEach(i -> {
            board.append("|");
            IntStream.range(0, base).forEach(j -> {
                board.append( getCurrentChip( j, height - i - 1 ) );
                board.append("|");
            });
            board.append("\n");
        });
        if ( itIsADraw() ){
            board.append("\nDraw!");
        } else if ( finished() ) {
            board.append("\n" + winner() + " wins!");
        }
        return board.toString();

    }

    private boolean theColumnIsFull(int column) {
        return gameBoard.get(column - 1).size() == height;
    }

    private boolean theColumnIsOutOfBounds(int column) {
        return column > base || column < 1;
    }

    private boolean rowExistsInColumn(int column, int row) {
        return gameBoard.get(column).size() > row && row >= 0;
    }

    private int getRowIndex(int column) {
        return gameBoard.get(column).size() - 1;
    }

//    public String show() {
//        String board =
//                IntStream.range(0, height)
//                .mapToObj(i -> "\n|" + IntStream.range(0, base)
//                        .mapToObj(j -> gameBoard.get(j).size() > height - 1 - i ? gameBoard.get(j).get(height - 1 - i) : "-")
//                        .collect(Collectors.joining()) + "|")
//                .collect(Collectors.joining());
//        board += "\n|" + " \uD83D\uDD3C ".repeat(base) + "|";
//        return board;
//    }
}

package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AAConnectFour {

    public static final String ERROR_POSITION = "Invalid position";
    public static final String COLUMN_OUT_OF_BOUNDS = "Column out of bounds";
    public static final String COLUMN_IS_FULL = "Column is full";

    private int base;
    private int height;
    private ArrayList<ArrayList<String>> gameBoard;
    private BBGameModes mode;
    private CCTurns currentTurn;
    private String currentPlayer;
    private String winner = "There is no winner yet";

    public AAConnectFour( int base, int height, char mode ) {
        this.currentTurn = new CDRedTurn();
        this.currentPlayer = "Red";
        this.base = base;
        this.height = height;
        this.mode = BBGameModes.chosenMode(mode);
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

    public CCTurns getNextTurnIfGameNotOver(int column) {
        if (itIsADraw()) {
            return new Draw();
        } else if (mode.finished(this, column)) {
            this.winner = this.currentPlayer;
            return new CDGameFinished();
        }
        return currentTurn.nextTurn();
    }

    public char getCurrentChip ( int colIndex, int rowIndex){
        if (!theColumnIsOutOfBounds(colIndex + 1) && rowExistsInColumn(colIndex, rowIndex)) {
                return gameBoard.get(colIndex).get(rowIndex).charAt(0);
            }
        return ' ' ;
    }

    public boolean winnerVerticallyorHorizontally ( int column ) {
        Integer rowIndex = gameBoard.get(column).size() - 1;
        char player = getCurrentChip( column , rowIndex );

        boolean rowWin = IntStream.iterate(column - 3, i -> i + 1).limit(4)
                .mapToObj(col -> IntStream.range(0, 4)
                        .map( i -> getCurrentChip(col + i, rowIndex))
                        .allMatch( c -> c == player))
                .anyMatch(b -> b == true);

        boolean colWin = IntStream.iterate(rowIndex - 3, i -> i + 1).limit(4)
                .mapToObj(fila -> IntStream.range(0, 4)
                        .map( i -> getCurrentChip( column , fila + i))
                        .allMatch( c -> c == player))
                .anyMatch(b -> b == true);

        return rowWin || colWin;
    }

    public boolean isGameOverDiagonally ( int place){
        return GameOverDiagonally(place, 1) || GameOverDiagonally(place, -1);
    }

    private boolean GameOverDiagonally ( int place, int direction){
        int rowIndex = gameBoard.get(place).size() - 1;
        char player = getCurrentChip(place, rowIndex);
        return IntStream.range(0, 4)
                .mapToObj(i -> IntStream.range(0, 4)
                        .allMatch(j -> getCurrentChip(place + i + j * direction, rowIndex + i - j) == player))
                .anyMatch(b -> b);
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

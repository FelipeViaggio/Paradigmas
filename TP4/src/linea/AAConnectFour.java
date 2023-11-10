package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AAConnectFour {

    private static final String ERROR_POSITION = "Invalid position";

    private int base;
    private int height;
    private BBGameModes mode;
    private CCTurns turn;
    private String currentPlayer;
    private String winner;
    private ArrayList<ArrayList<String>> gameBoard;

    public AAConnectFour(int base, int height, char mode) {
        this.currentPlayer = "Red";
        this.turn = new CDRedTurn();
        this.base = base;
        this.height = height;
        this.mode = BBGameModes.chosenMode(mode);
        this.gameBoard = new ArrayList<>();
        IntStream.range(0, base).forEach(i -> gameBoard.add(new ArrayList<>()));
    }

    public void placeChipInColumn(int column) {
        if (column > base) {
            throw new RuntimeException("Invalid column");
        } else if (gameBoard.get(column - 1).size() == height) {
            throw new RuntimeException("Column is full");
        } else {
            gameBoard.get(column - 1).add(turn.getCurrentChip());
            this.turn = checkIfGameOver(column - 1);
            this.currentPlayer = turn.whoIsPlaying();
        }
    }

    public CCTurns checkIfGameOver(int column) {
        if (isDraw()) {
            return new Draw();
        } else if (mode.finished(this, column)) {
            this.winner = this.currentPlayer;
            return new CDGameFinished();
        }
        return turn.nextTurn();
    }


    public boolean isDraw() {
        long totalSpaces = base * height;
        long totalChips = gameBoard.stream()
                .mapToLong(List::size)
                .sum();

        return totalSpaces == totalChips;
    }

    public String show() {
        String board = IntStream.range(0, height)
                .mapToObj(i -> "\n|" + IntStream.range(0, base)
                        .mapToObj(j -> gameBoard.get(j).size() > height - 1 - i ? gameBoard.get(j).get(height - 1 - i) : "8")
                        .collect(Collectors.joining()) + "|")
                .collect(Collectors.joining());
        board += "\n|" + " \uD83D\uDD3C ".repeat(base) + "|";
        return board;
    }

    public boolean finished() {
        return turn.finished();
    }

    public boolean redTurn() {
        return turn.redTurn();
    }

    public boolean blueTurn() {
        return turn.blueTurn();
    }

    public void playRedAt(int pos) {
        if (pos <= 0 || pos > base) {
            throw new RuntimeException(ERROR_POSITION);
        }
        turn.playRedAt(pos, this);
    }

    public void playBlueAt ( int pos) {
        if (pos <= 0 || pos > base) {
            throw new RuntimeException(ERROR_POSITION);
        }

        turn.playBlueAt(pos, this);
    }

    public boolean rowWin ( int place){
        int rowIndex = gameBoard.get(place).size();
        String player = turn.getCurrentChip();
        //return IntStream.rangeClosed(place - 3, place)
        //        .filter(i -> i >= 0 && i < base)
        //.mapToObj(col -> IntStream.range(0, 4)
        //                .allMatch(i -> getCurrentChip(col + i, rowIndex) == player))
        //        .anyMatch(b -> b);
        return IntStream.range()

    }

    public boolean colWin ( int place) {
        int rowIndex = gameBoard.get(place).size();
        String player = getCurrentChip(place, rowIndex);
        return IntStream.rangeClosed(rowIndex - 3, rowIndex)
                .filter(i -> i >= 0 && i < height)
                .mapToObj(row -> IntStream.range(0, 4)
                        .allMatch(i -> getCurrentChip(place, row + i) == player))
                .anyMatch(b -> b);
    }

    public boolean winnerVerticallyorHorizontally ( int place){
        return rowWin(place) || colWin(place);
    }

    public boolean isGameOverDiagonally ( int place){
        return isGameOverDiagonally(place, 1) || isGameOverDiagonally(place, -1);
    }

    private boolean isGameOverDiagonally ( int place, int direction){
        int rowIndex = gameBoard.get(place).size() - 1;
        String player = getCurrentChip(place, rowIndex);
        return IntStream.range(0, 4)
                .mapToObj(i -> IntStream.range(0, 4)
                        .allMatch(j -> getCurrentChip(place + i + j * direction, rowIndex + i - j) == player))
                .anyMatch(b -> b);
    }

    public String getCurrentChip ( int colIndex, int rowIndex){
        if (colIndex < base && colIndex >= 0) {
            if (gameBoard.get(colIndex).size() > rowIndex && rowIndex >= 0) {
                return gameBoard.get(colIndex).get(rowIndex);
            }
        }
        return " ";
    }

    public String winner () {
        return winner;
    }
}

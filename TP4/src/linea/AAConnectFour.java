package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// javac linea/AAConnectFour.java linea/AGame.java
// java linea.Game

public class AAConnectFour {

    private static final String ERROR_POSITION = "Invalid position";

    private int base;
    private int height;
    private ArrayList<ArrayList<String>> gameBoard;
    private BBGameModes mode;
    private CCTurns turn;
    private String currentPlayer;
    private String winner = "There is no winner yet";

    public AAConnectFour(int base, int height, char mode) {
        this.turn = new CDRedTurn();
        this.currentPlayer = "Red";
        this.base = base;
        this.height = height;
        this.mode = BBGameModes.chosenMode(mode);
        this.gameBoard = new ArrayList<>();
        IntStream.range(0, base).forEach(i -> gameBoard.add(new ArrayList<>()));
    }

    public boolean isDraw() {
        long totalSpaces = base * height;
        long totalChips = gameBoard.stream()
                .mapToLong(List::size)
                .sum();

        return totalSpaces == totalChips;
    }

    public boolean finished() {
        return turn.finished();
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

    public void placeChipInColumn(int column) {
        if (column > base || column < 1) {
            throw new RuntimeException("Column out of bounds");
        } else if (gameBoard.get(column - 1).size() == height) {
            throw new RuntimeException("Column is full");
        } else {
            String chip = String.valueOf(turn.chip());
            gameBoard.get(column - 1).add(chip);
            this.turn = checkIfGameOver(column - 1);
            this.currentPlayer = turn.whoIsPlaying();
        }
    }

    public char getCurrentChip ( int colIndex, int rowIndex){
        if (colIndex < base && colIndex >= 0) {
            if (gameBoard.get(colIndex).size() > rowIndex && rowIndex >= 0) {
                return gameBoard.get(colIndex).get(rowIndex).charAt(0);
            }
        }
        return ' ' ;
    }

    public void playRedAt(int column) {
        turn.playRedAt(column, this);
    }

    public void playBlueAt ( int pos) {
        turn.playBlueAt(pos, this);
    }


    public boolean isGameOverDiagonally ( int place){
        return GameOverDiagonally(place, 1) || GameOverDiagonally(place, -1);
    }

    public String show() {
        String board = IntStream.range(0, height)
                .mapToObj(i -> "\n|" + IntStream.range(0, base)
                        .mapToObj(j -> gameBoard.get(j).size() > height - 1 - i ? gameBoard.get(j).get(height - 1 - i) : "-")
                        .collect(Collectors.joining()) + "|")
                .collect(Collectors.joining());
        board += "\n|" + " \uD83D\uDD3C ".repeat(base) + "|";
        return board;
    }

    public boolean redTurn() {
        return turn.redTurn();
    }

    public boolean blueTurn() {
        return turn.blueTurn();
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

    private boolean GameOverDiagonally ( int place, int direction){
        int rowIndex = gameBoard.get(place).size() - 1;
        char player = getCurrentChip(place, rowIndex);
        return IntStream.range(0, 4)
                .mapToObj(i -> IntStream.range(0, 4)
                        .allMatch(j -> getCurrentChip(place + i + j * direction, rowIndex + i - j) == player))
                .anyMatch(b -> b);
    }

    public String winner () {
        return winner;
    }
}

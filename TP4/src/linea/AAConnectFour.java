package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//javac linea/Linea.java linea/Game.java
//java linea.Game

public class AAConnectFour {
        private int base;
        private int height;
        private BBGameModes mode;
        private boolean redFinished;
        private boolean blueFinished;
        private CCTurns turn = new CDRedTurn();
        private String winner;
        private static final String ERROR_POSITION = "Invalid position";

        private ArrayList<ArrayList<String>> gameBoard;

        public AAConnectFour(int base, int height, char mode) {
            this.base = base;
            this.height = height;
            this.mode = BBGameModes.chosenMode(mode, this);
            this.gameBoard = new ArrayList<>();
            IntStream.range(0, base).forEach(i -> gameBoard.add(new ArrayList<>()));
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
            return redFinished || blueFinished || (!redFinished && !blueFinished && completedBoard()) ;
        }

        public void playRedAt(int pos) {
            if (pos <= 0 || pos > base) {
                throw new RuntimeException(ERROR_POSITION);
            }

            turn = turn.playRed(pos, turn, this.gameBoard);

            redFinished = mode.winningStrategies(this, pos);

            if (redFinished) {
                System.out.println("Red wins!");
                winner = "red";
                turn = new CDGameFinished();
            } else if (completedBoard()) {
                System.out.println("Draw!");
                turn = new CDGameFinished();
            }
        }

        public void playBlueAt(int pos) {
            if (pos <= 0 || pos > base) {
                throw new RuntimeException(ERROR_POSITION);
            }

            turn = turn.playBlue(pos, turn, this.gameBoard);

            blueFinished = mode.winningStrategies(this, pos);

            if (blueFinished) {
                System.out.println("Blue wins!");
                winner = "blue";
                turn = new CDGameFinished();
            } else if (completedBoard()) {
                System.out.println("Draw!");
                turn = new CDGameFinished();
            }
        }


        public boolean verticalWin(int col) {
            int row = gameBoard.get(col - 1).size();
            String chip = gameBoard.get(col - 1).get(row - 1);
            return row > 3 && IntStream.range(0, row)
                    .mapToObj(i -> gameBoard.get(col - 1).get(i))
                    .filter(chip::equals)
                    .limit(4)
                    .count() == 4;
        }

        public boolean horizontalWin(int col) {
            int row = gameBoard.get(col - 1).size();
            String chip = gameBoard.get(col - 1).get(row - 1);
            return IntStream.range(0, base)
                    .filter(i -> gameBoard.get(i).size() >= row)
                    .mapToObj(i -> gameBoard.get(i).get(row - 1))
                    .filter(chip::equals)
                    .limit(4)
                    .count() == 4;
        }

    public boolean rightDiagonalWin(int col) {
        int row = gameBoard.get(col - 1).size();
        String chip = gameBoard.get(col - 1).get(row - 1);
        int start = col - row;
        List<String> diagonal = IntStream.range(0, base - start)
                .filter(i -> start + i >= 0 && gameBoard.get(start + i).size() > i)
                .mapToObj(i -> gameBoard.get(start + i).get(gameBoard.get(start + i).size() - 1 - i))
                .collect(Collectors.toList());
        return IntStream.range(0, diagonal.size() - 3)
                .anyMatch(i -> diagonal.get(i).equals(chip) && diagonal.get(i + 1).equals(chip) && diagonal.get(i + 2).equals(chip) && diagonal.get(i + 3).equals(chip));
    }




    public boolean leftDiagonalWin(int col) {
            int row = gameBoard.get(col - 1).size();
            String chip = gameBoard.get(col - 1).get(row - 1);
            int start = col + row - 2;
            List<String> diagonal = IntStream.range(0, height)
                    .filter(i -> start - i < base && start - i >= 0 && gameBoard.get(start - i).size() > i)
                    .mapToObj(i -> gameBoard.get(start - i).get(i))
                    .collect(Collectors.toList());
            return IntStream.range(0, diagonal.size() - 3)
                    .anyMatch(i -> diagonal.get(i).equals(chip) && diagonal.get(i + 1).equals(chip) && diagonal.get(i + 2).equals(chip) && diagonal.get(i + 3).equals(chip));
        }


        public String winner() {
            return winner;
        }

        public boolean completedBoard(){
            return gameBoard.stream().allMatch(column -> column.size() == height);
        }
}

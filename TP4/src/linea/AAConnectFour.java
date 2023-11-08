package linea;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

    public class AAConnectFour {
        private int base;
        private int height;
        private BBGameModes mode;
        private boolean redFinished;
        private boolean blueFinished;
        private CCTurns turn = new CDRedTurn();
        private String winner;
        private static final String ERROR_POSITION = "Invalid position";

        private ArrayList<ArrayList<String>> gameBoard = new ArrayList<>();


        public AAConnectFour(int base, int height, char mode) {
            this.base = base;
            this.height = height;
            this.mode = BBGameModes.chosenMode(mode, this);
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
            return redFinished || blueFinished || completedBoard() ;
        }

        public void playRedAt(int pos) {
            turn.playRed();

            if (pos <= 0 || pos > base) {
                throw new RuntimeException(ERROR_POSITION);
            }

            gameBoard.get(pos - 1).add("X");

            redFinished = mode.winningStrategies(this, pos);

            if (redFinished) {
                System.out.println("Red wins!");
                winner = "red";
            }
            if (completedBoard()) {
                System.out.println("Draw!");
                turn = new CDGameFinished();
            }
            turn = turn.next();
        }

        public void playBlueAt(int pos) {
            turn.playBlue();

            if (pos <= 0 || pos > base) {
                throw new RuntimeException(ERROR_POSITION);
            }

            gameBoard.get(pos - 1).add(" O ");

            blueFinished = mode.winningStrategies(this, pos);

            if (blueFinished) {
                System.out.println("Blue wins!");
                winner = "blue";
            }
            if (completedBoard()) {
                System.out.println("Draw!");
                turn = new CDGameFinished();
            }
            turn = turn.next();
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
            return IntStream.range(0, base - start)
                    .filter(i -> start + i >= 0 && gameBoard.get(start + i).size() > i)
                    .mapToObj(i -> gameBoard.get(start + i).get(i))
                    .filter(chip::equals)
                    .limit(4)
                    .count() == 4;
        }

        public boolean leftDiagonalWin(int col) {
            int row = gameBoard.get(col - 1).size();
            String chip = gameBoard.get(col - 1).get(row - 1);
            int start = col + row - 2;
            return IntStream.range(0, height)
                    .filter(i -> start - i < base && start - i >= 0 && gameBoard.get(start - i).size() > i)
                    .mapToObj(i -> gameBoard.get(start - i).get(i))
                    .filter(chip::equals)
                    .limit(4)
                    .count() == 4;
        }


        public String winner() {
            return winner;
        }

        public boolean completedBoard(){
            return gameBoard.stream().allMatch(column -> column.size() == height);
        }
    }

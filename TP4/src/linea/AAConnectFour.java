package linea;

import java.util.ArrayList;
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
            String board = "";
            for (int i = height - 1; i >= 0; i--) {
                board += "\n|";
                for (int j = 0; j < base; j++) {
                    if (gameBoard.get(j).size() > i) {
                        board += gameBoard.get(j).get(i);
                    } else {
                        board += "8";
                    }
                }
                board += "|";
            }
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
            int inLine = 0;
            if (row > 3) {
                for (int i = 0; i < row; i++) {
                    if (gameBoard.get(col - 1).get(i).equals(chip)) {
                        inLine++;
                    } else {
                        inLine = 0;
                    }
                    if (inLine == 4) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean horizontalWin(int col) {
            int row = gameBoard.get(col - 1).size();
            String chip = gameBoard.get(col - 1).get(row - 1);
            int inLine = 0;
            for (int i = 0; i < base; i++) {
                if (gameBoard.get(i).size() >= row) {
                    if (gameBoard.get(i).get(row - 1).equals(chip)) {
                        inLine++;
                    } else {
                        inLine = 0;
                    }
                } else {
                    inLine = 0;
                }
                if (inLine == 4) {
                    return true;
                }
            }
            return false;
        }

        public boolean rightDiagonalWin(int col) {
            int row = gameBoard.get(col - 1).size();
            String chip = gameBoard.get(col - 1).get(row - 1);
            int inLine = 0;
            int start = col - row;
            for (int i = 0; i < base - start; i++) {
                if (start + i >= 0) {
                    if (gameBoard.get(start + i).size() > i) {
                        if (gameBoard.get(start + i).get(i).equals(chip)) {
                            inLine++;
                        } else {
                            inLine = 0;
                        }
                        if (inLine == 4) {
                            return true;
                        }
                    } else {
                        inLine = 0;
                    }
                }
            }
            return false;
        }

        public boolean leftDiagonalWin(int col) {
            int row = gameBoard.get(col - 1).size();
            String chip = gameBoard.get(col - 1).get(row - 1);
            int inLine = 0;
            int start = col + row - 2;
            for (int i = 0; i < height; i++) {
                if (start - i < base && start - i >= 0) {
                    if (gameBoard.get(start - i).size() > i) {
                        if (gameBoard.get(start - i).get(i).equals(chip)) {
                            inLine++;
                        } else {
                            inLine = 0;
                        }
                        if (inLine == 4) {
                            return true;
                        }
                    } else {
                        inLine = 0;
                    }
                }
            }
            return false;
        }


        public String winner() {
            return winner;
        }

        public boolean completedBoard(){
            return gameBoard.stream().allMatch(column -> column.size() == height);
        }
    }

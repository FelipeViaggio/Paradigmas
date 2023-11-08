    package linea;

    public class CDGameFinished extends CCTurns {
        public CCTurns playRed(int column, CCTurns turn) {
            throw new RuntimeException("Game finished!");
        }

        public CCTurns playBlue(int column, CCTurns turn) {
            throw new RuntimeException("Game finished!");
        }
    }

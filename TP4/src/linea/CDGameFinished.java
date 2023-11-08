    package linea;

    public class CDGameFinished extends CCTurns {
        public CCTurns next() {
            return this;
        }

        public void playRed() {
            throw new RuntimeException("Game finished!");
        }

        public void playBlue() {
            throw new RuntimeException("Game finished!");
        }
    }

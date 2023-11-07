package linea;

public class RedTurn extends Turns {
    public Turns next() {
        return new BlueTurn();
    }

    public void playRed() {}

    public void playBlue() {
        throw new RuntimeException("Not your turn!");
    }
}
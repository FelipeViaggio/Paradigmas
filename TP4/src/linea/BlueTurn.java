package linea;

public class BlueTurn extends Turns {
    public Turns next() {
        return new RedTurn();
    }

    public void playRed() {
        throw new RuntimeException("Not your turn!");
    }

    public void playBlue() {}
}

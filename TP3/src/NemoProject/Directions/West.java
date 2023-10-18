package NemoProject.Directions;
import NemoProject.Nemo;
import NemoProject.Coordenate;

public class West extends Direction {
    @Override
    public Direction turnRight() {
        return new North();
    }

    @Override
    public Direction turnLeft() {
        return new South();
    }

    @Override
    public void moveForward(Nemo nemo) {
        Coordenate.decrementX();
    }

    @Override
    public String getDirectionString() {
        return "Directions.West";
    }
}

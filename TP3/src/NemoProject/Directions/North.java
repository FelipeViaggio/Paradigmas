package NemoProject.Directions;
import NemoProject.Nemo;
import NemoProject.Coordenate;

public class North extends Direction {
    @Override
    public Direction turnRight() {
        return new East();
    }

    @Override
    public Direction turnLeft() {
        return new West();
    }

    @Override
    public void moveForward(Nemo nemo) {
        Coordenate.incrementY();
    }

    @Override
    public String getDirectionString() {
        return "Directions.North";
    }
}

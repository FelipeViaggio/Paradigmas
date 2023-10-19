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
        nemo.getDirection().moveForward( nemo );
    }

    @Override
    public String getDirectionString() {
        return "North";
    }
}

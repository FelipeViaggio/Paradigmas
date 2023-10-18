package NemoProject.Directions;
import NemoProject.Nemo;
import NemoProject.Coordenate;

public class South extends Direction {
    @Override
    public Direction turnRight() {
        return new West();
    }

    @Override
    public Direction turnLeft() {
        return new East();
    }

    @Override
    public void moveForward(Nemo nemo) {
        Coordenate.decrementY();
    }

    @Override
    public String getDirectionString() {
        return "South";
    }
}

package NemoProject.Directions;
import NemoProject.Nemo;
import NemoProject.Point;

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
        nemo.getPosition().addPoint( new Point( -1, 0 ) );
    }

    @Override
    public String getDirectionString() {
        return "West";
    }
}

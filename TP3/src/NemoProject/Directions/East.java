package NemoProject.Directions;
import NemoProject.Nemo;
import NemoProject.Coordinates.Point;

public class East extends Direction {
    @Override
    public Direction turnRight() {
        return new South();
    }

    @Override
    public Direction turnLeft() {
        return new North();
    }

    @Override
    public void moveForward(Nemo nemo) {
        nemo.getCoordinate().addPoint( new Point( 1, 0 ) );
    }

    @Override
    public String getDirectionString() {
        return "East";
    }
}

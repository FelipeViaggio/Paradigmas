package NemoProject.Directions;
import NemoProject.Nemo;
import NemoProject.Coordinates.Point;

public class East extends Direction {
    public Direction turnRight() {
        return new South();
    }

    public Direction turnLeft() {
        return new North();
    }

    public void moveForward(Nemo nemo) {
        nemo.getCoordinate().addPoint( new Point( 1, 0 ) );
    }

    public String getDirectionString() {
        return "East";
    }
}

package NemoProject.Directions;
import NemoProject.Nemo;
import NemoProject.Coordinates.Point;

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
    public void moveForward( Nemo nemo ) {
        nemo.getCoordinate().addPoint( new Point( 0, -1 ) );
    }

    @Override
    public String getDirectionString() {
        return "South";
    }
}

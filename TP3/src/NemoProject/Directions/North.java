package NemoProject.Directions;
import NemoProject.Nemo;
import NemoProject.Point;

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
        nemo.getCoordinate().addPoint( new Point( 0, 1 ) );
    }

    @Override
    public String getDirectionString() {
        return "North";
    }
}

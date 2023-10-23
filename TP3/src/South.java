public class South extends Direction {
    public Direction turnRight() {
        return new West();
    }

    public Direction turnLeft() {
        return new East();
    }

    public void moveForward( Nemo nemo ) {
        nemo.getCoordinate().addPoint( new Point( 0, -1 ) );
    }

    public String getDirectionString() {
        return "South";
    }
}

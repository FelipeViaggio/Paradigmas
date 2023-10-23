public class North extends Direction {
    public Direction turnRight() {
        return new East();
    }

    public Direction turnLeft() {
        return new West();
    }

    public void moveForward(Nemo nemo) {
        nemo.getCoordinate().addPoint( new Point( 0, 1 ) );
    }

    public String getDirectionString() {
        return "North";
    }
}

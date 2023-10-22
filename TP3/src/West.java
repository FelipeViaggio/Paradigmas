public class West extends Direction {

    public Direction turnRight() {
        return new North();
    }

    public Direction turnLeft() {
        return new South();
    }

    public void moveForward(Nemo nemo) {
        nemo.getCoordinate().addPoint( new Point( -1, 0 ) );
    }

    public String getDirectionString() {
        return "West";
    }
}

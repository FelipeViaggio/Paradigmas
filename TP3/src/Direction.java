public abstract class Direction {
    public abstract Direction turnRight();
    public abstract Direction turnLeft();
    public abstract void moveForward( Nemo nemo );
    public abstract String getDirectionString();
}

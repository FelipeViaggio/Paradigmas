public class East extends Direction{
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
        Points.incrementX();
    }

    @Override
    public String getDirectionString() {
        return "East";
    }
}

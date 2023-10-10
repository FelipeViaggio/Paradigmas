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
        nemo.decrementX();
    }

    @Override
    public String getDirectionString() {
        return "West";
    }
}

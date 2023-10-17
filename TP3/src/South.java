public class South extends Direction{
    @Override
    public Direction turnRight() {
        return new West();
    }

    @Override
    public Direction turnLeft() {
        return new East();
    }

    @Override
    public void moveForward(Nemo nemo) {
        Points.decrementY();
    }

    @Override
    public String getDirectionString() {
        return "South";
    }
}

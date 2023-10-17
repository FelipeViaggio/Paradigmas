public class TurnLeft extends Command{
    @Override
    public void execute(Nemo nemo) {
        nemo.turnLeft();
    }

    @Override
    public boolean matches(char order) {
        return order == 'l';
    }
}

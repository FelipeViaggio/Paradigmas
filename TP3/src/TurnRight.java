public class TurnRight extends Command{
    @Override
    public void execute(Nemo nemo) {
        nemo.turnRight();
    }

    @Override
    public boolean matches(char order) {
        return order == 'r';
    }
}

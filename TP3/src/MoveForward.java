public class MoveForward extends Command{
    @Override
    public void execute(Nemo nemo) {
        nemo.moveForward();
    }

    @Override
    public boolean matches(char order) {
        return order == 'f';
    }
}

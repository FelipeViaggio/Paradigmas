public class Ascend extends Command {
    public void execute(Nemo nemo) {
        nemo.ascend( nemo );
    }

    public boolean matches(char order) {
        return order == 'u';
    }

}

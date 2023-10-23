public class Descend extends Command {
    public void execute(Nemo nemo) {
        nemo.descend( nemo );
    }

    public boolean matches(char order) {
        return order == 'd';
    }

}

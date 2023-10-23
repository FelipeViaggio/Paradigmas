public class ReleaseCapsule extends Command {
    public void execute(Nemo nemo) {
        nemo.releaseCapsule();
    }

    public boolean matches(char order) {
        return order == 'm';
    }

}
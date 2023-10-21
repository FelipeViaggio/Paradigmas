package NemoProject.Commands;

import NemoProject.Nemo;

public class MoveForward extends Command {
    public void execute(Nemo nemo) {
        nemo.moveForward();
    }

    public boolean matches(char order) {
        return order == 'f';
    }
}

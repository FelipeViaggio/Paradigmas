package NemoProject.Commands;

import NemoProject.Nemo;

public class TurnRight extends Command {
    public void execute(Nemo nemo) {
        nemo.turnRight();
    }

    public boolean matches(char order) {
        return order == 'r';
    }
}

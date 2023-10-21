package NemoProject.Commands;

import NemoProject.Nemo;

public class TurnLeft extends Command {
    public void execute(Nemo nemo) {
        nemo.turnLeft();
    }

    public boolean matches(char order) {
        return order == 'l';
    }
}

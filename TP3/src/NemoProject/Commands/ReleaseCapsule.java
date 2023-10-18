package NemoProject.Commands;

import NemoProject.Nemo;

public class ReleaseCapsule extends Command {
    @Override
    public void execute(Nemo nemo) {
        nemo.releaseCapsule();
    }

    @Override
    public boolean matches(char order) {
        return order == 'm';
    }

}
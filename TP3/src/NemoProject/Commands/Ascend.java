package NemoProject.Commands;

import NemoProject.Nemo;

public class Ascend extends Command {
    @Override
    public void execute(Nemo nemo) {
        nemo.ascend();
    }

    @Override
    public boolean matches(char order) {
        return order == 'u';
    }

}

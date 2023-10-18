package NemoProject.Commands;

import NemoProject.Nemo;

public class Descend extends Command {
    @Override
    public void execute(Nemo nemo) {
        nemo.descend( nemo );
    }

    @Override
    public boolean matches(char order) {
        return order == 'd';
    }

}

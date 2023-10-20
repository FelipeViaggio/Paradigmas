package NemoProject.Commands;

import NemoProject.Nemo;

import java.util.Arrays;
import java.util.List;

public abstract class Command {

    public static final List<Command> commands = Arrays.asList(
            new Descend(),
            new Ascend(),
            new MoveForward(),
            new TurnLeft(),
            new TurnRight(),
            new ReleaseCapsule()
    );

    public abstract void execute( Nemo nemo );
    public abstract boolean matches( char order );

}

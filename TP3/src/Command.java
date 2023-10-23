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

    public static void executeAll(Nemo nemo, String directions) {
        directions.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .forEach(directionChar -> commands.stream()
                        .filter(command -> command.matches(directionChar))
                        .forEach(command -> command.execute(nemo)));
    }

    public abstract void execute( Nemo nemo );
    public abstract boolean matches( char order );

}

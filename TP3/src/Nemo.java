import java.util.Arrays;
import java.util.List;

public class Nemo {
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private Direction direction = new North();
    private static final List<Command> commands = Arrays.asList(
            new Descend(),
            new Ascend(),
            new MoveForward(),
            new TurnLeft(),
            new TurnRight()
    );

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public boolean isOnSurface() {
        return z == 0;
    }

    public int getDepth() {
        return z;
    }

    public Direction getDirection() {
        return direction;
    }

    public void ascend() {
        if (z == 0) {
            return;
        }
        z--;
    }

    public void descend() {
        z++;
    }

    public void incrementY() {
        y++;
    }

    public void decrementY() {
        y--;
    }

    public void incrementX() {
        x++;
    }

    public void decrementX() {
        x--;
    }

    public void moveForward() {
        direction.moveForward(this);
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void move(String orders) {
        orders.chars()
                .mapToObj(c -> (char) c)
                .forEach(order -> {
                    commands.stream()
                            .filter(command -> command.matches(order))
                            .findFirst()
                            .ifPresent(command -> command.execute(this));
                });
    }
}

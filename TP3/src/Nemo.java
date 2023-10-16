import java.util.HashMap;
import java.util.Map;

public class Nemo {
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private Direction direction = new North();

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
        Map<Character, Command> commands = new HashMap<>();
        commands.put('d', new Descend());
        commands.put('u', new Ascend());
        commands.put('f', new MoveForward());
        commands.put('l', new TurnLeft());
        commands.put('r', new TurnRight());

        for (char order : orders.toCharArray()) {
            Command command = commands.get(order);
            if (command != null) {
                command.execute(this);
            }
        }
    }
}

// PRUEBAS
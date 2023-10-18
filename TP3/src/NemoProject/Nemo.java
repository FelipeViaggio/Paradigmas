package NemoProject;

import NemoProject.Commands.*;
import NemoProject.DepthState.DepthState;
import NemoProject.DepthState.Superficie;
import NemoProject.Directions.Direction;
import NemoProject.Directions.North;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nemo {
    private Direction direction = new North();
    private DepthState depthState = new Superficie();
    static public String NEMO_EXPLODED = "Nemo exploded";

    private static final List<Command> commands = Arrays.asList(
            new Descend(),
            new Ascend(),
            new MoveForward(),
            new TurnLeft(),
            new TurnRight()
    );

    public int[] getPosition() {
        return new int[]{ Coordenate.x, Coordenate.y};
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
        depthState = depthState.ascend();
    }

    public void descend() {
        depthState = depthState.descend();
    }

    public void moveForward() {
        direction.moveForward( this );
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void releaseCapsule() {
        depthState = depthState.releaseCapsule();
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

    public Object error() {
        throw new Error( NEMO_EXPLODED );
    }
}


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
    private ArrayList<DepthState> depthState = new ArrayList<>();
    static public String NEMO_EXPLODED = "Nemo exploded";
    public Nemo () {
        depthState.add( new Superficie() );
    }

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
        return (depthState.size() - 1 == 0);
    }

    public int getDepth() {
        return depthState.size() - 1;
    }

    public Direction getDirection() {
        return direction;
    }

    public void ascend( Nemo nemo ) {
        DepthState currentState = depthState.get( depthState.size() - 1 );
        currentState.ascend( this );
    }

    public void descend( Nemo nemo ) {
        DepthState currentState = depthState.get( depthState.size() - 1 );
        currentState.descend( this );
    }

    public void addState( DepthState currentState ) {
        depthState.add( currentState );
    }

    public void removeState() {
        depthState.remove( depthState.size() - 1 );
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

    public String releaseCapsule() {
        DepthState currentState = depthState.get( depthState.size() - 1 );
        return (String) currentState.releaseCapsule( this );
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


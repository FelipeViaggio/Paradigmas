package NemoProject;

import NemoProject.Commands.*;
import NemoProject.DepthState.DepthState;
import NemoProject.DepthState.Surface;
import NemoProject.Directions.Direction;
import NemoProject.Directions.North;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nemo {
    private Direction currentDirection;
    private ArrayList<DepthState> depthState = new ArrayList<>();
    static public String NEMO_EXPLODED = "Nemo exploded";
    public Coordenate coord;


    public Nemo ( Point point, Direction direction ) {
        this.currentCoordinate = new Coordinate( point, direction );
        this.currentDirection = direction;
        depthState.add( new Surface() );
    }

    private static final List<Command> commands = Arrays.asList(
            new Descend(),
            new Ascend(),
            new MoveForward(),
            new TurnLeft(),
            new TurnRight()
    );

    public int getDepth() {
        return depthState.size() - 1;
    }

//    public int getXCoordinate() {
//        return coord.getXCoordinate();
//    }

//    public int getYCoordinate() {
//        return coord.getYCoordinate();
//    }

    public Direction getDirection() {
        return direction;
    }

    public Point getPosition() { return this.currentCoordinate.point; }

    public boolean isOnSurface() {
        return (depthState.size() - 1 == 0);
    }

    public void ascend( Nemo nemo ) { getCurrentState().ascend( this ); }

    public void descend( Nemo nemo ) {
        DepthState currentState = depthState.get( depthState.size() - 1 );
        currentState.descend( this );
    }

    public void addState( DepthState currentState ) {
        depthState.add( currentState );
    }

    public void removeState() {
        depthState.remove( this.getDepth() );
    }

    public void moveForward() {
        currentDirection.moveForward( this );
    }

    public void turnLeft() {
        currentDirection = currentDirection.turnLeft();
    }

    public void turnRight() {
        currentDirection = currentDirection.turnRight();
    }

    public String releaseCapsule() { return (String) getCurrentState().releaseCapsule( this ); }

    public void move(String directions){
        directions.toLowerCase().chars()
                .forEach(direction -> {
                    char directionChar = (char) direction;
                    Command.commands.stream()
                            .filter(command -> command.matches(directionChar))
                            .forEach(command -> command.execute(this));
                });
    }

    public Object error() {
        throw new Error( NEMO_EXPLODED );
    }
}


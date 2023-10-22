import java.util.ArrayList;

public class Nemo {
    private Direction currentDirection;
    private ArrayList<DepthState> depthState = new ArrayList<>();
    static public String NEMO_EXPLODED = "Nemo exploded";
    public Coordinate currentCoordinate;

    public Nemo (Point point, Direction direction ) {
        this.currentCoordinate = new Coordinate( point, direction );
        this.currentDirection = direction;
        depthState.add( new Surface() );
    }

    public int getDepth() { return depthState.size() - 1; }

    public Coordinate getCoordinate() { return this.currentCoordinate; }

    public Direction getDirection() { return currentDirection; }

    public Point getPosition() { return this.currentCoordinate.getPosition(); }

    public boolean isOnSurface() { return (this.getDepth() == 0);}

    public void ascend( Nemo nemo ) { getCurrentState().ascend( this ); }

    public void descend( Nemo nemo ) { getCurrentState().descend( this ); }

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

    public Object error() { throw new Error( NEMO_EXPLODED ); }

    private DepthState getCurrentState() { return depthState.get(this.getDepth()); }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Nemo {
    private ArrayList<DepthState> depthStatesList = new ArrayList<>();

    public int z = 0;
    private Direction direction = new North();
    private static final List<Command> commands = Arrays.asList(
            new Descend(),
            new Ascend(),
            new MoveForward(),
            new TurnLeft(),
            new TurnRight()
    );

    public Nemo() {
        this.depthStatesList.add( new Surface() );
    }
    public Nemo ascend() {
        DepthState currentState = this.depthStatesList.get( this.depthStatesList.size() - 1 );
        currentState.ascend( this );
        return this;
    }

    public Nemo descend() {
        DepthState currentState = this.depthStatesList.get( this.depthStatesList.size() - 1 );
        currentState.descend( this );
        return this;
    }

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

//    public void ascend() {
//        if (z == 0) {
//            return;
//        }
//        z--;
//    }

//    public void descend() {
//        z++;
//    }


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

package linea;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class GameModes {
    public static ArrayList<GameModes> modos = new ArrayList<GameModes>( Arrays.asList( new VerticalHorizontal(), new Diagonal(), new AnyDirection() ) );

    public static GameModes chosenMode(char mode, ConnectFour game){
        List<GameModes> chosen = modos.stream()
                .filter( m -> m.letter( mode ) )
                .toList();
        return chosen.get(0);
    }

    public abstract boolean letter(char mode);
    public abstract boolean winningStrategies(ConnectFour game, int pos);
}



package linea;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BBGameModes {
    public static ArrayList<BBGameModes> modos = new ArrayList<BBGameModes>( Arrays.asList( new BCVerticalHorizontal(), new BCDiagonal(), new BCAnyDirection() ) );

    public static BBGameModes chosenMode(char mode, AAConnectFour game){
        List<BBGameModes> chosen = modos.stream()
                .filter( m -> m.letter( mode ) )
                .toList();
        return chosen.get(0);
    }

    public abstract boolean letter(char mode);
    public abstract boolean winningStrategies(AAConnectFour game, int pos);
}



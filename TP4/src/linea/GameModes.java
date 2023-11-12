package linea;
import java.util.Arrays;
import java.util.List;

public abstract class GameModes {
    private static final List<GameModes> modes = Arrays.asList(new WinnerVerticallyHorizontally(), new WinnerDiagonally(), new WinnerInAnyDirection());

    public static GameModes chosenMode(char mode) {
        return modes.stream()
                .filter(m -> m.correspondingGameMode(mode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid mode"));
    }

    public abstract boolean correspondingGameMode(char mode);

    public abstract boolean finished(ConnectFour game, int column);
}

package linea;
import java.util.Arrays;
import java.util.List;

public abstract class BBGameModes {
    private static final List<BBGameModes> modes = Arrays.asList(new BCVerticalHorizontal(), new BCDiagonal(), new BCAnyDirection());

    public static BBGameModes chosenMode(char mode) {
        return modes.stream()
                .filter(m -> m.letter(mode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid mode"));
    }

    public abstract boolean letter(char mode);
    public abstract boolean finished(AAConnectFour game, int pos);
}

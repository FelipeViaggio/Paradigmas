package linea;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LineaTest {
    @Test
    public void testPlayRedAt() {
        Linea game = new Linea(7, 6, 'C');
        game.playRedAt(0);
        assertEquals("Rojo", game.getTablero().get(0).get(0).getColor());
    }


    @Test
    public void testPlayBlueAt() {
        Linea game = new Linea(7, 6, 'C');
        game.playBlueAt(1);
        assertEquals("Azul", game.getTablero().get(1).get(0).getColor());
    }

    @Test
    public void testFinished() {
        Linea game = new Linea(7, 6, 'C');
        assertFalse(game.finished());
        game.playRedAt(0);
        game.playRedAt(0);
        game.playRedAt(0);
        game.playRedAt(0);
        assertTrue(game.finished());
    }
}

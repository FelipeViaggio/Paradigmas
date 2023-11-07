package linea;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConnectFourTest {
    @Test
    public void testVerticalWin() {
        ConnectFour game = new ConnectFour(7, 6, 'A');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        assertTrue(game.finished());
        assertEquals("red", game.winner());
    }

    @Test
    public void testHorizontalWin() {
        ConnectFour game = new ConnectFour(7, 6, 'A');
        game.playRedAt(1);
        game.playBlueAt(5);
        game.playRedAt(2);
        game.playBlueAt(5);
        game.playRedAt(3);
        game.playBlueAt(5);
        game.playRedAt(4);
        assertTrue(game.finished());
        assertEquals("red", game.winner());
    }

    @Test
    public void testRightDiagonalWin() {
        ConnectFour game = new ConnectFour(7, 6, 'B');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(5);
        game.playRedAt(4);
        assertTrue(game.finished());
        assertEquals("red", game.winner());
    }


    @Test
    public void testLeftDiagonalWin() {
        ConnectFour game = new ConnectFour(7, 6, 'B');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(5);
        game.playRedAt(4);
        assertTrue(game.finished());
        assertEquals("red", game.winner());
    }

    @Test
    public void testTurnSwitching() {
        ConnectFour game = new ConnectFour(7, 6, 'C');
        game.playRedAt(1);
        assertThrows(RuntimeException.class, () -> game.playRedAt(2));
        game.playBlueAt(2);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(3));
    }

    @Test
    public void testInvalidPosition() {
        ConnectFour game = new ConnectFour(7, 6, 'C');
        assertThrows(RuntimeException.class, () -> game.playRedAt(0));
        assertThrows(RuntimeException.class, () -> game.playRedAt(8));
    }


    @Test
    public void testInvalidMode() {
        assertThrows(RuntimeException.class, () -> new ConnectFour(7, 6, 'D'));
    }
}

package linea;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AAAConnectFourTest {
    @Test
    public void testVerticalWin() {
        AAConnectFour game = new AAConnectFour(7, 6, 'A');
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
        AAConnectFour game = new AAConnectFour(7, 6, 'A');
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
        AAConnectFour game = new AAConnectFour(7, 6, 'B');
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
        AAConnectFour game = new AAConnectFour(7, 6, 'B');
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
        AAConnectFour game = new AAConnectFour(7, 6, 'C');
        game.playRedAt(1);
        assertThrows(RuntimeException.class, () -> game.playRedAt(2));
        game.playBlueAt(2);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(3));
    }

    @Test
    public void testInvalidPosition() {
        AAConnectFour game = new AAConnectFour(7, 6, 'C');
        assertThrows(RuntimeException.class, () -> game.playRedAt(0));
        assertThrows(RuntimeException.class, () -> game.playRedAt(8));
    }


    @Test
    public void testInvalidMode() {
        assertThrows(RuntimeException.class, () -> new AAConnectFour(7, 6, 'D'));
    }

    @Test
    public void testGameFinished() {
        AAConnectFour game = new AAConnectFour(7, 6, 'C');
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(5);
        game.playBlueAt(5);
        game.playRedAt(5);
        game.playBlueAt(5);
        game.playRedAt(5);
        game.playBlueAt(5);
        game.playRedAt(6);
        game.playBlueAt(6);
        game.playRedAt(6);
        game.playBlueAt(6);
        game.playRedAt(6);
        game.playBlueAt(6);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(4);
        game.playRedAt(7);
        game.playBlueAt(7);
        game.playRedAt(7);
        game.playBlueAt(7);
        game.playRedAt(7);
        game.playBlueAt(7);
        assertTrue(game.finished());
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
    }

    @Test
    public void TestyouCannotplaywhengamefinished() {
        AAConnectFour game = new AAConnectFour(1, 1, 'C');
        game.playRedAt(1);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
    }

    @Test
    public void testDraw() {
        AAConnectFour game = new AAConnectFour(3, 3, 'C');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(3);
        assertTrue(game.finished());
        assertNull(game.winner());
    }

    @Test
    public void testAnyDirectionWin() {
        AAConnectFour game = new AAConnectFour(7, 6, 'C');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(6);
        game.playRedAt(4);
        assertTrue(game.finished());
        assertEquals("red", game.winner());
    }


    @Test
    public void testInvalidTurnAfterGameFinished() {
        AAConnectFour game = new AAConnectFour(1, 1, 'C');
        game.playRedAt(1);
        assertTrue(game.finished());
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
        assertThrows(RuntimeException.class, () -> game.playRedAt(1));
    }
}




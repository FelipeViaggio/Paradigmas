package linea;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConnectFourTest {
    @Test
    public void test01VerticalWin() {
        ConnectFour game = new ConnectFour(7, 6, 'A');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        assertTrue(game.finished());
        assertEquals("Red", game.winner());
    }

    @Test
    public void test02HorizontalWin() {
        ConnectFour game = new ConnectFour(7, 6, 'A');
        game.playRedAt(1);
        game.playBlueAt(5);
        game.playRedAt(2);
        game.playBlueAt(5);
        game.playRedAt(3);
        game.playBlueAt(5);
        game.playRedAt(4);
        assertTrue(game.finished());
        assertEquals("Red", game.winner());
    }

    @Test
    public void test03RightDiagonalWin() {
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
        assertEquals("Red", game.winner());
    }


    @Test
    public void test04LeftDiagonalWin() {
        ConnectFour game = new ConnectFour(7, 6, 'B');
        game.playRedAt(6);
        game.playBlueAt(5);
        game.playRedAt(5);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(3);
        game.playRedAt(4);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(2);
        game.playRedAt(3);
        assertTrue(game.finished());
        assertEquals("Red", game.winner());
    }

    @Test
    public void test05TurnSwitching() {
        ConnectFour game = new ConnectFour(7, 6, 'C');
        game.playRedAt(1);
        assertThrows(RuntimeException.class, () -> game.playRedAt(2));
        game.playBlueAt(2);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(3));
    }

    @Test
    public void test06InvalidPosition() {
        ConnectFour game = new ConnectFour(7, 6, 'C');
        assertThrows(RuntimeException.class, () -> game.playRedAt(0));
        assertThrows(RuntimeException.class, () -> game.playRedAt(8));
    }


    @Test
    public void test07InvalidMode() {
        assertThrows(RuntimeException.class, () -> new ConnectFour(7, 6, 'D'));
    }

    @Test
    public void test08NoSpaceLeftItsADraw() {
        ConnectFour game = new ConnectFour(2, 2, 'C');
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        assertTrue(game.finished());
        assertEquals( "There is no winner yet", game.winner());
    }

    @Test
    public void test09YouCannotPlayWhenGameFinished() {
        ConnectFour game = new ConnectFour(1, 1, 'C');
        game.playRedAt(1);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
    }

    @Test
    public void test10Draw() {
        ConnectFour game = new ConnectFour(3, 3, 'C');
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
        assertEquals( "There is no winner yet", game.winner());
    }

    @Test
    public void test11AnyDirectionWin() {
        ConnectFour game = new ConnectFour(7, 6, 'C');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(1);
        game.playRedAt(4);
        assertTrue(game.finished());
        assertEquals("Red", game.winner());
    }


    @Test
    public void test12InvalidTurnAfterGameFinished() {
        ConnectFour game = new ConnectFour(1, 1, 'C');
        game.playRedAt(1);
        assertTrue(game.finished());
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
        assertThrows(RuntimeException.class, () -> game.playRedAt(1));
    }
}




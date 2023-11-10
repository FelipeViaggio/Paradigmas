package linea;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AAAConnectFourTest {
    @Test
    public void test01VerticalWinsRedPlayer() {
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
    public void test02VerticalWinsBluePlayer() {
        AAConnectFour game = new AAConnectFour(7, 6, 'A');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(2);
        assertTrue(game.finished());
        assertEquals("blue", game.winner());
    }

    @Test
    public void test03HorizontalWinsRedPlayer() {
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
    public void test04HorizontalWinsBluePlayer(){
        AAConnectFour game = new AAConnectFour(7, 6, 'A');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(1);
        game.playBlueAt(4);
        game.playRedAt(1);
        game.playBlueAt(5);
        assertTrue(game.finished());
        assertEquals("blue", game.winner());
    }

    @Test
    public void test05RightDiagonalWinsRedPlayer() {
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
    public void test06RightDiagonalWinsBluePlayer() {
        AAConnectFour game = new AAConnectFour(7, 6, 'B');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);
        game.playBlueAt(4);
        game.playRedAt(5);
        game.playBlueAt(4);
        game.playRedAt(5);
        game.playBlueAt(5);
        game.playRedAt(6);
        game.playBlueAt(5);
        assertTrue(game.finished());
        assertEquals("blue", game.winner());
    }


    @Test
    public void test07LeftDiagonalWinsRedPlayer() {
        AAConnectFour game = new AAConnectFour(7, 6, 'B');
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
        assertEquals("red", game.winner());
    }

    @Test
    public void test08LeftDiagonalWinsBluePlayer() {
        AAConnectFour game = new AAConnectFour(7, 6, 'B');
        game.playRedAt(6);
        game.playBlueAt(5);
        game.playRedAt(4);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        assertTrue(game.finished());
        assertEquals("red", game.winner());
    }

    @Test
    public void test09ModeCVerticalWinsRedPlayer() {
        AAConnectFour game = new AAConnectFour(7, 6, 'C');
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
    public void test10ModeCHorizontalWinsBluePlayer() {
        AAConnectFour game = new AAConnectFour(7, 6, 'C');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(3);
        game.playRedAt(1);
        game.playBlueAt(4);
        game.playRedAt(2);
        game.playBlueAt(5);
        assertTrue(game.finished());
        assertEquals("blue", game.winner());
    }

    @Test
    public void test11ModeCRightDiagonalWinsRedPlayer() {
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
        game.playBlueAt(1);
        game.playRedAt(4);
//        game.playBlueAt(1);
//        game.playRedAt(5);
//        game.playBlueAt(5);
//        game.playRedAt(5);
//        game.playBlueAt(5);
//        game.playRedAt(5);
        assertTrue(game.finished());
        assertEquals("red", game.winner());
    }

    @Test
    public void test10TurnSwitchingCorrectly() {
        AAConnectFour game = new AAConnectFour(7, 6, 'C');
        game.playRedAt(1);
        assertThrows(RuntimeException.class, () -> game.playRedAt(2));
        game.playBlueAt(2);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(3));
    }

    @Test
    public void test11InvalidPosition() {
        AAConnectFour game = new AAConnectFour(7, 6, 'C');
        assertThrows(RuntimeException.class, () -> game.playRedAt(8));
    }


    @Test
    public void test11InvalidMode() {
        assertThrows(RuntimeException.class, () -> new AAConnectFour(7, 6, 'D'));
    }

    @Test
    public void test12GameFinishedWhenCompleteGameBoard() {
        AAConnectFour game = new AAConnectFour( 4 , 4 ,'C');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(1);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(3);
        assertTrue(game.finished());
    }

    @Test
    public void test13YouCannotplayWhenGameFinished() {
        AAConnectFour game = new AAConnectFour(1, 1, 'C');
        game.playRedAt(1);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
    }

    @Test
    public void test14Draw() {
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
    public void testInvalidTurnAfterGameFinished() {
        AAConnectFour game = new AAConnectFour(1, 1, 'C');
        game.playRedAt(1);
        assertTrue(game.finished());
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
        assertThrows(RuntimeException.class, () -> game.playRedAt(1));
    }
}




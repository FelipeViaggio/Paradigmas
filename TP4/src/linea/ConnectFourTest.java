package linea;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConnectFourTest {
    @Test
    public void test02GameboardStartsEmpty() {
        IntStream.rangeClosed(1, 4)
                .forEach(row ->
                        IntStream.rangeClosed(1, 4)
                                .forEach(column ->
                                        assertEquals(game.getCurrentChip(row, column), ' ')
                                )
                );
    }

    @Test
    public void test03PlayerRedBegins(){
        assertEquals(new RedTurn(), game.currentGameState());
    }

    @Test
    public void test04YouCannotPlaceAChipOutOfTheGameBoard(){
        assertThrowsLike(() -> game.playRedAt(7), game.COLUMN_OUT_OF_BOUNDS);
    }

    @Test
    public void test05YouCannotPlaceChipWhenTheColumnIsFull(){
        ConnectFour game1x1 = new ConnectFour(2, 1, 'A');
        game1x1.playRedAt(1);
        assertThrowsLike(() -> game1x1.playBlueAt(1), game.COLUMN_IS_FULL);
    }

    @Test
    public void test06ColumnIndexStartsAtOne(){
        assertThrowsLike(() -> game.playRedAt(0), game.COLUMN_OUT_OF_BOUNDS);
    }

    @Test
    public void test07TurnSwitching() {
        game.playRedAt(1);
        assertThrows(RuntimeException.class, () -> game.playRedAt(2));
        game.playBlueAt(2);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(3));
    }

    @Test
    public void test08NoSpaceLeftItsADraw() {
        completeBoardDraw();
        assertTrue(game.finished());
        assertEquals(THERE_IS_NO_WINNER_YET, game.winner());
    }

    @Test
    public void test09YouCannotPlayWhenGameFinished() {
        ConnectFour game = new ConnectFour(1, 1, 'C');
        game.playRedAt(1);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
    }

    @Test
    public void test10InvalidTurnAfterGameFinished() {
        ConnectFour game = new ConnectFour(1, 1, 'C');
        game.playRedAt(1);
        assertTrue(game.finished());
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
        assertThrows(RuntimeException.class, () -> game.playRedAt(1));
    }

    @Test
    public void test11RedPlayerCannotPlayWhenItIsNotHisTurn(){
        assertThrowsLike(() -> game.playBlueAt(1), "Not your turn!");
    }

    @Test
    public void test12TheChipIsWellPlacedAndItsCorrect() {
        game.playRedAt(1);
        assertEquals(game.chipInThisPosition(1, 1), "X");
    }

    @Test
    public void test13RedPlayerWinsVerticallyCorrectly(){
        RedWinsHorizontally();
        assertTrue(game.finished());
        assertEquals("Red", game.winner());
    }

    @Test
    public void test14BluePlayerWinsVerticallyCorrectly(){
        BlueWinsVertically();
        assertTrue(game.finished());
        assertEquals(BLUE, game.winner());
    }

    @Test
    public void test15RedPlayerWinsHorizontallyCorrectly() {
        RedWinsHorizontally();
        assertTrue(game.finished());
        assertEquals("Red", game.winner());
    }

    @Test
    public void test17RedPlayerWinsRightDiagonallyCorrectly() {
        RedWinsRightDiagonally();
        assertTrue(game.finished());
        assertEquals("Red", game.winner());
    }


    @Test
    public void test18RedPlayerWinsLeftDiagonallyCorrectly() {
        RedWinsLeftDiagonally();
        assertTrue(game.finished());
        assertEquals("Red", game.winner());
    }

    @Test
    public void test19BluePlayerWinsRightDiagonallyCorrectly() {
        BlueWinsRightDiagonally();
        assertTrue(game.finished());
        assertEquals(BLUE, game.winner());
    }


    @Test
    public void test20BluePlayerWinsLeftDiagonallyCorrectly() {
        BlueWinsleftDiagonally();
        assertTrue(game.finished());
        assertEquals(BLUE, game.winner());
    }

    @Test
    public void test21PlayerDoesNotWinIfHePuts4ChipsDiagonallyInHorizontalVerticalMode() {
        ConnectFour gameModeA = connectFourModeA();
        RedWinsRightDiagonally();
        assertFalse(gameModeA.finished());
        assertEquals(THERE_IS_NO_WINNER_YET, gameModeA.winner());
    }

    @Test
    public void test22PlayerDoesNotWinIfHePuts4ChipsHorizontallyInDiagonalMode() {
        ConnectFour gameModeB = connectFourModeB();
        BlueWinsHorizontally();
        assertFalse(gameModeB.finished());
        assertEquals(THERE_IS_NO_WINNER_YET, gameModeB.winner());
    }

    @Test
    public void test23PlayerDoesNotWinIfHePuts4ChipsVerticallyInDiagonalMode() {
        ConnectFour gameModeB = connectFourModeB();
        BlueWinsVertically();
        assertFalse(gameModeB.finished());
        assertEquals(THERE_IS_NO_WINNER_YET, gameModeB.winner());
    }

    @Test
    public void test24BoardCreation() {
        String board = """
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |1|2|3|4|5|6|
                """;
        assertEquals(board, game.show());
    }

    @Test
    public void test25BoardShowsRedAndBluePlays() {
        game.playRedAt(1);
        game.playBlueAt(2);
        String board = """
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |X|0|-|-|-|-|
                |1|2|3|4|5|6|
                """;
        assertEquals(board, game.show());
    }

    @Test
    public void test26ChipsStackWhenPlayedInTheSameColumn() {
        game.playRedAt(1);
        game.playBlueAt(1);
        String board = """
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |0|-|-|-|-|-|
                |X|-|-|-|-|-|
                |1|2|3|4|5|6|
                """;
        assertEquals(board, game.show());
    }

    @Test
    public void test27RedWinShowsCorrectBoardAndMessage() {
        RedWinsVertically();
        String expectedBoard = """
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |X|-|-|-|-|-|
                |X|0|-|-|-|-|
                |X|0|-|-|-|-|
                |X|0|-|-|-|-|
                |1|2|3|4|5|6|
                Red wins!
                """;
        String actualBoard = game.show();
        assertEquals(expectedBoard.replaceAll("\\s", ""), actualBoard.replaceAll("\\s", ""));
    };

    @Test
    public void test28BlueWinShowsCorrectBoardAndMessage() {
        BlueWinsVertically();
        String expectedBoard =
                """
                |-|-|-|-|-|-|
                |-|-|-|-|-|-|
                |-|0|-|-|-|-|
                |X|0|-|-|-|-|
                |X|0|-|-|-|-|
                |X|0|X|-|-|-|
                |1|2|3|4|5|6|
                Blue wins!
                """;
        String actualBoard = game.show();
        assertEquals(expectedBoard.replaceAll("\\s", ""), actualBoard.replaceAll("\\s", ""));
    }

    @Test
    public void tes29tDrawShowsCorrectBoardAndMessage() {
        completeBoardDraw();
        String expectedBoard = """
                |0|X|0|X|0|X|
                |0|X|0|X|0|X|
                |0|X|0|X|0|X|
                |X|0|X|0|X|0|
                |X|0|X|0|X|0|
                |X|0|X|0|X|0|
                |1|2|3|4|5|6|
                Draw!
                """;
        String actualBoard = game.show();
        assertEquals(expectedBoard.replaceAll("\\s", ""), actualBoard.replaceAll("\\s", ""));
    }

    private void assertThrowsLike( Executable executable, String message ) {
        assertEquals( message,
                assertThrows( Exception.class, executable )
                        .getMessage() );
    }

    private ConnectFour runGame(int ... moves) {
        for (int i = 0; i < moves.length; i += 2) {
            game.playRedAt(moves[i]);
            if (i + 1 ==  moves.length) break;
            game.playBlueAt(moves[i + 1]);
        }
        return game;
    }

    private ConnectFour RedWinsHorizontally(){
        return runGame(1,2,1,2,1,2,1);
    }

    private ConnectFour BlueWinsHorizontally(){
        return runGame(1, 2, 1, 2, 1, 2, 3, 2);
    }

    private ConnectFour RedWinsVertically() {
        return runGame(1, 2, 1, 2, 1, 2, 1);
    }

    private ConnectFour BlueWinsVertically() {
        return runGame(1, 2, 1, 2, 1, 2, 3, 2);
    }

    private ConnectFour RedWinsRightDiagonally() {
        return runGame(1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4);
    }

    private ConnectFour BlueWinsRightDiagonally() {
        return runGame(1, 2, 3, 3, 4, 4, 5, 4, 5, 5, 1, 5);
    }

    private ConnectFour RedWinsLeftDiagonally() {
        return runGame(6, 5, 5, 4, 4, 3, 4, 3, 3, 6, 3);
    }

    private ConnectFour BlueWinsleftDiagonally() {
        return runGame(6, 5, 4, 4, 3, 3, 2, 3, 2, 2, 6, 2);
    }

    private ConnectFour completeBoardDraw() {
        return runGame(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2, 1);
    }

    private ConnectFour connectFourModeB(){
        return new ConnectFour(6, 6, 'B');
    }
    
    private ConnectFour connectFourModeA(){
        return new ConnectFour(6, 6, 'A');
    }
}




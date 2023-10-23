import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class NemoTests {
    @Test
    public void test00ShouldStartWhereItIsTold(){
        assertTrue( new Point( 0, 0 ).equals( nemoAtPointZeroLookingToNorth().getPosition() ) );
    }

    @Test
    public void test01ShouldStartLookingToWhereItIsTold(){
        assertEquals( "North", nemoAtPointZeroLookingToNorth().getDirection().getDirectionString() );
    }

    @Test
    public void test02CheckIfItIsOnTheSurface(){
        assertTrue( nemoAtPointZeroLookingToNorth().isOnSurface() );
    }

    @Test
    public void test03ShouldNotMoveIfNoOrderGiven(){
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "" );
        assertTrue( isNemoAtPositionSelected( nemo, 0, 0 ) );
    }

    @Test
    public void test04ShouldSubmergeIfOrderIsToDive() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "d" );
        assertFalse( nemo.isOnSurface() );
    }

    @Test
    public void test05NothingShouldHappenIfItIsOnSurfaceAndOrderIsToGoUp() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "u" );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test06ShouldBeOnTheSurfaceIfItDivesAndThenGoesUp() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "du" );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test07TurningRightWorksCorrectly() {
        Nemo nemo = nemoAtPointZeroLookingToNorth();
        nemo.move( "r" );
        assertEquals( "East", nemo.getDirection().getDirectionString() );
        nemo.move( "r" );
        assertEquals( "South", nemo.getDirection().getDirectionString() );
        nemo.move( "r" );
        assertEquals( "West", nemo.getDirection().getDirectionString() );
        nemo.move( "r" );
        assertEquals( "North", nemo.getDirection().getDirectionString() );
    }

    @Test
    public void test08TurningLeftWorksCorrectly() {
        Nemo nemo = nemoAtPointZeroLookingToNorth();
        nemo.move( "l" );
        assertEquals( "West", nemo.getDirection().getDirectionString() );
        nemo.move( "l" );
        assertEquals( "South", nemo.getDirection().getDirectionString() );
        nemo.move( "l" );
        assertEquals( "East", nemo.getDirection().getDirectionString() );
        nemo.move( "l" );
        assertEquals( "North", nemo.getDirection().getDirectionString() );
    }

    @Test
    public void test09NemoCanChangeDirectionMultipleTimes() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "rrll" );
        assertEquals( "North", nemo.getDirection().getDirectionString() );
    }


    @Test
    public void test10MovingWorksCorrectly() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "uddrrfff" );
        assertTrue( isNemoAtPositionSelected( nemo, 0, -3 ) );
        assertEquals( 2 , nemo.getDepth() );
    }

    @Test
    public void test11NemoCanMoveForwardMultipleTimes() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "ffff" );
        assertTrue( isNemoAtPositionSelected( nemo, 0, 4 ) );
    }

    @Test
    public void test12NemoCanChangeDepthMultipleTimes() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "ddu" );
        assertEquals( 1, nemo.getDepth() );
    }

    @Test
    public void test13NemoMovesInAllDirections() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "rflflfrfr" );
        assertTrue( isNemoAtPositionSelected( nemo, 0, 2 ) );
        assertEquals( "East", nemo.getDirection().getDirectionString() );
    }

    @Test
    public void test14NemoMovesInAllDirectionsUnderwater() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "drflflfrfru" );
        assertTrue( isNemoAtPositionSelected( nemo, 0, 2 ) );
        assertEquals( "East", nemo.getDirection().getDirectionString() );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test15NemoMovesInSquare() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "rfrfrfrf" );
        assertTrue( isNemoAtPositionSelected( nemo, 0, 0 ) );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test16NemoMovesInSquareUnderwater() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "drfrfrfrf" );
        assertTrue( isNemoAtPositionSelected( nemo, 0, 0 ) );
        assertEquals( 1, nemo.getDepth() );
    }

    @Test
  public void test17NemoLaunchsTheCapsuleAtDepth0AndDepth1() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "m" );
        assertEquals( "Capsule released correctly", nemo.releaseCapsule() );
        nemo.move( "dm" );
        assertEquals( "Capsule released correctly", nemo.releaseCapsule() );
    }

    @Test
    public void test18NemoCapsuleReleaseDoesNotAffectMovement() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "mrf" );
        assertTrue( isNemoAtPositionSelected( nemo, 1, 0 ) );
    }

    @Test
    public void test19NemoCapsuleReleaseDoesNotAffectMovementUnderwater() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "dmrfu" );
        assertTrue( isNemoAtPositionSelected( nemo, 1, 0 ) );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test20NemoCapsuleReleaseDoesNotAffectRotation() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "mrl" );
        assertEquals( "North", nemo.getDirection().getDirectionString() );
    }

    @Test
    public void test21NemoCapsuleReleaseDoesNotAffectRotationUnderwater() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "dmrlu" );
        assertEquals( "North", nemo.getDirection().getDirectionString() );
    }

    @Test
    public void test22NemoCapsuleReleaseDoesNotAffectDepth() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "dmu" );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test23NemoExplodesWhenCapsuleIsLaunchedUnderDepth1() {
        Nemo nemo = nemoAtPointZeroLookingtoNorthMoves( "dd" );
        assertThrowsLike( Nemo.NEMO_EXPLODED, () -> nemo.move( "m" ) );
    }

    @Test
    public void test24NemoExplodesWhenCapsuleIsLaunchedAtDepth2() {
        assertThrowsLike( Nemo.NEMO_EXPLODED, () -> nemoAtPointZeroLookingtoNorthMoves( "ddm" ) );
    }

    private void assertThrowsLike( String expectedErrorMessage, Executable toBeEvaluated ) {
        assertEquals( expectedErrorMessage, assertThrows(Error.class, toBeEvaluated).getMessage() );
    }

    private static Nemo nemoAtPointZeroLookingToNorth() {
        return new Nemo( new Point(0, 0), new North() );
    }

    private static Nemo nemoAtPointZeroLookingtoNorthMoves( String movement ) {
        Nemo nemo = nemoAtPointZeroLookingToNorth();
        nemo.move( movement );
        return nemo;
    }

    private static boolean isNemoAtPositionSelected( Nemo nemo, int x, int y ) {
        return new Point( x, y ).equals( nemo.getPosition() );
    }

}
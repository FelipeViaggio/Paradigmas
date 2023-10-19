package NemoProject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void test00ShouldStartAtTheCentre(){
        assertEquals( new Point( 0, 0 ), new Nemo( new Point(0, 0) ).getPosition() );
    }
    @Test
    public void test01CheckIfItIsOnTheSurface(){
        assertTrue( new Nemo( new Point( 0, 0 )).isOnSurface() );
    }

    @Test
    public void test02ShouldStartLookingToNorth(){
        Assertions.assertEquals( "North", new Nemo( new Point( 0, 0 ) ).getDirection().getDirectionString() );
    }

    @Test
    public void test03ShouldNotMoveIfNoOrderGiven(){
        Nemo nemo = new Nemo( new Point( 0, 0 ) );
        nemo.move( "" );
        assertEquals( new Point( 0, 0 ), nemo.getPosition() );
    }

    @Test
    public void test04ShouldSubmergeIfOrderIsToDive() {
        Nemo nemo = new Nemo( new Point( 0, 0 ) );
        nemo.move( "d" );
        assertFalse( nemo.isOnSurface() );
    }

    @Test
    public void test05NothingShouldHappenIfItIsOnSurfaceAndOrderIsToGoUp() {
        Nemo nemo = new Nemo( new Point( 0, 0 ) );
        nemo.move( "u" );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test06ShouldBeOnTheSurfaceIfItDivesAndThenGoesUp() {
        Nemo nemo = new Nemo( new Point( 0, 0 ) );
        nemo.move( "d" );
        nemo.move( "u" );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test07MovingWorksCorrectly() {
        Nemo nemo = new Nemo( new Point( 0, 0 ) );
        nemo.move( "uddrrfff" );
        assertEquals( new Point( 0, -3 ), nemo.getPosition() );
        assertEquals(2 , nemo.getDepth() );
    }

    @Test
    public void test08TurningRightWorksCorrectly() {
        Nemo nemo = new Nemo( new Point( 0, 0 ) );
        nemo.move( "r" );
        Assertions.assertEquals( "East", nemo.getDirection().getDirectionString() );
        nemo.move("r");
        Assertions.assertEquals( "South", nemo.getDirection().getDirectionString() );
        nemo.move("r");
        Assertions.assertEquals( "West", nemo.getDirection().getDirectionString() );
        nemo.move("r");
        Assertions.assertEquals( "North", nemo.getDirection().getDirectionString() );
    }

    @Test
    public void test09TurningLeftWorksCorrectly() {
        Nemo nemo = new Nemo( new Point( 0, 0 ) );
        nemo.move( "l" );
        Assertions.assertEquals( "West", nemo.getDirection().getDirectionString() );
        nemo.move("l");
        Assertions.assertEquals( "South", nemo.getDirection().getDirectionString() );
        nemo.move("l");
        Assertions.assertEquals( "East", nemo.getDirection().getDirectionString() );
        nemo.move("l");
        Assertions.assertEquals( "North", nemo.getDirection().getDirectionString() );
    }
    @Test
  public void test10NemoLaunchsTheCapsuleAtDepth0AndDepth1() {
        Nemo nemo = new Nemo( new Point( 0, 0 ) );
        nemo.move( "m" );
        assertEquals( "Capsule released correctly", nemo.releaseCapsule() );
        nemo.move( "dm" );
        assertEquals( "Capsule released correctly", nemo.releaseCapsule() );
    }

    @Test
    public void test11NemoExplodesWhenCapsuleIsLaunchedUnderDepth1() {
        Nemo nemo = new Nemo( new Point( 0, 0 ) );
        nemo.move( "dd" );
        assertThrowsLike( Nemo.NEMO_EXPLODED, () -> nemo.releaseCapsule() );
    }



    private void assertThrowsLike(String expectedErrorMessage, Executable toBeEvaluated) {
        assertEquals(expectedErrorMessage, assertThrows(Error.class, toBeEvaluated).getMessage());
    }
}
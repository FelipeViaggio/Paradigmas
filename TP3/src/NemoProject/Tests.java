package NemoProject;

import NemoProject.Directions.North;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void test00ShouldStartWhereItIsTold(){
        assertTrue( new Point( 0, 0 ).equals( new Nemo( new Point(0, 0), new North() ).getPosition() ));
    }
    @Test
    public void test01CheckIfItIsOnTheSurface(){
        assertTrue( new Nemo( new Point( 0, 0 ), new North() ).isOnSurface() );
    }

    @Test
    public void test02ShouldStartLookingToNorth(){
        Assertions.assertEquals( "North", new Nemo( new Point( 0, 0 ), new North() ).getDirection().getDirectionString() );
    }

    @Test
    public void test03ShouldNotMoveIfNoOrderGiven(){
        Nemo nemo = new Nemo( new Point( 0, 0 ), new North() );
        nemo.move( "" );
        assertTrue( new Point( 0, 0 ).equals( nemo.getPosition() ));
//        assertEquals( new Point( 0, 0 ), nemo.getPosition() );
    }

    @Test
    public void test04ShouldSubmergeIfOrderIsToDive() {
        Nemo nemo = new Nemo( new Point( 0, 0 ), new North() );
        nemo.move( "d" );
        assertFalse( nemo.isOnSurface() );
    }

    @Test
    public void test05NothingShouldHappenIfItIsOnSurfaceAndOrderIsToGoUp() {
        Nemo nemo = new Nemo( new Point( 0, 0 ), new North() );
        nemo.move( "u" );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test06ShouldBeOnTheSurfaceIfItDivesAndThenGoesUp() {
        Nemo nemo = new Nemo( new Point( 0, 0 ), new North() );
        nemo.move( "d" );
        nemo.move( "u" );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test07MovingWorksCorrectly() {
        Nemo nemo = new Nemo( new Point( 0, 0 ), new North() );
        nemo.move( "uddrrfff" );
        assertTrue( new Point( 0, -3 ).equals( nemo.getPosition() ));
        assertEquals(2 , nemo.getDepth() );
    }

    @Test
    public void test08TurningRightWorksCorrectly() {
        Nemo nemo = new Nemo( new Point( 0, 0 ), new North() );
        nemo.move( "r" );
        assertEquals( "East", nemo.getDirection().getDirectionString() );
        nemo.move("r");
        assertEquals( "South", nemo.getDirection().getDirectionString() );
        nemo.move("r");
        assertEquals( "West", nemo.getDirection().getDirectionString() );
        nemo.move("r");
        assertEquals( "North", nemo.getDirection().getDirectionString() );
    }

    @Test
    public void test09TurningLeftWorksCorrectly() {
        Nemo nemo = new Nemo( new Point( 0, 0 ), new North() );
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
        Nemo nemo = new Nemo( new Point( 0, 0 ), new North() );
        nemo.move( "m" );
        assertEquals( "Capsule released correctly", nemo.releaseCapsule() );
        nemo.move( "dm" );
        assertEquals( "Capsule released correctly", nemo.releaseCapsule() );
    }

    @Test
    public void test11NemoExplodesWhenCapsuleIsLaunchedUnderDepth1() {
        Nemo nemo = new Nemo( new Point( 0, 0 ), new North() );
        nemo.move( "dd" );
        assertThrowsLike( Nemo.NEMO_EXPLODED, () -> nemo.move("m") );
    }

    private void assertThrowsLike(String expectedErrorMessage, Executable toBeEvaluated) {
        assertEquals(expectedErrorMessage, assertThrows(Error.class, toBeEvaluated).getMessage());
    }
}
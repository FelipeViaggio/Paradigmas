import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void test00ShouldStartAtTheCentre(){
        assertArrayEquals( new int[]{0, 0}, new Nemo().getPosition() );
    }
    @Test
    public void test01CheckIfItIsOnTheSurface(){
        assertTrue( new Nemo().isOnSurface() );
    }

    @Test
    public void test02ShouldStartLookingToNorth(){
        assertEquals( "North", new Nemo().getDirection().getDirectionString() );
    }

    @Test
    public void test03ShouldNotMoveIfNoOrderGiven(){
        Nemo nemo = new Nemo();
        nemo.move( "" );
        assertArrayEquals( new int[]{0, 0}, nemo.getPosition() );
    }

    @Test
    public void test04ShouldSubmergeIfOrderIsToDive() {
        Nemo nemo = new Nemo();
        nemo.move( "d" );
        assertFalse( nemo.isOnSurface() );
    }

    @Test
    public void test05NothingShouldHappenIfItIsOnSurfaceAndOrderIsToGoUp() {
        Nemo nemo = new Nemo();
        nemo.move( "u" );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test06ShouldBeOnTheSurfaceIfItDivesAndThenGoesUp() {
        Nemo nemo = new Nemo();
        nemo.move( "d" );
        nemo.move( "u" );
        assertTrue( nemo.isOnSurface() );
    }

    @Test
    public void test07MovingWorksCorrectly() {
        Nemo nemo = new Nemo();
        nemo.move( "uddrrfff" );
        assertArrayEquals( new int[]{0, -3}, nemo.getPosition() );
        assertEquals(2 , nemo.getDepth() );
    }

    @Test
    public void test08TurningRightWorksCorrectly() {
        Nemo nemo = new Nemo();
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
        Nemo nemo = new Nemo();
        nemo.move( "l" );
        assertEquals( "West", nemo.getDirection().getDirectionString() );
        nemo.move("l");
        assertEquals( "South", nemo.getDirection().getDirectionString() );
        nemo.move("l");
        assertEquals( "East", nemo.getDirection().getDirectionString() );
        nemo.move("l");
        assertEquals( "North", nemo.getDirection().getDirectionString() );
    }

//    @Test
//    public void test10NemoLaunchsTheCapsuleAtDepth0AndDepth1() {
//        Nemo nemo = new Nemo();
//        nemo.move( "m" );
//        assertEquals( "Capsule launched!", nemo.launchCapsule() );
//        nemo.move( "dm" );
//        assertEquals( "Capsule launched!", nemo.launchCapsule() );
//    }
//
//    @Test
//    public void test11NemoExplodesWhenCapsuleIsLaunchedUnderDepth1() {
//        Nemo nemo = new Nemo();
//        nemo.move( "dd" );
//        assertThrowsLike( () -> nemo.move("m"), "Cannot launch capsule at this depth, Nemo exploded!" );
//    }



    private void assertThrowsLike( Executable executable, String message ) {
        assertEquals( message, assertThrows( RuntimeException.class, executable).getMessage() );
    }
}
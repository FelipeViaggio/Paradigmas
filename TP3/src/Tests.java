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
        assertEquals( "NORTH", new Nemo().getDirection() );
    }

    @Test
    public void test03ShouldNotMoveIfNoOrderGiven(){
        Nemo nemo = new Nemo();
        nemo.move( "" );
        assertArrayEquals( new int[]{0, 0}, new Nemo().getPosition() );
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
}
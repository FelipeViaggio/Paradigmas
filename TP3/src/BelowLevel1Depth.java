import javax.management.RuntimeErrorException;

public class BelowLevel1Depth extends DepthState {
    public void ascend( Nemo nemo ) {
        nemo.removeState();
    }

    public void descend( Nemo nemo ) {
        nemo.addState( new BelowLevel1Depth() );
    }

    public void releaseCapsule() {
        throw new RuntimeException( Nemo.NEMO_EXPLODED );
    }
}

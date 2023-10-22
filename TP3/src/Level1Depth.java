public class Level1Depth extends DepthState {
    public void ascend( Nemo nemo ) {
        nemo.removeState();
    }

    public void descend( Nemo nemo ) {
        nemo.addState( new BelowLevel1Depth() );
    }

    public String releaseCapsule( Nemo nemo ) {
        return "Capsule released correctly";
    }
}
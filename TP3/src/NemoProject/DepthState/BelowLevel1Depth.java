package NemoProject.DepthState;

import NemoProject.Nemo;

public class BelowLevel1Depth extends DepthState {
    public void ascend( Nemo nemo ) {
        nemo.removeState();
    }

    public void descend( Nemo nemo ) {
        nemo.addState( new BelowLevel1Depth() );
    }

    public Object releaseCapsule( Nemo nemo ) {
        return nemo.error();
    }
}

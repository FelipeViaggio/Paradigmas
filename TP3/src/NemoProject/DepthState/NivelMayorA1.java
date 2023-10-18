package NemoProject.DepthState;

import NemoProject.Nemo;

public class NivelMayorA1 extends DepthState {
    public void ascend( Nemo nemo ) {
        nemo.removeState();
    }

    public void descend( Nemo nemo ) {
        nemo.addState( new NivelMayorA1() );
    }

    public Object releaseCapsule( Nemo nemo ) {
        return nemo.error();
    }
}

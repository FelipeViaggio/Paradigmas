package NemoProject.DepthState;

import NemoProject.Nemo;

public class Surface extends DepthState {

    @Override
    public void ascend( Nemo nemo ) {}

    @Override
    public void descend( Nemo nemo ) {
        nemo.addState( new Level1Depth() );
    }

    @Override
    public String releaseCapsule( Nemo nemo ) {
        return "Capsule released correctly";
    }
}

package NemoProject.DepthState;

import NemoProject.Nemo;

public abstract class DepthState {
    public abstract void ascend( Nemo nemo );
    public abstract void descend( Nemo nemo );
    public abstract Object releaseCapsule( Nemo nemo );
}

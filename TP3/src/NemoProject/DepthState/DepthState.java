package NemoProject.DepthState;

import NemoProject.Nemo;

public abstract class DepthState {
    public abstract DepthState ascend();
    public abstract DepthState descend();
    public abstract Object releaseCapsule( Nemo nemo );
}

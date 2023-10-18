package NemoProject.DepthState;

import NemoProject.Nemo;

public class NivelMayorA1 extends DepthState {
    public DepthState ascend() {
        return new Nivel1();
    }

    public DepthState descend() {
        return this;

    public Object releaseCapsule( Nemo nemo ) {
        return nemo.error();
    }
}

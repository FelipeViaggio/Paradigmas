package NemoProject.DepthState;

import NemoProject.Nemo;

public class Superficie extends DepthState {

    @Override
    public void ascend( Nemo nemo ) {}

    @Override
    public void descend( Nemo nemo ) {
        nemo.addState( new Nivel1() );
    }

    @Override
    public String releaseCapsule( Nemo nemo ) {
        return "Capsule released correctly"; // Implementa la lógica para liberar la cápsula en la superficie
    }
}

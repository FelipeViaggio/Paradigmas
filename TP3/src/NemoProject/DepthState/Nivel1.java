package NemoProject.DepthState;

import NemoProject.Nemo;

public class Nivel1 extends DepthState {
    public void ascend( Nemo nemo ) {
        nemo.removeState(); // Cuando asciendes desde el nivel 1, llegas a la superficie
    }

    public void descend( Nemo nemo ) {
        nemo.addState( new NivelMayorA1() );
    }

    public String releaseCapsule( Nemo nemo ) {
        return "Capsule released correctly"; // Implementa la lógica para liberar la cápsula en el nivel 1 de profundidad
    }
}
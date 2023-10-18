package NemoProject.DepthState;

import NemoProject.Nemo;

public class Superficie extends DepthState {

    @Override
    public DepthState ascend() {
        return this;
    }

    @Override
    public DepthState descend() {
        return new Nivel1();
    }

    public void liberarCapsula() {
        // Implementa la lógica para liberar la cápsula en la superficie
    }
}

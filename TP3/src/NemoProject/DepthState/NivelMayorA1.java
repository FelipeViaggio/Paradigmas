package NemoProject.DepthState;

import NemoProject.Nemo;

public class NivelMayorA1 extends DepthState {
    public DepthState ascend() {
        return new Nivel1();
    }

    public DepthState descend() {
        return this;

    public void liberarCapsula() {
        // Implementa la lógica para liberar la cápsula en un nivel mayor a 1
    }
}

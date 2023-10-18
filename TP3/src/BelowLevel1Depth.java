public class BelowLevel1Depth extends DepthState {
    public DepthState ascend( Nemo nemo ) {
        return new Level1Depth(); // Cuando asciendes desde un nivel mayor a 1, llegas al nivel 1
    }

    public DepthState descend( Nemo nemo ) {
        return this; // En un nivel mayor a 1, no puedes descender más
    }

    public void releaseCapsule() {
        // Implementa la lógica para liberar la cápsula en un nivel mayor a 1
    }
}
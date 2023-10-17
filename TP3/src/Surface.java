public class Surface extends DepthState{
    public DepthState ascend( Nemo nemo ) {
        return this; // En la superficie, no puedes ascender más
    }

    public DepthState descend( Nemo nemo ) {
        return new Level1Depth(); // Cuando desciendes desde la superficie, llegas al nivel 1
    }

    public void releaseCapsule() {
        // Implementa la lógica para liberar la cápsula en la superficie
    }
}

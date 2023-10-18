public class Level1Depth extends DepthState {
    public DepthState ascend( Nemo nemo ) {
        return new Surface(); // Cuando asciendes desde el nivel 1, llegas a la superficie
    }

    public DepthState descend( Nemo nemo ) {
        return new BelowLevel1Depth(); // Cuando desciendes desde el nivel 1, llegas al nivel mayor a 1
    }

    public void releaseCapsule() {
        // Implementa la lógica para liberar la cápsula en el nivel 1
    }
}
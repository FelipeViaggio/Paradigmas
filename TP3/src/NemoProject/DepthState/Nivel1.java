package NemoProject.DepthState;

public class Nivel1 extends DepthState {
    public DepthState ascend() {
        return new Superficie(); // Cuando asciendes desde el nivel 1, llegas a la superficie
    }

    public DepthState descend() {
        return new NivelMayorA1(); // Cuando desciendes desde el nivel 1, llegas al nivel mayor a 1
    }

    public String releaseCapsule() {
        return "Capsule released correctly"; // Implementa la lógica para liberar la cápsula en el nivel 1 de profundidad
    }
}
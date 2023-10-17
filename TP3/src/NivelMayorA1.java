public class NivelMayorA1 extends EstadoProfundidad {
    public EstadoProfundidad ascend() {
        return new Nivel1(); // Cuando asciendes desde un nivel mayor a 1, llegas al nivel 1
    }

    public EstadoProfundidad descend() {
        return this; // En un nivel mayor a 1, no puedes descender más
    }

    public void liberarCapsula() {
        // Implementa la lógica para liberar la cápsula en un nivel mayor a 1
    }
}
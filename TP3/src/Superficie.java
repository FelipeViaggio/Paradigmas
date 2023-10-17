public class Superficie extends EstadoProfundidad{
    public EstadoProfundidad ascend() {
        return this; // En la superficie, no puedes ascender más
    }

    public EstadoProfundidad descend() {
        return new Nivel1(); // Cuando desciendes desde la superficie, llegas al nivel 1
    }

    public void liberarCapsula() {
        // Implementa la lógica para liberar la cápsula en la superficie
    }
}

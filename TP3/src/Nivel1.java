public class Nivel1 extends EstadoProfundidad {
    public EstadoProfundidad ascend() {
        return new Superficie(); // Cuando asciendes desde el nivel 1, llegas a la superficie
    }

    public EstadoProfundidad descend() {
        return new NivelMayorA1(); // Cuando desciendes desde el nivel 1, llegas al nivel mayor a 1
    }

    public void liberarCapsula() {
        // Implementa la lógica para liberar la cápsula en el nivel 1
    }
}
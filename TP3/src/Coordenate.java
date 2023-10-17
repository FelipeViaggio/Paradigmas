public class Coordenate {
    public static int x = 0;
    public static int y = 0;

    public Coordenate( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    public static Coordenate incrementY() {
        return new Coordenate( x, y + 1 );
    }

    public static Coordenate decrementY() {
        return new Coordenate( x, y - 1 );
    }

    public static Coordenate incrementX() {
        return new Coordenate( x + 1, y );
    }

    public static Coordenate decrementX() {
        return new Coordenate( x - 1, y );
    }
}
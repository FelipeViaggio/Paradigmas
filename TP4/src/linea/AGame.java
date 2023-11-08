package linea;

public class AGame {

    public static void main( String[] args) throws Exception {

        System.out.println( "Dimensiones?");
        AAConnectFour game = new AAConnectFour( prompt( "Base? " ), prompt( "Altura? " ), 'C' );
        System.out.println( game.show() );

        while ( !game.finished() ) {
            game.playRedAt( prompt( "Negras? " ) );
            System.out.println( game.show() );
            if ( !game.finished() ) {
                game.playBlueAt( prompt( "Blancas? " ) );
                System.out.println( game.show() );
            }
        }
    }

    private static int prompt( String message ) {
        System.out.print( message );
        return Integer.parseInt( System.console().readLine() );
    }
}

package linea;

public class AGame {

    public static void main( String[] args) throws Exception {

        System.out.println( "Dimensions?");
        AAConnectFour game = new AAConnectFour( prompt( "Base? " ), prompt( "Height? " ), 'C' );
        System.out.println( game.show() );

        while ( !game.finished() ) {
            game.playRedAt( prompt( "Red's turn: " ) );
            System.out.println( game.show() );
            if ( !game.finished() ) {
                game.playBlueAt( prompt( "Blue's turn: " ) );
                System.out.println( game.show() );
            }
        }
    }

    private static int prompt( String message ) {
        System.out.print( message );
        return Integer.parseInt( System.console().readLine() );
    }
}

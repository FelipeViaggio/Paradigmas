public class Surface extends DepthState {

    public void ascend( Nemo nemo ) {}

    public void descend( Nemo nemo ) {
        nemo.addState( new Level1Depth() );
    }

}

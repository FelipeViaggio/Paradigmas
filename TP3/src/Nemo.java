public class Nemo {
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private String direction = "NORTH";

    public int[] getPosition() { return new int[]{x, y}; }

    public boolean isOnSurface() { return z == 0; }

    public int getDepth() { return z; }

    public String getDirection() { return direction; }

    public void move( String orders ) {
        if ( orders.equals("")) {
            return;
        }
        for ( int i = 0; i < orders.length(); i++) {
            char order = orders.charAt(i);
            if ( order == 'd' ) {
                z++;
            }
            else if ( order == 'u') {
                if ( z == 0 ) {
                    continue;
                }
                z--;
            }
            else if ( order == 'f' ) {
                if ( direction.equals( "NORTH" ) ) {
                    y++;
                }
                else if ( direction.equals( "SOUTH" ) ) {
                    y--;
                }
                else if ( direction.equals( "EAST" ) ) {
                    x++;
                }
                else if ( direction.equals( "WEST" ) ) {
                    x--;
                }
            }
            else if ( order == 'l' ) {
                if ( direction.equals( "NORTH" ) ) {
                    direction = "WEST";
                }
                else if ( direction.equals( "SOUTH" ) ){
                    direction = "EAST";
                }
                else if ( direction.equals( "EAST" ) ) {
                    direction = "NORTH";
                }
                else if ( direction.equals( "WEST" ) ) {
                    direction = "SOUTH";
                }
            }
            else if ( order == 'r' ) {
                if ( direction.equals( "NORTH" ) ) {
                    direction = "EAST";
                }
                else if ( direction.equals( "SOUTH" ) ) {
                    direction = "WEST";
                }
                else if ( direction.equals( "EAST" ) ) {
                    direction = "SOUTH";
                }
                else if ( direction.equals( "WEST" ) ) {
                    direction = "NORTH";
                }
            }

        }
    }
}
package NemoProject.Coordinates;

import NemoProject.Directions.Direction;

public class Coordinate {
    public Point point;
    public Direction direction;

    public Coordinate(Point point, Direction direction ) {
        this.point = point;
        this.direction = direction;
    }

    public Point getPosition() {
        return this.point;
    }

    public Point addPoint( Point point ) {
        return new Point( this.getPosition().x += point.getXCoordinate(),
                this.getPosition().y += point.getYCoordinate() );
    }

}
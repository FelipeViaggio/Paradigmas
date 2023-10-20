package NemoProject;

import NemoProject.Directions.Direction;

public class Coordinate {
    public Point point;
    public Direction direction;

    public Coordinate(Point point, Direction direction ) {
        this.point = point;
        this.direction = direction;
    }

}
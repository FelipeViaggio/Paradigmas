package NemoProject;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXCoordinate() {
        return this.x;
    }

    public int getYCoordinate() {
        return this.y;
    }

    public void addPoint( Point point ) {
        this.x += point.getXCoordinate();
        this.y += point.getYCoordinate();
    }

    public boolean equals( Point point ) {
        return (this.x == point.getXCoordinate() && this.y == point.getYCoordinate());
    }
}

package gr.aueb.cf.ch14.composition;

public class Point2D {
    private Point point;
    private double y;

    public Point2D() {

    }

    public Point getPoint() {
        return point;
    }

    public double getY() {
        return y;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setY(double y) {
        this.y = y;
    }
}


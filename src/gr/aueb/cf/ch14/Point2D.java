package gr.aueb.cf.ch14;

public class Point2D extends Point {
    private double y ;


    public Point2D() {
//        super();  // Ως 1η εντολή  καλεί τον default constructor της point
//        y = 0;
    }


    public Point2D(double x, double y) {
        super(x); // καλεί τον overloaded (υπεργορτωμενο) constructor της point
//        setX(x);
        this.y = y;
    }

    @Override
    public String pointToString() {
        return super.pointToString();
    }

    // Liskov substitution principle
    @Override
    public void movePlus10() {
        super.movePlus10();
    }

    @Override
    protected void movePlusOne() {
        super.movePlusOne();
    }


}

package gr.aueb.cf.ch14;

public class Point3D extends Point2D{
    private double z ;

    public Point3D () {
//        super();  // constructor chaining
//        z = 0;
    }

    public Point3D(double x, double y) {
        super(x, y);
    }

    @Override
    public String pointToString() {
        return super.pointToString();
    }

    @Override
    public void movePlus10() {
        super.movePlus10();
    }

    @Override
    protected void movePlusOne() {
        super.movePlusOne();
    }
}

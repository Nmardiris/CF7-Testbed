package gr.aueb.cf.ch14.composition;

import java.util.Random;

public class Point {
    private int x;
    private int y;

    private Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point getInstance() {
        return new Point();
    }

    public static Point getRandomPoint(){
        Random random = new Random(System.currentTimeMillis());
        return new Point(random.nextInt(10) +1, random.nextInt(10)+1);
    }
}

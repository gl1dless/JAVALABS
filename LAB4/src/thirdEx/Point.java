package thirdEx;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public static double angle(Point a, Point b) {
        double Ax = a.x, Ay = a.y;
        double Bx = b.x, By = b.y;

        double numerator   = Ax * By - Ay * Bx;
        double denominator = Ax * Bx + Ay * By;

        return Math.atan2(numerator, denominator);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

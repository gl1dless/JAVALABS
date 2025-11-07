package thirdEx;

public class Point3D extends Point {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }

    public static double angle(Point3D a, Point3D b) {
        double Ax = a.getX(), Ay = a.getY(), Az = a.z;
        double Bx = b.getX(), By = b.getY(), Bz = b.z;

        double dot = Ax * Bx + Ay * By + Az * Bz;

        double lenA = Math.sqrt(Ax*Ax + Ay*Ay + Az*Az);
        double lenB = Math.sqrt(Bx*Bx + By*By + Bz*Bz);

        return Math.acos(dot / (lenA * lenB));
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
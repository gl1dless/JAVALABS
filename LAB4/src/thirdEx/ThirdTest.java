package thirdEx;

public class ThirdTest {
    public static void run() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(0, 1);
        System.out.println("Angle 2D = " + Point.angle(p1, p2));

        Point3D q1 = new Point3D(1, 0, 0);
        Point3D q2 = new Point3D(0, 1, 0);
        System.out.println("Angle 3D = " + Point3D.angle(q1, q2));
    }
}

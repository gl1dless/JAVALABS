package firstEx;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        super("Triangle");
        setSides(a, b, c);
    }
    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }

    public final void setSides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException("Sides must be > 0");
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("Triangle inequality violated");
        this.a = a; this.b = b; this.c = c;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(Math.max(0.0, s * (s - a) * (s - b) * (s - c)));
    }

    @Override
    public String toString() { return super.toString() + ", a=" + a + ", b=" + b + ", c=" + c; }
}

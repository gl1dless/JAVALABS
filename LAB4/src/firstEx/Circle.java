package firstEx;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        setRadius(radius);
    }

    public double getRadius() { return radius; }

    public final void setRadius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius must be > 0");
        this.radius = radius;
    }

    public double getArea() { return Math.PI * radius * radius; }

    public String toString() {
        return super.toString() + ", r=" + radius;
    }
}
package firstEx;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        setRadius(radius);
    }

    public double getRadius() { return radius; }

    public void setRadius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius must be > 0");
        this.radius = radius;
    }

    @Override
    public double getArea() { return Math.PI * radius * radius; }

    @Override
    public String toString() {
        return super.toString() + ", r=" + radius;
    }
}
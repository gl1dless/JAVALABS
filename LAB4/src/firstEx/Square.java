package firstEx;

public class Square extends Shape {
    private double side;

    public Square(double side) {
        super("Square");
        setSide(side);
    }

    public double getSide() { return side; }

    public final void setSide(double side) {
        if (side <= 0) throw new IllegalArgumentException("Side must be > 0");
        this.side = side;
    }

    @Override
    public double getArea() { return side * side; }

    @Override
    public String toString() { return super.toString() + ", a=" + side; }
}

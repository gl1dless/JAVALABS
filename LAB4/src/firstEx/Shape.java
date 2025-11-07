package firstEx;

public abstract class Shape {
    private String name;

    protected Shape(String name) {
        setName(name);
    }

    public String getName() { return name; }

    public final void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Shape name must be non-empty");
        }
        this.name = name.trim();
    }

    public abstract double getArea();

    public String toString() {
        return getName() + ", area=" + String.format("%.4f", getArea());
    }
}

package firstEx;

public class Test {
    public static void run() {
        Drawing drawing = new Drawing();
        drawing.add(new Circle(3));
        drawing.add(new Square(4));
        drawing.add(new Triangle(3,4,5));
        drawing.printAll();
        System.out.println();
        System.out.println("Circles: " + drawing.countByType(Circle.class));
        System.out.println("Squares: " + drawing.countByType(Square.class));
        System.out.println("Triangles:" + drawing.countByType(Triangle.class));
        Shape s = drawing.pop();
        if (s != null) {
            System.out.println("Popped: " + s);
        }
        System.out.printf("Total area after pop = " + drawing.totalArea());
    }
}

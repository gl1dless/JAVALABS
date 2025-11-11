package firstEx;

import java.util.*;


public class Drawing {
    private final List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public void add(Shape s) {
        if (s == null) throw new IllegalArgumentException("Shape cannot be null");
        shapes.add(s);
    }

    public Shape pop() {
        return shapes.isEmpty() ? null : shapes.remove(shapes.size() - 1);
    }

    public int countByType(Class<? extends Shape> type) {
        int cnt = 0;
        for (Shape s : shapes) {
            if (type.isInstance(s)) cnt++;
        }
        return cnt;
    }

    public double totalArea() {
        double sum = 0;
        for (Shape s : shapes) {
            sum += s.getArea();
        }
        return sum;
    }

    public void printAll() {
        if (shapes.isEmpty()) {
            System.out.println("Drawing is empty");
            return;
        }
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i+1) + ")" + shapes.get(i));
        }
        System.out.printf("Total area = " + totalArea());
    }
}
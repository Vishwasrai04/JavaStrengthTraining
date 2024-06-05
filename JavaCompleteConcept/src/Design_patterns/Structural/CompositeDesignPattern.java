package Design_patterns.Structural;

import java.util.ArrayList;
import java.util.List;

/**
 In simpler terms, imagine you have shapes like circles, squares, and triangles. You could use the Composite Pattern to
 treat a group of these shapes as a single shape. So, if you have a group of circles, squares, and triangles, you can
 treat them all as one shape, which makes it easier to work with them in your code.
 */
public class CompositeDesignPattern {
    public static void main(String args[]){
    Circle circle = new Circle();
    Square square = new Square();
    Triangle triangle = new Triangle();

    CompositeShape composite = new CompositeShape();
        composite.addShape(circle);
        composite.addShape(square);
        composite.addShape(triangle);

        composite.draw();}
}


interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a square");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

class CompositeShape implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

public class abstractClass {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 10);
        Triangle tri = new Triangle(5, 10);
        
        System.out.println("Area of Rectangle: " + rect.area());
        System.out.println("Area of Triangle: " + tri.area());
    }
}

abstract class Figure {
    double dim1;
    double dim2;
    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    abstract double area();
}
class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }
    double area() {
        return dim1 * dim2;
    }
}
class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }
    double area() {
        return (dim1 * dim2) / 2;
    }
}
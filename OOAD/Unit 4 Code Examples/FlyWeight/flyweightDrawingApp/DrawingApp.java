public class DrawingApp {
    public static void main(String[] args) {

        Color red1 = ColorFactory.getColor("Red");
        red1.applyColor("Circle");

        Color red2 = ColorFactory.getColor("Red");
        red2.applyColor("Square");

        Color blue = ColorFactory.getColor("Blue");
        blue.applyColor("Triangle");
    }
}

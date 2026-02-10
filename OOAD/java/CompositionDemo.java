class Engine {
    void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    private Engine engine;

    Car() {
        this.engine = new Engine();
    }

    void startCar() {
        engine.start();
        System.out.println("Car is ready to go!");
    }

}
public class CompositionDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();
    }
}
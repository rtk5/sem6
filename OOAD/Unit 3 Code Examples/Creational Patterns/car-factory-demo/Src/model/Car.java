
package model;

public abstract class Car {
    protected int horsePower;
    protected String color;
    protected String fuelSource;

    public Car(int horsePower, String color, String fuelSource) {
        this.horsePower = horsePower;
        this.color = color;
        this.fuelSource = fuelSource;
    }

    public void cleanCar() {
        System.out.println(getClass().getSimpleName() + " cleaned");
    }

    public void mechanicCheck() {
        System.out.println(getClass().getSimpleName() + " checked by mechanic");
    }

    public void fuelCar() {
        System.out.println(getClass().getSimpleName() + " fueled with " + fuelSource);
    }

    public void startEngine() {
        System.out.println(getClass().getSimpleName() + " engine started with " + horsePower + " HP");
    }
}

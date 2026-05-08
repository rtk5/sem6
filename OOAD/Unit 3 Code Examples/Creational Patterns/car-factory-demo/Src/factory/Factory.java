
package factory;

import model.Car;

public abstract class Factory {

    public Car create(String type) {
        Car car = retrieveCar(type);
        prepareCar(car);
        return car;
    }

    protected abstract Car retrieveCar(String type);

    private void prepareCar(Car car) {
        if (car != null) {
            car.cleanCar();
            car.mechanicCheck();
            car.fuelCar();
        }
    }
}

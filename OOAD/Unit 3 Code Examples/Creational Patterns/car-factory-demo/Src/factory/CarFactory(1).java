
package factory;

import model.*;

public class CarFactory extends Factory {

    @Override
    protected Car retrieveCar(String type) {
        switch (type.toLowerCase()) {
            case "tesla":
                return new Tesla();
            case "audi":
                return new Audi();
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}

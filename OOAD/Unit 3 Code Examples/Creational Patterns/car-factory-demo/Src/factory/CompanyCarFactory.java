
package factory;

import model.*;

public class CompanyCarFactory extends Factory {

    @Override
    protected Car retrieveCar(String type) {
        switch (type.toLowerCase()) {
            case "toyota":
                return new Toyota();
            case "volkswagen":
                return new Volkswagen();
            default:
                throw new IllegalArgumentException("Unknown company car type: " + type);
        }
    }
}

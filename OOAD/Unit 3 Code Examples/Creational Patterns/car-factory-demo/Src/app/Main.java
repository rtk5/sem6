
package app;

import factory.*;
import model.Car;

public class Main {
    public static void main(String[] args) {

        Factory luxuryFactory = new CarFactory();
        Car tesla = luxuryFactory.create("tesla");
        tesla.startEngine();

        System.out.println("------------------");

        Factory companyFactory = new CompanyCarFactory();
        Car toyota = companyFactory.create("toyota");
        toyota.startEngine();
    }
}

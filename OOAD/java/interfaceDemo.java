interface Bicycle {
    void changeCadence(int newValue);
    void changeGear(int newValue);
    void speedUp(int increment);
    void applyBrakes(int decrement);
}

class AAABicycle implements Bicycle {
    int cadence = 0;
    int speed = 0;
    int gear = 1;

public void changeCadence(int newValue) {
    cadence = newValue;
}
public void changeGear(int newValue) {
    gear = newValue;
}

public void speedUp(int increment) {
    speed = speed + increment;
}
public void applyBrakes(int decrement) {
    speed = speed - decrement;
}
public void printStates() {
    System.out.println("cadence:" + cadence + " speed:" + speed + " gear:" + gear);
}

}

public class interfaceDemo {
    public static void main(String[] args) {
        AAABicycle bicycle = new AAABicycle();
        bicycle.changeCadence(50);
        bicycle.speedUp(10);
        bicycle.changeGear(2);
        bicycle.printStates();
    }
}
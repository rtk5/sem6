/**
 *
 * @author shridevisawant
 */

class Employee {
    void work() {
        System.out.println("Employee works");
    }
}

class Manager extends Employee {
    void manage() {
        System.out.println("Manager manages team");
    }
}

class SeniorManager extends Manager {
    void takeDecision() {
        System.out.println("Senior Manager takes strategic decisions");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {

        SeniorManager sm = new SeniorManager();

        sm.work();
        sm.manage();
        sm.takeDecision();

        // instanceof checks
        System.out.println(sm instanceof SeniorManager); // true
        System.out.println(sm instanceof Manager);       // true
        System.out.println(sm instanceof Employee);      // true
        System.out.println(sm instanceof Object);        // true
    }
}
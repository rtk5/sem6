/**
 *
 * @author shridevisawant
 */

class Employee {
    int salary;

    Employee(int salary) {
        this.salary = salary;
    }

    int calculateBonus() {
        return salary * 10 / 100;
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(int salary) {
        super(salary);
    }
}

class Intern extends Employee {

    Intern(int salary) {
        super(salary);
    }

    int calculateBonus() {
        throw new UnsupportedOperationException("Interns do not get bonus");
    }
}

//substituting Intern for Employee breaks the program → LSP violation.
// Intern cannot behave like Employee because it throws an exception.
public class BadLSP {
    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee(50000);
        System.out.println(e1.calculateBonus());

        Employee e2 = new Intern(10000);
        System.out.println(e2.calculateBonus());  // Problem
    }
}
/**
 *
 * @author shridevisawant
 */
//LSP states that a subclass (like Intern) should be able to 
//replace its parent class (Employee) without breaking program 
//behavior.

class Employee {
    int salary;

    Employee(int salary) {
        this.salary = salary;
    }
}

class BonusEligibleEmployee extends Employee {

    BonusEligibleEmployee(int salary) {
        super(salary);
    }

    int calculateBonus() {
        return salary * 10 / 100;
    }
}

class FullTimeEmployee extends BonusEligibleEmployee {

    FullTimeEmployee(int salary) {
        super(salary);
    }
}

class Intern extends Employee {

    Intern(int salary) {
        super(salary);
    }
}

public class LSPDemo {
    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee(50000); 
        //e1 = new Intern(1000);

        if (e1 instanceof BonusEligibleEmployee) {
            BonusEligibleEmployee b = (BonusEligibleEmployee) e1;
            System.out.println(b.calculateBonus());
        }else {
            System.out.println("No bonus applicable");
        }

    }
}
/**
 *
 * @author shridevisawant
 */
/*
Open/Closed Principle
    - Software entities should be open for extension but 
    closed for modification.

Using inheritance and abstraction, new employee types can be added 
without modifying existing code.

*/
abstract class Employee {
    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {

    double calculateSalary() {
        return 50000;
    }
}

class PartTimeEmployee extends Employee {

    double calculateSalary() {
        return 20000;
    }
}

class SalaryCalculator {

    double calculateSalary(Employee employee) {
        return employee.calculateSalary();
    }
}

class OCPDemo {

    public static void main(String[] args) {

        Employee emp1 = new FullTimeEmployee();
        Employee emp2 = new PartTimeEmployee();

        SalaryCalculator calc = new SalaryCalculator();

        System.out.println(calc.calculateSalary(emp1));
        System.out.println(calc.calculateSalary(emp2));
    }
}
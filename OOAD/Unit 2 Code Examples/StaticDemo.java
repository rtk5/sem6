/**
 *
 * @author shridevisawant
 */

class Employee {

    // Instance variable
    int id;
    String name;

    // Static variable
    private static int empCount = 0;

    // Constructor
    Employee(int id, String name) {
        this.id = id;
        this.name = name;
        empCount++;
    }

    // Instance method
    void display() {
        System.out.println(id + " " + name + " ");
    }

    static void displayCount(){
        System.out.println("Total Employees" + empCount);
    }
    // // Static method
    // static void changeCompany(String newCompany) {
    //     company = newCompany;
    //     System.out.println("Company changed to: " + company);
    // }
}

public class StaticDemo {
    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Alice");
        Employee e2 = new Employee(102, "Bob");

        e1.display();
        e2.display();

        // Calling static method
        Employee.displayCount();

        
    }
}
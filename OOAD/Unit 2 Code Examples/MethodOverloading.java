/**
 *
 * @author shridevisawant
 */

class Student {

    void register(int id) {
        System.out.println("Registering student with ID");
    }

    void register(int id, String name) {
        System.out.println("Registering student with ID and Name");
    }

    void register(String name, int id) {
        System.out.println("Registering student with Name and ID");
    }

    void register(double marks) {
        System.out.println("Registering student with Marks");
    }
}

public class MethodOverloading{

    public static void main(String[] args) {
        Student s = new Student();

        s.register(101);              // Case 1
        s.register(101, "Amit");       // Case 2
        s.register("Neha", 102);       // Case 3
        s.register(85);               // Case 4
    }
}
/**
 *
 * @author shridevisawant
 */

/*
The Singleton Pattern ensures that a class has only one instance and
 provides a global access point to it.

 Private constructor → prevents object creation from outside
 Static instance → holds the single object
 Public method → provides access to the instance
*/

class StudentManager {

    // Step 1: Create a private static instance
    private static StudentManager instance;

    // Step 2: Private constructor
    private StudentManager() {
        System.out.println("StudentManager Created");
    }

    // Step 3: Public method to access instance
    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void registerStudent(String name) {
        System.out.println("Registering student: " + name);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {

        StudentManager obj1 = StudentManager.getInstance();
        StudentManager obj2 = StudentManager.getInstance();

        obj1.registerStudent("john");

        // Check if both references point to same object
        System.out.println(obj1 == obj2); // true
    }
}
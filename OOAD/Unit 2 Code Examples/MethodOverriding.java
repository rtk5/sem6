/**
 *
 * @author shridevisawant
 */

class Employee {
    String name;
    int empId;

    public Employee(String name, int id) {
        this.name = name;
        empId = id;
    }

    void work() {
        System.out.println("Employee works on assigned tasks");
    }

           
}

class Developer extends Employee {
    String skill;

    public Developer(String name, int id, String skill ) {
         super(name, id);
         this.skill = skill;
      
    }


    @Override
    void work() {
        System.out.println("Developer writes and reviews code of " + skill);
    }
}

class Tester extends Employee {
    String testingTool;
    

    public Tester(String tool , String name, int id) {
        super(name, id);
        this.testingTool = tool;
    }

    @Override
    void work() {
        System.out.println("Tester tests the application using " + testingTool);
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
       

        Employee e1 = new Developer("", 1, "");   // Upcasting
        Employee e2 = new Tester("", "", 1);    // Upcasting

        e1.work();   // Calls Developer's version
        e2.work();   // Calls Tester's version

        
    }
}
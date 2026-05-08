/**
 *
 * @author shridevisawant
 */

class Student {

    // 1. Private data members (data hiding)
    private int rollNo;
    private String name;

    // 2. Public getter and setter methods
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {

        Student s = new Student();

        // Accessing data using methods
        s.setRollNo(101);
        s.setName("Riya");

        System.out.println("Roll No: " + s.getRollNo());
        System.out.println("Name: " + s.getName());
    }
}
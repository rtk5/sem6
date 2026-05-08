/**
 *
 * @author shridevisawant
 */

class Student{
    String name;
    int rollNo;

    public Student(String name, int rollNo ) {
        this.name = name;
        this.rollNo = rollNo;
       
    }

    @Override
    public boolean equals(Object obj) {
        Student temp = (Student) obj;
        return this.name.equals( temp.name) && this.rollNo == temp.rollNo;
    }

    @Override
    public String toString() {
        return "Roll No:" + rollNo + "\nName:" + name;
    }

    
    

}

public class ObjectDemo {
    public static void main(String[] args) {
        Student s1 = new Student("john", 1);
        Student s2 = new Student("john", 1);

        if (s1 == s2) {
            System.out.println("referencing same object");
        }
        else {
            System.out.println("referencing different object");
        }

        if (s1.equals(s2)) {
            System.out.println("Student content is same");
        }
        else {
            System.out.println("Student content is different");
        }

        System.out.println("Class:" + s1.getClass().getName());
        System.out.println("Hash:" + s1.hashCode());
        System.out.println(s1);
    }
}
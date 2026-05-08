/**
 *
 * @author shridevisawant
 */

/*
Single Responsibility Principle:
A class should have only one responsibility and one reason to change.

In this example:
	•	Student → data
	•	University → admission logic
	•	StudentPrinter → display logic
    */

class Student {
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}

class University {

    void registerStudent(Student student) {
        System.out.println(student.getName() + " registered to the university");
    }
}

class StudentPrinter {

    void printStudent(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
    }
}

public class SRPDemo {
    public static void main(String[] args) {
        Student std = new Student("john", 23);
        University univ = new University();
        StudentPrinter stdPrinter = new StudentPrinter();

        univ.registerStudent(std);
        stdPrinter.printStudent(std);
    }
}
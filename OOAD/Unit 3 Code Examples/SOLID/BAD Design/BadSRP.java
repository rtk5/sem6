/**
 *
 * @author shridevisawant
 */
/*
SRP Violation

In this design, the Student class has multiple responsibilities:
	1.	Storing student data
	2.	Managing university admission logic
	3.	Printing student details
*/

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void registerStudent() {
        System.out.println("Student registered to university");
    }

    void printStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
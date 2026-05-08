

/**
 *
 * @author shridevisawant
 */
class Person {

    // attributes / properties
    String firstName; 
    private int age;
  
    // methods
    void displayInfo(){
        System.out.println("Name:" + firstName);
        System.out.println("Age:" + age);
    }

}


public class ClassDemo {

public static void main(String[] args) {
        System.out.println("Hello World");

        Person p1 = new Person();
        p1.firstName = "John";
        System.out.println("Name of p1: " + p1.firstName);
        
        //Cannot access age being private access modifier
        //System.out.println("Age of p1: " + p1.age); 

        p1.displayInfo();
    }

}
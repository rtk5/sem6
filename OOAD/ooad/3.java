class Animal {

    // Superclass constructor
    Animal() {
        System.out.println("Animal constructor called");
    }

    // Superclass method
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    // Subclass constructor
    Dog() {

        // Calling superclass constructor
        super();

        System.out.println("Dog constructor called");
    }

    // Subclass method
    void display() {

        // Calling superclass method
        super.sound();

        System.out.println("Dog barks");
    }
}

public class SuperDemo {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.display();
    }
}
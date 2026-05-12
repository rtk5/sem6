code such that the output in the main function is true.
public class Sample {
public static void main(String[] args) {
Demo objOne=new Demo(10,20);
Demo objTwo=new Demo(10,20);
System.out.println(objOne.equals(objTwo)); //prints false
}
}
class Demo{
int a;
int b;
Demo(int a,int b){
this.a=a;
this.b=b;
}
}

Reason Why Output is false

The equals() method is inherited from the Object class.

By default, Object class equals() compares:

memory addresses (object references),
not the actual data inside the objects.

public class Sample {

    public static void main(String[] args) {

        Demo objOne = new Demo(10, 20);
        Demo objTwo = new Demo(10, 20);

        System.out.println(objOne.equals(objTwo)); // prints true
    }
}

class Demo {

    int a;
    int b;

    Demo(int a, int b) {

        this.a = a;
        this.b = b;
    }

    // Overriding equals() method
    public boolean equals(Object obj) {

        Demo d = (Demo) obj;

        return (this.a == d.a && this.b == d.b);
    }
}
/**
 *
 * @author shridevisawant
 */
/*
Applying Information Expert - GRASP principle

The Student object knows the marks.
So Student should calculate the average.

*/


class Student {
    private int[] marks;

    public Student(int[] marks) {
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / (double) marks.length;
    }
}

public class InfoExDemo {
    public static void main(String[] args) {
        Student student = new Student(new int[]{80, 90, 100});
        System.out.println("Average: " + student.calculateAverage());
    }
}
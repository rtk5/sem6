/**
 *
 * @author shridevisawant
 */

class Student {
    private int[] marks;

    public Student(int[] marks) {
        this.marks = marks;
    }

    public int[] getMarks() {
        return marks;
    }
}

public class BadInfoExDemo {

    // BAD DESIGN: external class calculating average
    public static double calculateAverage(Student student) {
        int[] marks = student.getMarks();
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return sum / (double) marks.length;
    }

    public static void main(String[] args) {

        Student student = new Student(new int[]{80, 90, 100});

        double avg = calculateAverage(student);

        System.out.println("Average: " + avg);
    }
}
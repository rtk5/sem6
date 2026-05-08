/**
 *
 * @author shridevisawant
 */

abstract class Teacher {

    // abstract method
    abstract void teach();

    // concrete method
    void takeAttendance() {
        System.out.println("Teacher takes attendance");
    }
}

class SchoolTeacher extends Teacher {

    @Override //optional annotation
    void teach() {
        System.out.println("School teacher teaches using textbooks");
    }
}

class CollegeProfessor extends Teacher {

    void teach() {
        System.out.println("College professor teaches using presentations and research");
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {

        Teacher t1 = new SchoolTeacher();
        Teacher t2 = new CollegeProfessor();

        t1.teach();
        t1.takeAttendance();

        t2.teach();
        t2.takeAttendance();
    }
}
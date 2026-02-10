abstract class Teacher {
    abstract void teach();

    void takeAttendance() {
        System.out.println("Taking attendance.");
    }
}

class SchoolTeacher extends Teacher {
    @Override
    void teach() {
        System.out.println("Teaching the class.");
    }
}

class CollegeProf extends Teacher {
    @Override
    void teach() {
        System.out.println("Lecturing the students.");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        Teacher schoolTeacher = new SchoolTeacher();
        Teacher collegeProf = new CollegeProf();

        System.out.println("School Teacher:");
        schoolTeacher.teach();
        schoolTeacher.takeAttendance();

        System.out.println("\nCollege Professor:");
        collegeProf.teach();
        collegeProf.takeAttendance();
    }
}

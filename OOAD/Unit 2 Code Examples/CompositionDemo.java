/**
 *
 * @author shridevisawant
 */

class Syllabus {
    void topics() {
        System.out.println("Course syllabus topics");
    }
}

class Course {
    private Syllabus syllabus = new Syllabus(); // composition

    void startCourse() {
        syllabus.topics();
        System.out.println("Course started");
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        Course ooad = new Course();
        ooad.startCourse();
    }
}
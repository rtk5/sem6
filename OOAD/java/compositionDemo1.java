public class compositionDemo1 {
    public static void main(String[] args) {
        course c = new course();
        c.s.display();
}

class syllabus {
    void display() {
        System.out.println("Syllabus displayed.");
    }
}
class course {
    private syllabus s;
    course() {
        this.s = new syllabus();
    }
}
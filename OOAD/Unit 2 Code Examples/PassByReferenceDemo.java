/**
 *
 * @author shridevisawant
 */

class Student {
    int marks;
}

public class PassByReferenceDemo {

    static void updateMarks(Student s) {
        s.marks = 90;   // modifying object data
    }

    public static void main(String[] args) {
        Student st = new Student();
        st.marks = 50;

        updateMarks(st);

        System.out.println(st.marks);
    }
}
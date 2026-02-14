package demo;

class Student1 {
    int marks;
}

public class PassByReferenceDemo {

    static void updateMarks(Student1 s) {
        s.marks = 90;
    }

    public static void main(String[] args) {
        Student1 st = new Student1();
        st.marks = 50;

        updateMarks(st);

        System.out.println(st.marks);
    }
}
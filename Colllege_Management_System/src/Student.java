import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<String> Courses;

    public Student(String name, Long id, String email) {
        super(name, id, email);
        Courses = new ArrayList<>();
    }

    @Override
    public void getDetails() {

    }
}

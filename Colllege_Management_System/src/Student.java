import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<String> courses;

    public Student(String name, Long id, String email) {
        super(name, id, email);
        courses = new ArrayList<>();
    }

    @Override
    public void getDetails() {
        System.out.println("Hello, " + getName() + " #" + getId());
        if (!courses.isEmpty()) {
            System.out.println("Courses list:");
            for (String course : courses) {
                System.out.println(course);
            }
        }
    }

    public void addCourse(String courseCode) {
        if (!courseCode.matches("^[A-Z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Invalid course code! Example: CSE101");
        }
        courses.add(courseCode);
    }
}

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Student extends Person {
    private final ArrayList<String> courses;

    public Student(String name, String id, String email) {
        super(name, id, email);
        courses = new ArrayList<>();
    }

    @Override
    public void getDetails() {
        System.out.println("Hello, " + getName() + " #" + getId());
        if (!courses.isEmpty()) {
            System.out.println("Your course list:");
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
    public void RemoveCourse(String courseCode) {
        if (!courseCode.matches("^[A-Z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Invalid course code! Example: CSE101");
        }
        if(!courses.contains(courseCode)) {
            throw new NoSuchElementException("Couldn't find a course " + courseCode + " in your course list.");
        }
        courses.remove(courseCode);
    }
}

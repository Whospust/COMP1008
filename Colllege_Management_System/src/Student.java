import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Student extends Person {
    private final ArrayList<String> courses;
    private String major;

    public Student(String name, String id, String email, String major) {
        super(name, id, email);
        courses = new ArrayList<>();
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if(!major.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Invalid field of study! Example: Computer Science");
        }
        this.major = major;
    }

    @Override
    public void getDetails() {
        System.out.println("Hello, " + getName() + " #" + getId());
        System.out.println("Study of field: " + major);
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
        if (!courses.contains(courseCode)) {
            throw new NoSuchElementException("Couldn't find a course " + courseCode + " in your course list.");
        }
        courses.remove(courseCode);
    }

    public void RemoveAllCourses() {
        for (String course : courses) {
            courses.remove(course);
        }
        System.out.println("You have successfully removed all courses!");
    }
}

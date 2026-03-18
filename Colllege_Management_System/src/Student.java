import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Student extends Person {
    // List that collects courses for each individual student
    private final ArrayList<String> courses;

    // fiend of study of an individual student
    private String major;

    public Student(String name, String id, String email, String major) {
        // calling parent constructor
        super(name, id, email);
        courses = new ArrayList<>();

        // validating that fiend of study is only letters and spaces
        if(!major.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Invalid field of study! Example: Computer Science");
        }
        this.major = major;
    }

    // standard getter
    public String getMajor() {
        return major;
    }

    // standard setter with validation
    public void setMajor(String major) {
        if(!major.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Invalid field of study! Example: Computer Science");
        }
        this.major = major;
    }


    // overriding parent method from abstract class person
    @Override
    public void getDetails() {
        System.out.println("Student name: " + getName() + "Student id: #" + getId());
        System.out.println("Study of field: " + major);
        if (!courses.isEmpty()) {
            System.out.println("Your course list:");
            for (String course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No course selected yet:");
        }
    }

    // method, which validates course and then adds it if its valid
    public void addCourse(String courseCode) {
        if (!courseCode.matches("^[A-Z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Invalid course code! Example: CSE101");
        }
        courses.add(courseCode);
    }

    // same method as above but to remove course with exactly the same regex validation
    public void RemoveCourse(String courseCode) {
        if (!courseCode.matches("^[A-Z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Invalid course code! Example: CSE101");
        }
        if (!courses.contains(courseCode)) {
            throw new NoSuchElementException("Couldn't find a course " + courseCode + " in your course list.");
        }
        courses.remove(courseCode);
    }

    // removing all courses from student's list
    public void RemoveAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses to remove!");
            return;
        }
        courses.clear();
        System.out.println("You have successfully removed all courses!");
    }
}

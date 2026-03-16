import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Instructor extends Person{
    // List to collect all courses that an instructor teaches
    private final ArrayList<String> coursesTeaching;
    // field of teaching, for example computer science
    String department;

    // constructor, implemented in exactly the same way as student class constructor
    public Instructor(String name, String id, String email, String department) {
        // calling parent class constructor (Person)
        super(name,id,email);

        // validating field of teaching before assigning it to a variable
        if(!department.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Invalid field of study! Example: Computer Science");
        }
        // if field of teaching is valid then assigned to a variable department
        this.department = department;
        coursesTeaching = new ArrayList<>();
    }

    // standard getter for department field
    public String getDepartment() {
        return this.department;
    }
    // standard setter with regex validation (approves only letters and spaces)
    public void setDepartment(String department) {
        if(!department.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Invalid field of study! Example: Computer Science");
        }
        this.department = department;
    }

    // overridden method from parent abstract class (Person)
    @Override
    public void getDetails() {
        System.out.println("Instructor name: " + getName() + " Instructor id: #" + getId());
        if(!coursesTeaching.isEmpty()) {
            System.out.println("Your current teaching course list:");
            for (String course : coursesTeaching) {
                System.out.println(course);
            }
        } else {
            System.out.println("No course to teach yet");
        }
    }

    // method which adds course that instructor teaches
    public void addCourse(String courseCode) {
        if (!courseCode.matches("^[A-Z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Invalid course code! Example: CSE101");
        }
        coursesTeaching.add(courseCode);
    }
    // method which removes course that instructor taught
    public void RemoveCourse(String courseCode) {
        if (!courseCode.matches("^[A-Z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Invalid course code! Example: CSE101");
        }
        if (!coursesTeaching.contains(courseCode)) {
            throw new NoSuchElementException("Couldn't find a course " + courseCode + " in your course list.");
        }
        coursesTeaching.remove(courseCode);
    }

    // removes all courses
    public void RemoveAllCourses() {
        for (String course : coursesTeaching) {
            coursesTeaching.remove(course);
        }
        System.out.println("You have successfully removed all courses!");
    }
}

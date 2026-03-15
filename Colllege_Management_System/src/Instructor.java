import java.util.ArrayList;
import java.util.NoSuchElementException;
//TODO ADD COMMENTS EVERYWHERE
public class Instructor extends Person{
    private final ArrayList<String> coursesTeaching;
    String department;
    public Instructor(String name, String id, String email, String department) {
        super(name,id,email);
        if(!department.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Invalid field of study! Example: Computer Science");
        }
        this.department = department;
        coursesTeaching = new ArrayList<>();
    }

    public String getDepartment() {
        return this.department;
    }
    public void setDepartment(String department) {
        if(!department.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Invalid field of study! Example: Computer Science");
        }
        this.department = department;
    }

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

    public void addCourse(String courseCode) {
        if (!courseCode.matches("^[A-Z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Invalid course code! Example: CSE101");
        }
        coursesTeaching.add(courseCode);
    }

    public void RemoveCourse(String courseCode) {
        if (!courseCode.matches("^[A-Z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Invalid course code! Example: CSE101");
        }
        if (!coursesTeaching.contains(courseCode)) {
            throw new NoSuchElementException("Couldn't find a course " + courseCode + " in your course list.");
        }
        coursesTeaching.remove(courseCode);
    }

    public void RemoveAllCourses() {
        for (String course : coursesTeaching) {
            coursesTeaching.remove(course);
        }
        System.out.println("You have successfully removed all courses!");
    }
}

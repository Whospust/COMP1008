import java.util.ArrayList;

public class Instructor extends Person{
    private final ArrayList<String> courseTeaching;
    String department;
    public Instructor(String name, String id, String email, String department) {
        super(name,id,email);
        if(!department.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Invalid field of study! Example: Computer Science");
        }
        this.department = department;
        courseTeaching = new ArrayList<>();
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

    }
}

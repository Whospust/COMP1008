import java.util.ArrayList;

public class Instructor extends Person{
    ArrayList<String> courseTeaching;
    String department;
    public Instructor(String name, String id, String email, String department) {
        super(name,id,email);
        this.department = department;
    }

    @Override
    public void getDetails() {

    }
}

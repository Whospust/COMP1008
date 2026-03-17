import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static ArrayList<Instructor> instructorList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

    }


    // Method which allows to add student
    private static void addStudent() {
        try {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Student ID (S-1234): ");
            String id = scanner.nextLine();

            System.out.print("Enter Student Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Major: ");
            String major = scanner.nextLine();

            Student student = new Student(name, id, email, major);
            studentList.add(student);
            System.out.println("Student added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Method which allows to add instructor
    private static void addInstructor() {
        try {
            System.out.print("Enter Instructor Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Instructor ID (S-1234): ");
            String id = scanner.nextLine();

            System.out.print("Enter Instructor Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            Instructor instructor = new Instructor(name, id, email, department);
            instructorList.add(instructor);
            System.out.println("Instructor added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding instructor: " + e.getMessage());
        }
    }

    // Methods which allow to find by studentId student or instructor
    private static Student findStudentById(String id) {
        for (Student s : studentList) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }

    private static Instructor findInstructorById(String id) {
        for (Instructor i : instructorList) {
            if (i.getId().equals(id)) return i;
        }
        return null;
    }

}
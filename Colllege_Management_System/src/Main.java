import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Student> studentList = new ArrayList<>();
    private static final ArrayList<Instructor> instructorList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Instructor");
            System.out.println("3. Assign Course to Student");
            System.out.println("4. Assign Course to Instructor");
            System.out.println("5. Display All Students");
            System.out.println("6. Display All Instructors");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    addInstructor();
                    break;
                case "3":
                    assignCourseToStudent();
                    break;
                case "4":
                    assignCourseToInstructor();
                    break;
                case "5":
                    displayStudents();
                    break;
                case "6":
                    displayInstructors();
                    break;
                case "7":
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
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

    private static void assignCourseToStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            System.out.print("Enter Course Code (e.g., CSE101): ");
            String course = scanner.nextLine();
            try {
                student.addCourse(course);
                System.out.println("Course assigned to student!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void assignCourseToInstructor() {
        System.out.print("Enter Instructor ID: ");
        String id = scanner.nextLine();
        Instructor instructor = findInstructorById(id);

        if (instructor != null) {
            System.out.print("Enter Course Code (e.g., CSE101): ");
            String course = scanner.nextLine();
            try {
                instructor.addCourse(course);
                System.out.println("Course assigned to instructor!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Instructor not found!");
        }
    }

    private static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("\nStudent List");
            for (Student s : studentList) {
                s.getDetails();
                System.out.println(" ");
            }
        }
    }


    private static void displayInstructors() {
        if (instructorList.isEmpty()) {
            System.out.println("No instructors in the system.");
        } else {
            System.out.println("\nInstructor List");
            for (Instructor i : instructorList) {
                i.getDetails();
                System.out.println(" ");
            }
        }
    }





    // Methods which allow to find by id student or instructor
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
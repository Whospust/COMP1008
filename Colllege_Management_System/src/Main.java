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
            System.out.println("4. Remove Course from Student");
            System.out.println("5. Remove All Courses from Student");
            System.out.println("6. Assign Course to Instructor");
            System.out.println("7. Remove Course from Instructor");
            System.out.println("8. Remove All Courses from Instructor");
            System.out.println("9. Display All Students");
            System.out.println("10. Display All Instructors");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addStudent(); break;
                case "2": addInstructor(); break;
                case "3": assignCourseToStudent(); break;
                case "4": removeCourseFromStudent(); break;
                case "5": removeAllCoursesFromStudent(); break;
                case "6": assignCourseToInstructor(); break;
                case "7": removeCourseFromInstructor(); break;
                case "8": removeAllCoursesFromInstructor(); break;
                case "9": displayStudents(); break;
                case "10": displayInstructors(); break;
                case "11":
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
    private static void removeCourseFromStudent() {
        Student student = findStudentById();
        if (student != null) {
            System.out.print("Enter Course Code to Remove: ");
            String course = scanner.nextLine();
            try {
                student.RemoveCourse(course);
                System.out.println("Course removed from student successfully!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }



    private static void assignCourseToStudent() {
        System.out.print("Enter Student ID: ");
        Student student = findStudentById();

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

    private static void removeCourseFromInstructor() {
        Instructor instructor = findInstructorById();
        if (instructor != null) {
            System.out.print("Enter Course Code to Remove: ");
            String course = scanner.nextLine();
            try {
                instructor.RemoveCourse(course);
                System.out.println("Course removed from instructor successfully!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void assignCourseToInstructor() {
        System.out.print("Enter Instructor ID: ");

        Instructor instructor = findInstructorById();

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

    private static void removeAllCoursesFromStudent() {
        Student student = findStudentById();
        if (student != null) {
            try {
                student.RemoveAllCourses();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void removeAllCoursesFromInstructor() {
        Instructor instructor = findInstructorById();
        if (instructor != null) {
            try {
                instructor.RemoveAllCourses();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
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
    private static Student findStudentById() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        for (Student s : studentList) {
            if (s.getId().equals(id)) return s;
        }
        System.out.println("Student not found!");
        return null;
    }

    private static Instructor findInstructorById() {
        System.out.print("Enter Instructor ID: ");
        String id = scanner.nextLine();
        for (Instructor i : instructorList) {
            if (i.getId().equals(id)) return i;
        }
        System.out.println("Instructor not found!");
        return null;
    }

}
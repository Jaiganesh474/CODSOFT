import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class Main {
    private static final String FILENAME = "students.txt";

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        try {
            List<Student> students = StudentDataReader.readStudentsFromFile(FILENAME);
            students.forEach(sms::addStudent);
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add a new student");
            System.out.println("2. Edit a student's information");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Remove a student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    addStudent(scanner, sms);
                    break;
                case 2:
                    editStudent(scanner, sms);
                    break;
                case 3:
                    searchStudent(scanner, sms);
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    removeStudent(scanner, sms);
                    break;
		case 6:
		    System.out.println("Student details updated and Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        // Validate input
        if (name.isEmpty() || grade.isEmpty() || email.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        Student student = new Student(name, rollNumber, grade, email);
        sms.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void editStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.print("Enter roll number of the student to edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Optional<Student> studentOpt = sms.searchStudent(rollNumber);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            System.out.print("Enter new name (or press Enter to keep " + student.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                student.setName(name);
            }
            System.out.print("Enter new grade (or press Enter to keep " + student.getGrade() + "): ");
            String grade = scanner.nextLine();
            if (!grade.isEmpty()) {
                student.setGrade(grade);
            }
            System.out.print("Enter new email (or press Enter to keep " + student.getEmail() + "): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                student.setEmail(email);
            }
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.print("Enter roll number to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Optional<Student> studentOpt = sms.searchStudent(rollNumber);
        if (studentOpt.isPresent()) {
            System.out.println(studentOpt.get());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.print("Enter roll number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        sms.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }
}

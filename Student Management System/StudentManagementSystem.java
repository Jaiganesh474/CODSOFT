import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Optional<Student> searchStudent(int rollNumber) {
        return students.stream().filter(student -> student.getRollNumber() == rollNumber).findFirst();
    }

    public void displayAllStudents() {
        students.forEach(System.out::println);
    }
}

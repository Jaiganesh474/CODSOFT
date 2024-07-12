import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentDataWriter {
    public static void writeStudentsToFile(List<Student> students, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade() + "," + student.getEmail() + "\n");
            }
        }
    }
}

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        Student student = searchStudent(id);

        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    public boolean updateStudent(int id, String newName, int newAge) {
        Student student = searchStudent(id);

        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            return true;
        }

        return false;
    }

    public void saveToFile() {

        try {
            FileWriter writer = new FileWriter("students.txt");

            for (Student student : students) {
                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getAge() + "\n");
            }

            writer.close();

            System.out.println("Data Saved!");

        } catch (IOException e) {
            System.out.println("Error Saving File");
        }
    }

    public void loadFromFile() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                students.add(new Student(id, name, age));
            }

            reader.close();

            System.out.println("Data Loaded!");

        } catch (IOException e) {

            System.out.println("No previous data found.");
        }
    }
    public int getStudentCount() {
        return students.size();
    }
}
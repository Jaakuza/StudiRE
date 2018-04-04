package persistence;

import business.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static List<Student> students = new ArrayList<>();

    public static List<Student> getStudents() {
        return students;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(Student student) {
        students.remove(student);
    }

}

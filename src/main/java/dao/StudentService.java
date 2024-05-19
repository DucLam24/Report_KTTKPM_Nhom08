package dao;

import java.util.List;

import entity.Course;
import entity.Student;

public interface StudentService {
//	void enrollStudentInCourse(Student student, Course course);
    void registerCourse(Student student, Course course);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    Student getStudentById(int studentId);
    List<Student> getAllStudents();
}

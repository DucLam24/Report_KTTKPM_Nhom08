package dao;

import java.util.List;

import entity.Course;

public interface CourseService {
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Long courseId);
    Course getCourseById(int courseId);
    List<Course> getAllCourses();
}

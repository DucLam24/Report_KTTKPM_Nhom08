package dao;

import java.util.List;

import entity.Course;
import entity.Department;

public interface DepartmentService {
	void addCourse(Course course);
    void addDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Long departmentId);
    Department getDepartmentById(int departmentId);
    List<Department> getAllDepartments();
}


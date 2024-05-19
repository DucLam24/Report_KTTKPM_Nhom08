package dao;

import java.util.List;

import entity.Enrollment;

public interface EnrollmentService {
    void addEnrollment(Enrollment enrollment);
    void updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(Long enrollmentId);
    Enrollment getEnrollmentById(Long enrollmentId);
    List<Enrollment> getAllEnrollments();
}


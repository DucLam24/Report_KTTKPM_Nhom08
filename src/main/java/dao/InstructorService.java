package dao;

import java.util.List;

import entity.Instructor;

public interface InstructorService {
    void addInstructor(Instructor instructor);
    void updateInstructor(Instructor instructor);
    void deleteInstructor(Long instructorId);
    Instructor getInstructorById(int instructorId);
    List<Instructor> getAllInstructors();
}

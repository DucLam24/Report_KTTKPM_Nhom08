package dao;

import java.util.List;

import entity.Semester;

public interface SemesterService {
    void addSemester(Semester semester);
    void updateSemester(Semester semester);
    void deleteSemester(Long semesterId);
    Semester getSemesterById(Long semesterId);
    List<Semester> getAllSemesters();
}


package dao.impls;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

import dao.SemesterService;
import entity.Semester;

public class SemesterServiceImpl implements SemesterService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLyLopHocTinChi_Server");

    @Override
    public void addSemester(Semester semester) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(semester);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateSemester(Semester semester) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(semester);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteSemester(Long semesterId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Semester semester = em.find(Semester.class, semesterId);
        if (semester != null) {
            em.remove(semester);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Semester getSemesterById(Long semesterId) {
        EntityManager em = emf.createEntityManager();
        Semester semester = em.find(Semester.class, semesterId);
        em.close();
        return semester;
    }

    @Override
    public List<Semester> getAllSemesters() {
        EntityManager em = emf.createEntityManager();
        List<Semester> semesters = em.createQuery("SELECT s FROM Semester s", Semester.class).getResultList();
        em.close();
        return semesters;
    }
}


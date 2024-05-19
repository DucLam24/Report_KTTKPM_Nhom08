package dao.impls;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

import dao.EnrollmentService;
import entity.Enrollment;

public class EnrollmentServiceImpl implements EnrollmentService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLyLopHocTinChi_Server");

    @Override
    public void addEnrollment(Enrollment enrollment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(enrollment);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(enrollment);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Enrollment enrollment = em.find(Enrollment.class, enrollmentId);
        if (enrollment != null) {
            em.remove(enrollment);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Enrollment getEnrollmentById(Long enrollmentId) {
        EntityManager em = emf.createEntityManager();
        Enrollment enrollment = em.find(Enrollment.class, enrollmentId);
        em.close();
        return enrollment;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        EntityManager em = emf.createEntityManager();
        List<Enrollment> enrollments = em.createQuery("SELECT e FROM Enrollment e", Enrollment.class).getResultList();
        em.close();
        return enrollments;
    }
}


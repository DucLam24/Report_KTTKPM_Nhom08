package dao.impls;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

import dao.InstructorService;
import entity.Instructor;

public class InstructorServiceImpl implements InstructorService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLyLopHocTinChi_Server");

    @Override
    public void addInstructor(Instructor instructor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(instructor);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(instructor);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteInstructor(Long instructorId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Instructor instructor = em.find(Instructor.class, instructorId);
        if (instructor != null) {
            em.remove(instructor);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Instructor getInstructorById(int instructorId) {
        EntityManager em = emf.createEntityManager();
        Instructor instructor = em.find(Instructor.class, instructorId);
        em.close();
        return instructor;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        EntityManager em = emf.createEntityManager();
        List<Instructor> instructors = em.createQuery("SELECT i FROM Instructor i", Instructor.class).getResultList();
        em.close();
        return instructors;
    }
}


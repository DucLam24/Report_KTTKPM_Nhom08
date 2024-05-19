package dao.impls;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

import dao.DepartmentService;
import entity.Course;
import entity.Department;

public class DepartmentServiceImpl implements DepartmentService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLyLopHocTinChi_Server");


    public void addDepartment(Department department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        em.close();
    }
    
    
    @Override
    public void addCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    public void updateDepartment(Department department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(department);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteDepartment(Long departmentId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Department department = em.find(Department.class, departmentId);
        if (department != null) {
            em.remove(department);
        }
        em.getTransaction().commit();
        em.close();
    }


    public Department getDepartmentById(int departmentId) {
        EntityManager em = emf.createEntityManager();
        Department department = em.find(Department.class, departmentId);
        em.close();
        return department;
    }


    public List<Department> getAllDepartments() {
        EntityManager em = emf.createEntityManager();
        List<Department> departments = em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        em.close();
        return departments;
    }
}


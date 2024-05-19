package dao.impls;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

import dao.StudentService;
import entity.Course;
import entity.Enrollment;
import entity.Student;

public class StudentServiceImpl implements StudentService {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLyLopHocTinChi_Server");

	
//	@Override
//    public void registerCourse(Student student, Course course) {
//        EntityTransaction transaction = null;
//        try {
//            transaction = EntityManager.getTransaction();
//            transaction.begin();
//
//            // Thêm sinh viên vào danh sách sinh viên đã đăng ký của môn học
//            Enrollment en = new Enrollment(student, course, null, null);
//            course.getEnrollments().add(en);
//            entityManager.merge(course);
//
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null && transaction.isActive()) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//}
	public StudentServiceImpl() {
		super();
	}
	 
	
	 @Override
	 public void registerCourse(Student student, Course course) {
			EntityManager em = emf.createEntityManager();
			
			try {
				em.getTransaction().begin();
	
	            // Thêm sinh viên vào danh sách sinh viên đã đăng ký của môn học
	            Enrollment en = new Enrollment(student, course, null, null);
	            course.getEnrollments().add(en);
	            em.merge(course);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            if (em.getTransaction() != null && em.getTransaction().isActive()) {
	            	em.getTransaction().rollback();
	            }
	            e.printStackTrace();
	        }
	 }
	

	@Override
	public void addStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void updateStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void deleteStudent(int studentId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, studentId);
		if (student != null) {
			em.remove(student);
		}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Student getStudentById(int studentId) {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, studentId);
		em.close();
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		EntityManager em = emf.createEntityManager();
		List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		em.close();
		return students;
	}
}

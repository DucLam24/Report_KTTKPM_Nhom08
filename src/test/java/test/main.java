package test;

import java.util.List;

import dao.CourseService;
import dao.DepartmentService;
import dao.InstructorService;
import dao.StudentService;
import dao.impls.CourseServiceImpl;
import dao.impls.DepartmentServiceImpl;
import dao.impls.InstructorServiceImpl;
import dao.impls.StudentServiceImpl;
import entity.Course;
import entity.Department;
import entity.Enrollment;
import entity.Instructor;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLyLopHocTinChi_Server");
		EntityManager em = emf.createEntityManager();
		CourseService courseDao = new CourseServiceImpl();
		StudentService stu =  new StudentServiceImpl();
		
		DepartmentService dep = new DepartmentServiceImpl();
		InstructorService ins = new InstructorServiceImpl();
//
			EntityTransaction tx = em.getTransaction();
			Student st = stu.getStudentById(1);
			Department deps = dep.getDepartmentById(1);
			Instructor instructor = ins.getInstructorById(1);
			Course course =  courseDao.getCourseById(5);
////			Course course = new Course();
//			Course co = new Course(null, null, 0, null, null);
//			Enrollment en = new Enrollment(st, co, null, null);
//			try {
//				tx.begin();				 
//				em.merge(course);
//				tx.commit();
//			}catch (Exception e) {
//				e.printStackTrace();
//				tx.rollback();
//			}
//			
//			System.out.println(co.getEnrollments());
			
	        try {
			tx.begin();	
//
          // Thêm sinh viên vào danh sách sinh viên đã đăng ký của môn học
          Enrollment en = new Enrollment(st, course, null, null);
          course.getEnrollments().add(en);
          em.merge(course);

         tx.commit();
      } catch (Exception e) {
//          if (transaction != null && transaction.isActive()) {
//              transaction.rollback();
//          }
          e.printStackTrace();
			tx.rollback();
      }
		
		
//		List<Student> stus = stu.getAllStudents();
//		
//		for (Student student : stus) {
//			
//			System.out.println(student.getName());
//		}
		
		

	}

}

package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Course;
import com.zsquared.hibernate.demo.entity.Instructor;
import com.zsquared.hibernate.demo.entity.InstructorDetail;
import com.zsquared.hibernate.demo.entity.Review;
import com.zsquared.hibernate.demo.entity.Student;

public class CreateCourseandStudentsDemo {
	


	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Instructor.class)
								  .addAnnotatedClass(InstructorDetail.class)
								  .addAnnotatedClass(Course.class)
								  .addAnnotatedClass(Review.class)
								  .addAnnotatedClass(Student.class)
								  .buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			
		
			
			// start a transaction
			session.beginTransaction();
			
		
			
			// Get student Mary from database
			int studentId = 1;
			Student student = session.get(Student.class, studentId);
			//System.out.println("\nLoaded Student : " +student);
			//System.out.println(" Course" +student.getCourses());
			
			//	add student to classes
			Course course1 = new Course("Philosophy of Religion");
			Course course2 = new Course("Algorithms");
			course1.addStudent(student);
			course2.addStudent(student);
			
			// save the courses
			session.save(course1);
			session.save(course2);
			
			
			Student student1 = new Student("John", "Deacon","jdeacon@queen.com");
			Student student2 = new Student("Steven", "Tyler","styler@aerosmith.com");
			
			course1.addStudent(student1);
			course1.addStudent(student2);
			course2.addStudent(student1);
			
			session.save(student1);
			session.save(student2);
			
			System.out.println("Students course1 :" +course1.getStudents());
			System.out.println("Students course2 :" +course2.getStudents());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} finally {
			factory.close();
		}

	}
}

package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Course;
import com.zsquared.hibernate.demo.entity.Instructor;
import com.zsquared.hibernate.demo.entity.InstructorDetail;
import com.zsquared.hibernate.demo.entity.Review;
import com.zsquared.hibernate.demo.entity.Student;

public class DeleteMaryStudentDemo {
	


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
			
			int studentId = 2;
			Student student = session.get(Student.class, studentId);
			
			//save the students
			System.out.println("\nLoading student" + student);
			System.out.println("Courses :" +student.getCourses());
			
			System.out.println("Deleting " +student);
			session.delete(student);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} finally {
			factory.close();
		}

	}
}

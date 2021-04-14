package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Course;
import com.zsquared.hibernate.demo.entity.Instructor;
import com.zsquared.hibernate.demo.entity.InstructorDetail;
import com.zsquared.hibernate.demo.entity.Review;
import com.zsquared.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {
	


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
			
			Course course = new Course("TOdays Computers");
			
			System.out.println("Saving the course");
			session.save(course);
			System.out.println("Saved course" +course);
			
			//create students
			Student student1 = new Student("John", "Doe","john@gmail.com");
			Student student2 = new Student("May", "Doe", "may@gmail.com");
			
			//add students to course
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save the students
			System.out.println("Saving students");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students :" +course.getStudents());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} finally {
			factory.close();
		}

	}
}

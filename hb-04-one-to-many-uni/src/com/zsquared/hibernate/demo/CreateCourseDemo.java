package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Course;
import com.zsquared.hibernate.demo.entity.Instructor;
import com.zsquared.hibernate.demo.entity.InstructorDetail;

public class CreateCourseDemo {
	


	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Instructor.class)
								  .addAnnotatedClass(InstructorDetail.class)
								  .addAnnotatedClass(Course.class)
								  .buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			
		
			
			// start a transaction
			session.beginTransaction();
			
			// get instructor from db
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			// create some courses
			Course tempCourse1 = new Course("Imporvising of Jazz chords");
			Course tempCourse2 = new Course("Classical Guitar principals");
			
			// add courses to instructor
			instructor.add(tempCourse1);
			instructor.add(tempCourse2);
			
			// save courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} finally {
			factory.close();
		}

	}
}

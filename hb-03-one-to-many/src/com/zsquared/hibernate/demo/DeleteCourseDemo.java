package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Course;
import com.zsquared.hibernate.demo.entity.Instructor;
import com.zsquared.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {
	


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
			
			// get a course
			int theId = 10;
			Course theCourse = session.get(Course.class, theId);	
		
			
			System.out.println("deleing Course : " +theCourse);
			
			session.delete(theCourse);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} finally {
			factory.close();
		}

	}
}

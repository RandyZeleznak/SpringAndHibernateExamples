package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Instructor;
import com.zsquared.hibernate.demo.entity.InstructorDetail;
import com.zsquared.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {
	


	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Instructor.class)
								  .addAnnotatedClass(InstructorDetail.class)
								  .buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			int theId = 30;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class , theId);
			
			System.out.println("Instructor Detail = " +instructorDetail);
			
			System.out.println("The associated Instructor = " +instructorDetail.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}
}

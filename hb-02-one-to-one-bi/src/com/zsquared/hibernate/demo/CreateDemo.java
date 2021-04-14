package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Instructor;
import com.zsquared.hibernate.demo.entity.InstructorDetail;
import com.zsquared.hibernate.demo.entity.Student;

public class CreateDemo {
	


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
			
			// create objects 
			Instructor instructor = new Instructor("Steve", "Morse" , "steve@deeppurple.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Playing Awsome Guitar");
			
			// associate objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor and Instructor Detail by cascade
			System.out.println("Saving Instructor -> "+ instructor);
			session.save(instructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} finally {
			factory.close();
		}

	}
}

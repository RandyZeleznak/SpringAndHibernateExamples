package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	


	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Student.class)
								  .buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			// create student object
			System.out.println("Creating new student object ..."); 
			Student student = new Student("Brian", "May", "bmay@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving student....");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} finally {
			factory.close();
		}

	}
}

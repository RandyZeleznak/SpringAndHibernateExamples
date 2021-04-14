package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	


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
			Student student = new Student("Jimmy", "Page", "jpage@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving student....");
			System.out.println(student);
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Saved student id "+student.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting  student id "+student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get complete student : " +myStudent);
			
			session.getTransaction().commit();
			
			
			
			
			System.out.println("Done!");
			

		} finally {
			factory.close();
		}

	}
}

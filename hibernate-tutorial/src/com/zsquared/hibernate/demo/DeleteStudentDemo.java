package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	


	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Student.class)
								  .buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			
			int studentId = 1;
			
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting  student id "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("updating student : " +myStudent);
			myStudent.setFirstName("Fred");
			
			session.getTransaction().commit();
			
			
			
			
			System.out.println("Done!");
			

		} finally {
			factory.close();
		}

	}
}

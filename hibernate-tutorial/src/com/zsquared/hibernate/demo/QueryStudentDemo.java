package com.zsquared.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	


	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Student.class)
								  .buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			// display results of query
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Page'").getResultList();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Page'"
					+ " OR s.firstName='Roger'").getResultList();
			System.out.println("Multi Query");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%gmail.com'").getResultList();
			System.out.println("LIKE Query");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}
}

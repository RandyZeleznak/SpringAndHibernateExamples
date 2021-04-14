package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					System.out.println("Creating 3 student object ..."); 
					Student student1 = new Student("Freddie", "Mercury", "fmercury@gmail.com");
					Student student2 = new Student("John", "Deacon", "jdeacon@gmail.com");
					Student student3 = new Student("Roger", "Taylor", "rtaylor@gmail.com");
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving student....");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Committed!");
					

				} finally {
					factory.close();
				}


	}

}

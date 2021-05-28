package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.zsquared.hibernate.demo.entity.Course;
import com.zsquared.hibernate.demo.entity.Instructor;
import com.zsquared.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCourseDemo {
	


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
			//Instructor instructor = session.get(Instructor.class, theId);
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:"
					+ "theInstructorId", 
					Instructor.class);
			
			query.setParameter("theInstructorId", theId);
			
			Instructor instructor = query.getSingleResult();
		
			System.out.println("Instructor = " +instructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			session.close();
			System.out.println("Courses : " +instructor.getCourses());
			

		} finally {
			factory.close();
		}

	}
}

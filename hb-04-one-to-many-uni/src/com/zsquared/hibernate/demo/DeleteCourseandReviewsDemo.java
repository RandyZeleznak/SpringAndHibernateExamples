package com.zsquared.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zsquared.hibernate.demo.entity.Course;
import com.zsquared.hibernate.demo.entity.Instructor;
import com.zsquared.hibernate.demo.entity.InstructorDetail;
import com.zsquared.hibernate.demo.entity.Review;

public class DeleteCourseandReviewsDemo {
	


	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Instructor.class)
								  .addAnnotatedClass(InstructorDetail.class)
								  .addAnnotatedClass(Course.class)
								  .addAnnotatedClass(Review.class)
								  .buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			
		
			
			// start a transaction
			session.beginTransaction();
			
			int theId = 2;
			Course course = session.get(Course.class, theId);
			
			System.out.println("The Course: "+course) ;
			System.out.println("The Rviews" +course.getReviews());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Committed!");
			

		} finally {
			factory.close();
		}

	}
}

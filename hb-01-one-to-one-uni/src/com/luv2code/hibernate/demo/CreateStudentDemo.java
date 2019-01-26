package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

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
			//use the session object to save java object
			System.out.println("Creating new student object...");
			
			//create a student object
			Student tempStudent = new Student("Gowtham","Guntoju","Gowtham.guntoju@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done! ");
			
		}
		finally {
			factory.close();
		}
	}

}

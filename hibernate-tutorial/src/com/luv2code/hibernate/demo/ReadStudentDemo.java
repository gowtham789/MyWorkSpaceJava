package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

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
			System.out.println("Creating new student object...");
			
			//create a student object
			Student tempStudent = new Student("Drake","Gigg","Drake.gigg@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving student object...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//MY NEW CODE
			
			//find out the student's id: Primary Key
			
			System.out.println("Saved student.Generated Id: "+tempStudent.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\n getting student with id :" +tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete: "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done! ");
			
		}
		finally {
			factory.close();
		}
	}

}

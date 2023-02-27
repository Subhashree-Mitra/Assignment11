package org.antwalk.Student;

import java.util.*;

//import org.antwalk.dao.BookDaoImpl;
//import org.antwalk.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDao std = (StudentDao) context.getBean("StudentDaoImpl");
		System.out.println("Adding records");
		std.create("Upasana", 32);
		std.create("Roshan", 21);
		
		System.out.println("Listing the Student");

		
		List<Student> student =std.listStudents();
		try {
			for (Student st1 : student) {
				System.out.println("id " + st1.getStid()); //
				System.out.println("Name " + st1.getName()); //
				System.out.println("age " + st1.getAge()); // } //
			}	
		}
		catch(Exception e)
		{
			System.out.println("Null error");
		}
       
	}

}

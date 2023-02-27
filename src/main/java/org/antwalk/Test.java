package org.antwalk;

import java.util.List;

//import org.antwalk.dao.BookDaoImpl;
//import org.antwalk.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDao emp = (EmployeeDao) context.getBean("employeeDaoImpl");
		System.out.println("Adding records");
		emp.create("Upasana", 32, 5000000L);

		System.out.println("Listing the Employee");

		
		List<Employee> employees = emp.listEmployees(); // for(Book book1:books) // { //
		for (Employee emp1 : employees) {
			System.out.println("id " + emp1.getEmpid()); //
			System.out.println("Salary " + emp1.getSalary()); //
			System.out.println("Name " + emp1.getName()); //
			System.out.println("age " + emp1.getAge()); // } //
		}
       
	}

}

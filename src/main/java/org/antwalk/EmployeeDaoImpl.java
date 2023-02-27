package org.antwalk;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Component
public class EmployeeDaoImpl implements EmployeeDao{
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObj;
	
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObj = jdbcTemplateObject;
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;// initializing connection
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age, Long salary) {		  
		try {
		 String SQL = "INSERT INTO Employee (name, age, salary) VALUES (?, ?, ?)";
		 jdbcTemplateObj.update(SQL, new Object[]{name, age, salary} );
		System.out.println("Created Record Name = " + name + " Age = " + age+ " Salary = " + salary);
		 // to simulate the exception.
		 //throw new RuntimeException("simulate Error condition") ;
		  } catch (DataAccessException e) {
		       System.out.println("Error in creating record, rolling back");
		       throw e;
		    }
		}
	 public Employee getEmployee(Integer empid) {
		  String SQL = "SELECT * FROM Employee WHERE empid = ?";
		  Employee employee = (Employee) jdbcTemplateObj.queryForObject(SQL, new Object[]{empid}, new EmployeeMapper());
		     return employee;
		 }
	 public List listEmployees() {
		  String SQL = "SELECT * FROM Employee";
		  List employees = (List) jdbcTemplateObj.query(SQL, new EmployeeMapper());
		     return null;
		 }
	 
	 public void delete(Integer empid) {
		  String SQL = "DELETE FROM Employee WHERE empid = ?";
		  jdbcTemplateObj.update(SQL, new Object[]{empid});
		  System.out.println("Deleted Record with EMPID = " + empid );
		 }
	 public void update(Integer empid, Integer age) {
		   String SQL = "UPDATE Employee SET age = ? WHERE empid = ?";
		   jdbcTemplateObj.update(SQL, new Object[]{age, empid});
		   System.out.println("Updated Record with EMPID = " + empid );
		 } 
}

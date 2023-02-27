package org.antwalk.Student;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class StudentDaoImpl implements StudentDao {
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObj;
	
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObj = jdbcTemplateObject;
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;// initializing connection
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	 public void delete(Integer stid) {
		  String SQL = "DELETE FROM Student WHERE stid = ?";
		  jdbcTemplateObj.update(SQL, new Object[]{stid});
		  System.out.println("Deleted Record with stid = " + stid );
		 }
	 public void update(Integer stid, Integer age) {
		   String SQL = "UPDATE Student SET age = ? WHERE stid = ?";
		   jdbcTemplateObj.update(SQL, new Object[]{age, stid});
		   System.out.println("Updated Record with stid = " + stid );
		 }

	public void create(String name, Integer age) {
		// TODO Auto-generated method stub
		try {
			 String SQL = "INSERT INTO Student (name, age) VALUES (?, ?)";
			 jdbcTemplateObj.update(SQL, new Object[]{name, age} );
			System.out.println("Created Record Name = " + name + " Age = " + age);
			 // to simulate the exception.
			 //throw new RuntimeException("simulate Error condition") ;
			  } catch (DataAccessException e) {
			       System.out.println("Error in creating record, rolling back");
			       throw e;
			    }
		
	}

	public Student getStudent(Integer stid) {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM Student WHERE stid = ?";
		  Student Student = (Student) jdbcTemplateObj.queryForObject(SQL, new Object[]{stid}, new StudentMapper());
		     return Student;
	}

	public List listStudents() {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM Student";
		  List Students = (List) this.jdbcTemplateObj.query(SQL, new StudentMapper());
		     return Students;
	} 
}

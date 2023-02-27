package org.antwalk.Student;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDao {
	public void setDataSource(DataSource ds);

	 void create(String name, Integer age);
	 
	 Student getStudent(Integer stid);
	 
	 List listStudents();
	 
	 void delete(Integer stid);
	 
	 void update(Integer stid, Integer age);

}

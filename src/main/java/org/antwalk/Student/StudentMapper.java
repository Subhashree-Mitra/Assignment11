package org.antwalk.Student;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper {  
	 public Student mapRow(ResultSet rs, int rowNum) throws SQLException {  
	  Student student = new Student();  
	  student.setStid(rs.getInt("stid"));  
	  student.setName(rs.getString("name"));  
	  student.setAge(rs.getInt("age"));   
	  return student;  
	 }  
}
package org.antwalk;

import java.util.List;

import javax.sql.DataSource;

public interface EmployeeDao {
	public void setDataSource(DataSource ds);

	 void create(String name, Integer age, Long salary);
	 
	 Employee getEmployee(Integer empid);
	 
	 List listEmployees();
	 
	 void delete(Integer empid);
	 
	 void update(Integer empid, Integer age);

}

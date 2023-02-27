package org.antwalk.Student;

public class Student {

	private int stid;
	 private String name;
	 private int age;
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(int stid, String name, int age) {
		super();
		this.stid = stid;
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [stid=" + stid + ", name=" + name + ", age=" + age + "]";
	}
	 
}

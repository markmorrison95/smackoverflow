package model;

public class Subject {
	private String name;
	private Teacher teacher;

	public Subject(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Teacher getTeacher() {
		return this.teacher;
	}
	
	public void setTeacher(Teacher newTeacher) {
		this.teacher = newTeacher;
	}
	
	public String toString() {
		return this.getName();
	}	
}

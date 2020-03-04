package model;

public class Subject {
	private String subjectName;
	private Teacher teacher;

	public Subject(String name) {
		this.subjectName = name;
	}
	
	public String getName() {
		return this.subjectName;
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

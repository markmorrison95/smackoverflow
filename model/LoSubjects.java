package model;

import java.util.ArrayList;

// List of Classes
public class LoSubjects {
	private ArrayList<Subject> subjects;
	
	public LoSubjects() {
		this.subjects = new ArrayList<Subject>();
	}
	
	public ArrayList<Subject> getSubjects() {
		return this.subjects;
	}
	
	public void addSubject(Subject c) {
		this.subjects.add(c);
	}
	
	public Subject find(String courseName) {
		for (Subject c : subjects) {
			if (c.getName().equals(courseName)) {
				return c;
			}
		}
		return null;
	}
	
	public void print() {
		for (Subject c : subjects) {
			System.out.println(c);
		}
	}

}

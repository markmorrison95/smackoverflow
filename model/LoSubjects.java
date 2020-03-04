package model;

import java.util.ArrayList;

// List of Classes
public class LoSubjects {
	private ArrayList<Subject> classes;
	
	public LoSubjects() {
		this.classes = new ArrayList<Subject>();
	}
	
	public ArrayList<Subject> getSubjects() {
		return this.classes;
	}
	
	public void addSubject(Subject c) {
		this.classes.add(c);
	}
	
	public Subject find(String courseName) {
		for (Subject c : classes) {
			if (c.getName().equals(courseName)) {
				return c;
			}
		}
		return null;
	}
	
	public void print() {
		for (Subject c : classes) {
			System.out.println(c);
		}
	}

}

package model;

public class Subject {
	private String subjectName;

	public Subject(String name) {
		/**
		 * just takes the subject name as a variable
		 */
		this.subjectName = name;
	}

	/**
	 * getters for variables
	 */
	public String getName() {
		return this.subjectName;
	}

	public String toString() {
		return this.getName();
	}	
}

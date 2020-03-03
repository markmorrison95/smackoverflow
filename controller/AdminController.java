import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import model.*;
import view.*;
import controller.*;


public class AdminController implements ActionListener {
	private AdminView view;
	private LoTeachers teachers;
	private LoCourses classes;
	private Map<Course, Teacher> pairedMap;
	private String teacherName;
	private String className;

	public AdminController(LoTeachers teachers, LoCourses classes) {
		this.teachers = teachers;
		this.classes = classes;
		this.view = new AdminView(this);
		pairedMap = new HashMap<Course, Teacher>();

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view.teacherList) {
			teacherName = (String) view.teacherList.getSelectedItem();
		} else if (e.getSource() == view.classList) {
			className = (String) view.classList.getSelectedItem();
		} else if (e.getSource() == view.assign) {
			updateMap(className, teacherName);
			view.updateMapDisplay();
		} else if (e.getSource() == view.send) {
			System.out.println("okay they're sent to training good job");
		} else if (e.getSource() == view.signOut) {
			System.out.println("sign em out");
		}
	}

	public LoTeachers getTeachers() {
		return this.teachers;
	}

	public LoCourses getClasses() {
		return this.classes;
	}

	// add teacher/class combo to hashmap
	public void updateMap(Course newClass, Teacher newTeacher) {
		pairedMap.put(newClass, newTeacher);

	}

	public void updateMap(String classString, String teacherString) {
		Course currentClass = null;
		Teacher currentTeacher = null;
		for (int i = 0; i < classes.getClasses().size(); i++) {
			if (classes.getClasses().get(i).getName().equals(classString)) {
				currentClass = classes.getClasses().get(i);
				break;
			}
		}
		
		for (int i = 0; i < teachers.getListOfTeachers().size(); i++) {
			if (teachers.getListOfTeachers().get(i).getName().equals(teacherString)) {
				currentTeacher = teachers.getListOfTeachers().get(i);
				break;
			}
		}

		pairedMap.put(currentClass, currentTeacher);
	}
	
	public Map<Course, Teacher> getMap() {
		return pairedMap;
	}



}

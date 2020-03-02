import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.LoClasses;
import model.LoTeachers;
import model.Teacher;
import model.Class;

public class AdminController implements ActionListener {
	private AdminView view;
	private LoTeachers teachers;
	private LoClasses classes;
	private Map<Class, Teacher> pairedMap;
	private String[] teacherNames, classNames;
	
	public AdminController(LoTeachers teachers, LoClasses classes) {
		this.view = new AdminView(this);
		this.teachers = teachers;
		this.classes = classes;
		pairedMap = new HashMap<Class, Teacher>();

	}
	
	public void actionPerformed(ActionEvent e) {
		String teacherName = null;
		String className = null;
		if (e.getSource() == view.teacherList) {
			teacherName = (String) view.teacherList.getSelectedItem();
		} else if (e.getSource() == view.classList) {
			className = (String) view.classList.getSelectedItem();
		} else if (e.getSource() == view.assign) {
			if (teacherName != null && className != null) {
				updateMap(className, teacherName);
				view.updateMapDisplay();
			}
		} else if (e.getSource() == view.send) {
			System.out.println("okay they're sent to training good job");
		} else if (e.getSource() == view.home) {
			System.out.println("take em to the home screen");
		}
		
	}
	
	// return teacher string array
	public String[] getTeacherNames() {
		System.out.println(teachers.getListOfTeachers());
		String[] names = new String[teachers.getListOfTeachers().size()];
		for (int i = 0; i < teachers.getListOfTeachers().size(); i++) {
			names[i] = teachers.getListOfTeachers().get(i).getName();
		}

		return names;
	}
	
	// return class string array
	public String[] getClassNames() {
		String[] classNames = new String[classes.getClasses().size()];
		for (int i = 0; i < classes.getClasses().size(); i++) {
			classNames[i] = classes.getClasses().get(i).getName();
		}
		
		return classNames;
	}
	
	
	// add teacher/class combo to hashmap
	public void updateMap(Class newClass, Teacher newTeacher) {
		pairedMap.put(newClass, newTeacher);
		
	}
	
	public void updateMap(String classString, String teacherString) {
		Class currentClass = null;
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
	
	public Map<Class, Teacher> getMap() {
		return pairedMap;
	}



}

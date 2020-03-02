import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.LoClasses;
import model.LoTeachers;
import model.Teacher;
import model.Class;

public class AdminView extends JFrame {
	JFrame frame;
	JPanel panel;
	JButton assign, send, signOut;
	JComboBox<String> teacherList, classList;
	JList mapDisplay;
	AdminController controller;
	LoTeachers teachers;
	LoClasses classes;
	
	
	public AdminView(AdminController controller) {
		this.controller = controller;
		teachers = controller.getTeachers();
		classes = controller.getClasses();
		frame = new JFrame("Administrator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		frame.setSize(500,200);
		
		layoutComponents();
		
	}
	
	public void layoutComponents() {
		JLabel title = new JLabel("Administrator");
		
		assign = new JButton("Assign Teacher");
		assign.addActionListener(controller);
		send = new JButton("Send List To PTT Director");
		send.addActionListener(controller);
		signOut = new JButton("Home");
		signOut.addActionListener(controller);
		
		
		teacherList = new JComboBox<String>();
		
		for (int i = 0; i < teachers.getListOfTeachers().size(); i++) {
			teacherList.addItem(teachers.getListOfTeachers().get(i).toString());
		}
		
		teacherList.addActionListener(controller);
		
		classList = new JComboBox<String>();
		
		for (int i = 0; i < classes.getClasses().size(); i++) {
			classList.addItem(classes.getClasses().get(i).toString());
		}
		
		classList.addActionListener(controller);
		
		mapDisplay = new JList();
		resetMapDisplay();
		
		panel.add(title);
		
		panel.add(teacherList);
		panel.add(classList);
		
		panel.add(assign);
		panel.add(send);
		panel.add(signOut);
		
		panel.add(mapDisplay);
		
	
		frame.add(panel);
		frame.setVisible(true);
	
		
	}
	
	public void updateMapDisplay() {
		String[] pairs = new String[controller.getMap().size()];
		Map<Class, Teacher> pairedMap = controller.getMap();
		int counter = 0;
		for (Map.Entry<Class, Teacher> entry : pairedMap.entrySet()) {
			Class matchedClass = entry.getKey();
			Teacher matchedTeacher = entry.getValue();
			pairs[counter] = matchedClass.getName() + " - " + matchedTeacher.getName();
			counter++;
		}
		
		mapDisplay.setListData(pairs);
		
	}
	
	public void resetMapDisplay() {
		String[] empty = new String[5];
		for (int i = 0; i < 5; i++) {
			empty[i] = "";
		}
		
		mapDisplay.setListData(empty);
		
	}


}

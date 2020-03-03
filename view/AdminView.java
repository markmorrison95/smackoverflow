package view;

import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import model.*;
import controller.*;


public class AdminView extends JFrame {
	JFrame frame;
	JPanel panel;
	JButton assign, send, signOut;
	JComboBox<String> teacherList, classList;
	JList<String> mapDisplay;
	AdminController controller;
	LoTeachers teachers;
	LoCourses classes;
	
	
	public AdminView() {
		frame = new JFrame("Administrator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		layoutComponents();
	}
	
	public void layoutComponents() {
		JLabel title = new JLabel("Administrator");		
		assign = new JButton("Assign Teacher");
		send = new JButton("Send List To PTT Director");
		signOut = new JButton("Home");
		teacherList = new JComboBox<String>();
		classList = new JComboBox<String>();		
		mapDisplay = new JList<String>();
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
		frame.pack();
	
		
	}
	
	public void resetMapDisplay() {
		String[] empty = new String[5];
		for (int i = 0; i < 5; i++) {
			empty[i] = "";
		}
		
		mapDisplay.setListData(empty);
		
	}
	public JButton getAssignButton(){
		return assign;
	}
	public JButton getSendButton(){
		return send;
	}
	public JButton getSignOutButton(){
		return signOut;
	}
	public JComboBox<String> getTeacherList(){
		return teacherList;
	}
	public JComboBox<String> getClassList(){
		return classList;
	}
	public JList<String> getMapDisplay(){
		return mapDisplay;
	}
	


}

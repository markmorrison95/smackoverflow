package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.*;


public class AdminView extends JFrame {
	JPanel panel, titlePanel, selectionPanel, buttonPanel, infoPanel, rightPanel;
	JButton assign, send, signOut;
	JComboBox<String> teacherList, classList;
	JList<String> mapDisplay;
	LoTeachers teachers;
	LoCourses classes;
	
	
	public AdminView() {
		this.setTitle("Administrator");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(3, 1));
		
		titlePanel = new JPanel();
		selectionPanel = new JPanel();
		buttonPanel = new JPanel();
		infoPanel = new JPanel();

		selectionPanel.setLayout(new GridLayout(1,2));
		buttonPanel.setLayout(new GridLayout(3, 1));
		
		JLabel title = new JLabel("Administrator");	
		title.setFont(new Font("Arial", Font.BOLD, 30));	
		
		assign = new JButton("Assign Teacher");
		assign.setFont(new Font("Arial", Font.PLAIN, 18));
		send = new JButton("Assign Teachers to Training Courses");
		send.setFont(new Font("Arial", Font.PLAIN, 18));
		signOut = new JButton("Sign Out");
		signOut.setFont(new Font("Arial", Font.PLAIN, 18));
		
		teacherList = new JComboBox<String>();
		classList = new JComboBox<String>();	
		
		mapDisplay = new JList<String>();
		resetMapDisplay();
		
		titlePanel.add(title);
		selectionPanel.add(teacherList);
		selectionPanel.add(classList);
		buttonPanel.add(assign);
		buttonPanel.add(send);
		buttonPanel.add(signOut);
		
		infoPanel.add(mapDisplay);
		
		rightPanel.add(titlePanel);
		rightPanel.add(selectionPanel);
		rightPanel.add(buttonPanel);
		
		panel.add(rightPanel);
		panel.add(infoPanel);
		
		
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	
		
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

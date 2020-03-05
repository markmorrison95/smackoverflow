package view;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.*;

// The Administrator Window
public class AdminView extends JFrame {
	JPanel panel, titlePanel, selectionPanel, buttonPanel, infoPanel, rightPanel;
	JButton assign, send, signOut;
	JLabel messageCenter;
	JComboBox<String> teacherList, subjectList;
	JList<String> mapDisplay;
	LoTeachers teachers;
	LoSubjects subjects;
	
	
	public AdminView() {
		this.setTitle("Administrator");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		/**
		 * The right panel contains the title, the message center, the combo boxes, and the buttons
		 */
		 rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(3, 1));
		
		titlePanel = new JPanel();
		selectionPanel = new JPanel();
		buttonPanel = new JPanel();
		/**
		 * The info panel contains the JList of matched classes and teachers
		 */
		infoPanel = new JPanel();

		selectionPanel.setLayout(new GridLayout(1,2));
		buttonPanel.setLayout(new GridLayout(3, 1));
		
		JLabel title = new JLabel("Administrator");	
		title.setFont(new Font("Arial", Font.BOLD, 30));
		/**
		 * The message center is empty until the teachers are added to training courses
		 */
		messageCenter = new JLabel("");
		messageCenter.setFont(new Font("Arial", Font.PLAIN, 11));
		/**
		 * The assign button matches the teacher to a class and displays the pair on the JList
		 */
		assign = new JButton("Match Teacher to Class");
		assign.setFont(new Font("Arial", Font.PLAIN, 18));
		/**
		 * The send button assigns the currently selected teachers to appropriate training courses
		 */
		send = new JButton("Assign Selected Teachers to Training Courses");
		send.setFont(new Font("Arial", Font.PLAIN, 18));
		/**
		 * The sign out button closes the administrator window and returns the user to the home screen
		 */
		signOut = new JButton("Sign Out");
		signOut.setFont(new Font("Arial", Font.PLAIN, 18));
		/**
		 * The user selects a teacher and class from each of these boxes before pressing the assign button
		 */
		teacherList = new JComboBox<String>();
		subjectList = new JComboBox<String>();	
		mapDisplay = new JList<String>();
		resetMapDisplay();
		/**
		 * adding all components to appropriate panel
		 */
		titlePanel.add(title);
		titlePanel.add(messageCenter);
		selectionPanel.add(teacherList);
		selectionPanel.add(subjectList);
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
		/**
		 * Empties the JList of paired teachers/classes
		 */
		String[] empty = new String[5];
		for (int i = 0; i < 5; i++) {
			empty[i] = "";
		}
		
		mapDisplay.setListData(empty);
		
	}
	
	/**
	 * getters to allow access from controller
	 */
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
		return subjectList;
	}
	public JList<String> getMapDisplay(){
		return mapDisplay;
	}
	public JLabel getMessageCenter(){
		return messageCenter;
	}
	


}

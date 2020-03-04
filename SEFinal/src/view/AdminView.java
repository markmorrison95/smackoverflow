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
import controller.*;


public class AdminView extends JFrame {
	JFrame frame;
	JPanel panel;
	JButton assign, send, signOut;
	JComboBox<String> teacherList, classList;
	JList<String> mapDisplay;
	LoTeachers teachers;
	LoCourses classes;
	
	
	public AdminView() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		JLabel title = new JLabel("Administrator");	
		title.setFont(new Font("Arial", Font.PLAIN, 20));	
		assign = new JButton("Assign Teacher");
		assign.setFont(new Font("Arial", Font.PLAIN, 18));
		send = new JButton("Send List To PTT Director");
		send.setFont(new Font("Arial", Font.PLAIN, 18));
		signOut = new JButton("Home");
		signOut.setFont(new Font("Arial", Font.PLAIN, 18));
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
		this.add(panel);
		this.setVisible(true);
		this.pack();
		
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
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
	JButton assign, send, home;
	JComboBox<String> teacherList, classList;
	JList mapDisplay;
	AdminController controller;
	
	
	public AdminView(AdminController controller) {
		this.controller = controller;
		frame = new JFrame("Administrator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		frame.setSize(500,200);
		frame.setVisible(true);
		
		layoutComponents();
		
	}
	
	public void layoutComponents() {
		JLabel title = new JLabel("Administrator");
		
		assign = new JButton("Assign Teacher");
		assign.addActionListener(controller);
		send = new JButton("Send List To PTT Director");
		send.addActionListener(controller);
		home = new JButton("Home");
		home.addActionListener(controller);
		
		teacherList = new JComboBox<String>(controller.getTeacherNames());
		teacherList.addActionListener(controller);
		classList = new JComboBox<String>(controller.getClassNames());
		classList.addActionListener(controller);
		
		mapDisplay = new JList();
		resetMapDisplay();
		
		panel.add(title);
		
		panel.add(teacherList);
		panel.add(classList);
		
		panel.add(assign);
		panel.add(send);
		panel.add(home);
		
		panel.add(mapDisplay);
		
	
		frame.add(panel);
	
		
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

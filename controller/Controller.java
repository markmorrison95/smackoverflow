package controller;

import view.*;
import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class Controller implements ActionListener {
    private JButton signInButton, cdSignOutButton, cdAddClassButton, adAssignButton, adSendButton, adSignOutButton;
    private JTextField homeIdTextField, cdIdTextField;
    private JComboBox<String> adTeacherList, adClassList;
    private JList<String> adMapDisplay;
    private AssigningList assigningList;
    private JLabel cdUpdateLabel;
    private HomeWindow homeWindow;
    private ClassDirectorWindow cdWindow;
    private LoCourses lCourses;
    private LoTeachers lTeachers;
    private Course assignedCourse;
    private LoTrainingCourses lTrainingCourses;
    private AdminView adminWindow;

    public Controller() {
        /**
         * creates list of courses instance opens home window and adds event to the sign
         * in button
         */
        lCourses = new LoCourses();
        lTeachers = new LoTeachers();
        lTrainingCourses = new LoTrainingCourses();
        assigningList = new AssigningList();
        try {
            readFileIn("PermanentInfo.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lTeachers.printTeacher();
        lTrainingCourses.printTcourses();
        homeWindow = new HomeWindow();
        signInButton = homeWindow.getSignInButton();
        signInButton.addActionListener(this);
        homeIdTextField = homeWindow.getIdText();
    }

    public void signIn(String idNo) {
        /**
         * takes the info in the text field when sign in pressed parses to int so can be
         * used if begins in a certain value directs to the right method and therefore
         * window if not valid id no, displays message
         */
        int idNumber = (Integer.parseInt(idNo)) / 100;
        if (idNumber == 1) {
            classDirector();
        }
        if (idNumber == 2) {
            admin();
        }
        if (idNumber == 3) {
            pttDirector();
        } else {
            homeWindow.getUpdateLabel().setText("Invalid ID Number! Enter Valid ID.");
        }
    }

    public void signOut(JFrame window) {
        /**
         * for when the sign out button is pressed by the class director ensures there
         * is no invalid ID message on home window closes CD window and repopulates the
         * prompt in the text field on home
         */
        homeWindow.getUpdateLabel().setText("");
        window.dispose();
        homeIdTextField.setText("Enter ID number here (eg. 232)");
    }

    public void classDirector() {
        /**
         * opens the class director window and adds actions to the buttons initiates
         * local accessibility for certain variables
         */
        cdWindow = new ClassDirectorWindow();
        cdAddClassButton = cdWindow.getAddClassButton();
        cdAddClassButton.addActionListener(this);
        cdSignOutButton = cdWindow.getSignOutButton();
        cdSignOutButton.addActionListener(this);
        cdIdTextField = cdWindow.getClassIDText();
        cdUpdateLabel = cdWindow.getUpdateLabel();
    }

    public void admin() {
        adminWindow = new AdminView();
        adAssignButton = adminWindow.getAssignButton();
        adAssignButton.addActionListener(this);
        adSendButton = adminWindow.getSendButton();
        adSendButton.addActionListener(this);
        adSignOutButton = adminWindow.getSignOutButton();
        adSignOutButton.addActionListener(this);
        adTeacherList = adminWindow.getTeacherList();
        for (int i = 0; i < lTeachers.getListOfTeachers().size(); i++) {
			adTeacherList.addItem(lTeachers.getListOfTeachers().get(i).toString());
        }
        adTeacherList.addActionListener(this);
        adClassList = adminWindow.getClassList();
        for (int i = 0; i < lCourses.getClasses().size(); i++) {
			adClassList.addItem(lCourses.getClasses().get(i).toString());
        }
        adClassList.addActionListener(this);
    }

    public void pttDirector() {
        // add pttDirector window code
    }

    public void addClass(String courseName) {
        /**
         * creates a course based on the name passed then adds this to the list of
         * courses repopulates the textField with class id prompt
         */
        lCourses.addCourse(new Course(courseName));
        cdUpdateLabel.setText("Course: " + courseName + " Added!");
        cdIdTextField.setText("Enter Class ID. (eg. MATH201)");
    }

    public void actionPerformed(ActionEvent e) {
        /**
         * handles all button actions and directs to the right method
         */
        if (e.getSource() == signInButton) {
            signIn(homeIdTextField.getText());
        }
        if (e.getSource() == cdAddClassButton) {
            addClass(cdIdTextField.getText());
        }
        if (e.getSource() == cdSignOutButton) {
            signOut(cdWindow);
        }
        if (e.getSource() == adAssignButton) {
			updateMap((String) adClassList.getSelectedItem(),(String) adTeacherList.getSelectedItem());
			updateMapDisplay();
        }
        if (e.getSource() == adSendButton) {
            //add method for sending to training course
			System.out.println("okay they're sent to training good job");
        }
        if (e.getSource() == adSignOutButton) {
            signOut(adminWindow);
		}
    }
    
    public void updateMap(String classString, String teacherString) {
		Course currentClass = null;
		Teacher currentTeacher = null;
		for (int i = 0; i < lCourses.getClasses().size(); i++) {
			if (lCourses.getClasses().get(i).getName().equals(classString)) {
				currentClass = lCourses.getClasses().get(i);
				break;
			}
		}
		
		for (int i = 0; i < lTeachers.getListOfTeachers().size(); i++) {
			if (lTeachers.getListOfTeachers().get(i).getName().equals(teacherString)) {
				currentTeacher = lTeachers.getListOfTeachers().get(i);
				break;
			}
		}

		assigningList.getAssigningList().put(currentClass, currentTeacher);
    }
    public void updateMapDisplay() {
        adMapDisplay = adminWindow.getMapDisplay();
		String[] pairs = new String[assigningList.getAssigningList().size()];
		int counter = 0;
		for (Map.Entry<Course, Teacher> entry : assigningList.getAssigningList().entrySet()) {
			Course matchedClass = entry.getKey();
			Teacher matchedTeacher = entry.getValue();
			pairs[counter] = matchedClass.getName() + " - " + matchedTeacher.getName();
			counter++;
		}
		
		adMapDisplay.setListData(pairs);
		
	}


    public void readFileIn(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        boolean finishedTeachers = false;
        String nextString;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            if (!finishedTeachers) {
                nextString = scanner.next();
                if (nextString.matches(".*\\d.*")) {
                    nextString = scanner.next();
                }
                if (nextString.contains("TrainingCourses")) {
                    scanner.nextLine();
                    finishedTeachers = true;
                } else {
                    lTeachers.addTeacher(new Teacher(nextString));
                }
            }
            if (finishedTeachers) {
                lTrainingCourses.addCourse(new TrainingCourse(scanner.next(), scanner.next()));
            }
        }

    }


    /* 
    * 
    */
    public void writeToFile() throws IOException {
        File file = new File("TeachersClasses.txt");
        FileOutputStream fileOut = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOut));
        for(Teacher teacher : lTeachers.getListOfTeachers()){
            //assignedCourse = hasmap.get(teacher);
            bw.write(teacher + " " + assignedCourse);
            bw.newLine();
        }
        bw.write("TrainingCourse");
        bw.newLine();
        for(TrainingCourse tc : lTrainingCourses.getListOfTC()){
            bw.write(tc.getCourseName() + " " + tc.getSubjectName());
            bw.newLine();
        }
        bw.close();
    }
}
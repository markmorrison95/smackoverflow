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

public class Controller implements ActionListener {
    private JButton cdSignOutButton, cdAddClassButton, adAssignButton, adSendButton, adSignOutButton,
            homeAdminButton, homeCDButton, homePttButton, pttApproveButton, pttDisapproveButton;
    private JComboBox<String> adTeacherList, adClassList, cdClassList;
    private JList<String> adMapDisplay;
    private AssigningList assigningList;
    private JLabel cdUpdateLabel;
    private HomeWindow homeWindow;
    private ClassDirectorWindow cdWindow;
    private LoCourses lCourses, lAllCourses;
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
        lAllCourses = new LoCourses();
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
        homeCDButton = homeWindow.getCourseDirectorButton();
        homeCDButton.addActionListener(this);
        homeAdminButton = homeWindow.getAdminButton();
        homeAdminButton.addActionListener(this);
        homePttButton = homeWindow.getPttDirectorButton();
        homePttButton.addActionListener(this);
    }

    public void signOut(JFrame window) {
        /**
         * for when the sign out button is pressed by the class director ensures there
         * is no invalid ID message on home window closes CD window and repopulates the
         * prompt in the text field on home
         */
        window.dispose();
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
        cdClassList = cdWindow.getClassListBox();
        for (int i = 0; i < lAllCourses.getClasses().size(); i++) {
			cdClassList.addItem(lAllCourses.getClasses().get(i).getName());
        }
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
        adTeacherList.setSelectedIndex(0);
        adClassList = adminWindow.getClassList();
        for (int i = 0; i < lCourses.getClasses().size(); i++) {
            adClassList.addItem(lCourses.getClasses().get(i).toString());
        }
        adClassList.setSelectedIndex(0);
    }

    public void pttDirector() {
        PTTDirectorWindow pttWindow = new PTTDirectorWindow();
        pttApproveButton = pttWindow.getApproveButton();
        pttApproveButton.addActionListener(this);
        pttDisapproveButton = pttWindow.getDisapproveButton();
        pttDisapproveButton.addActionListener(this);
    }

    public void addClass(String courseName) {
        /**
         * creates a course based on the name passed then adds this to the list of
         * courses repopulates the textField with class id prompt
         */
        lCourses.addCourse(new Course(courseName));
        cdUpdateLabel.setText("Course: " + courseName + " Added!");
    }

    public void actionPerformed(ActionEvent e) {
        /**
         * handles all button actions and directs to the right method
         */
        if (e.getSource() == homeCDButton) {
            classDirector();
        }
        if (e.getSource() == homeAdminButton) {
            admin();
        }
        if (e.getSource() == homePttButton) {
            pttDirector();
        }
        if (e.getSource() == cdAddClassButton) {
            addClass((String)cdClassList.getSelectedItem());
        }
        if (e.getSource() == cdSignOutButton) {
            signOut(cdWindow);
        }
        if (e.getSource() == adAssignButton) {
            updateMap((String) adClassList.getSelectedItem(), (String) adTeacherList.getSelectedItem());
            updateMapDisplay();
        }
        if (e.getSource() == adSendButton) {
            // add method for sending to training course
            assignTeacherTC();
            System.out.println("okay they're sent to training good job");
        }
        if (e.getSource() == adSignOutButton) {
            signOut(adminWindow);
        }
        if(e.getSource() == pttApproveButton){

        }
        if(e.getSource() == pttDisapproveButton){
            
        }
    }

    public void assignTeacherTC(){
        Course course = null;
        Teacher teacher = null;
        for (Map.Entry<Course, Teacher> entry : assigningList.getAssigningList().entrySet()) {
            course = entry.getKey();
            teacher = entry.getValue();
            System.out.print(course.toString() + " " + teacher.toString());
            for (int i=0; i < lTrainingCourses.getListOfTC().size(); i++) {
                /**
                 * wasn't initializing tCourse to equal the training course it had reached in the list
                 * changed it so that gets set each loop and is just a method variable because only
                 * being used here
                 */
                TrainingCourse tCourse = lTrainingCourses.getListOfTC().get(i);
                if (course.getName().equals(tCourse.getSubjectName())){
                    tCourse.setTeacher(teacher);
                    System.out.println(tCourse.getTeacher().toString());
                }
            }
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
                String tc = scanner.next();
                String subject = scanner.next();
                lTrainingCourses.addCourse(new TrainingCourse(tc, subject));
                lAllCourses.addCourse(new Course(subject));
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
        for (Teacher teacher : lTeachers.getListOfTeachers()) {
            // assignedCourse = hasmap.get(teacher);
            bw.write(teacher + " " + assignedCourse);
            bw.newLine();
        }
        bw.write("TrainingCourse");
        bw.newLine();
        for (TrainingCourse tc : lTrainingCourses.getListOfTC()) {
            bw.write(tc.getCourseName() + " " + tc.getSubjectName());
            bw.newLine();
        }
        bw.close();
    }
}

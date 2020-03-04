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
    private JButton cdSignOutButton, cdAddClassButton, adAssignButton, adSendButton, adSignOutButton, homeAdminButton,
            homeCDButton, homePttButton, pttApproveButton, pttDisapproveButton;
    private JComboBox<String> adTeacherList, adClassList, cdClassList;
    private JList<String> adMapDisplay, pttTeacherCourseList;
    private AssigningList assigningList;
    private JLabel cdUpdateLabel;
    private HomeWindow homeWindow;
    private ClassDirectorWindow cdWindow;
    PTTDirectorWindow pttWindow;
    private LoSubjects lSubjects, lAllSubjects;
    private LoTeachers lTeachers;
    private Subject assignedCourse;
    private ApprovedList approvedList;
    private LoTrainingCourses lTrainingCourses;
    private AdminView adminWindow;
    private CellRenderer cellRenderer;

    public Controller() {
        /**
         * creates list of courses instance opens home window and adds event to the sign
         * in button
         */
        approvedList = new ApprovedList();
        lSubjects = new LoSubjects();
        lTeachers = new LoTeachers();
        lAllSubjects = new LoSubjects();
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
        for (int i = 0; i < lAllSubjects.getSubjects().size(); i++) {
            cdClassList.addItem(lAllSubjects.getSubjects().get(i).getName());
        }
        cdUpdateLabel = cdWindow.getUpdateLabel();
    }

    public void admin() {
        /**
         * opens the admin window and adds actions to the buttons initiates local
         * accessibility for certain variables
         */
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
        for (int i = 0; i < lSubjects.getSubjects().size(); i++) {
            adClassList.addItem(lSubjects.getSubjects().get(i).toString());
        }
        adClassList.setSelectedIndex(0);
    }

    public void pttDirector() {
        /**
         * opens the ptt director window and adds actions to the buttons initiates local
         * accessibility for certain variables
         */
        pttWindow = new PTTDirectorWindow();
        pttTeacherCourseList = pttWindow.getList();
        pttTeacherCourseList.setListData(assigningList.stringArray());
        pttApproveButton = pttWindow.getApproveButton();
        pttApproveButton.addActionListener(this);
        pttDisapproveButton = pttWindow.getDisapproveButton();
        pttDisapproveButton.addActionListener(this);
        
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
            addClass((String) cdClassList.getSelectedItem());
        }
        if (e.getSource() == cdSignOutButton) {
            signOut(cdWindow);
        }
        if (e.getSource() == adAssignButton) {
            updateMap((String) adClassList.getSelectedItem(), (String) adTeacherList.getSelectedItem());
            updateMapDisplay();
        }
        if (e.getSource() == adSendButton) {
            assignTeacherTC();
            adminWindow.getMessageCenter().setText("All teachers have been added to the appropriate training course.");
        }
        if (e.getSource() == adSignOutButton) {
            signOut(adminWindow);
        }

        if (e.getSource() == pttApproveButton) {
            int index = pttTeacherCourseList.getSelectedIndex();
            String[] teacherPairings = assigningList.stringArray();
            teacherPairings[index] = teacherPairings[index] + " \u2714";
            approvedList.getQualifiedTeacher().add(teacherPairings[index]);
            pttTeacherCourseList.setSelectedIndex(index);
            pttTeacherCourseList.setCellRenderer(new CellRenderer(cellRenderer));
            System.out.println(teacherPairings[0]);

        }

        if (e.getSource() == pttDisapproveButton) {

            int index = pttTeacherCourseList.getSelectedIndex();
            pttTeacherCourseList.setSelectedIndex(index);
            pttTeacherCourseList.setCellRenderer(new CellRenderer(cellRenderer));

        }
    }

    public void addClass(String courseName) {
        /**
         * creates a course based on the name passed then adds this to the list of
         * courses repopulates the textField with class id prompt
         */
        lSubjects.addSubject(new Subject(courseName));
        cdUpdateLabel.setText("Course: " + courseName + " Added!");
    }

    public void assignTeacherTC() {
        Subject course = null;
        Teacher teacher = null;
        for (Map.Entry<Subject, Teacher> entry : assigningList.getAssigningList().entrySet()) {
            course = entry.getKey();
            teacher = entry.getValue();
            System.out.print(course.toString() + " " + teacher.toString());
            for (int i = 0; i < lTrainingCourses.getListOfTC().size(); i++) {
                /**
                 * wasn't initializing tCourse to equal the training course it had reached in
                 * the list changed it so that gets set each loop and is just a method variable
                 * because only being used here
                 */
                TrainingCourse tCourse = lTrainingCourses.getListOfTC().get(i);
                if (course.getName().equals(tCourse.getSubjectName())) {
                    tCourse.setTeacher(teacher);
                    System.out.println(tCourse.getTeacher().toString());
                }
            }
        }
    }

    public void updateMap(String classString, String teacherString) {
        Subject currentClass = null;
        Teacher currentTeacher = null;
        for (int i = 0; i < lSubjects.getSubjects().size(); i++) {
            if (lSubjects.getSubjects().get(i).getName().equals(classString)) {
                currentClass = lSubjects.getSubjects().get(i);
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
        for (Map.Entry<Subject, Teacher> entry : assigningList.getAssigningList().entrySet()) {
            Subject matchedClass = entry.getKey();
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
                lAllSubjects.addSubject(new Subject(subject));
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

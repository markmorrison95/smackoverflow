package view;// Chris Castaldo
// 2495856C

import model.AssigningList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PTTDirectorWindow extends JFrame {

    private JList<String> list1;
    private JLabel TopString;
    private JLabel TopString2;
    private JLabel CoursesString;
    private JButton approveButton;
    private JButton disapproveButton;
    private JButton signOut;
    private String[] array;
    AssigningList list;

    public PTTDirectorWindow() {
        list1 = new JList<>();
        TopString = new JLabel("All Teachers Are Being Trained For Assigned Courses");
        TopString2 = new JLabel("Please Approve or Disapprove");
        CoursesString = new JLabel("Teacher : Course");
        approveButton = new JButton("Approve");
        disapproveButton = new JButton("Disapprove");
        signOut = new JButton("Sign Out");
        list = new AssigningList();
        TopString.setBounds(15, 20, 1000, 35);
        TopString.setFont(new Font("Arial", Font.PLAIN, 14));

        TopString2.setBounds(15, 40, 1000, 35);
        TopString2.setFont(new Font("Arial", Font.PLAIN, 14));

        CoursesString.setBounds(20, 100, 300, 35);
        CoursesString.setFont(new Font("Arial", Font.PLAIN, 14));

        approveButton.setBounds(350, 140, 100, 35);

        disapproveButton.setBounds(350, 180, 100, 35);
        signOut.setBounds(350, 220, 100, 35);

        // signOut.addActionListener(new ActionListener() {

        //         @Override
        //         public void actionPerformed(ActionEvent arg0) {
        //             dispose();

        //         }

        // });

        list.getAssigningList();
        array = list.stringArray();
        list1.setListData(array);

        list1.setBounds(15, 140, 300, 120);  // Positions the slots within the JFrame

        this.setResizable(true);
        this.setSize(500, 330);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        panel.add(TopString);
        panel.add(TopString2);
        panel.add(CoursesString);
        panel.add(signOut);
        panel.add(approveButton);
        panel.add(disapproveButton);
        panel.add(list1);
        this.pack();
        this.setVisible(true);
    }

    public JButton getSignOut() {
        return signOut;
    }

    public JButton getApproveButton() { return this.approveButton; }

    public JButton getDisapproveButton() { return this.disapproveButton; }

    public JList<String> getList() { return list1; }

    public String[] getArray() {
        return array;
    }
}

package view;// Chris Castaldo
// 2495856C

import model.AssigningList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PTTDirectorWindow extends JFrame {

    private JList list1 = new JList();
    private JLabel TopString = new JLabel("All Teachers Are Being Trained For Assigned Courses");
    private JLabel TopString2 = new JLabel("Please Approve or Disapprove");
    private JLabel CoursesString = new JLabel("Teacher : Course");
    private JButton approveButton = new JButton("Approve");
    private JButton disapproveButton = new JButton("Disapprove");
    private JButton signOut = new JButton("Sign Out");
    private String[] array;
    AssigningList list = new AssigningList();

    public PTTDirectorWindow() {

        TopString.setBounds(15, 20, 1000, 35);
        TopString.setFont(new Font("Arial", Font.PLAIN, 14));

        TopString2.setBounds(15, 40, 1000, 35);
        TopString2.setFont(new Font("Arial", Font.PLAIN, 14));

        CoursesString.setBounds(20, 100, 300, 35);
        CoursesString.setFont(new Font("Arial", Font.PLAIN, 14));

        approveButton.setBounds(350, 140, 100, 35);

        approveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

            }

            });

        disapproveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

            }

        });

        disapproveButton.setBounds(350, 180, 100, 35);
        signOut.setBounds(350, 220, 100, 35);

        signOut.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    dispose();

                }

        });

        list.getAssigningList();
        array = list.stringArray();
        list1.setListData(array);

        list1.setBounds(15, 140, 300, 120);  // Positions the slots within the JFrame

        this.setVisible(true);
        this.setResizable(true);
        this.setSize(500, 330);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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

    }

    public JButton getsignOut() { return this.signOut; }

    public JButton getApproveButton() { return approveButton; }

    public JButton getDisapproveButton() { return disapproveButton; }

    public JList getList() { return list1; }

    public String[] getArray() {
        return array;
    }
}

package view;


import javax.swing.*;

import java.awt.*;

public class PTTDirectorWindow extends JFrame {

    private JList<String> pairedList;
    private JLabel topString, topString2, coursesString;
    private JButton approveButton, disapproveButton, signOut;
    private String[] array;

    public PTTDirectorWindow() {
        this.setTitle("PTT Director");
        this.setResizable(true);
        this.setSize(500, 330);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pairedList = new JList<>();
        topString = new JLabel("All Teachers Are Being Trained For Assigned Courses");
        topString2 = new JLabel("Please Approve or Disapprove");
        coursesString = new JLabel("Teacher : Course");
        approveButton = new JButton("Approve");
        disapproveButton = new JButton("Disapprove");
        signOut = new JButton("Sign Out");
        topString.setBounds(15, 20, 1000, 35);
        topString.setFont(new Font("Arial", Font.PLAIN, 14));

        topString2.setBounds(15, 40, 1000, 35);
        topString2.setFont(new Font("Arial", Font.PLAIN, 14));

        coursesString.setBounds(20, 100, 300, 35);
        coursesString.setFont(new Font("Arial", Font.PLAIN, 14));

        approveButton.setBounds(350, 140, 100, 35);

        disapproveButton.setBounds(350, 180, 100, 35);
        signOut.setBounds(350, 220, 100, 35);

        pairedList.setBounds(15, 140, 300, 120);  // Positions the slots within the JFrame
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(topString);
        panel.add(topString2);
        panel.add(coursesString);
        panel.add(signOut);
        panel.add(approveButton);
        panel.add(disapproveButton);
        panel.add(pairedList);
        this.add(panel);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JButton getSignOut() {
        return signOut;
    }

    public JButton getApproveButton() { return this.approveButton; }

    public JButton getDisapproveButton() { return this.disapproveButton; }

    public JList<String> getList() { return pairedList; }

    public String[] getArray() {
        return array;
    }
}

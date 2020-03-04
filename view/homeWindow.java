package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.GridLayout;

public class HomeWindow extends JFrame {
    JPanel main;
    JButton courseDirector, admin, pttDirector;
    JLabel updateLabel;

    public HomeWindow() {
        this.setTitle("Home");
        main = new JPanel();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        main.setBorder(new EmptyBorder(30, 30, 30, 30));
        main.setLayout(new GridLayout(3, 1));
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 1));
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(3,1));
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1,1));
        courseDirector = new JButton("Course Director");
        courseDirector.setFont(new Font("Arial", Font.PLAIN, 22));
        courseDirector.setSize(50, 10);
        admin = new JButton("Admin");
        admin.setFont(new Font("Arial", Font.PLAIN, 22));
        pttDirector = new JButton("Ptt Director");
        pttDirector.setFont(new Font("Arial", Font.PLAIN, 22));
        middle.add(courseDirector);
        middle.add(admin);
        middle.add(pttDirector);
        JLabel info = new JLabel("Sign in ID:");
        info.setFont(new Font("Arial", Font.PLAIN, 20));
        top.add(info);
        updateLabel = new JLabel();
        updateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        bottom.add(updateLabel);
        main.add(top);
        main.add(middle);
        main.add(bottom);
        this.add(main);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JButton getCourseDirectorButton(){
        return courseDirector;
    }
    public JButton getAdminButton(){
        return admin;
    }
    public JButton getPttDirectorButton(){
        return pttDirector;
    }
    public JLabel getUpdateLabel(){
        return updateLabel;
    }

}

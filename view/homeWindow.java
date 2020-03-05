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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        main = new JPanel();
        /**
         * creating the panels and setting the layout for adding components
         */
        main.setBorder(new EmptyBorder(30, 30, 30, 30));
        main.setLayout(new GridLayout(2, 1));
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 1));
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(3,1));
        /**
         * creating all the buttons for window.
         * there is one for each screen that will be directed 
         * the actions for these are initiated in the controller
         */
        courseDirector = new JButton("Course Director");
        courseDirector.setFont(new Font("Arial", Font.PLAIN, 22));
        admin = new JButton("Admin");
        admin.setFont(new Font("Arial", Font.PLAIN, 22));
        pttDirector = new JButton("Ptt Director");
        pttDirector.setFont(new Font("Arial", Font.PLAIN, 22));
        /**
         * information label
         */
        JLabel info = new JLabel("Sign in ID:");
        info.setFont(new Font("Arial", Font.PLAIN, 20));
        /**
         * adding components to appropriate panel
         */
        bottom.add(courseDirector);
        bottom.add(admin);
        bottom.add(pttDirector);
        top.add(info);
        /**
         * adding all panels to the main JFrame
         */
        main.add(top);
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

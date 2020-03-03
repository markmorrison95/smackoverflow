package view;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ClassDirectorWindow extends JFrame {
    private JPanel main;
    private JButton addClass, signOut;
    JComboBox<String> classList;
    private JLabel update;

    public ClassDirectorWindow() {
        this.setTitle("ClassDirector");
        main = new JPanel();
        main.setBorder(new EmptyBorder(30, 30, 30, 30));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        main.setLayout(new GridLayout(3, 1));
        JPanel top = new JPanel();
        JPanel middle = new JPanel();
        JPanel bottom = new JPanel();
        middle.setLayout(new GridLayout(1, 2));
        top.setLayout(new GridLayout(2, 1));
        bottom.setLayout(new GridLayout(1, 1));
        addClass = new JButton("Add Class");
        addClass.setFont(new Font("Arial", Font.PLAIN, 18));
        signOut = new JButton("Sign Out");
        signOut.setFont(new Font("Arial", Font.PLAIN, 18));
        middle.add(addClass);
        middle.add(signOut);
        JLabel info = new JLabel("Class to be Filled:");
        info.setFont(new Font("Arial", Font.PLAIN, 20));
        classList = new JComboBox<String>();
        classList.setFont(new Font("Arial", Font.PLAIN, 18));
        top.add(info);
        top.add(classList);
        update = new JLabel();
        update.setFont(new Font("Arial", Font.PLAIN, 18));
        bottom.add(update);
        main.add(top);
        main.add(middle);
        main.add(bottom);
        this.add(main);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JButton getAddClassButton() {
        return this.addClass;
    }

    public JButton getSignOutButton() {
        return this.signOut;
    }

    public JLabel getUpdateLabel() {
        return this.update;
    }
    public JComboBox<String> getClassListBox(){
        return classList;
    }
}

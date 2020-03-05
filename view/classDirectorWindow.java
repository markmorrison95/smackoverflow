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
        /**
         * when the window is closed wont stop program
         */
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        main.setLayout(new GridLayout(3, 1));
        JPanel top = new JPanel();
        JPanel middle = new JPanel();
        JPanel bottom = new JPanel();
        middle.setLayout(new GridLayout(1, 2));
        top.setLayout(new GridLayout(2, 1));
        bottom.setLayout(new GridLayout(1, 1));
        /**
         * when class is added the update label is used to confirm
         * class name and a message will be displayed
         */
        addClass = new JButton("Add Class");
        addClass.setFont(new Font("Arial", Font.PLAIN, 18));
        signOut = new JButton("Sign Out");
        signOut.setFont(new Font("Arial", Font.PLAIN, 18));
        JLabel info = new JLabel("Class to be Filled:");
        info.setFont(new Font("Arial", Font.PLAIN, 20));
        update = new JLabel();
        update.setFont(new Font("Arial", Font.PLAIN, 18));
        /**
         * classList will display all the possible classes that can be marked as 
         * needing a teacher
         */
        classList = new JComboBox<String>();
        classList.setFont(new Font("Arial", Font.PLAIN, 18));
        /**
         * adding components to panels
         */
        middle.add(addClass);
        middle.add(signOut);
        top.add(info);
        top.add(classList);
        bottom.add(update);
        /**
         * adding to main panel
         */
        main.add(top);
        main.add(middle);
        main.add(bottom);

        this.add(main);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
	 * getters to allow access from controller
	 */
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

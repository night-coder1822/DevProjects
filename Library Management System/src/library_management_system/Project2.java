package library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project2 extends JFrame implements ActionListener {
    JButton display, issued, dued, cancel;

    Project2() {
        super("PROJECT-2");
        setSize(600,400);
        setLocation(400,150);
        setLayout(null);

        display = new JButton("My Details");
        display.setBounds(50, 50, 200, 45);
        display.addActionListener(this);
        display.setFont(new Font("serif",Font.BOLD, 23));
        add(display);

        // Cancel Button
        issued = new JButton("Issue Details");
        issued.setBounds(50, 145, 200, 45);
        issued.addActionListener(this);
        issued.setFont(new Font("serif",Font.BOLD, 23));
        add(issued);

        dued = new JButton("Return Details");
        dued.setBounds(50, 240, 200, 45);
        dued.addActionListener(this);
        dued.setFont(new Font("serif",Font.BOLD, 23));
        add(dued);

        cancel = new JButton("Back To Login Page");
        cancel.setBounds(300, 143, 250, 50);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD, 23));
        add(cancel);


        
        setVisible(true);
    }   

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == display) {
            new DisplayStudent();
            setVisible(false);
        } else if (ae.getSource() == issued) {
            new IssueDetails();
            setVisible(false);
        } else if (ae.getSource() == dued) {
            new ReturnDetails();
            setVisible(false);
        } else {
            new Index();
            setVisible(false);
        }
    }
    
    public static void main(String args[]) {
        new Project2();
    }
}

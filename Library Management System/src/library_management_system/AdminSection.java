package library_management_system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AdminSection extends JFrame implements ActionListener {

    JButton button1,button2,button3,button4,button5;

    AdminSection() {
        super("PROJECT");
        // FRAME SIZE AND LOCATION
        setSize(1300,660);
        setLocation(30,30);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // LOCK IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/project.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 30, 800, 600);
        add(image);


        // HEADING
        JLabel heading = new JLabel("WELCOME TO ADMIN SECTION");
        heading.setBounds(35, 30, 600, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        add(heading);

        // ADD STUDENT BUTTON
        button1 = new JButton("Add User");
        button1.setBounds(100, 120, 200, 40);
        button1.addActionListener(this);
        button1.setFont(new Font("Arial", Font.BOLD, 23));
        add(button1);

        // ADD BOOKS BUTTON
        button2 = new JButton("Add Books");
        button2.setBounds(100, 200, 200, 40);
        button2.addActionListener(this);
        button2.setFont(new Font("Arial", Font.BOLD, 23));
        add(button2);

        // STUDENT LOGIN BUTTON
        button3 = new JButton("Issue Book");
        button3.setBounds(100, 280, 200, 40);
        button3.addActionListener(this);
        button3.setFont(new Font("Arial", Font.BOLD, 23));
        add(button3);

        // STUDENT LOGIN BUTTON
        button4 = new JButton("Return Book");
        button4.setBounds(100, 360, 200, 40);
        button4.addActionListener(this);
        button4.setFont(new Font("Arial", Font.BOLD, 23));
        add(button4);
        
        // STUDENT LOGIN BUTTON
        button5 = new JButton("Back To Login Page");
        button5.setBounds(60, 500, 280, 40);
        button5.addActionListener(this);
        button5.setFont(new Font("Arial", Font.BOLD, 23));
        add(button5);        

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button1 ) {
            //JOptionPane.showMessageDialog(null, "Entered In Admin Section!!");
            new AddUser();
            this.setVisible(false);
        } 
        if (ae.getSource() == button2) {
            //JOptionPane.showMessageDialog(null, "Entered In Student Section!!");
            new AddBooks();
            this.setVisible(false);
        }
        if (ae.getSource() == button3) {
            //JOptionPane.showMessageDialog(null, "Entered In Student Section!!");
            new IssueBooks();
            this.setVisible(false);
        }
        if (ae.getSource() == button4) {
            //JOptionPane.showMessageDialog(null, "Entered In Student Section!!");
            new ReturnBooks();
            this.setVisible(false);
        }
        if (ae.getSource() == button5) {
            //JOptionPane.showMessageDialog(null, "Entered In Student Section!!");
            new Index();
            this.setVisible(false);
        }
    }
    public static void main (String args[]) {
        new AdminSection();
    }
}

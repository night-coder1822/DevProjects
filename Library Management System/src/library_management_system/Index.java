package library_management_system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Index extends JFrame implements ActionListener {

    JPanel p1,p2,p3;
    JButton button1,button2; 

    Index() {
        super("INDEX");
        // FRAME SIZE AND LOCATION
        setSize(550,300);
        setLocation(380,200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setFont(new Font("Arial", Font.BOLD, 25));
        setFont(new Font("Arial", Font.BOLD, 20));

        // LOCK IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/index.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 80, 150, 150);
        add(image);

        // HEADING
        JLabel heading = new JLabel("WELCOME TO LMS");
        heading.setBounds(120, 20, 400, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        add(heading);

        // ADMIN LOGIN BUTTON
        button1 = new JButton("Admin Login");
        button1.setBounds(260, 100, 200, 40);
        button1.addActionListener(this);
        button1.setFont(new Font("Arial", Font.BOLD, 23));
        add(button1);

        // STUDENT LOGIN BUTTON
        button2 = new JButton("Student Login");
        button2.setBounds(260, 170, 200, 40);
        button2.addActionListener(this);
        button2.setFont(new Font("Arial", Font.BOLD, 23));
        add(button2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button1 ) {
            new AdminLogin();
            this.setVisible(false);
        } 
        if (ae.getSource() == button2) {
            JOptionPane.showMessageDialog(null, "Entered In Student Section!!");
            new StudentLogin();
            this.setVisible(false);
        }
    }
    public static void main (String args[]) {
        new Index();
    }
}



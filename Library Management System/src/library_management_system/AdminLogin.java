package library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener{

    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    AdminLogin() {
        super("ADMIN LOGIN");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Admin Login");
        heading.setBounds(170, 15, 200, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        add(heading);
        
        JLabel lblusername = new JLabel("Username -");
        lblusername.setBounds(40, 80, 100, 30);
        lblusername.setFont(new Font("Arial", Font.PLAIN, 18));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 80, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password -");
        lblpassword.setBounds(40, 130, 100, 30);
        lblpassword.setFont(new Font("Arial", Font.PLAIN, 18));
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 130, 150, 30);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(130, 190, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(280, 190, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setSize(550,300);
        setLocation(380,200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from adminlogin where username='"+username+"' and password='"+password+"'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Entered In Admin Section!!");
                    setVisible(false);
                    new AdminSection();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            new Index();
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new AdminLogin();
    }
}
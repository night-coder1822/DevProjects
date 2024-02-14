package library_management_system;

import javax.imageio.ImageIO;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DisplayStudent extends JFrame implements ActionListener {

    // Add a new class variable to hold the image
    private Image backgroundImage;

    Choice crollno;
    JTable table;
    JButton login, cancel;
    JTextField tfpasskey,tfpassword;

    DisplayStudent() {
        super("DISPLAY STUDENT");
        setSize(1000, 400);
        setLocation(200,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        try {
            backgroundImage = ImageIO.read(new File("path/to/your/image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a new JPanel to hold your components
        JPanel content = new JPanel() {
 {           // Set the panel's layout to null
            setLayout(null);
            // Add the image to the panel
            JLabel background = new JLabel(new ImageIcon(backgroundImage));
            background.setBounds(0, 0, getWidth(), getHeight());
            add(background);

            // Add your components to the panel as before
            JLabel lblpasskey = new JLabel("Passkey");
            lblpasskey.setBounds(70, 40, 150, 30);
            lblpasskey.setFont(new Font("serif",Font.BOLD, 23));
            background.add(lblpasskey);
            
            
            tfpasskey = new JTextField();
            tfpasskey.setBounds(220, 40, 200, 30);
            add(tfpasskey);

            JLabel lblpassword = new JLabel("Password");
            lblpassword.setBounds(520, 40, 150, 30);
            lblpassword.setFont(new Font("serif", Font.BOLD, 23));
            add(lblpassword);

            tfpassword = new JTextField();
            tfpassword.setBounds(670, 40, 200, 30);
            add(tfpassword);

            
            table = new JTable();
            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(15, 150, 950, 200);
            add(jsp);
            
            // Add the panel to the frame
            add(content);
            setVisible(true);
    }
}
    public void showFrame() {
        login = new JButton("Login");
        login.setBounds(180, 90, 100, 30);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Back to Project2");
        cancel.setBounds(320, 90, 150, 30);
        cancel.addActionListener(this);
        add(cancel);
    }

    @Override
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == login) {
            String query = "select * from ADDUSER where passkey = '"+tfpasskey.getText()+"' and password = '"+tfpassword.getText()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            new Project2();
            setVisible(false);
        }
    } 
    public static void main(String[] args)
    {
        new DisplayStudent();
    }
}


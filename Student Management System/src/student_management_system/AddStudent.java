package student_management_system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener 
{
    JTextField tfname, tffname, tfphone, tfemail, tfx, tfxii, tfsgpa;
    JLabel labelrollno;
    JDateChooser dcdob;
    JButton submit,cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {
        setSize(825,650);
        setLocation(300,40);
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(280, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblrollno = new JLabel("Roll No.");
        lblrollno.setBounds(50, 230, 150, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        
        labelrollno = new JLabel("10"+first4);
        labelrollno.setBounds(200, 230, 150, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 310, 150, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 310, 150, 30);
        add(tfemail);

        JLabel lblxii = new JLabel("Class 12th");
        lblxii.setBounds(50, 390, 150, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200, 390, 150, 30);
        add(tfxii);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 150, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(400, 230, 150, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 230, 150, 30);
        add(tfphone);
        
        JLabel lblx = new JLabel("Class 10th");
        lblx.setBounds(400, 310, 150, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600, 310, 150, 30);
        add(tfx);
        
        JLabel lblsgpa = new JLabel("SGPA");
        lblsgpa.setBounds(400, 390, 150, 30);
        lblsgpa.setFont(new Font("serif", Font.BOLD, 20));
        add(lblsgpa);

        tfsgpa = new JTextField();
        tfsgpa.setBounds(600, 390, 150, 30);
        add(tfsgpa);
        
        submit = new JButton("Submit");
        submit.setBounds(220, 500, 150, 45);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 500, 150, 45);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String sgpa = tfsgpa.getText();

            try {
                String query = "insert into STUDENT values ('"+name+"','"+fname+"','"+rollno+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+sgpa+"')";
                
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Added Successfully!!");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main (String agrs[]) 
    {
        new AddStudent();
    }
}
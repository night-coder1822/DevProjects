package library_management_system;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ReturnBooks extends JFrame implements ActionListener{
    
    JTextField tfname, tfbookname, tfisbn;
    JLabel labelrollno,labelpasskeyno, labelbookno, labelname, labelbookname, labelyear, labelisbn, labelissue, labeldue;
    JButton submit, cancel;
    Choice crollno, cbookno;
    JDateChooser dcissue, dcdue;
    
    ReturnBooks() {  
        super("RETURN BOOKS");
        setSize(825,650);
        setLocation(300,40);
        setLayout(null);
        
        JLabel heading = new JLabel("Return Books");
        heading.setBounds(300, 20, 300, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);
        
        // Choice Box 1
        JLabel lblbooknumber = new JLabel("Book Number");
        lblbooknumber.setBounds(30, 100, 150, 30);
        lblbooknumber.setFont(new Font("serif", Font.BOLD, 23));
        add(lblbooknumber);
        
        cbookno = new Choice();
        cbookno.setBounds(200, 100, 180, 30);
        add(cbookno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from issuebook");
            while(rs.next()) {
                cbookno.add(rs.getString("bookno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // // Choice Box 2
        // JLabel lblpasskey = new JLabel("Passkey");
        // lblpasskey.setBounds(450, 100, 100, 30);
        // lblpasskey.setFont(new Font("serif", Font.BOLD, 23));
        // add(lblpasskey);
        
        // cpasskey = new Choice();
        // cpasskey.setBounds(570, 100, 180, 30);
        // add(cpasskey);
        
        // try {
        //     Conn c = new Conn();
        //     ResultSet rs = c.s.executeQuery("select * from issuebook");
        //     while(rs.next()) {
        //         cpasskey.add(rs.getString("passkey"));
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        
        // Display
        JLabel lblbookno = new JLabel("Book Number -");
        lblbookno.setBounds(450, 100, 180, 30);
        lblbookno.setFont(new Font("serif", Font.BOLD, 23));
        add(lblbookno);
    
        labelbookno = new JLabel();
        labelbookno.setBounds(620, 100, 180, 30);
        labelbookno.setFont(new Font("Tahoma", Font.PLAIN, 23));
        add(labelbookno);

        JLabel lblpasskeyno = new JLabel("Passkey -");
        lblpasskeyno.setBounds(50, 180, 150, 30);
        lblpasskeyno.setFont(new Font("serif", Font.BOLD, 23));
        add(lblpasskeyno);
        
        labelpasskeyno = new JLabel();
        labelpasskeyno.setBounds(270, 180, 250, 30);
        labelpasskeyno.setFont(new Font("Serif", Font.BOLD, 23));
        add(labelpasskeyno);

        JLabel lblbookname = new JLabel("Book Name -");
        lblbookname.setBounds(350, 230, 150, 30);
        lblbookname.setFont(new Font("serif", Font.BOLD, 23));
        add(lblbookname);
        
        labelbookname = new JLabel();
        labelbookname.setBounds(530, 230, 250, 30);
        labelbookname.setFont(new Font("Serif", Font.BOLD, 23));
        add(labelbookname);

        
        JLabel lblname = new JLabel("Student Name -");
        lblname.setBounds(50, 280, 180, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 23));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(270, 280, 180, 30);
        labelname.setFont(new Font("serif", Font.BOLD, 23));
        add(labelname);

        JLabel lblrollno = new JLabel("Roll Number -");
        lblrollno.setBounds(350, 330, 150, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 23));
        add(lblrollno);
    
        labelrollno = new JLabel();
        labelrollno.setBounds(530, 330, 180, 30);
        labelrollno.setFont(new Font("Tahoma", Font.PLAIN, 23));
        add(labelrollno);

        JLabel lblissue = new JLabel("Issue Date -");
        lblissue.setBounds(50, 380, 180, 30);
        lblissue.setFont(new Font("serif", Font.BOLD, 23));
        add(lblissue);
        
        labelissue = new JLabel();
        labelissue.setBounds(270, 380, 180, 30);
        labelissue.setFont(new Font("serif", Font.BOLD, 23));
        add(labelissue);
        
        JLabel lbldue = new JLabel("Due Date -");
        lbldue.setBounds(350, 430, 150, 30);
        lbldue.setFont(new Font("serif", Font.BOLD, 23));
        add(lbldue);
        
        labeldue = new JLabel();
        labeldue.setBounds(530, 430, 180, 30);
        labeldue.setFont(new Font("serif", Font.BOLD, 23));
        add(labeldue);
        
        try {
            Conn c = new Conn();
            String query = "select * from issuebook where bookno='"+cbookno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelbookno.setText(rs.getString("bookno"));
                labelpasskeyno.setText(rs.getString("passkey"));
                labelbookname.setText(rs.getString("booktitle"));
                labelname.setText(rs.getString("name"));
                labelrollno.setText(rs.getString("rollno"));
                labelissue.setText(rs.getString("issue"));
                labeldue.setText(rs.getString("due"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cbookno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from issuebook where bookno='"+cbookno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelbookno.setText(rs.getString("bookno"));
                        labelpasskeyno.setText(rs.getString("passkey"));
                        labelbookname.setText(rs.getString("booktitle"));
                        labelname.setText(rs.getString("name"));
                        labelrollno.setText(rs.getString("rollno"));
                        labelissue.setText(rs.getString("issue"));
                        labeldue.setText(rs.getString("due"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Item state changed for Passkey
        // try {
        //     Conn c = new Conn();
        //     String query = "select * from issuebook where passkey='"+cpasskey.getSelectedItem()+"'";
        //     ResultSet rs = c.s.executeQuery(query);
        //     while(rs.next()) {
        //         labelpasskeyno.setText(rs.getString("passkey"));
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        
        // cbookno.addItemListener(new ItemListener() {
        //     public void itemStateChanged(ItemEvent ie) {
        //         try {
        //             Conn c = new Conn();
        //             String query = "select * from issuebook where passkey='"+cpasskey.getSelectedItem()+"'";
        //             ResultSet rs = c.s.executeQuery(query);
        //             while(rs.next()) {
        //                 labelpasskeyno.setText(rs.getString("passkey"));
        //             }
        //         } catch (Exception e) {
        //             e.printStackTrace();
        //         }
        //     }
        // });

        // Return Button
        submit = new JButton("RETURN");
        submit.setBounds(220, 530, 150, 45);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(submit);

        // Cancel Button
        cancel = new JButton("CANCEL");
        cancel.setBounds(420, 530, 150, 45);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String bookno = labelbookno.getText();
            String passkey = labelpasskeyno.getText();
            String bookname = labelbookname.getText();
            String name = labelname.getText();
            String rollno = labelrollno.getText();
            String issue = labelissue.getText();
            String due = labeldue.getText();
            
            try {
                String query = "insert into returnbook values('"+passkey+"','"+bookno+"','"+bookname+"','"+name+"','"+rollno+"','"+issue+"','"+due+"')";
                String query1  = "update addbook set quantity=quantity+1 where bookno='"+bookno+"'";
                String query2 = "delete from issuebook where bookno='"+bookno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Book Return Successfully");
                new AdminSection();
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new AdminSection();
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new ReturnBooks();
    }
}

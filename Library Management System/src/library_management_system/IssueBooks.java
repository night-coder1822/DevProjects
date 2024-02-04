package library_management_system;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class IssueBooks extends JFrame implements ActionListener{
    
    JTextField tfname, tfbookname, tfisbn;
    JLabel labelpasskey, labelbookno, labelname, labelbookname, labelyear, labelisbn, labelquantityremains,labelrollno;
    JButton submit, cancel;
    Choice cpasskey, cbookno;
    JDateChooser dcissue, dcdue;
    
    IssueBooks() {  
        super("ISSUE BOOKS");
        setSize(825,650);
        setLocation(300,40);
        setLayout(null);
        
        JLabel heading = new JLabel("Issue Books");
        heading.setBounds(300, 20, 300, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);
        
        // Choice Box 1
        JLabel lblpasskey = new JLabel("Passkey");
        lblpasskey.setBounds(30, 100, 150, 30);
        lblpasskey.setFont(new Font("serif", Font.BOLD, 23));
        add(lblpasskey);
        
        cpasskey = new Choice();
        cpasskey.setBounds(200, 100, 180, 30);
        add(cpasskey);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from adduser");
            while(rs.next()) {
                cpasskey.add(rs.getString("passkey"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Choice Box 2
        JLabel lblbooknumber = new JLabel("Book Number");
        lblbooknumber.setBounds(430, 100, 150, 30);
        lblbooknumber.setFont(new Font("serif", Font.BOLD, 23));
        add(lblbooknumber);
        
        cbookno = new Choice();
        cbookno.setBounds(600, 100, 180, 30);
        add(cbookno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from addbook");
            while(rs.next()) {
                cbookno.add(rs.getString("bookno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Display
        JLabel lblname = new JLabel("Student Name");
        lblname.setBounds(30, 170, 150, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 23));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(200, 170, 180, 30);
        labelname.setFont(new Font("Serif", Font.BOLD, 23));
        add(labelname);
        
        JLabel lblbookname = new JLabel("Book Name");
        lblbookname.setBounds(430, 170, 150, 30);
        lblbookname.setFont(new Font("serif", Font.BOLD, 23));
        add(lblbookname);
        
        labelbookname = new JLabel();
        labelbookname.setBounds(600, 170, 180, 30);
        labelbookname.setFont(new Font("serif", Font.BOLD, 23));
        add(labelbookname);

        JLabel lblpasskeyno = new JLabel("Passkey");
        lblpasskeyno.setBounds(30, 240, 150, 30);
        lblpasskeyno.setFont(new Font("serif", Font.BOLD, 23));
        add(lblpasskeyno);
    
        labelpasskey = new JLabel();
        labelpasskey.setBounds(200, 240, 180, 30);
        labelpasskey.setFont(new Font("Tahoma", Font.PLAIN, 23));
        add(labelpasskey);

        JLabel lblbookno = new JLabel("Book Number");
        lblbookno.setBounds(430, 240, 150, 30);
        lblbookno.setFont(new Font("serif", Font.BOLD, 23));
        add(lblbookno);
    
        labelbookno = new JLabel();
        labelbookno.setBounds(600, 240, 180, 30);
        labelbookno.setFont(new Font("Tahoma", Font.PLAIN, 23));
        add(labelbookno);

        JLabel lblyear = new JLabel("Year");
        lblyear.setBounds(30, 310, 150, 30);
        lblyear.setFont(new Font("serif", Font.BOLD, 23));
        add(lblyear);
        
        labelyear = new JLabel();
        labelyear.setBounds(200, 310, 180, 30);
        labelyear.setFont(new Font("Serif", Font.BOLD, 23));
        add(labelyear);

        JLabel lblisbn = new JLabel("ISBN");
        lblisbn.setBounds(430, 310, 150, 30);
        lblisbn.setFont(new Font("serif", Font.BOLD, 23));
        add(lblisbn);
        
        labelisbn = new JLabel();
        labelisbn.setBounds(600, 310, 180, 30);
        labelisbn.setFont(new Font("Serif", Font.BOLD, 23));
        add(labelisbn);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(30, 380, 150, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 23));
        add(lblrollno);
        
        labelrollno = new JLabel();
        labelrollno.setBounds(200, 380, 180, 30);
        labelrollno.setFont(new Font("Serif", Font.BOLD, 23));
        add(labelrollno);

        JLabel lblquantityremains = new JLabel("Quantity Available - ");
        lblquantityremains.setBounds(430, 380, 250, 30);
        lblquantityremains.setFont(new Font("serif", Font.BOLD, 23));
        add(lblquantityremains);

        labelquantityremains = new JLabel();
        labelquantityremains.setBounds(650, 380, 100, 30);
        labelquantityremains.setFont(new Font("Serif", Font.BOLD, 23));
        add(labelquantityremains);

        JLabel lblissue = new JLabel("Issue Date");
        lblissue.setBounds(30, 450, 150, 30);
        lblissue.setFont(new Font("serif", Font.BOLD, 23));
        add(lblissue);
        
        dcissue = new JDateChooser();
        dcissue.setBounds(200, 450, 180, 30);
        add(dcissue);

        JLabel lbldue = new JLabel("Due Date");
        lbldue.setBounds(430, 450, 150, 30);
        lbldue.setFont(new Font("serif", Font.BOLD, 23));
        add(lbldue);
        
        dcdue = new JDateChooser();
        dcdue.setBounds(600, 450, 180, 30);
        add(dcdue);
        
        // 1st Item State change
        try {
            Conn c = new Conn();
            String query = "select * from adduser where passkey='"+cpasskey.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelpasskey.setText(rs.getString("passkey"));
                labelyear.setText(rs.getString("year"));
                labelrollno.setText(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cpasskey.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from adduser where passkey='"+cpasskey.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelpasskey.setText(rs.getString("passkey"));
                        labelyear.setText(rs.getString("year"));
                        labelrollno.setText(rs.getString("rollno"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // 2nd Item State change
        
        try {
            Conn c = new Conn();
            String query = "select * from addbook where bookno='"+cbookno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelbookname.setText(rs.getString("booktitle"));
                labelbookno.setText(rs.getString("bookno"));
                labelisbn.setText(rs.getString("isbn"));
                labelquantityremains.setText(rs.getString("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cbookno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from addbook where bookno='"+cbookno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelbookname.setText(rs.getString("booktitle"));
                        labelbookno.setText(rs.getString("bookno"));
                        labelisbn.setText(rs.getString("isbn"));
                        labelquantityremains.setText(rs.getString("quantity"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        // Submit Button
        submit = new JButton("ISSUE");
        submit.setBounds(220, 520, 150, 45);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(submit);

        // Cancel Button
        cancel = new JButton("CANCEL");
        cancel.setBounds(420, 520, 150, 45);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String passkey = labelpasskey.getText();
            String name = labelname.getText();
            String bookno = labelbookno.getText();
            String booktitle = labelbookname.getText();
            String year = labelyear.getText();
            String isbn = labelisbn.getText();
            String rollno = labelyear.getText();
            String issue = ((JTextField) dcissue.getDateEditor().getUiComponent()).getText();
            String due = ((JTextField) dcdue.getDateEditor().getUiComponent()).getText();
            
            try {
                String query = "insert into issuebook values('"+passkey+"','"+name+"','"+bookno+"','"+booktitle+"','"+year+"','"+isbn+"','"+rollno+"','"+issue+"','"+due+"')";
                String query1  = "update addbook set quantity=quantity-1 where bookno='"+bookno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                con.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null, "Book Issued Successfully");
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
        new IssueBooks();
    }
}




    
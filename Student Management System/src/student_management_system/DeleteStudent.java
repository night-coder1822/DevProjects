package student_management_system;

import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteStudent extends JFrame implements ActionListener
{
    JTable table;
    Choice crollno;
    JButton delete,search;
    JLabel labelrollno;

    DeleteStudent() {
        setSize(1100,650);
        setLocation(150,40);
        setLayout(null);

        JLabel heading = new JLabel("Delete Student Details");
        heading.setBounds(280,20,500,50);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 35));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number -");
        lblrollnumber.setBounds(50,100,250,25);
        lblrollnumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(300,100,200,28);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from STUDENT");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 200, 1100, 600);
        add(jsp);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 150, 150, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 23));
        add(lblrollno);
    
        labelrollno = new JLabel();
        labelrollno.setBounds(250, 150, 180, 30);
        labelrollno.setFont(new Font("Tahoma", Font.PLAIN, 23));
        add(labelrollno);
        
        delete = new JButton("Delete");
        delete.setBounds(600, 100, 80, 30);
        delete.addActionListener(this);
        add(delete);
        
        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelrollno.setText(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelrollno.setText(rs.getString("rollno"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == delete) {
            String rollno = labelrollno.getText();
            try {
                String query1 = "delete from student where rollno='"+rollno+"'";
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Student Deleted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String agrs[]) 
    {
        new DeleteStudent();
    }
}

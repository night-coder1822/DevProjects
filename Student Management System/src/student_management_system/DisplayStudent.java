package student_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class DisplayStudent extends JFrame
{
    JTable table;
    DisplayStudent() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 130, 1000, 310);
        add(jsp);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(1100,650);
        setLocation(150,40);
        setVisible(true);
    }
    
    public static void main (String agrs[]) 
    {
        new DisplayStudent();
    }
}

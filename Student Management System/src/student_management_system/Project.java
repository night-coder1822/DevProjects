package student_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener 
{
    Project() {
        setSize(1300,650);
        setBounds(35, 40, 1300, 650);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        JMenu updateInformation = new JMenu("Update Information");
        updateInformation.setForeground(Color.BLUE);
        mb.add(updateInformation);

        JMenuItem updatestudent = new JMenuItem("Update Student Information");
        updatestudent.setBackground(Color.WHITE);
        updatestudent.addActionListener(this);
        updateInformation.add(updatestudent);

        JMenu deleteInformation = new JMenu("Delete Information");
        deleteInformation.setForeground(Color.BLUE);
        mb.add(deleteInformation);

        JMenuItem deletestudent = new JMenuItem("Delete Student Information");
        deletestudent.setBackground(Color.WHITE);
        deletestudent.addActionListener(this);
        deleteInformation.add(deletestudent);

        JMenu searchInformation = new JMenu("Search Information");
        searchInformation.setForeground(Color.BLUE);
        mb.add(searchInformation);

        JMenuItem searchstudent = new JMenuItem("Search Student Information");
        searchstudent.setBackground(Color.WHITE);
        searchstudent.addActionListener(this);
        searchInformation.add(searchstudent);

        JMenu displayInformation = new JMenu("Display Information");
        displayInformation.setForeground(Color.BLUE);
        mb.add(displayInformation);

        JMenuItem displaystudent = new JMenuItem("Display Student Information");
        displaystudent.setBackground(Color.WHITE);
        displaystudent.addActionListener(this);
        displayInformation.add(displaystudent);

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.RED);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("Update Student Information")) {
            new UpdateStudent();
        } else if (msg.equals("Delete Student Information")) {
            new DeleteStudent();
        } else if (msg.equals("Search Student Information")) {
            new SearchStudent();
        } else if (msg.equals("Display Student Information")) {
            new DisplayStudent();
        } 
    }
    public static void main(String agrs[]) 
    {
        new Project();
    }
}

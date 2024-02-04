package library_management_system;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;

public class AddBooks extends JFrame implements ActionListener {

    JTextField tfbookno,tfisbn,tfauthorname,tfbooktitle, tfcategory,tfyear, tfquantity;
    JButton submit,cancel;
    JDateChooser dcarrive;

    AddBooks() {
        super("ADD BOOKS");
        setSize(825,650);
        setLocation(300,40);
        setLayout(null);

        JLabel heading = new JLabel("New Book Details");
        heading.setBounds(280, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);
        
        // BOOK NUMBER
        JLabel lblbookno = new JLabel("Book No.");
        lblbookno.setBounds(30, 150, 150, 30);
        lblbookno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbookno);

        tfbookno = new JTextField();
        tfbookno.setBounds(160, 150, 200, 30);
        add(tfbookno);

        // ISBN (10 DIGIT)
        JLabel lblisbn = new JLabel("ISBN");
        lblisbn.setBounds(415, 150, 150, 30);
        lblisbn.setFont(new Font("serif", Font.BOLD, 20));
        add(lblisbn);

        tfisbn = new JTextField();
        tfisbn.setBounds(560, 150, 200, 30);
        add(tfisbn);

        // AUTHOR NAME
        JLabel lblauthorname = new JLabel("Author Name");
        lblauthorname.setBounds(30, 230, 150, 30);
        lblauthorname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblauthorname);

        tfauthorname = new JTextField();
        tfauthorname.setBounds(160, 230, 200, 30);
        add(tfauthorname);

        // BOOK TITLE
        JLabel lblbooktitle = new JLabel("Book Title");
        lblbooktitle.setBounds(415, 230, 150, 30);
        lblbooktitle.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbooktitle);

        tfbooktitle = new JTextField();
        tfbooktitle.setBounds(560, 230, 200, 30);
        add(tfbooktitle);

        // CATEGORY (YEAR - DEPARTMENT)
        JLabel lblcategory = new JLabel("Category");
        lblcategory.setBounds(30, 310, 150, 30);
        lblcategory.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcategory);

        tfcategory = new JTextField();
        tfcategory.setBounds(160, 310, 200, 30);
        add(tfcategory);

        // YEAR PUBLISHED
        JLabel lblyear = new JLabel("Year Published");
        lblyear.setBounds(415, 310, 150, 30);
        lblyear.setFont(new Font("serif", Font.BOLD, 20));
        add(lblyear);

        tfyear = new JTextField();
        tfyear.setBounds(560, 310, 200, 30);
        add(tfyear);

        // DATE ARRIVED
        JLabel lblarrive = new JLabel("Arrive Date");
        lblarrive.setBounds(30, 390, 150, 30);
        lblarrive.setFont(new Font("serif", Font.BOLD, 20));
        add(lblarrive);
        
        dcarrive = new JDateChooser();
        dcarrive.setBounds(160, 390, 200, 30);
        add(dcarrive);

        // QUANTITY
        JLabel lblquantity = new JLabel("Quantity");
        lblquantity.setBounds(415, 390, 150, 30);
        lblquantity.setFont(new Font("serif", Font.BOLD, 20));
        add(lblquantity);

        tfquantity = new JTextField();
        tfquantity.setBounds(560, 390, 200, 30);
        add(tfquantity);

        // Submit Button
        submit = new JButton("Add");
        submit.setBounds(220, 500, 150, 45);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 500, 150, 45);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(cancel);

        this.setVisible(true);
    }
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == submit) {
            String bookno = tfbookno.getText();
            String isbn = tfisbn.getText();
            String authorname = tfauthorname.getText();
            String booktitle = tfbooktitle.getText();
            String category = tfcategory.getText();
            String year = tfyear.getText();
            String arrive = ((JTextField) dcarrive.getDateEditor().getUiComponent()).getText();
            String quantity = tfquantity.getText();

            try {
                String query = "insert into ADDBOOK values ('"+bookno+"','"+isbn+"','"+authorname+"','"+booktitle+"','"+category+"','"+year+"','"+arrive+"','"+quantity+"')";
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Books Added Successfully!!");
                new AdminSection();
                this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new AdminSection();
            this.setVisible(false);
        }
    }
    public static void main (String agrs[]) {
        new AddBooks();
    }
}
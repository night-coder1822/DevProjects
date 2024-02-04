package student_management_system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable 
{
    Thread t;
    Splash() {    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splashh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();
        
        setVisible(true);
        for (int i=2; i<=600; i++) {
            setLocation(i-520, i-560);
            setSize(i+600, i+60);
        }
    }
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);

            new Project();
        } catch (Exception e) {}
    }
    public static void main(String args[]) 
    {
        new Splash();
    }
}

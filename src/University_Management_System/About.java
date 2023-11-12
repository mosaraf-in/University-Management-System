package University_Management_System;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/about.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);

        JLabel heading = new JLabel("<html>University<br/>Management System<html/>");
        heading.setBounds(40,10,500,130);
        heading.setFont(new Font("Thoma",Font.BOLD,30));
        heading.setForeground(Color.BLUE);
        add(heading);


        JLabel name = new JLabel("Developed by: MOSARAF HOSSAIN");
        name.setBounds(40,220,500,30);
        name.setFont(new Font("Thoma",Font.BOLD,25));
        add(name);

        JLabel rollNo = new JLabel("Roll No: 22U61A0558");
        rollNo.setBounds(40,265,500,30);
        rollNo.setFont(new Font("Thoma",Font.ITALIC,20));
        add(rollNo);

        JLabel contact = new JLabel("Contact: mosaraf.ind@gmail.com");
        contact.setBounds(40,300,500,30);
        contact.setFont(new Font("Thoma",Font.ITALIC,20));
        add(contact);

        JLabel education = new JLabel("Education- B.Tech (Computer Science)");
        education.setBounds(40,340,500,30);
        education.setFont(new Font("Thoma",Font.ITALIC,20));
        add(education);

        JLabel phone = new JLabel("Phone- 9679232461");
        phone.setBounds(40,380,500,30);
        phone.setFont(new Font("Thoma",Font.ITALIC,20));
        add(phone);

        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new About();
    }
}

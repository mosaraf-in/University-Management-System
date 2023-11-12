package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {
    String rollNo;
    JButton back;
    Conn c = new Conn();
    Marks(String rollNo){
        this.rollNo = rollNo;

        JLabel heading = new JLabel("Global Institute of Engineering & Technology");
        heading.setBounds(30, 10, 500, 25);
        heading.setFont(new Font("Thoma", Font.BOLD, 20));
        add(heading);

        JLabel subHeading = new JLabel("Result of Examination 2023");
        subHeading.setBounds(130, 50, 400, 20);
        subHeading.setFont(new Font("Thoma", Font.BOLD, 16));
        add(subHeading);


        JLabel roll = new JLabel("Roll Number :" + rollNo);
        roll.setBounds(60, 100, 400, 20);
        roll.setFont(new Font("Thoma", Font.PLAIN, 16));
        add(roll);

        JLabel semester = new JLabel();
        semester.setBounds(60, 130, 400, 20);
        semester.setFont(new Font("Thoma", Font.PLAIN, 16));
        add(semester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 400, 20);
        sub1.setFont(new Font("Thoma", Font.PLAIN, 16));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 230, 400, 20);
        sub2.setFont(new Font("Thoma", Font.PLAIN, 16));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 260, 400, 20);
        sub3.setFont(new Font("Thoma", Font.PLAIN, 16));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 290, 400, 20);
        sub4.setFont(new Font("Thoma", Font.PLAIN, 16));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 320, 400, 20);
        sub5.setFont(new Font("Thoma", Font.PLAIN, 16));
        add(sub5);

        try{
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollNo = '"+rollNo+"'");
            while (rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollNo = '"+rollNo+"'");
            while (rs2.next()){
                sub1.setText(sub1.getText() + "----------------" + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "----------------" + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "----------------" + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "----------------" + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "----------------" + rs2.getString("marks5"));
                semester.setText("Semester " + rs2.getString("semester"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(250, 500, 120, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Thoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);

        setSize(500,600);
        setLocation(500,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    public static void main(String[] args) {
        new Marks("");
    }
}

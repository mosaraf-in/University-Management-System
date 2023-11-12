package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {

    Choice chRollNo;
    JComboBox semesterCombo;
    JTextField sub1Text, sub2Text, sub3Text, sub4Text, sub5Text, mark1Text, mark2Text, mark3Text, mark4Text, mark5Text;
    JButton submit, back;
    Conn c = new Conn();

    EnterMarks() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 30, 400, 300);
        add(image);

        JLabel heading = new JLabel("Enter marks of Students ");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Thoma", Font.BOLD, 20));
        add(heading);

        JLabel rollNumber = new JLabel("Select Roll Number");
        rollNumber.setBounds(50, 70, 150, 20);
        add(rollNumber);

        chRollNo = new Choice();
        chRollNo.setBounds(200, 70, 150, 20);
        add(chRollNo);

        try {
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                chRollNo.add(rs.getString("rollNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel semester = new JLabel("Select Semester");
        semester.setBounds(50, 110, 150, 20);
        add(semester);

        String Semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        semesterCombo = new JComboBox<>(Semester);
        semesterCombo.setBounds(200, 110, 150, 20);
        semesterCombo.setBackground(Color.WHITE);
        add(semesterCombo);

        JLabel enterSubject = new JLabel("Enter Subject");
        enterSubject.setBounds(100, 150, 200, 40);
        add(enterSubject);

        JLabel enterMarks = new JLabel("Enter Marks");
        enterMarks.setBounds(320, 150, 200, 40);
        add(enterMarks);

        sub1Text = new JTextField();
        sub1Text.setBounds(50, 200, 200, 20);
        add(sub1Text);
        mark1Text = new JTextField();
        mark1Text.setBounds(250, 200, 200, 20);
        add(mark1Text);

        sub2Text = new JTextField();
        sub2Text.setBounds(50, 230, 200, 20);
        add(sub2Text);
        mark2Text = new JTextField();
        mark2Text.setBounds(250, 230, 200, 20);
        add(mark2Text);

        sub3Text = new JTextField();
        sub3Text.setBounds(50, 260, 200, 20);
        add(sub3Text);
        mark3Text = new JTextField();
        mark3Text.setBounds(250, 260, 200, 20);
        add(mark3Text);

        sub4Text = new JTextField();
        sub4Text.setBounds(50, 290, 200, 20);
        add(sub4Text);
        mark4Text = new JTextField();
        mark4Text.setBounds(250, 290, 200, 20);
        add(mark4Text);

        sub5Text = new JTextField();
        sub5Text.setBounds(50, 320, 200, 20);
        add(sub5Text);
        mark5Text = new JTextField();
        mark5Text.setBounds(250, 320, 200, 20);
        add(mark5Text);

        submit = new JButton("Submit");
        submit.setBounds(100, 380, 130, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Thoma", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(250, 380, 130, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Thoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);


        setSize(900, 480);
        setLocation(300, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){

            try{
                String query1 = "insert into subject values('"+chRollNo.getSelectedItem()+"','"+semesterCombo.getSelectedItem()+"','"+sub1Text.getText()+"','"+sub2Text.getText()+"','"+sub3Text.getText()+"','"+sub4Text.getText()+"','"+sub5Text.getText()+"')";
                String query2 = "insert into marks values('"+chRollNo.getSelectedItem()+"','"+semesterCombo.getSelectedItem()+"','"+mark1Text.getText()+"','"+mark2Text.getText()+"','"+mark3Text.getText()+"','"+mark4Text.getText()+"','"+mark5Text.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();

            }
        }else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new EnterMarks();

    }
}
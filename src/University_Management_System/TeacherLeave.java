package University_Management_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice chId,chDuration;
    JDateChooser chooseDate;
    JButton submit,cancel;
    Conn c = new Conn();

    TeacherLeave(){
        setLayout(null);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Thoma",Font.BOLD,20));
        add(heading);

        JLabel id = new JLabel("Search by Id");
        id.setBounds(60,100,200,20);
        id.setFont(new Font("Thoma",Font.PLAIN,18));
        add(id);

        chId = new Choice();
        chId.setBounds(60,130,200,20);
        add(chId);

        try{
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()){
                chId.add(rs.getString("Id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel date = new JLabel("Date");
        date.setBounds(60,180,200,20);
        date.setFont(new Font("Thoma",Font.PLAIN,18));
        add(date);

        chooseDate = new JDateChooser();
        chooseDate.setBounds(60,210,200,20);
        add(chooseDate);

        JLabel duration = new JLabel("Time Duration");
        duration.setBounds(60,260,200,20);
        duration.setFont(new Font("Thoma",Font.PLAIN,18));
        add(duration);

        chDuration = new Choice();
        chDuration.setBounds(60,290,200,20);
        chDuration.add("Full Day");
        chDuration.add("Half Day");
        add(chDuration);

        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Thoma",Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Thoma",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        setSize(500,500);
        setLocation(450,100);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){

            String id = chId.getSelectedItem();
            String date = ((JTextField) chooseDate.getDateEditor().getUiComponent()).getText();
            String duration = chDuration.getSelectedItem();

            String query = "insert into teacherLeave values('"+id+"','"+date+"','"+duration+"')";

            try{
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();

            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }

}

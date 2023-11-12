package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice chRollNo;
    JComboBox cbCoarse,cbBranch,cbSemester;
    JLabel labelTotal;
    JButton update,payFee,back;
    Conn c = new Conn();

    StudentFeeForm(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/fee.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,450,300);
        add(image);


        JLabel rollNumber = new JLabel("Select Roll Number");
        rollNumber.setBounds(40,60,150,20);
        rollNumber.setFont(new Font("Thoma",Font.BOLD,16));
        add(rollNumber);

        chRollNo = new Choice();
        chRollNo.setBounds(200,60,150,20);
        chRollNo.setFont(new Font("Thoma",Font.PLAIN,16));
        add(chRollNo);

        try{
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()){
                chRollNo.add(rs.getString("rollNo"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(40,100,150,20);
        labelName.setFont(new Font("Thoma",Font.BOLD,16));
        add(labelName);

        JLabel name = new JLabel();
        name.setBounds(200,100,150,20);
        name.setFont(new Font("Thoma",Font.PLAIN,16));
        add(name);

        JLabel labelFName = new JLabel("Father's Name");
        labelFName.setBounds(40,140,150,20);
        labelFName.setFont(new Font("Thoma",Font.BOLD,16));
        add(labelFName);

        JLabel fatherName = new JLabel();
        fatherName.setBounds(200,140,150,20);
        fatherName.setFont(new Font("Thoma",Font.PLAIN,16));
        add(fatherName);

        try{
            String query = "select * from student where rollNo = '"+chRollNo.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                name.setText(rs.getString("name"));
                fatherName.setText(rs.getString("fname"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        chRollNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    String query = "select * from student where rollNo = '"+chRollNo.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        name.setText(rs.getString("name"));
                        fatherName.setText(rs.getString("fname"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        JLabel coarse = new JLabel("Course");
        coarse.setBounds(40,180,150,20);
        coarse.setFont(new Font("Thoma",Font.BOLD,16));
        add(coarse);

        String Course[] = {"BTech","BDS","MBA","BSc","BA","MCA","BCom",};
        cbCoarse = new JComboBox<>(Course);
        cbCoarse.setBounds(200,180,150,20);
        cbCoarse.setBackground(Color.WHITE);
        add(cbCoarse);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(40,220,100,20);
        branch.setFont(new Font("Thoma",Font.BOLD,16));
        add(branch);

        String Branch[] = {"CSE","CSD","CSM","ECE","CE","ME","AI","IT"};
        cbBranch = new JComboBox<>(Branch);
        cbBranch.setBounds(200,220,150,20);
        cbBranch.setBackground(Color.WHITE);
        add(cbBranch);

        JLabel semester = new JLabel("Semester");
        semester.setBounds(40,260,150,20);
        semester.setFont(new Font("Thoma",Font.BOLD,16));
        add(semester);

        String Semester[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        cbSemester = new JComboBox<>(Semester);
        cbSemester.setBounds(200, 260, 150, 20);
        cbSemester.setBackground(Color.WHITE);
        add(cbSemester);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40,300,150,20);
        total.setFont(new Font("Thoma",Font.BOLD,16));
        add(total);


        labelTotal = new JLabel();
        labelTotal.setBounds(200,300,150,20);
        labelTotal.setFont(new Font("Thoma",Font.PLAIN,16));
        add(labelTotal);

        update = new JButton("Update");
        update.setBounds(30, 380, 120, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Thoma", Font.BOLD, 15));
        update.addActionListener(this);
        add(update);

        payFee = new JButton("Pay Fee");
        payFee.setBounds(170, 380, 120, 25);
        payFee.setBackground(Color.BLACK);
        payFee.setForeground(Color.WHITE);
        payFee.setFont(new Font("Thoma", Font.BOLD, 15));
        payFee.addActionListener(this);
        add(payFee);

        back = new JButton("Back");
        back.setBounds(310, 380, 120, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Thoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);


        setSize(870,500);
        setLocation(300,100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == update){
            String coarse = (String) cbCoarse.getSelectedItem();
            String semester = (String) cbSemester.getSelectedItem();

            try{
                ResultSet rs = c.s.executeQuery("select * from fee where coarse= '"+coarse+"'");
                while (rs.next()){
                    labelTotal.setText(rs.getString(semester));
                }
            }catch (Exception e){
                e.printStackTrace();
            }


        }else if (ae.getSource() == payFee){
            String rollNo = chRollNo.getSelectedItem();
            String coarse = (String) cbCoarse.getSelectedItem();
            String branch = (String) cbBranch.getSelectedItem();
            String semester = (String) cbSemester.getSelectedItem();
            String total = labelTotal.getText();

            try{
                String query = "insert into collegeFee values('"+rollNo+"','"+coarse+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"College fee submitted successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }


        }else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new StudentFeeForm();
    }

}

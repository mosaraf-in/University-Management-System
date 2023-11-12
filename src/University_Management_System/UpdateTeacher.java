package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField addressTextField,phoneTextField,emailTextField,educationTextField,departmentTextField;
    JLabel id;
    JButton update,cancel;
    Choice chIdNo;
    Conn c = new Conn();
    UpdateTeacher(){
        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details :");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Thoma",Font.ITALIC,35));
        add(heading);

        JLabel idNumber = new JLabel("Select Id Number");
        idNumber.setBounds(50,100,220,20);
        idNumber.setFont(new Font("serif",Font.PLAIN,20));
        add(idNumber);

        chIdNo = new Choice();
        chIdNo.setBounds(270,100,220,20);
        add(chIdNo);

        try{
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()){
                chIdNo.add(rs.getString("Id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,150,100,30);
        labelName.setFont(new Font("serif",Font.BOLD,20));
        add(labelName);

        JLabel name = new JLabel();
        name.setBounds(200,150,150,30);
        name.setFont(new Font("Thoma",Font.PLAIN,18));
        add(name);

        JLabel labelFName = new JLabel("Father's Name");
        labelFName.setBounds(400,150,300,30);
        labelFName.setFont(new Font("serif",Font.BOLD,20));
        add(labelFName);

        JLabel fatherName = new JLabel();
        fatherName.setBounds(600,150,150,30);
        name.setFont(new Font("Thoma",Font.PLAIN,18));
        add(fatherName);

        JLabel labelIdNo = new JLabel("Id Number");
        labelIdNo.setBounds(50,200,300,30);
        labelIdNo.setFont(new Font("serif",Font.BOLD,20));
        add(labelIdNo);

        id = new JLabel();
        id.setBounds(200,200,300,30);
        id.setFont(new Font("Thoma",Font.PLAIN,18));
        add(id);

        JLabel labelDOB = new JLabel("Date of Birth");
        labelDOB.setBounds(400,200,300,30);
        labelDOB.setFont(new Font("serif",Font.BOLD,20));
        add(labelDOB);

        JLabel dob = new JLabel();
        dob.setBounds(600,200,150,30);
        dob.setFont(new Font("Thoma",Font.PLAIN,18));
        add(dob);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,100,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(200,250,150,30);
        add(addressTextField);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,300,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(600,250,150,30);
        add(phoneTextField);

        JLabel email = new JLabel("Email Id");
        email.setBounds(50,300,100,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(200,300,150,30);
        add(emailTextField);

        JLabel labelClassX = new JLabel("Class X(%)");
        labelClassX.setBounds(400,300,300,30);
        labelClassX.setFont(new Font("serif",Font.BOLD,20));
        add(labelClassX);

        JLabel classX = new JLabel();
        classX.setBounds(600,300,150,30);
        classX.setFont(new Font("Thoma",Font.PLAIN,18));
        add(classX);

        JLabel labelClassXII = new JLabel("Class XII(%)");
        labelClassXII.setBounds(50,350,300,30);
        labelClassXII.setFont(new Font("serif",Font.BOLD,20));
        add(labelClassXII);

        JLabel classXII = new JLabel();
        classXII.setBounds(200,350,150,30);
        classXII.setFont(new Font("Thoma",Font.PLAIN,18));
        add(classXII);

        JLabel labelAadhaarNo = new JLabel("Aadhaar No");
        labelAadhaarNo.setBounds(400,350,200,30);
        labelAadhaarNo.setFont(new Font("serif",Font.BOLD,20));
        add(labelAadhaarNo);

        JLabel aadhaar = new JLabel();
        aadhaar.setBounds(600,350,150,30);
        aadhaar.setFont(new Font("Thoma",Font.PLAIN,18));
        add(aadhaar);

        JLabel education = new JLabel("Education");
        education.setBounds(50,400,100,30);
        education.setFont(new Font("serif",Font.BOLD,20));
        add(education);

        educationTextField = new JTextField();
        educationTextField.setBounds(200,400,150,30);
        add(educationTextField);

        JLabel department = new JLabel("Department");
        department.setBounds(400,400,200,30);
        department.setFont(new Font("serif",Font.BOLD,20));
        add(department);

        departmentTextField = new JTextField();
        departmentTextField.setBounds(600,400,150,30);
        add(departmentTextField);

        chIdNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    String query = "select * from teacher where Id = '"+chIdNo.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        name.setText(rs.getString("name"));
                        fatherName.setText(rs.getString("fname"));
                        dob.setText(rs.getString("dob"));
                        addressTextField.setText(rs.getString("address"));
                        phoneTextField.setText(rs.getString("phone"));
                        emailTextField.setText(rs.getString("email"));
                        classX.setText(rs.getString("class_X"));
                        classXII.setText(rs.getString("class_XII"));
                        aadhaar.setText(rs.getString("aadhaar"));
                        id.setText(rs.getString("Id"));
                        educationTextField.setText(rs.getString("education"));
                        departmentTextField.setText(rs.getString("department"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        update = new JButton("Update");
        update.setBounds(250,500,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Thoma",Font.BOLD,15));
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Thoma",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        setSize(800,650);
        setLocation(300,50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update){

            String Id =  id.getText();
            String address = addressTextField.getText();
            String phone = phoneTextField.getText();
            String email = emailTextField.getText();
            String education = educationTextField.getText();
            String department = departmentTextField.getText();

            try{
                String query = "update teacher set address = '"+address+"', phone = '"+phone+"', email ='"+email+"',education = '"+education+"', department = '"+department+"' where Id='"+Id+"'";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Details Updated Successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();

            }

        }
        else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }

}

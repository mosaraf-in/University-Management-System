package University_Management_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField nameTextField,fatherNameTextField,addressTextField,phoneTextField,classXTextField,emailTextField,classXIITextField,aadhaarNoTextField;
    JLabel idLabel;
    JDateChooser chooseDOB;
    JComboBox cbEducation,cbDepartment;
    JButton submit,cancel;
    Random ran = new Random();
    long last4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddTeacher(){
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(280,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(200,150,150,30);
        add(nameTextField);

        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(400,150,300,30);
        fatherName.setFont(new Font("serif",Font.BOLD,20));
        add(fatherName);

        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(600,150,150,30);
        add(fatherNameTextField);

        JLabel employeeId = new JLabel("Employee Id");
        employeeId.setBounds(50,200,300,30);
        employeeId.setFont(new Font("serif",Font.BOLD,20));
        add(employeeId);

        idLabel = new JLabel("U6" + last4);
        idLabel.setBounds(200,200,300,30);
        idLabel.setFont(new Font("serif",Font.BOLD,20));
        add(idLabel);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,300,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        chooseDOB = new JDateChooser();
        chooseDOB.setBounds(600,200,150,30);
        add(chooseDOB);

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

        JLabel classX = new JLabel("Class X(%)");
        classX.setBounds(400,300,300,30);
        classX.setFont(new Font("serif",Font.BOLD,20));
        add(classX);

        classXTextField = new JTextField();
        classXTextField.setBounds(600,300,150,30);
        add(classXTextField);

        JLabel classXII = new JLabel("Class XII(%)");
        classXII.setBounds(50,350,300,30);
        classXII.setFont(new Font("serif",Font.BOLD,20));
        add(classXII);

        classXIITextField = new JTextField();
        classXIITextField.setBounds(200,350,150,30);
        add(classXIITextField);

        JLabel aadhaarNo = new JLabel("Aadhaar No");
        aadhaarNo.setBounds(400,350,200,30);
        aadhaarNo.setFont(new Font("serif",Font.BOLD,20));
        add(aadhaarNo);

        aadhaarNoTextField = new JTextField();
        aadhaarNoTextField.setBounds(600,350,150,30);
        add(aadhaarNoTextField);

        JLabel education = new JLabel("Education");
        education.setBounds(50,400,200,30);
        education.setFont(new Font("serif",Font.BOLD,20));
        add(education);

        String Education[] = {"B.Tech","BDS","MBA","BSc","BA","MCA","BCom",};
        cbEducation = new JComboBox<>(Education);
        cbEducation.setBounds(200,400,150,30);
        cbEducation.setBackground(Color.WHITE);
        add(cbEducation);

        JLabel department = new JLabel("Department");
        department.setBounds(400,400,200,30);
        department.setFont(new Font("serif",Font.BOLD,20));
        add(department);

        String branch[] = {"CSE","CSD","CSM","ECE","CE","ME","AI","IT"};
        cbDepartment = new JComboBox<>(branch);
        cbDepartment.setBounds(600,400,150,30);
        cbDepartment.setBackground(Color.WHITE);
        add(cbDepartment);

        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Thoma",Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
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
        if (ae.getSource() == submit){
            String name = nameTextField.getText();
            String fname = fatherNameTextField.getText();
            String id = idLabel.getText();
            String dob = ((JTextField) chooseDOB.getDateEditor().getUiComponent()).getText();
            String address = addressTextField.getText();
            String phone = phoneTextField.getText();
            String email = emailTextField.getText();
            String classX = classXTextField.getText();
            String classXII = classXIITextField.getText();
            String aadhaar = aadhaarNoTextField.getText();
            String education = (String)cbEducation.getSelectedItem();
            String department = (String)cbDepartment.getSelectedItem();

            try{
                String query = "insert into teacher values('"+name+"','"+fname+"','"+id+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+classX+"','"+classXII+"','"+aadhaar+"','"+education+"','"+department+"')";


                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully");
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
        new AddTeacher();
    }

}

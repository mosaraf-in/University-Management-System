package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton cancel,login;
    JPasswordField passwordField;
    JTextField userField;
    Login(){
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,20);
        add(username);

        userField = new JTextField();
        userField.setBounds(150,20,150,20);
        userField.setFont(new Font("Thoma",Font.BOLD,12));
        add(userField);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,20);
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,20);
        passwordField.setFont(new Font("Thoma",Font.BOLD,15));
        add(passwordField);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Thoma",Font.BOLD,15));
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Thoma",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        setSize(600,300);
        setLocation(400,230);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login){
            String username = userField.getText();
            String password = passwordField.getText();

            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            try{
                Conn c = new Conn();
                ResultSet rs =  c.s.executeQuery(query);

               if(rs.next()){
                   setVisible(false);
                   new Project();
               }else {
                   JOptionPane.showMessageDialog(null,"Invalid username or password");
                   setVisible(false);
               }
               c.s.close();

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}

package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentDetails extends JFrame implements ActionListener {

    Choice chRollNo;
    JTable table;
    JButton search,print,add,update,cancel;
    Conn c = new Conn();

    StudentDetails(){
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        chRollNo = new Choice();
        chRollNo.setBounds(180,20,150,20);
        add(chRollNo);

        try{
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()){
                chRollNo.add(rs.getString("rollNo"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        table = new JTable();

        try{
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(10,100,850,500);
        add(jsp);


        getContentPane().setBackground(Color.WHITE);
        setSize(900,650);
        setLocation(300,50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search){
            String query = "select * from student where rollNo = '"+chRollNo.getSelectedItem()+"'";

            try {
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){

            }
        } else if (ae.getSource() == print) {
            try{
                table.print();
            }catch (Exception e){

            }
        } else if(ae.getSource() == add){
            setVisible(false);
            new AddStudent();
        }else if(ae.getSource() == update){
            setVisible(false);
            new UpdateStudent();
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new StudentDetails();
    }

}

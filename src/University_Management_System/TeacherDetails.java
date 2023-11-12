package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherDetails extends JFrame implements ActionListener {
    Choice chIdNo;
    JTable table;
    JButton search,print,add,update,cancel;
    Conn c = new Conn();

    TeacherDetails(){
        setLayout(null);

        JLabel heading = new JLabel("Search by Id");
        heading.setBounds(20,20,150,20);
        add(heading);

        chIdNo = new Choice();
        chIdNo.setBounds(180,20,150,20);
        add(chIdNo);

        try{
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()){
                chIdNo.add(rs.getString("Id"));
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
            ResultSet rs = c.s.executeQuery("select * from teacher");
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
            String query = "select * from teacher where Id = '"+chIdNo.getSelectedItem()+"'";

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
            new AddTeacher();
        }else if(ae.getSource() == update){
            setVisible(false);
             new UpdateTeacher();
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherDetails();
    }


}

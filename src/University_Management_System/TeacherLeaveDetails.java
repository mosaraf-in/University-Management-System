package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice chId;
    JTable table;
    JButton search,print,cancel;
    Conn c = new Conn();

    TeacherLeaveDetails(){
        setLayout(null);

        JLabel heading = new JLabel("Search by Id");
        heading.setBounds(20,20,150,20);
        add(heading);

        chId = new Choice();
        chId.setBounds(180,20,150,20);
        add(chId);

        try{
            ResultSet rs = c.s.executeQuery("select * from teacherLeave");
            while (rs.next()){
                chId.add(rs.getString("Id"));
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


        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        table = new JTable();

        try{
            ResultSet rs = c.s.executeQuery("select * from teacherLeave");
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
            String query = "select * from teacherLeave where Id = '"+chId.getSelectedItem()+"'";

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
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }

}

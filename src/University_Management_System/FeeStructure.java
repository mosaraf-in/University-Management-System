package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class FeeStructure extends JFrame {

    Conn c = new Conn();

    FeeStructure(){

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50,10,400,30);
        heading.setFont(new Font("Thoma",Font.BOLD,30));
        add(heading);
        JTable table = new JTable();

        try{
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0,60,900,700);
        add(scroll);

        setSize(900,600);
        setLocation(250,50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FeeStructure();
    }
}

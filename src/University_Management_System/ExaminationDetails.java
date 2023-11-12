package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener {

    JTextField search;
    JButton result,back;
    JTable table;
    Conn c = new Conn();
    ExaminationDetails(){
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Thoma", Font.BOLD, 24));
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Thoma",Font.PLAIN,18));
        add(search);

        result = new JButton("Result");
        result.setBounds(300, 90, 120, 30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        result.setFont(new Font("Thoma", Font.BOLD, 15));
        result.addActionListener(this);
        add(result);

        back = new JButton("Back");
        back.setBounds(440, 90, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Thoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);

        table = new JTable();
        table.setFont(new Font("Thoma",Font.PLAIN,16));

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0,130,950,300);
        add(scroll);

        try{
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();

        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
               int row = table.getSelectedRow();
               search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        setSize(950,450);
        setLocation(250,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == result){
            setVisible(false);
             new Marks(search.getText());
        }else {
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new ExaminationDetails();
    }


}

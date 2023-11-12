package University_Management_System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/first.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(1050,620,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();

        setVisible(true);

        int x = 0;
        for(int i=0; i<=600; i+=4,x++){
            setLocation(510-(i + x)/2,340-i/2);
            setSize((i + 3*x),(i + x/3));
            try{
                Thread.sleep(15);
            }
            catch (Exception e){}
        }
    }
    @Override
    public void run() {
        try{
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        }
        catch (Exception e){}
    }
    public static void main(String[] args) {
        new Splash();
    }


}

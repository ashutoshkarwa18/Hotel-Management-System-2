package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;       //since * imports classes and not sub-packages

public class InitialFrame extends JFrame implements ActionListener{

    InitialFrame(){
      setSize(1280,600);
      setLocation(120,120);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/project/assets/hotel1.jpeg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1280,600);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(250,5,1000,90);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.TRUETYPE_FONT,70));
        l1.add(l2);                                                        //to make it visible above l1

        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(1110,500,120,45);
        b1.setFont(new Font("serif",Font.TRUETYPE_FONT,20));
        b1.setBorder(null);
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        setVisible(true);

        while(true){

            l2.setVisible(false);                                        //initially invisible
            try{
                Thread.sleep(500);                                  //time is stopped for this interval
            }catch(Exception e){}

            l2.setVisible(true);                                         //again made visible
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }



    }

    public void actionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        this.setVisible(false);                     //this is for current class reference
    }

    public static void main(String[] args) {
    new InitialFrame();
    }
}

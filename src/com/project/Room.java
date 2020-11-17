package com.project;

import javax.swing.*;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Room extends JFrame implements ActionListener{

    JTable t1;
    JButton b1,b2;
    Room(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/project/assets/room5.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(430,40,500,400);
        add(icon);

        JLabel l1 = new JLabel("Room No.");

        l1.setBounds(5,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(82,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(170,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(250,10,60,20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(320,10,100,20);
        add(l5);


        t1 = new JTable();
        t1.setBounds(0,40,400,400);
        add(t1);

        b1 = new JButton("Load Data");
        b1.setBounds(100,460,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(250,460,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(265, 170, 950, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b1){
            try{
                conn c = new conn();
                String str = "SELECT * FROM room";

                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e) {
            }

        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Room().setVisible(true);
    }
}
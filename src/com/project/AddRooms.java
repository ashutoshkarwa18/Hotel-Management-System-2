package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    AddRooms(){

        JLabel l1 = new JLabel("ADD ROOMS");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setBounds(140,20,150,20);
        add(l1);

        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Tahoma",Font.PLAIN,14));
        room.setBounds(50, 80,120, 30);
        add(room);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma",Font.PLAIN,14));
        t1.setBounds(190,80,120,30);
        add(t1);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,14));
        available.setBounds(50, 130,120, 30);
        add(available);

        c1 = new JComboBox(new String[] {" Available", " Occupied"});
        c1.setBounds(190,130,120,30);
        c1.setBackground(Color.white);
        add(c1);

        JLabel status = new JLabel("Cleaning status");
        status.setFont(new Font("Tahoma",Font.PLAIN,14));
        status.setBounds(50, 180,120, 30);
        add(status);

        c2 = new JComboBox(new String[] {" Clean", " Dirty"});
        c2.setBounds(190,180,120,30);
        c2.setBackground(Color.white);
        add(c2);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,14));
        price.setBounds(50, 230,120, 30);
        add(price);

        t2 = new JTextField();
        t2.setBounds(190,230,120,30);
        add(t2);

        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma",Font.PLAIN,14));
        type.setBounds(50, 280,120, 30);
        add(type);

        c3 = new JComboBox(new String[] {" Single Bed", " Double Bed"});
        c3.setBounds(190,280,120,30);
        c3.setBackground(Color.white);
        add(c3);

        b1 = new JButton("Add room");
        b1.setBounds(50,360,120,30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(190,360,120,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/project/assets/room4.jpg"));
        Image i2=i1.getImage().getScaledInstance(520,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(350, 50, 520, 300);
        add(l2);

        getContentPane().setBackground(Color.WHITE);


        setBounds(265, 200, 900, 470);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String room = t1.getText();
            String available = (String)c1.getSelectedItem();
            String status = (String)c2.getSelectedItem();
            String price = t2.getText();
            String type = (String)c3.getSelectedItem();

            conn c = new conn();
            try{
                String str = "INSERT INTO room VALUES ('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New Room Added");
                this.setVisible(false);
            }catch(Exception e){

            }

        } else if(ae.getSource() == b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddRooms().setVisible(true);
    }
}

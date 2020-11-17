package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Checkout extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;

    Checkout(){

        JLabel l1 = new JLabel("Checkout");
        l1.setBounds(100,20,100,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l1);

        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(30,80,100,30);
        add(l2);

        c1=new Choice();
        try{
            conn c = new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while (rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){}

        c1.setBounds(150,80,150,30);
        add(c1);


        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);

        t1=new JTextField();
        t1.setBounds(150,130,150,30);
        add(t1);

        b1=new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,200,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(170,200,120,30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/project/assets/tick.png"));
        Image i2= i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        b3=new JButton(i3);
        b3.setBounds(310,80,20,20);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("com/project/assets/checkout.jpg"));
        Image i5= i4.getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l4=new JLabel(i6);
        l4.setBounds(350,10,400,250);
        add(l4);



        setLayout(null);
        setBounds(450,250,800,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==b1){
            String id=c1.getSelectedItem();
            String room = t1.getText();
            String str="delete from customer where number = '"+id+"'";
            String str2="update room set available='Available', status='Dirty' where room='"+room+"'";
            conn c=new conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Checkout Done");
                new Reception().setVisible(true);
                this.setVisible(false);

            }catch (Exception e){}

        }else if (ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);

        }else if (ae.getSource()==b3){
            String id=c1.getSelectedItem();
            conn c = new conn();
            try {
                ResultSet rs=c.s.executeQuery("select * from customer where number = '"+id+"'");
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                }
            } catch (Exception e) {
            }

        }
    }

    public static void main(String[] args) {
        new Checkout().setVisible(true);
    }
}

package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;

    UpdateCheck(){

        JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(90,20,200,30);
        add(l1);

        JLabel l2 = new JLabel("Customer - ID");
        l2.setBounds(30,80,100,20);
        add(l2);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                c1.add(rs.getString("number"));
            }

        }catch(Exception e){
        }
        c1.setBounds(200,80,150,25);
        add(c1);


        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,120,100,20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,160,100,20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);

        JLabel l5 = new JLabel("Check-in");
        l5.setBounds(30,200,100,20);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);

        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30,240,100,20);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);

        JLabel l7 = new JLabel("Pending Amount ");
        l7.setBounds(30,280,130,20);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);

        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(120,320,130,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(30,370,130,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setBounds(200,370,130,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/project/assets/check-in.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l9 = new JLabel(i3);
        l9.setBounds(400,30,400,400);
        add(l9);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(265,170,830,500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String room = null;
                String deposit = null;
                int amountPaid ;
                String price = null;

                conn c = new conn();
                String id = c1.getSelectedItem();
                String str = "SELECT * FROM customer WHERE number = '"+id+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");

                }
                ResultSet rs2 = c.s.executeQuery("SELECT * FROM room WHERE room = '"+room+"'");
                while(rs2.next()){
                    price = rs2.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));
                }

            }catch (Exception e){

            }

        }else if(ae.getSource()== b2){
            try {
                conn c = new conn();
                String room = t1.getText();
                String name = t2.getText();
                String status = t3.getText();
                String amount = t4.getText();
                String pending = t5.getText();
                String number = c1.getSelectedItem();

                String str2 = "update customer set room='" + room + "', name='" + name + "', status='" + status + "', deposit='" + amount + "' where number='" + number + "'";
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception e){}

        }else if (ae.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }
}

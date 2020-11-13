package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JRadioButton r1, r2;
    JComboBox c1;
    JButton b1, b2;

    AddDriver() {

        JLabel title = new JLabel("ADD DRIVERS");
        title.setBounds(150, 20, 180, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(title);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        name.setBounds(60, 70, 100, 30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(200, 70, 150, 30);
        add(t1);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma", Font.PLAIN, 14));
        age.setBounds(60, 110, 100, 30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200, 110, 150, 30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        gender.setBounds(60, 150, 100, 30);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r1.setBounds(200, 150, 70, 30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r2.setBounds(280, 150, 90, 30);
        r2.setBackground(Color.WHITE);
        add(r2);

        JLabel car = new JLabel("Car Company");
        car.setFont(new Font("Tahoma", Font.PLAIN, 14));
        car.setBounds(60, 190, 100, 30);
        add(car);

        t3 = new JTextField();
        t3.setBounds(200, 190, 150, 30);
        add(t3);

        JLabel model = new JLabel("Model");
        model.setFont(new Font("Tahoma", Font.PLAIN, 14));
        model.setBounds(60, 230, 100, 30);
        add(model);

        t4 = new JTextField();
        t4.setBounds(200, 230, 150, 30);
        add(t4);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.PLAIN, 14));
        available.setBounds(60, 270, 100, 30);
        add(available);

        c1 = new JComboBox(new String[]{"Available", "Busy"});
        c1.setBounds(200, 270, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma", Font.PLAIN, 14));
        location.setBounds(60, 310, 100, 30);
        add(location);

        t5 = new JTextField();
        t5.setBounds(200, 310, 150, 30);
        add(t5);

        b1 = new JButton("Add Driver");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 370, 130, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(210, 370, 130, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/project/assets/driver.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400, 50, 500, 300);
        add(l1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(240, 200, 950, 450);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) c1.getSelectedItem();
            String company = t3.getText();
            String brand = t4.getText();
            String available = (String) c1.getSelectedItem();
            String location = t5.getText();

            conn c = new conn();

            String str = "INSERT INTO driver VALUES ('" + name + "','" + age + "','" + gender + "','" + company + "','" + brand + "','" + available + "','" + location + "')";
            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                this.setVisible(false);
            } catch (Exception e) {

            }

        }else if (ae.getSource() == b2) {
            setVisible(false);
        }
    }
        public static void main(String[]args){
            new AddDriver().setVisible(true);
        }
}

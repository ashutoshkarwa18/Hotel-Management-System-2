package com.project;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","hms_user","Hotel_123");
            s = c.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

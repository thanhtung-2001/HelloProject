package com.fpt.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/QLBS","root","");
                System.out.println("ket noi database thanh cong!");
            }catch (Exception exception){
                exception.printStackTrace();
            };
        }
        return connection;
    }

//    public static void main(String[] args) {
//        DBConnection.getConnection();
//    }
}

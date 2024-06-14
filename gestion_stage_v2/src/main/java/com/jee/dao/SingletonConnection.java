package com.jee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static SingletonConnection instance;
    private Connection cnx;
    private final String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; 
    private final String username = "hr"; 
    private final String password = "hr"; 

    private SingletonConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cnx = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to DB !");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}

package com.evalumate.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBhelper {
    private static final String mySqlUrl = "jdbc:mysql://localhost:3306/runoob?useSSL=false&characterEncoding-UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "password";
    private Connection connection;

    public DBhelper(){
        connection = connectDB();
    }

    private Connection connectDB(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Load jdbc Driver successfully.");
            connection = DriverManager.getConnection(mySqlUrl, user, password);
            System.out.println("Connected to mySql.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}

package com.how2j.MultiThread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class ThreadLocalLearning2 {
    public static void main(String[] args) {
        //针对不同thread 开各自独立的th
    }
}

class ConnectionManager{
    private static final String mySqlUrl = "jdbc:mysql://localhost:3306/runoob?useSSL=false&characterEncoding-UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "password";

    private  ConnectionManager(){ }

    private static ThreadLocal<Connection> connectionThreadLocal;

    public static Connection getConnection(){
        if (connectionThreadLocal.get() == null) {
            try {
                Connection connection = DriverManager.getConnection(mySqlUrl, user, password);
                connectionThreadLocal.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Connected to mySql.");

        }
        return connectionThreadLocal.get();
    }

    public static void closeConnection(){
        Connection c = connectionThreadLocal.get();
        if (c != null) {
            try {
                c.close();
                connectionThreadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

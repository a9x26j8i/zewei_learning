package com.how2j.jdbc;

import java.lang.Class;
import java.sql.*;
import java.util.ArrayList;

public class TestMySql {
    private static final String mySqlUrl = "jdbc:mysql://localhost:3306/runoob?useSSL=false&characterEncoding-UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        TestMySql test = new TestMySql();
        Statement statement = test.connectDB();
        String sql = "select * from runoob_tbl";

        ArrayList<String> result = test.lookUp(statement, sql);
        System.out.println(result);
    }

    private ArrayList<String> lookUp(Statement statement, String sql) {
        ArrayList<String> ret = new ArrayList<>();

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                ret.add(resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    private Statement connectDB() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Load jdbc Driver successfully.");
            connection = DriverManager.getConnection(mySqlUrl, user, password);
            System.out.println("Connected to mySql.");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

}



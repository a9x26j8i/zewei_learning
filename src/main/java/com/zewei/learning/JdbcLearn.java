package com.zewei.learning;

import com.xiaoleilu.hutool.crypto.SecureUtil;

import java.lang.*;
import java.sql.*;
import java.util.Arrays;


public class JdbcLearn {
    public static final String SALT_STRING = "dskjf243987834uj38y734uh43iy78cbhjy73834237y328";
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库加载成功！");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/runoob?useSSL=false&characterEncoding-UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "password");
            System.out.println("连接成功， 获取连接对象：" + connection);

            statement = connection.createStatement();
            System.out.println("连接成功， 获取Statement对象：" + statement);

            String sql1 = "select * from runoob_tbl";


//            insertData(statement);
//            updateData(statement);
            lookupData(statement );
//            checkAccount(statement);
//            hashPassword();

            System.out.println(Arrays.toString("你".getBytes()));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertData(Statement statement) {
        String sql = "";
        for (int i = 0; i < 5; i++) {
//            sql = "insert into runoob_tbl values(" + (i+2) + "," + "lkj," + "zewei," + "NOW()" + ")";
            sql = "insert into runoob_tbl values(null, \"php\", \"cainiao\", NOW())";
            try {
                statement.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateData(Statement statement) {
        String sql = "";
        sql = "update runoob_tbl set runoob_title='java' where runoob_id between 203 and 205";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void lookupData(Statement statement) {
        String sql = "";
        sql = "select * from account";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
//                Date date = resultSet.getDate(4);
                System.out.println(id + "," + title + "," + author + "," );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkAccount(Statement statement) {
        String sql = "";
        sql = "select * from account where id = 1 and password = \"a9x26j8i\"";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("succeed!");
            } else {
                System.out.println("failed!");
            }
//            while(resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String title = resultSet.getString(2);
//                String author = resultSet.getString(3);
////                Date date = resultSet.getDate(4);
//                System.out.println(id + "," + title + "," + author );
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void hashPassword() {
        String password = "ILoveJava";
        System.out.println(password);
        System.out.println(SecureUtil.md5(password));
    }

}

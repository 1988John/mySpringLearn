package com.foo.test.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author jiangwang3
 * @date 2018/8/16.
 */
public class JdbcTest {

    private static String JDBC_URL = "jdbc:MySql://192.168.146.129:3306/lease?characterEncoding=UTF-8";

    private static String USERNAME = "root";

    private static String PASSWORD = "3ctestroot";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");//加载驱动

        Connection conn= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);//链接到数据库

        String sql = "SELECT count(id) as total from user";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getInt("total"));
        }

    }
}

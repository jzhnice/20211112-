package com.dzqc.until;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static Connection conn;
    static {
//        类加载器
        InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties p = new Properties();
        try {
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = p.getProperty("driver");
        String url = p.getProperty("url");
        String username = p.getProperty("username");

        String password = p.getProperty("password");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException |  SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }
    public static  void close(Connection connection){
        conn=connection;
    }
}

package com.rama.myapplication2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "db_login";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
            conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

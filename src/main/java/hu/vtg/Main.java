package hu.vtg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String user = "test01";
        String pass = "titok";
        String url = "jdbc:mariadb://localhost:3306/test01";
        Connection conn = DriverManager.getConnection(url, user, pass);
        System.out.println("OK");
        String sql = "SELECT * FROM jarmuvek";

        conn.close();
    }
}
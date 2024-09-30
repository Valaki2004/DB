package hu.vtg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        //(MYSQL) String user = "test01";
        //(MYSQL) String pass = "titok";
        //(MYSQL) String url = "jdbc:mariadb://localhost:3306/test01";
        String url = "jdbc:sqlite:database.sqlite";
        //(MYSQL) Connection conn = DriverManager.getConnection(url, user, pass);
        Connection conn = DriverManager.getConnection(url);
        System.out.println("OK");
        

        String insertSql = 
            """
            insert into jarmuvek
            (rendszam, marka)
            values
            (?, ?)        
            """;
        

        PreparedStatement ps = conn.prepareStatement(insertSql);
        ps.setString(1, "RDA-348");
        ps.setString(2, "Opel"); 
        ps.executeUpdate();      
        
        
        
        String sql = "SELECT * FROM jarmuvek";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString("id") + "." + " " + rs.getString("rendszam") + " " + rs.getString("marka"));
        }
        conn.close();

    
    }
}
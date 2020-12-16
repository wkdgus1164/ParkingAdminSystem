package db;

import java.io.IOException;
import java.sql.*;

public class DatabaseManager {

    String strDriver = "oracle.jdbc.driver.OracleDriver";
    String strURL = "jdbc:oracle:thin:@localhost:1521";
    String id = "ADMIN";
    String pq = "alpha190315";
    
    public Connection DB_con;
    public Statement DB_stmt;
    public ResultSet DB_rs;

    public void dbOpen() throws IOException {
        try {
            Class.forName(strDriver);
            DB_con = DriverManager.getConnection(strURL, id, pq);
            DB_stmt = DB_con.createStatement();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }
    
    public void dbClose() throws IOException {
        try {
            DB_stmt.close();        // Exit Statement Connection
            DB_con.close();         // exit DB Connection
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }
}

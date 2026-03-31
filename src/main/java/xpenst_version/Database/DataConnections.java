package xpenst_version.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnections {

    private static final String URL = "jdbc:mysql://localhost:3306/xpenst_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Password"; 
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
            // System.out.println("Connected to MySQL successfully!");
        
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            // e.printStackTrace();
            return null;
        }
    }
}

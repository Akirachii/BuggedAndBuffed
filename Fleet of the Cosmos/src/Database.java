
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3307/spacefleet";
    private static final String USER = "root";
    private static final String PASSWORD = "galacticRoot123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✨ load the driver manually
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found 😤");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

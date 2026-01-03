import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {

    public static void main(String[] args) {
        initConnection();
    }

    public static void initConnection() {
        String url = "jdbc:sqlite:sqlite_database_2022.db";

        try (Connection conn = DriverManager.getConnection(url)) {

            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite");
        }
    }
}

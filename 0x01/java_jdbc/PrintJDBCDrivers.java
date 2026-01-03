import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {

    public static void main(String[] args) {

        System.out.println("Available JDBC Drivers:");

        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            System.out.println(
                driver.getClass().getName() +
                " - version " +
                driver.getMajorVersion() +
                "." +
                driver.getMinorVersion()
            );
        }
    }
}

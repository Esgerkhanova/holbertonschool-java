import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {
@Override
    public Connection connect(String connectionUrl) {
        Connection connection = null;
        try {
          
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection to SQLite DB established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: SQLite JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void createTable(String connectionUrl) {
        String sql = "CREATE TABLE IF NOT EXISTS customer (\n"
                   + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                   + "    name TEXT NOT NULL,\n"
                   + "    age INTEGER,\n"
                   + "    cpf TEXT,\n"
                   + "    rg TEXT\n"
                   + ");";

        try (Connection conn = this.connect(connectionUrl);
             Statement stmt = conn.createStatement()) {
          
            stmt.execute(sql);
            System.out.println("Customer table created (or already exists).");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    @Override
    public void insert(String connectionUrl, Customer customer) {
        String sql = "INSERT INTO customer(name, age, cpf, rg) VALUES(?, ?, ?, ?)";

        try (Connection conn = this.connect(connectionUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, customer.getName());
            pstmt.setInt(2, customer.getAge());
            pstmt.setString(3, customer.getCpf());
            pstmt.setString(4, customer.getRg());
            
            pstmt.executeUpdate();
            System.out.println("Customer inserted successfully: " + customer.getName());
        } catch (SQLException e) {
            System.err.println("Error inserting customer: " + e.getMessage());
        }
    }

    @Override
    public void selectAll(String connectionUrl) {
        String sql = "SELECT id, name, age, cpf, rg FROM customer";

        try (Connection conn = this.connect(connectionUrl);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            System.out.println("\n--- All Customers ---");
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAge(rs.getInt("age"));
                customer.setCpf(rs.getString("cpf"));
                customer.setRg(rs.getString("rg"));
                System.out.println(customer.toString());
            }
            System.out.println("---------------------\n");
        } catch (SQLException e) {
            System.err.println("Error selecting all customers: " + e.getMessage());
        }
    }

    @Override
    public void update(String connectionUrl, int id, String name, Integer age) {
        String sql = "UPDATE customer SET name = ?, age = ? WHERE id = ?";

        try (Connection conn = this.connect(connectionUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer with ID " + id + " updated successfully.");
            } else {
                System.out.println("Customer with ID " + id + " not found for update.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating customer: " + e.getMessage());
        }
    }

    @Override
    public void delete(String connectionUrl, int id) {
        String sql = "DELETE FROM customer WHERE id = ?";

        try (Connection conn = this.connect(connectionUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer with ID " + id + " deleted successfully.");
            } else {
                System.out.println("Customer with ID " + id + " not found for deletion.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting customer: " + e.getMessage());
        }
    }
}

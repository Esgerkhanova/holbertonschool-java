package src;

import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Connection connect(String connectionUrl) {
        try {
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createTable(String connectionUrl) {
        String sql = "CREATE TABLE IF NOT EXISTS customers (" +
                     "id INTEGER PRIMARY KEY, " +
                     "name TEXT, " +
                     "age INTEGER, " +
                     "cpf TEXT, " +
                     "rg TEXT)";

        try (Connection conn = connect(connectionUrl);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String connectionUrl, Customer customer) {
        String sql = "INSERT INTO customers (id, name, age, cpf, rg) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect(connectionUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, customer.getId());
            pstmt.setString(2, customer.getName());
            pstmt.setInt(3, customer.getAge());
            pstmt.setString(4, customer.getCpf());
            pstmt.setString(5, customer.getRg());

            pstmt.executeUpdate();
            System.out.println("Customer inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll(String connectionUrl) {
        String sql = "SELECT * FROM customers";

        try (Connection conn = connect(connectionUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", CPF: " + rs.getString("cpf") +
                        ", RG: " + rs.getString("rg")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String connectionUrl, int id, String name, Integer age) {
        String sql = "UPDATE customers SET name = ?, age = ? WHERE id = ?";

        try (Connection conn = connect(connectionUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();
            System.out.println("Customer updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String connectionUrl, int id) {
        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection conn = connect(connectionUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Customer deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

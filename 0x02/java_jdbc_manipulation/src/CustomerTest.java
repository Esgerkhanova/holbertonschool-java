public class CustomerTest {

    public static void main(String[] args) {

        // The URL for the SQLite database. The file will be created if it doesn't exist.
        String url = "jdbc:sqlite:sqlite_database_marco_2022.db";

        // 1) Instantiating the implementation class
        CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
        
        // Connect is used to ensure the database file is present and the connection works.
        System.out.println("--- 1) Attempting Connection and Database Creation ---");
        customerDAOImpl.connect(url);

        // 2) Creating the table 
        System.out.println("\n--- 2) Creating Customer Table ---");
        customerDAOImpl.createTable(url);

        // 3) Inserting customers
        Customer c1 = new Customer();
        c1.setName("Danilo R. Pereira");
        c1.setAge(37);
        c1.setCpf("111.111.111-11");
        c1.setRg("222.222.222-22");

        Customer customer2 = new Customer();
        customer2.setName("Joao Oliveira Silva");
        customer2.setAge(55);
        customer2.setCpf("888.111.111-11");
        customer2.setRg("777.222.222-22");

        System.out.println("\n--- 3) Inserting Initial Data ---");
        customerDAOImpl.insert(url, c1);
        customerDAOImpl.insert(url, customer2);
        
        // 4) Selecting all customers
        System.out.println("\n--- 4) Initial Selection (Expected IDs 1 and 2) ---");
        customerDAOImpl.selectAll(url);

        // 5) Updating a customer (ID 1 is Danilo R. Pereira)
        System.out.println("\n--- 5) Updating Customer with ID 1 ---");
        customerDAOImpl.update(url, 1, "Danilo Rodrigues Pereira", 38);
        
        // Verify update
        System.out.println("\n--- Selection After Update (ID 1 changed) ---");
        customerDAOImpl.selectAll(url);

        // 6) Deleting a customer (ID 2 is Joao Oliveira Silva)
        System.out.println("\n--- 6) Deleting Customer with ID 2 ---");
        customerDAOImpl.delete(url, 2);
        
        // Verify deletion
        System.out.println("\n--- Final Selection (Only ID 1 remains) ---");
        customerDAOImpl.selectAll(url);
    }
}

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) != null) {
            return false;
        }
        customers.add(new Customer(customerName, initialAmount));
        return true;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            return false;
        }
        customer.addTransaction(amount);
        return true;
    }

    public Customer findCustomer(String customerName) {
        for (Customer c : customers) {
            if (c.getName().equals(customerName)) {
                return c;
            }
        }
        return null;
    }
}

import providers.Shipping;

public class Order {

    private int code;
    private double weight;
    private double total;
    private Shipping shipping;

    public Order(int code, double weight, double total) {
        this.code = code;
        this.weight = weight;
        this.total = total;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotal() {
        return total;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }
}

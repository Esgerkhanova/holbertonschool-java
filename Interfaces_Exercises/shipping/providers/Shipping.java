package providers;

public class Shipping {

    private double value;
    private ShippingProviderType shippingProviderType;

    public Shipping(double value, ShippingProviderType type) {
        this.value = value;
        this.shippingProviderType = type;
    }

    public double getValue() {
        return value;
    }

    public ShippingProviderType getShippingProviderType() {
        return shippingProviderType;
    }
}

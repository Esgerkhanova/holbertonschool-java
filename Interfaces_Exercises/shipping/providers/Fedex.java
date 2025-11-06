package providers;

public class Fedex implements ShippingProvider {

    @Override
    public Shipping calculateShipping(double weight, double value) {
        double cost;

        // weight in grams; convert to kg
        if (weight > 1000)
            cost = value * 0.10;
        else
            cost = value * 0.05;

        return new Shipping(cost, ShippingProviderType.FEDEX);
    }

    @Override
    public ShippingProviderType getShippingProviderType() {
        return ShippingProviderType.FEDEX;
    }
}

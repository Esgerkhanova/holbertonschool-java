import java.util.function.Consumer;
import java.util.function.Supplier;

public class Product {

    private String name;
    private double price;
    private double markupPercentage = 10; 

    public Supplier<Double> priceWithMarkup;
    public Consumer<Double> updateMarkup;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
        this.priceWithMarkup = () ->
                price + (price * markupPercentage / 100);

        this.updateMarkup = (Double newMarkup) ->
                this.markupPercentage = newMarkup;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

import java.util.ArrayList;
import java.util.List;

public class BeverageDecorator extends Beverage {

    protected Beverage decoratedBeverage;

    public BeverageDecorator(Beverage decoratedBeverage) {
        this.decoratedBeverage = decoratedBeverage;
    }

    @Override
    public List<String> getIngredients() {
        // Copy to avoid mutating the wrapped beverage's internal list
        return new ArrayList<>(decoratedBeverage.getIngredients());
    }

    @Override
    public double getPrice() {
        return decoratedBeverage.getPrice();
    }
}

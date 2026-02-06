import java.util.ArrayList;
import java.util.List;

public class BeverageDecorator extends Beverage {

    private Beverage decoratedBeverage;

    public BeverageDecorator(Beverage decoratedBeverage) {
        this.decoratedBeverage = decoratedBeverage;
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(decoratedBeverage.getIngredients());
    }

    @Override
    public double getPrice() {
        return decoratedBeverage.getPrice();
    }
}

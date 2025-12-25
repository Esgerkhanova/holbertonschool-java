import java.util.List;
import java.util.stream.Collectors;

public class Query {

    public static List<Product> getProductsByMinimumPrice(List<Product> products, double minimumPrice) {
        return products.stream()
                .filter(p -> p.getPrice() >= minimumPrice)
                .collect(Collectors.toList());
    }
}

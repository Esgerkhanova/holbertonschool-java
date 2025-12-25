import java.util.List;
import java.util.stream.Collectors;

public class Query {

    public static List<Order> getOrdersWithElectronics(List<Order> orders) {
        return orders.stream()
                .filter(order ->
                        order.getProducts()
                             .stream()
                             .anyMatch(p -> p.getCategory() == ProductCategory.ELECTRONIC)
                )
                .collect(Collectors.toList());
    }
}

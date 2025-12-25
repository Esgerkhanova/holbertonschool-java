import java.util.List;
import java.util.stream.Collectors;

public class Query {

    public static List<Product> apply15PercentDiscountToElectronics(List<Product> products) {
        return products.stream()
                .map(product -> {
                    if (product.getCategory() == ProductCategory.ELECTRONIC) {
                        double discountedPrice = product.getPrice() * 0.85;
                        product.setPrice(discountedPrice);
                    }
                    return product;
                })
                .collect(Collectors.toList());
    }
}

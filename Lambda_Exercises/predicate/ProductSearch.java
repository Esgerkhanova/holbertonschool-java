import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ProductSearch {

    public static List<Product> filter(List<Product> products, Predicate<Product> predicate) {

        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (predicate.test(product)) {
                result.add(product);
            }
        }

        return result;
    }
}

import java.util.*;
import java.util.function.Predicate;

class ProductSearch {

static List<Product> filter(List<Product> products, Predicate<Product> predicate) {
    List<Product> result = new ArrayList<>();

    for (Product product : products) {
        if (predicate.test(product)) {
            result.add(product);
        }
    }

    return result;
}

}

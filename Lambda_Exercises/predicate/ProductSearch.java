import java.util.*;
import java.util.function.Predicate;

class ProductSearch {

static List filter(List products, Predicate predicate) {
    List result = new ArrayList();

    for (Object obj : products) {
        Product product = (Product) obj;
        if (predicate.test(product)) {
            result.add(product);
        }
    }

    return result;
}

}

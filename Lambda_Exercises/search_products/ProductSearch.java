import java.util.*;
 class ProductSearch {

static List<Product> filter(List<Product> products, FilterCriteria criteria) {
        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (criteria.test(product)) {
                result.add(product);
            }
        }
        return result;
    }
}

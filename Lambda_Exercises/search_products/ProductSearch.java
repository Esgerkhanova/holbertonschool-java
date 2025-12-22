import java.util.*;

class ProductSearch {

static List filter(List products, FilterCriteria criteria) {
    List result = new ArrayList();

    for (Object obj : products) {
        Product product = (Product) obj;
        if (criteria.test(product)) {
            result.add(product);
        }
    }

    return result;
}

}

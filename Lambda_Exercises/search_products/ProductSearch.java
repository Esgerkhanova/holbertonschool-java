import java.util.List;
import java.util.ArrayList;

public class ProductSearch {
    public static List filter(List products, FilterCriteria criteria) {
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

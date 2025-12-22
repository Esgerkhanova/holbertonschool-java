import java.util.List;
import java.util.ArrayList;

public class ProductSearch {
    /**
     * Filters a list of products based on a given criteria.
     * * @param products The original list of products
     * @param criteria The FilterCriteria (functional interface) to apply
     * @return A new List containing only products that pass the test
     */
    public static List<Product> filter(List<Product> products, FilterCriteria criteria) {
        List<Product> result = new ArrayList<>();
        
        for (Product product : products) {
            // No manual casting (Product) obj is needed when using Generics
            if (criteria.test(product)) {
                result.add(product);
            }
        }
        
        return result;
    }
}

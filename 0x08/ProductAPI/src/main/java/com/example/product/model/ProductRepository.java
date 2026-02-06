package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> list = new ArrayList<>();

    public List<Product> getAllProducts() {
        return new ArrayList<>(list); // defensive copy
    }

    public Product getProductById(Long id) {
        if (id == null) return null;
        return list.stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product p) {
        if (p == null) return;
        list.add(p);
    }

    public void updateProduct(Product p) {
        if (p == null || p.getId() == null) return;

        for (int i = 0; i < list.size(); i++) {
            if (p.getId().equals(list.get(i).getId())) {
                list.set(i, p);
                return;
            }
        }
        // if not found, you can choose to add it; task doesn't require.
    }

    public void removeProduct(Product p) {
        if (p == null) return;
        list.remove(p);
    }

    public void addList(List<Product> listOfProducts) {
        if (listOfProducts == null) return;
        list.addAll(listOfProducts);
    }
}

package com.techcamps.registrations.demo;

import com.techcamps.registrations.entities.Product;
import com.techcamps.registrations.models.ProductModel;

import java.util.List;

public class AdminApp {

    public static void main(String[] args) {

        ProductModel productModel = new ProductModel();

        Product p = new Product();
        p.setName("TV");
        p.setPrice(300.0);
        p.setQuantity(10);
        p.setStatus(true);

        productModel.create(p);

        List<Product> products = productModel.findAll();
        System.out.println("Products found: " + products.size());
    }
}

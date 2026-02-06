package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
@Api(tags = "Product API", value = "Product Registration REST API")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @PostConstruct
    public void seedData() {
        repo.addList(Arrays.asList(
                new Product(1L, "P-001", "Laptop", "Gaming laptop", new BigDecimal("2500.00"), LocalDateTime.now(), true),
                new Product(2L, "P-002", "Mouse", "Wireless mouse", new BigDecimal("35.99"), LocalDateTime.now(), true),
                new Product(3L, "P-003", "Keyboard", "Mechanical keyboard", new BigDecimal("89.90"), LocalDateTime.now(), true)
        ));
    }

    @GetMapping("/welcome")
    @ApiOperation(value = "Welcome message", notes = "Displays the welcome message of the Product REST API.")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("WELCOME TO PRODUCT REST API.");
    }

    @GetMapping("/allProducts")
    @ApiOperation(value = "List all products", notes = "Returns the full list of registered products.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    public ResponseEntity<List<Product>> allProducts() {
        // Business logic would decide when 11 happens; here only documented as asked.
        return ResponseEntity.ok(repo.getAllProducts());
    }

    @GetMapping("/findProductById/{id}")
    @ApiOperation(value = "Find product by ID", notes = "Searches and returns a product by its ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    public ResponseEntity<Product> findProductById(
            @ApiParam(value = "Product ID", required = true, example = "1")
            @PathVariable("id") Long id) {

        // PathVariable is required; 12 is requested only for documentation.
        Product p = repo.getProductById(id);
        if (p == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(p);
    }

    @PostMapping("/addProduct")
    @ApiOperation(value = "Add a new product", notes = "Adds a new product to the in-memory repository.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    public ResponseEntity<Product> addProduct(
            @ApiParam(value = "Product payload", required = true)
            @RequestBody Product p) {

        // No persistence, minimal validation (task asks only documentation for code 10)
        if (p == null || p.getId() == null || p.getName() == null || p.getCode() == null) {
            // In real life you'd return 400; task only asks swagger to show code=10.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (p.getCreatedOn() == null) p.setCreatedOn(LocalDateTime.now());
        if (p.getStatus() == null) p.setStatus(true);

        repo.addProduct(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @PutMapping("/updateProduct")
    @ApiOperation(value = "Update an existing product", notes = "Updates an existing product (matched by ID).")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    public ResponseEntity<Product> updateProduct(
            @ApiParam(value = "Product payload", required = true)
            @RequestBody Product p) {

        if (p == null || p.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Product existing = repo.getProductById(p.getId());
        if (existing == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // If identical, in real life you might return 304/204; here we keep simple.
        if (p.equals(existing)) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

        // keep createdOn if not provided
        if (p.getCreatedOn() == null) p.setCreatedOn(existing.getCreatedOn());

        repo.updateProduct(p);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/removeProduct")
    @ApiOperation(value = "Remove a product", notes = "Removes a product from the repository.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    public ResponseEntity<Void> removeProduct(
            @ApiParam(value = "Product payload (at least ID)", required = true)
            @RequestBody Product p) {

        if (p == null || p.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Product existing = repo.getProductById(p.getId());
        if (existing == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repo.removeProduct(existing);
        return ResponseEntity.ok().build();
    }
}

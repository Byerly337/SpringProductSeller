package org.example.Controller;

import org.example.Entity.Product;
import org.example.Exception.ProductException;
import org.example.Exception.ProductNotFoundException;
import org.example.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product", params = "productName")
    public ResponseEntity<List<Product>> getAllProductsByTitle(@RequestParam String productName) {

        List<Product> products;
        if (productName == null) {
            products = productService.getAllProducts();
        } else {
            products = productService.getAllProductsByProductName(productName);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    ///localhost:9009/seller/1/product
    @GetMapping(value = "product")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products;
        products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("seller/{id}/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product p, @PathVariable long id) throws Exception {
        Product product = productService.addProduct(id, p);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

}








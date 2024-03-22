package org.example.Service;

import org.example.Entity.Product;
import org.example.Entity.Seller;
import org.example.Exception.ProductException;
import org.example.Exception.ProductNotFoundException;
import org.example.Main;
import org.example.Repository.ProductRepository;
import org.example.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;
    SellerRepository sellerRepository;
    @Autowired
    public ProductService(ProductRepository productRepository, SellerRepository sellerRepository){
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(long id, Product p) throws ProductException {
        Optional<Seller> optional = sellerRepository.findById(id);
        Seller s;
        System.out.println("can i add a product?");
        if(p.getProductName() == null || p.getProductName().isEmpty()){
            Main.log.warn("Product name is empty");
            throw new ProductException("Product name is empty");
        }
        if(p.getPrice() <= 0){
            Main.log.warn("Product price is less than or equal to 0");
            throw new ProductException("Product price is less than or equal to 0");
        }
        if(optional.isEmpty()){

            Main.log.warn("Seller with id " + id + " is not a listed Seller");
            throw new ProductException("Seller " + id + " is not a listed Seller");
        } else {
            s = optional.get();
        }
        p.setSeller(s);
        Product savedProduct = productRepository.save(p);
        s.getProducts().add(savedProduct);
        sellerRepository.save(s);

        return savedProduct;
    }

    public List<Product> getAllProductsByProductName(String productName) {
        return productRepository.findByProductName2(productName);
    }

    public Product getById(long id) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findById(id);
        if(p.isEmpty()){
            throw new ProductNotFoundException("no such product... ");
        }else{
            return p.get();
        }
    }
     //Ted's example code:
    public Product saveProduct(long id, Product p) throws ProductNotFoundException {
        Optional<Seller> optional = sellerRepository.findById(id);
        Seller s;
        if(optional.isEmpty()){
            throw new ProductNotFoundException("product does not exist");
        }else{
            s = optional.get();
        }
        Product savedProduct = productRepository.save(p);
        s.getProducts().add(savedProduct);
        sellerRepository.save(s);
        return savedProduct;
    }
}

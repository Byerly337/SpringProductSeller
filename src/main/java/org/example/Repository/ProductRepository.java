package org.example.Repository;

import org.example.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //named query
    List<Product> findByProductName(String productName);
    //JPQL query (java persistence query language)
     //    SQL dialect agnostic
     //    directly maps to an ORM entity
     //    (we can still use native sql queries / named queries if we choose)

    @Query("from Product where productName=:productName")
    List<Product> findByProductName2(@Param("productName") String productName);


}

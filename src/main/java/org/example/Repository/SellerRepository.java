package org.example.Repository;

import org.example.Entity.Product;
import org.example.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {

//example:
   // @Query(value = "SELECT * FROM items WHERE category = :category", nativeQuery = true)
  //  List<Item> findByCategoryNative(String category);

  //create query to get all sellers. get all sellers is needed in seller service
  @Query("from Seller where name=:name")
  List<Seller> findSellerByName(@Param("name") String name);

  @Query("from Seller where id=:id")
  List<Seller> findAllSellersById(@Param("id") Long id);

}

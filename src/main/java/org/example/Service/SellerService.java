package org.example.Service;

import org.example.Entity.Product;
import org.example.Entity.Seller;
import org.example.Exception.SellerException;
import org.example.Main;
import org.example.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class SellerService {
    SellerRepository sellerRepository;
    @Autowired
    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }
    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }
    public Seller saveSeller(Seller s) throws SellerException {
        Main.log.info("log, added seller");
        System.out.println("A seller was added.");
        // Get the list of sellers from the database
        List<Seller> sellerList = sellerRepository.findSellerByName(s.name);
        // Throw an exception if the seller name is null or empty, returns 500 with error showing in logs
        if (s.getName() == null || s.getName().isEmpty()) {
            throw new SellerException("Seller Name is required.");

        }
        // Iterate through the list of sellers and check if seller exists
        for (Seller i : sellerList) {
            // Throw an exception if the seller already exists, returns 500 with error showing in logs
            if (i.getName().equals(s.getName())) {
                throw new SellerException("Seller Exists");
            }
        }
        // Add the seller to the database
        return sellerRepository.save(s);
    }

//    public boolean sellerExists (Long id){
        // Get a list of sellers
 //       List<Seller> sellerList = sellerRepository.findAll();

        // Check if the seller exists
//        for (Seller seller : sellerList) {
            // Check if the database seller id matches the provided seller id
//            if (seller.findAllSellersById() == id) {
//                return true;
            }
//        }
 //       return false;
 //   }


  //      public List<Seller> getAllSellersByName (String name){
  //          return sellerRepository.findSellerByName(name);
  //      }


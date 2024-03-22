package org.example.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String productName;
    public double price;

    @JsonIgnore
    @ManyToOne
    @JsonIgnoreProperties("products")
    @JoinColumn(name="seller_fk")
    public Seller seller;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", seller=" + seller +
                '}';
    }
}

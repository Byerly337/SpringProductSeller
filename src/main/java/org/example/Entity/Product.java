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
@ToString

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String productName;
    public double price;
    @JsonIgnore
    @ManyToOne
    @JsonIgnoreProperties("products")
    public Seller seller;

}

package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode

public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String name;
    public String seller;
    @OneToMany
    @JoinColumn(name = "seller_fk")

    public List<Product> products;

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seller='" + seller + '\'' +
                '}';
    }
}

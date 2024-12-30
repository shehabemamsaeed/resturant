package com.resurant.resturant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@NonNull
@Setter
@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Product  {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String logoPath;
   private String describtion;
   private String price;
   @JoinColumn(name = "category_id")
   @ManyToOne
   @JsonIgnore
   private Category category;

@ManyToMany
@JoinTable(
        name = "product_with_orders",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "requestOrders_id")
)
   private List<RequestOrder> requestOrders;
}

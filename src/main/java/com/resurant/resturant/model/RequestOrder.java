package com.resurant.resturant.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@NonNull
public class RequestOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String totalPrice;
    private String totalQuantity;
    @ManyToMany(mappedBy = "requestOrders", cascade = CascadeType.ALL)
    private List<Product> product;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}

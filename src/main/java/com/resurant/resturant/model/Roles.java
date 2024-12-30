package com.resurant.resturant.model;

import jakarta.persistence.*;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 @ManyToOne
 @JoinColumn(name = "client_id")
 private Client client;

 private String role;
}

package com.lq.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Supplier")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 255)
    private String contactInfo;

    @Column(length = 255)
    private String address;

    @OneToMany(mappedBy = "productId")
    private Set<Product> products;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Timestamp createdAt;


}
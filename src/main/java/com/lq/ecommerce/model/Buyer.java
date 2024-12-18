package com.lq.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "buyer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id", nullable = false, columnDefinition = "smallInt")
    private int buyerId;

    @Column(name = "username",nullable = false ,unique = true, columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(60)")
    private String password;

    @Column(name = "email", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(10)")
    private String phone;

    @Column(name = "address", columnDefinition = "VARCHAR(255)")
    private String address;

    @Column(name = "created_at" ,columnDefinition = "TIMESTAMPtz default current_timestamp")
    @CreationTimestamp
    private Timestamp created;

    @OneToMany(mappedBy = "buyer")
    private Set<FavouriteProduct> favoriteProducts;

    @OneToMany(mappedBy = "buyer")
    private Set<BuyerDiscount> coupons;


}

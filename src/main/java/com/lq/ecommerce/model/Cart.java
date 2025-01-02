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
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cart_id", nullable = false)
    private String id;

    @ManyToOne
    private Buyer buyer;

    @Column(name = "createrd_at", columnDefinition = "TIMESTAMPtz default current_timestamp")
    @CreationTimestamp
    private Timestamp date_created;

    @OneToMany
    private Set<CartItem> cartItems;



}

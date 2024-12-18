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
@Table(name = "Cart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    @Column(name = "cart_id", nullable = false ,columnDefinition = "smallInt")
    private int id;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer buyer;

    @Column(name = "createrd_at", columnDefinition = "TIMESTAMPtz default current_timestamp")
    @CreationTimestamp
    private Timestamp date_created;

    @OneToMany
    @JoinColumn(name = "cart", nullable = false)
    private Set<CartItem> cartItems;



}

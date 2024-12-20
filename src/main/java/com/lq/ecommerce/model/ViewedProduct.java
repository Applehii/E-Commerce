package com.lq.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "viewed_product")
@IdClass(ViewedProductId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ViewedProduct {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer buyer;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(name = "viewed_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp viewedAt;

}

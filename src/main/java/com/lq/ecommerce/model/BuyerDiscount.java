package com.lq.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "BuyerDiscount")
@IdClass(BuyerDiscountId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuyerDiscount {
    @Id
    @ManyToOne
    private Buyer buyer;

    @Id
    @ManyToOne
    private Discount discount;

    @Column(name = "assigned_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp assignedAt;

}

